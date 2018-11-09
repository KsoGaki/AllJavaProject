package persistence.dao;

import java.util.List;

import business.entitie.Frein;
import exception.SqlInserterException;
import persistence.exception.DaoException;
import persistence.father.TestUnitDao;

public class TestFreinDao extends TestUnitDao {

	Frein frein = null;
	FreinDao freinDao = null;
	int nbRow = 0;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		freinDao = new FreinDao();
		nbRow = getInserter().select("SELECT COUNT(*) FROM frein").getDataAsInt();
	}

	public void testFindList() throws DaoException {
		List<Frein> listFrein = freinDao.findList();
		assertEquals(nbRow, listFrein.size());
	}

	public void testFindById() throws DaoException, SqlInserterException {
		frein = freinDao.findById(1);
		assertNotNull(frein);
		String marque = getInserter().select("SELECT marque FROM frein WHERE id=" + frein.getId()).getDataAsString();
		assertEquals(marque, frein.getMarque());

		frein = freinDao.findById(200);
		assertNull(frein);
	}

	public void testCreate() throws DaoException {
		frein = new Frein(1, "Tobi", "Blop");
		frein = freinDao.create(frein);
		assertEquals(nbRow + 1, freinDao.findList().size());
		assertEquals(frein.getMarque(), freinDao.findById(frein.getId()).getMarque());

		frein = null; 
		Frein freinNull = freinDao.create(frein);
		assertNull(freinNull);
	}

	public void testUpdate() throws DaoException {
		frein = freinDao.findById(1);
		frein.setMarque("Bip");
		frein = freinDao.updateById(frein);
		assertEquals(frein.getMarque(), freinDao.findById(1).getMarque());

		frein = null; 
		Frein freinNull = freinDao.updateById(frein);
		assertNull(freinNull);
	}
	
	public void testDelete() throws DaoException {
		frein = new Frein(1,"Bip","Vop");
		frein = freinDao.create(frein);
		assertNotNull(frein);
		freinDao.deleteById(frein.getId());
		frein = freinDao.findById(frein.getId());
		assertNull(frein);
	}
}
