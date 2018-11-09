package persistence.dao;

import java.util.List;

import business.entitie.Moteur;
import exception.SqlInserterException;
import persistence.exception.DaoException;
import persistence.father.TestUnitDao;

public class TestMoteurDao extends TestUnitDao {

	Moteur moteur = null;
	MoteurDao moteurDao = null;
	int nbRow = 0;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		moteurDao = new MoteurDao();
		nbRow = getInserter().select("SELECT COUNT(*) FROM Moteur").getDataAsInt();
	}

	public void testFindList() throws DaoException {
		List<Moteur> listMoteur = moteurDao.findList();
		assertEquals(nbRow, listMoteur.size());
	}

	public void testFindById() throws DaoException, SqlInserterException {
		moteur = moteurDao.findById(1);
		assertNotNull(moteur);
		String marque = getInserter().select("SELECT marque FROM Moteur WHERE id=" + moteur.getId()).getDataAsString();
		assertEquals(marque, moteur.getMarque());
		moteur = moteurDao.findById(200);
		assertNull(moteur);
	}

	public void testCreate() throws DaoException {
		moteur = new Moteur(1, "Tobi", "Blop", 15);
		moteur = moteurDao.create(moteur);
		assertEquals(nbRow + 1, moteurDao.findList().size());
		assertEquals(moteur.getMarque(), moteurDao.findById(moteur.getId()).getMarque());

		moteur = null; 
		Moteur moteurNull = moteurDao.create(moteur);
		assertNull(moteurNull);
	}

	public void testUpdate() throws DaoException {
		moteur = moteurDao.findById(1);
		moteur.setMarque("Bip");
		moteur = moteurDao.updateById(moteur);
		assertEquals(moteur.getMarque(), moteurDao.findById(1).getMarque());

		moteur = null; 
		Moteur moteurNull = moteurDao.updateById(moteur);
		assertNull(moteurNull);
	}
	
	public void testDelete() throws DaoException {
		moteur = new Moteur(1,"Bip","Vop",1);
		moteur = moteurDao.create(moteur);
		assertNotNull(moteur);
		moteurDao.deleteById(moteur.getId());
		moteur = moteurDao.findById(moteur.getId());
		assertNull(moteur);
	}
	
}
