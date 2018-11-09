package persistence.dao;

import java.util.List;

import business.entitie.Automobile;
import business.entitie.Frein;
import business.entitie.Moteur;
import exception.SqlInserterException;
import persistence.exception.DaoException;
import persistence.father.TestUnitDao;

public class TestAutomobileDao extends TestUnitDao {

	Automobile automobile = null;
	MoteurDao moteurDao = null;
	FreinDao freinDao = null;
	AutomobileDao automobileDao = null;
	int nbRow = 0;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		moteurDao = new MoteurDao();
		automobileDao = new AutomobileDao();
		freinDao = new FreinDao();
		nbRow = getInserter().select("SELECT COUNT(*) FROM automobile").getDataAsInt();
	}

	public void testFindList() throws DaoException {
		List<Automobile> listAutomobile = automobileDao.findList();
		assertEquals(nbRow, listAutomobile.size());
	}

	public void testFindById() throws DaoException, SqlInserterException {
		automobile = automobileDao.findById(1);
		assertNotNull(automobile);
		String marque = getInserter().select("SELECT marque FROM automobile").getDataAsString();
		assertEquals(marque, automobile.getMarque());

		automobile = automobileDao.findById(200);
		assertNull(automobile);
	}

	public void testCreate() throws DaoException {
		Moteur moteur = moteurDao.findById(1);
		Frein frein = freinDao.findById(1);
		automobile = new Automobile(1, "Tobi", "Blop", moteur, frein);
		automobile = automobileDao.create(automobile);
		assertEquals(nbRow + 1, automobileDao.findList().size());
		assertEquals(automobile.getMarque(), automobileDao.findById(automobile.getId()).getMarque());

		automobile = null; 
		Automobile automobileNull = automobileDao.create(automobile);
		assertNull(automobileNull);
	}

	public void testUpdate() throws DaoException {
		automobile = automobileDao.findById(1);
		automobile.setMarque("Bip");
		automobile = automobileDao.updateById(automobile);
		assertEquals(automobile.getMarque(), automobileDao.findById(1).getMarque());

		automobile = null; 
		Automobile automobileNull = automobileDao.updateById(automobile);
		assertNull(automobileNull);
	}
	
	public void testDelete() throws DaoException {
		Moteur moteur = new Moteur(1,"Bip","Bop",15);
		Frein frein = new Frein(1,"Bip","Bop");
		automobile = new Automobile(1,"Bip", "Bop", moteur, frein);
		automobile = automobileDao.create(automobile);
		assertNotNull(automobileDao.findById(automobile.getId()));
		automobileDao.deleteById(automobile.getId());
		assertNull(automobileDao.findById(automobile.getId()));
	}
	
}
