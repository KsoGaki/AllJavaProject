package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entitie.Moteur;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class MoteurDao implements IDAO<Moteur> { 

	private final static String _INSERT = "INSERT INTO moteur(marque, modele, cylindree) VALUES (?,?,?)";
	private final static String _SELECTBYID = "SELECT * FROM moteur WHERE id=?";
	private final static String _SELECT = "SELECT * FROM moteur";
	private final static String _UPDATE = "UPDATE moteur SET marque=?, modele=?, cylindree=? WHERE id=?";
	private final static String _DELETE = "DELETE FROM moteur WHERE id=?";

	@Override
	public Moteur create(Moteur pT) throws DaoException {
		if(pT == null) {
			return null;
		}
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_INSERT, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, pT.getMarque());
			preparedStatement.setString(2, pT.getModele());
			preparedStatement.setInt(3, pT.getCylindree());
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
	public Moteur findById(long pId) throws DaoException {
		Moteur moteur = null;
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
				int cylindree = resultSet.getInt("cylindree");
				moteur = new Moteur(id, marque, modele, cylindree);
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
		return moteur;
	}

	@Override
	public List<Moteur> findList() throws DaoException {
		List<Moteur> listMoteur = new ArrayList<>();
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(_SELECT);

			while(resultSet.next()) {
				Long id = resultSet.getLong("id");
				String marque = resultSet.getString("marque");
				String modele = resultSet.getString("modele");
				int cylindree = resultSet.getInt("cylindree");
				listMoteur.add(new Moteur(id, marque, modele, cylindree));
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
		return listMoteur;
	}

	@Override
	public Moteur updateById(Moteur pT) throws DaoException {
		if(pT == null) {
			return null;
		}
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_UPDATE);
			preparedStatement.setString(1, pT.getMarque());
			preparedStatement.setString(2, pT.getModele());
			preparedStatement.setInt(3, pT.getCylindree());
			preparedStatement.setLong(4, pT.getId());
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
