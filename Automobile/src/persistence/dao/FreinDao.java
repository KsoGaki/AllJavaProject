package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entitie.Frein;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class FreinDao implements IDAO<Frein> {

	private final static String _INSERT = "INSERT INTO frein(marque, modele) VALUES (?,?)";
	private final static String _SELECTBYID = "SELECT * FROM frein WHERE id=?";
	private final static String _SELECT = "SELECT * FROM frein";
	private final static String _UPDATE = "UPDATE frein SET marque=?, modele=? WHERE id=?";
	private final static String _DELETE = "DELETE FROM frein WHERE id=?";

	@Override
	public Frein create(Frein pT) throws DaoException {
		if(pT == null) {
			return null;
		}
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_INSERT, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, pT.getMarque());
			preparedStatement.setString(2, pT.getModele());
			preparedStatement.execute();	

			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			while(resultSet.next()) {
				pT.setId(resultSet.getLong("GENERATED_KEY"));
			}

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				throw new DaoException(e);
			}
		}
		return pT;
	}

	@Override
	public Frein findById(long pId) throws DaoException {
		Frein frein = null;
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_SELECTBYID);
			preparedStatement.setLong(1,pId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Long id = resultSet.getLong("id");
				String marque = resultSet.getString("marque");
				String modele = resultSet.getString("modele");
				frein = new Frein(id, marque, modele);
			}

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				throw new DaoException(e);
			}
		}
		return frein;
	}

	@Override
	public List<Frein> findList() throws DaoException {
		List<Frein> listFrein = new ArrayList<>();
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(_SELECT);

			while(resultSet.next()) {
				Long id = resultSet.getLong("id");
				String marque = resultSet.getString("marque");
				String modele = resultSet.getString("modele");
				listFrein.add(new Frein(id, marque, modele));
			}

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				throw new DaoException(e);
			}
		}
		return listFrein;
	}

	@Override
	public Frein updateById(Frein pT) throws DaoException {
		if(pT == null) {
			return null;
		}
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_UPDATE);
			preparedStatement.setString(1, pT.getMarque());
			preparedStatement.setString(2, pT.getModele());
			preparedStatement.setLong(3, pT.getId());
			preparedStatement.execute();	
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				throw new DaoException(e);
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
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				throw new DaoException(e);
			}
		}
	}

}
