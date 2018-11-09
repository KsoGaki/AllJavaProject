package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entitie.Automobile;
import business.entitie.Frein;
import business.entitie.Moteur;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class AutomobileDao implements IDAO<Automobile>{ 

	private final static String _INSERT = "INSERT INTO automobile(marque, modele, moteur_id, frein_id) VALUES (?,?,?,?)";
	private final static String _SELECTBYID = "SELECT * FROM automobile "
			+ "INNER JOIN frein on frein.id = automobile.frein_id "
			+ "INNER JOIN moteur on moteur.id = automobile.moteur_id "
			+ "WHERE automobile.id=?;";
	private final static String _SELECT = "SELECT * FROM automobile "
			+ "INNER JOIN frein on frein.id = automobile.frein_id "
			+ "INNER JOIN moteur on moteur.id = automobile.moteur_id;";
	private final static String _UPDATE = "UPDATE automobile SET marque=?, modele=?, moteur_id=?, frein_id=? WHERE automobile.id=?;";
	private final static String _DELETE = "DELETE FROM automobile WHERE automobile.id=?;";

	@Override
	public Automobile create(Automobile pT) throws DaoException {
		if(pT == null) {
			return null;
		}
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_INSERT, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, pT.getMarque());
			preparedStatement.setString(2, pT.getModele());
			preparedStatement.setLong(3, pT.getMoteur().getId());
			preparedStatement.setLong(4, pT.getFrein().getId());
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
	public Automobile findById(long pId) throws DaoException {
		Automobile automobile = null;
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_SELECTBYID);
			preparedStatement.setLong(1,pId);
			ResultSet resultSet = preparedStatement.executeQuery();

			MoteurDao moteurDao = new MoteurDao();
			FreinDao freinDao = new FreinDao();

			while(resultSet.next()) {
				Long id = resultSet.getLong("id");
				String marque = resultSet.getString("marque");
				String modele = resultSet.getString("modele");
				long idMoteur = resultSet.getLong("moteur_id");
				long idFrein = resultSet.getLong("frein_id");
				Moteur moteur = moteurDao.findById(idMoteur);
				Frein frein = freinDao.findById(idFrein);
				automobile = new Automobile(id, marque, modele, moteur, frein);
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
		return automobile;
	}

	@Override
	public List<Automobile> findList() throws DaoException {
		List<Automobile> listAutomobile = new ArrayList<>();
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(_SELECT);

			MoteurDao moteurDao = new MoteurDao();
			FreinDao freinDao = new FreinDao();

			while(resultSet.next()) {
				Long id = resultSet.getLong("id");
				String marque = resultSet.getString("marque");
				String modele = resultSet.getString("modele");
				long idMoteur = resultSet.getLong("moteur_id");
				long idFrein = resultSet.getLong("frein_id");
				Moteur moteur = moteurDao.findById(idMoteur);
				Frein frein = freinDao.findById(idFrein);
				listAutomobile.add(new Automobile(id, marque, modele, moteur, frein));
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
		return listAutomobile;
	}

	@Override
	public Automobile updateById(Automobile pT) throws DaoException {
		if(pT == null) {
			return null;
		}
		Connection connection = null;
		try {
			connection = JDBCManager.getInstance().openConection();
			PreparedStatement preparedStatement = connection.prepareStatement(_UPDATE);
			preparedStatement.setString(1, pT.getMarque());
			preparedStatement.setString(2, pT.getModele());
			preparedStatement.setLong(3, pT.getMoteur().getId());
			preparedStatement.setLong(4, pT.getFrein().getId());
			preparedStatement.setLong(5, pT.getId());
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
