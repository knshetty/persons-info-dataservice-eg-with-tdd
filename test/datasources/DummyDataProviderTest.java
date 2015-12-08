package datasources;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Collection;

import datasources.DummyDataProvider;
import models.Person;

public class DummyDataProviderTest {
	
	private DummyDataProvider mdp;
	private ArrayList<Person> persons;
	private Person bart;
	
	/**
	 * This method is a setup hooks for test-cases, which ensures that each 
	 * test-case is dealing with known values.
	 */
	@Before
	public void setUp() throws Exception {
		mdp = new DummyDataProvider();
		persons = mdp.getPersons();
		bart = new Person(101,"Bart","Simpsons",1987,"Springfield","USA");
	}
	
	/**
	 * This method tests the side-effect of calling constructor i.e. is the local 
	 * dummy data-collection populated.
	 */
	@Test
	public void constructorInvokePopulateCollection() {
		assertFalse(persons.isEmpty());
	}
	
	/**
	 * This method tests the returned data-type of getPersons() method to match 
	 * with the IDataSource interface specification.
	 */
	@Test
	public void getPersonsReturnCollectionType() {
		Collection<Object> expectedDataCollection = new ArrayList<>();
		assertThat(expectedDataCollection, instanceOf(persons.getClass()));
	}
	
	/**
	 * This method tests getPersons() method return data-type's item to match 
	 * with the IDataSource interface specification.
	 */
	@Test
	public void getPersonsReturnCollectionItemType() {
		Person expectedType = bart;
		assertThat(expectedType, instanceOf(persons.get(0).getClass()));
	}

	/**
	 * This method tests the number of rows contained within the dummy 
	 * data-collection.
	 */
	@Test
	public void getPersonsReturnCollectionSize() {
		int expectedSize = 3;
		assertEquals(expectedSize, persons.size());
	}
	
	/**
	 * This method tests if getPersons() method is an infinite loop 
	 */
	@Test(timeout=1000) // milliseconds, i.e. 1000=1sec
	public void getPersonsInInfiniteLoop() {
		assertNotNull(mdp.getPersons());	
	}
	
}
