package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.classes.DisplayDataBase;
import business.entitie.Animal;
import business.entitie.Person;
import business.entitie.Specie;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class PersonDao implements IDAO<Person> {

	public final static String _INSERT = "INSERT INTO person (firstName,lastName,age) VALUES(?, ?, ?)";
	public final static String _INSERTLINK = "INSERT INTO animal__person (id_Animal,id_Person) VALUES(?, ?)";
	public final static String _SELECT = "SELECT person.*, animal.*, specie.* FROM person "
			+ "INNER JOIN animal__person ON animal__person.id_Person = person.id_Person "
			+ "INNER JOIN animal ON animal__person.id_Animal = Animal.id_Animal "
			+ "INNER JOIN specie ON specie.id_Specie = specie.id_Specie "
			+ "GROUP BY person.id_Person, Animal.id_Animal "
			+ "ORDER BY person.id_Person;";
	public final static String _SELECTWHERE = "SELECT * FROM person "
			+ "INNER JOIN animal__person ON animal__person.id_Person = person.id_Person "
			+ "INNER JOIN animal ON animal__person.id_Animal = Animal.id_Animal "
			+ "INNER JOIN specie ON specie.id_Specie = specie.id_Specie "
			+ "WHERE person.id_Person=? "
			+ "GROUP BY person.id_Person, Animal.id_Animal "
			+ "ORDER BY person.id_Person;";
	public final static String _SELECTANIMALPERSON = "SELECT * FROM animal__person WHERE id_Person=?";
	public final static String _UPDATE = "UPDATE person SET firstName=?, lastName=?, age=? WHERE id_Person=?;";
	public final static String _DELETE = "DELETE FROM Person WHERE id_Person=?;";

	private void deleteForeignById(long pId) throws DaoException {
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM animal__person WHERE id_Person=?;");
			preparedStatement.setLong(1, pId);
			preparedStatement.execute();
		}
		catch (Exception e) {
			throw new DaoException("Erreur Person deleteForeignById()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				e.getStackTrace();
				throw new DaoException("Erreur Person deleteForeignById() Close", e);
			}
		}
	}

	@Override
	public Person create(Person pT) throws DaoException {
		if(pT == null) {
			return null;
		}
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_INSERT, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, pT.getFirstName());
			preparedStatement.setString(2, pT.getLastName());
			preparedStatement.setInt(3, pT.getAge());
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			while(resultSet.next()) {
				pT.setId(resultSet.getLong("GENERATED_KEY"));
			}
			if(!(pT.getListAnimal() == null)) {
				AnimalDao animalDao = new AnimalDao();
				List<Animal> listAnimal = pT.getListAnimal();
				for(int i = 0; i < listAnimal.size(); i++) {
					animalDao.create(listAnimal.get(i));
					PreparedStatement preparedStatementLink = connection.prepareStatement(_INSERTLINK);
					preparedStatementLink.setLong(1, listAnimal.get(i).getId());
					preparedStatementLink.setLong(2, pT.getId());
					preparedStatementLink.execute();
				}
			}
		} 
		catch (Exception e) {
			throw new DaoException("Erreur Person create()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Person create() Close", e);
			}
		}
		return pT;
	}

	@Override
	public Person findById(long pId) throws DaoException {
		Connection connection = null;
		Person person = new Person();
		try {			
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_SELECTWHERE);
			preparedStatement.setLong(1, pId);
			ResultSet resultSet = preparedStatement.executeQuery();
			DisplayDataBase displayDataBase = new DisplayDataBase(resultSet);
			displayDataBase.display();
			long lastIdPerson = -1;
			resultSet.last();
			if(resultSet.getRow() == 0) {
				return null;
			}
			resultSet.beforeFirst();
			while(resultSet.next()) {
				long id_Person = resultSet.getLong("id_Person");
				long id_Animal = resultSet.getLong("id_Animal");
				int sex = resultSet.getInt("sex");
				String name = resultSet.getString("name");
				String coatColor = resultSet.getString("coatColor");

				long id_Specie = resultSet.getLong("id_Animal");
				String commonName = resultSet.getString("commonName");
				String latinName = resultSet.getString("latinName");
				Specie specie = new Specie(id_Specie,commonName,latinName);

				if(id_Person == lastIdPerson) {
					person.getListAnimal().add(new Animal(id_Animal, name, sex, coatColor, specie));
				}
				else {
					List<Animal> listAnimal = new ArrayList<>();
					String firstName = resultSet.getString("firstName");	
					String lastName = resultSet.getString("lastName");
					int age = resultSet.getInt("age");

					listAnimal.add(new Animal(id_Animal, name, sex, coatColor, specie));
					person = new Person(id_Person,firstName,lastName,age,listAnimal);
				}
				lastIdPerson = id_Person;
			}
		} 
		catch (Exception e) {
			throw new DaoException("Erreur Person findById()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Person findById() Close", e);
			}
		}
		return person;
	}

	@Override
	public List<Person> findList() throws DaoException {
		Connection connection = null;
		List<Person> listPerson = new ArrayList<>();
		try {	
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_SELECT);
			ResultSet resultSet = preparedStatement.executeQuery();
			DisplayDataBase displayDataBase = new DisplayDataBase(resultSet);
			displayDataBase.display();
			Person person = new Person();
			long lastIdPerson = -1;
			resultSet.beforeFirst();
			while(resultSet.next()) {
				long id_Person = resultSet.getLong("id_Person");
				long id_Animal = resultSet.getLong("id_Animal");
				int sex = resultSet.getInt("sex");
				String name = resultSet.getString("name");
				String coatColor = resultSet.getString("coatColor");

				long id_Specie = resultSet.getLong("id_Animal");
				String commonName = resultSet.getString("commonName");
				String latinName = resultSet.getString("latinName");
				if(id_Person == lastIdPerson) {
					Specie specie = new Specie(id_Specie,commonName,latinName);
					person.getListAnimal().add(new Animal(id_Animal, name, sex, coatColor, specie));
				}
				else {
					List<Animal> listAnimal = new ArrayList<>();
					String firstName = resultSet.getString("firstName");	
					String lastName = resultSet.getString("lastName");
					int age = resultSet.getInt("age");

					Specie specie = new Specie(id_Specie,commonName,latinName);
					listAnimal.add(new Animal(id_Animal, name, sex, coatColor, specie));
					person = new Person(id_Person,firstName,lastName,age,listAnimal);
					listPerson.add(person);
				}
				lastIdPerson = id_Person;
			}
		} 
		catch (Exception e) {
			throw new DaoException("Erreur Person findList()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Person findList() Close", e);
			}
		}
		return listPerson;
	}

	@Override
	public Person updateById(Person pT) throws DaoException {
		if(pT == null) {
			return null;
		}
		Connection connection = null;
		try {	
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_UPDATE);
			deleteForeignById(pT.getId());
			if(!(pT.getListAnimal() == null)) {
				List<Animal> listAnimal = pT.getListAnimal();
				for(int i = 0; i < listAnimal.size(); i++) {
					PreparedStatement preparedStatementLink = connection.prepareStatement(_INSERTLINK);
					preparedStatementLink.setLong(1, listAnimal.get(i).getId());
					preparedStatementLink.setLong(2, pT.getId());
					preparedStatementLink.execute();
				}
			}
			preparedStatement.setString(1, pT.getFirstName());
			preparedStatement.setString(2, pT.getLastName());
			preparedStatement.setInt(3, pT.getAge());
			preparedStatement.setLong(4, pT.getId());
			preparedStatement.execute();
		} 
		catch (Exception e) {
			throw new DaoException("Erreur Person updateById()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Person updateById() Close", e);
			}
		}
		return pT;
	}

	@Override
	public void deleteById(long pId) throws DaoException {
		deleteForeignById(pId);
		Connection connection = null;
		try {	
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_DELETE);
			preparedStatement.setLong(1, pId);
			preparedStatement.execute();
		} 
		catch (Exception e) {
			e.getStackTrace();
			throw new DaoException(e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				e.getStackTrace();
				throw new DaoException(e);
			}
		}
	}

}
