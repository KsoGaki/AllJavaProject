package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.classes.DisplayDataBase;
import business.entitie.Specie;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class SpecieDao implements IDAO<Specie> {

	public final static String _INSERT = "INSERT INTO specie (`commonName`, `latinName`) VALUES(?, ?)";
	public final static String _SELECT = "SELECT * FROM Specie WHERE id_Specie=?";
	public final static String _UPDATE = "UPDATE specie SET commonName=?, latinName=? WHERE id_Specie=?";
	public final static String _DELETE = "DELETE * FROM Specie WHERE id_Specie=?";

	@Override
	public Specie create(Specie pT) throws DaoException {
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_INSERT, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, pT.getCommonName());
			preparedStatement.setString(2, pT.getLatinName());
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			while(resultSet.next()) {
				pT.setId(resultSet.getLong("GENERATED_KEY"));
			}
		}
		catch (Exception e) {
			throw new DaoException("Erreur Specie create()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Specie create() Close", e);
			}
		}
		return pT;
	}

	@Override
	public Specie findById(long pId) throws DaoException {
		Connection connection = null;
		Specie specie = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_SELECT);
			preparedStatement.setLong(1, pId);
			ResultSet resultSet = preparedStatement.executeQuery();
			DisplayDataBase displayDataBase = new DisplayDataBase(resultSet);
			displayDataBase.display();
			resultSet.beforeFirst();
			while(resultSet.next()) {
				long id_Specie = resultSet.getLong("id_Specie");	
				String commonName = resultSet.getString("commonName");
				String latinName = resultSet.getString("latinName");
				specie = new Specie(id_Specie, commonName, latinName);
			}
		}
		catch (Exception e) {
			throw new DaoException("Erreur Specie findById()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Specie findById() Close", e);
			}
		}
		return specie;
	}

	@Override
	public List<Specie> findList() throws DaoException {
		Connection connection = null;
		List<Specie> listSpecie = new ArrayList<>();
		try {
			connection = JDBCManager.getInstance().openConection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Specie");
			DisplayDataBase displayDataBase = new DisplayDataBase(resultSet);
			displayDataBase.display();
			resultSet.beforeFirst();
			while(resultSet.next()) {
				long id_Specie = resultSet.getLong("id_Specie");	
				String commonName = resultSet.getString("commonName");	
				String latinName = resultSet.getString("latinName");
				listSpecie.add(new Specie(id_Specie,commonName,latinName));
			}
		}
		catch (Exception e) {
			throw new DaoException("Erreur Specie findList()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Specie findList() Close", e);
			}
		}
		return listSpecie;
	}

	@Override
	public Specie updateById(Specie pT) throws DaoException {
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_UPDATE);
			preparedStatement.setString(1, pT.getCommonName());
			preparedStatement.setString(2, pT.getLatinName());
			preparedStatement.setLong(2, pT.getId());
			preparedStatement.execute();
		}
		catch (Exception e) {
			throw new DaoException("Erreur Specie updateById()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Specie updateById() Close", e);
			}
		}
		return pT;
	}

	@Override
	public void deleteById(long pId) throws DaoException {
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_DELETE);
			preparedStatement.setLong(1, pId);
			preparedStatement.execute();
		}
		catch (Exception e) {
			throw new DaoException("Erreur Specie deleteById()", e);
		} 
		finally {
			try {
				connection.close();
				JDBCManager.getInstance().closeConnection();
			} 
			catch (SQLException e) {
				throw new DaoException("Erreur Specie deleteById() Close", e);
			}
		}
	}

}
