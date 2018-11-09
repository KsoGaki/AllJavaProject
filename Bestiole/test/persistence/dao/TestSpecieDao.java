package persistence.dao;

import java.util.List;

import business.entitie.Specie;
import persistence.exception.DaoException;
import persistence.father.TestUnitDao;

public class TestSpecieDao extends TestUnitDao {

	SpecieDao specieDao = null;
	int nbRow  = 0;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		specieDao = new SpecieDao();
		nbRow = getInserter().select("SELECT COUNT(id_Specie) FROM specie").getDataAsInt();
	}

	public void testFindList() {
		try {
			List<Specie> listSepcie = specieDao.findList();
			assertEquals(nbRow , listSepcie.size());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	public void testFindById() {
		try {
			Specie specie = specieDao.findById(1);
			Specie specieTwo = new Specie(1, "Rabbit", "Lepus");
			assertEquals(specieTwo.getCommonName(), specie.getCommonName());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		try {
			specieDao.findById(4);
		} catch (DaoException e) {
			assertNotNull(e);
		}
	}

	public void testCreate() {
		try {
			Specie specie = new Specie(4,"Saïd","SaïDus");
			specie = specieDao.create(specie);
			List<Specie> listSpecie = specieDao.findList();
			Specie specieTwo = specieDao.findById(specie.getId());
			assertEquals(nbRow + 1, listSpecie.size());
			assertEquals(specieTwo.getCommonName(), specie.getCommonName());

		} catch (DaoException e) {
			e.printStackTrace();
		}
		try {
			Specie specieNull = new Specie(4,null,null);
			specieDao.create(specieNull);
		} catch (DaoException e) {
			assertNotNull(e);
		}
	}

	public void testDelete() {
		try {
			specieDao.deleteById(3);
			specieDao.findById(3);
		} catch (DaoException e) {
			assertNotNull(e);
		}
		try {
			specieDao.deleteById(4);
		} catch (DaoException e) {
			assertNotNull(e);
		}
	}

	public void testUpdate() {
		try {
			Specie specie = new Specie(1, "Rabbite", "Rabbitus");
			specie = specieDao.updateById(specie);
			Specie specieTwo = specieDao.findById(1);
			assertEquals(specie.getCommonName(), specieTwo.getCommonName());
		} catch (DaoException e) {
		}
		try {
			Specie specie = new Specie(5, "Rabbite", "Rabbitus");
			specieDao.updateById(specie);
		} catch (DaoException e) {
			assertNotNull(e);
		}
	}

}
