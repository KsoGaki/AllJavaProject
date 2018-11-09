package persistence.dao;

import java.util.List;

import business.entitie.Animal;
import business.entitie.Specie;
import persistence.exception.DaoException;
import persistence.father.TestUnitDao;

public class TestAnimalDao extends TestUnitDao {

	AnimalDao animalDao = null;
	int nbRow  = 0;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		animalDao = new AnimalDao();
		nbRow = getInserter().select("SELECT COUNT(id_Animal) FROM animal").getDataAsInt();
	}

	public void testFindList() throws DaoException {
		List<Animal> listAnimal = animalDao.findList();
		assertEquals(nbRow, listAnimal.size());
	}

	public void testFindById() throws Exception {
		Animal animal = animalDao.findById(2);
		String animalName = getInserter().select("SELECT animal.name FROM animal WHERE id_Animal = " + 2).getDataAsString();
		assertEquals(animal.getName(), animalName);
		animal = animalDao.findById(10);
		assertNull(animal);
	}

	public void testCreate() throws DaoException {
		Specie specie = new Specie(1,"Said","Saidus");
		Animal animal = new Animal(0, "Said", 1, "Black", specie);
		animal = animalDao.create(animal);
		List<Animal> listAnimal = animalDao.findList();
		assertEquals(nbRow + 1, listAnimal.size());
		assertEquals(animal.getName(),animalDao.findById(animal.getId()).getName());
		animal = null;
		try {
			animalDao.create(animal);
		} catch (DaoException e) {
			assertNotNull(e);
		}
	}

	public void testDelete() throws DaoException {
		try {
			animalDao.deleteById(3);
			animalDao.findById(3);
		} catch (DaoException e) {
			assertNotNull(e);
		}
		try {
			animalDao.deleteById(10);
		} catch (DaoException e) {
			assertNotNull(e);
		}
	}

	public void testUpdate() throws DaoException {
		try {
			Specie specie = new Specie(1,"Said","Saidus");
			Animal animal = new Animal(1, "SaidBis", 1, "Brown", specie);
			animal = animalDao.updateById(animal);
			assertEquals(animal.getName(), animalDao.findById(animal.getId()).getName(),"SaidBis");
		} catch (DaoException e) {
			assertNotNull(e);
		}
		try {
			animalDao.deleteById(10);
		} catch (DaoException e) {
			assertNotNull(e);
		}
	}

}

