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
import business.entitie.Specie;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class AnimalDao implements IDAO<Animal> {

	public final static String _INSERT = "INSERT INTO animal (`name`, `sex`, `coatColor`, `id_Specie`) VALUES(?, ?, ?, ?);";
	public final static String _SELECT = "SELECT * FROM animal INNER JOIN specie on specie.id_Specie = animal.id_Specie WHERE id_Animal=?;";
	public final static String _UPDATE = "UPDATE animal SET name=?, sex=?, coatColor=?, id_Specie=? WHERE id_Animal=?;";
	public final static String _DELETE = "DELETE * FROM Animal WHERE id_Animal=?;";

	public void deleteForeignById(long pId) throws DaoException{
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM animal__person WHERE id_Animal=?;");
			preparedStatement.setLong(1, pId);
			preparedStatement.execute();
		}
		catch (Exception e) {
			throw new DaoException("Erreur Animal deleteForeignById()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Animal deleteForeignById() Close", e);
			}
		}
	}

	@Override
	public Animal create(Animal pT) throws DaoException {
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_INSERT, Statement.RETURN_GENERATED_KEYS);
			SpecieDao specieDao = new SpecieDao();
			specieDao.findById(pT.getSpecie().getId());
			preparedStatement.setString(1, pT.getName());
			preparedStatement.setInt(2, pT.getSex());
			preparedStatement.setString(3, pT.getCoatColor());
			preparedStatement.setLong(4, pT.getSpecie().getId());
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			while(resultSet.next()) {
				pT.setId(resultSet.getLong("GENERATED_KEY"));
			}
		} 
		catch (Exception e) {
			throw new DaoException("Erreur Animal create()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Animal create() Close", e);
			}
		}
		return pT;
	}

	@Override
	public Animal findById(long pId) throws DaoException {
		Connection connection = null;
		Animal animal = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_SELECT);
			preparedStatement.setLong(1, pId);
			ResultSet resultSet = preparedStatement.executeQuery();
			DisplayDataBase displayDataBase = new DisplayDataBase(resultSet);
			displayDataBase.display();
			resultSet.beforeFirst();
			while(resultSet.next()) {
				long id_Animal = resultSet.getLong("id_Animal");	
				String name = resultSet.getString("name");	
				int sex = resultSet.getInt("sex");
				String coatColor = resultSet.getString("coatColor");
				long id_Specie = resultSet.getLong("id_Specie");	
				String commonName = resultSet.getString("commonName");
				String latinName = resultSet.getString("commonName");
				Specie specie = new Specie(id_Specie, commonName, latinName);
				animal = new Animal(id_Animal, name, sex, coatColor, specie);
			}
		} 
		catch (Exception e) {
			throw new DaoException("Erreur Animal findById()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Animal findById() Close", e);
			}
		}
		return animal;
	}

	@Override
	public List<Animal> findList() throws DaoException {
		Connection connection = null;
		List<Animal> listAnimal = new ArrayList<>();
		try {
			connection = JDBCManager.getInstance().openConection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Animal INNER JOIN specie on specie.id_Specie = animal.id_Specie");
			DisplayDataBase displayDataBase = new DisplayDataBase(resultSet);
			displayDataBase.display();
			resultSet.beforeFirst();
			while(resultSet.next()) {
				long id_Animal = resultSet.getLong("id_Animal");	
				String name = resultSet.getString("name");	
				int sex = resultSet.getInt("sex");
				String coatColor = resultSet.getString("coatColor");
				long id_Specie = resultSet.getLong("id_Specie");	
				String commonName = resultSet.getString("commonName");
				String latinName = resultSet.getString("commonName");
				Specie specie = new Specie(id_Specie, commonName, latinName);
				listAnimal.add(new Animal(id_Animal,name,sex,coatColor,specie));
			}
		} 
		catch (Exception e) {
			throw new DaoException("Erreur Animal findList()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Animal findList() Close", e);
			}
		}
		return listAnimal;
	}

	@Override
	public Animal updateById(Animal pT) throws DaoException {
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_UPDATE);
			preparedStatement.setString(1, pT.getName());
			preparedStatement.setInt(2, pT.getSex());
			preparedStatement.setString(3, pT.getCoatColor());
			preparedStatement.setLong(4, pT.getSpecie().getId());
			preparedStatement.setLong(5, pT.getId());
			preparedStatement.execute();
		}
		catch (Exception e) {
			throw new DaoException("Erreur Animal updateById()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Animal updateById() Close", e);
			}
		}
		return pT;
	}

	@Override
	public void deleteById(long pId) throws DaoException {
		Connection connection = null;
		deleteForeignById(pId);
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_DELETE);
			preparedStatement.setLong(1, pId);
			preparedStatement.execute();
		}
		catch (Exception e) {
			throw new DaoException("Erreur Animal deleteById()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Animal deleteById() Close", e);
			}
		}
	}

}
