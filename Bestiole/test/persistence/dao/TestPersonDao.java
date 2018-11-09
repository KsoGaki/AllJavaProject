package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import business.entitie.Animal;
import business.entitie.Person;
import business.entitie.Specie;
import exception.SqlInserterException;
import persistence.exception.DaoException;
import persistence.father.TestUnitDao;

public class TestPersonDao extends TestUnitDao {

	PersonDao personDao = null;
	Specie specie = null;
	List<Animal> listAnimal = null;
	Person person = null;
	int nbRow = 0;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		personDao = new PersonDao();
		specie = new Specie(1,"Zabbit","Zepus");
		listAnimal = new ArrayList<>();
		listAnimal.add(new Animal(1,"ZaiDoux",0,"Zellow",specie));
		listAnimal.add(new Animal(2,"ZaiDange",1,"Zhite",specie));
		person = new Person(1, "Zaid", "Zubram", 55, listAnimal);
		nbRow = getInserter().select("SELECT COUNT(id_Person) FROM Person").getDataAsInt();
	}

	public void testFindList() throws DaoException {
		List<Person> listPerson = personDao.findList();
		assertEquals(nbRow, listPerson.size());
	}

	public void testFindById() throws DaoException, SqlInserterException {
		Person personById = personDao.findById(1);
		String firstName = getInserter().select("SELECT person.firstName FROM Person WHERE id_Person = " + personById.getId()).getDataAsString();
		assertEquals(firstName, personById.getFirstName());
		personById = personDao.findById(60);
		assertNull(personById);
	}
	
	public void testCreate() throws DaoException {
		Person personCreate = personDao.create(person); 
		List<Person> listPerson = personDao.findList();
		assertEquals(nbRow + 1, listPerson.size());
		assertEquals(personCreate.getFirstName(), personDao.findById(personCreate.getId()).getFirstName());
		person = null;
		personCreate = personDao.create(person);
		assertNull(person);
	}
	
	public void testDelete() throws DaoException {
		person = personDao.findById(1);
		assertNotNull(person);
		personDao.deleteById(1);
		person = personDao.findById(1);
		assertNull(person);
	}
	
	public void testUpdate() throws DaoException {
		person = personDao.findById(1);
		assertNotNull(person);
		person.setFirstName("Haha");
		person = personDao.updateById(person);
		assertEquals(person.getFirstName(), personDao.findById(person.getId()).getFirstName());
		
		person = null;
		person = personDao.updateById(person);
		assertNull(person);
	}

}
