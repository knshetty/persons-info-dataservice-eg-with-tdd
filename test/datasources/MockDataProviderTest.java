package datasources;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Collection;

import datasources.MockDataProvider;
import models.Person;

public class MockDataProviderTest {
	
	private MockDataProvider mdp;
	private ArrayList<Person> persons;
	private Person bart;
	
	@Before
	public void setUp() throws Exception {
		mdp = new MockDataProvider();
		persons = mdp.getPersons();
		bart = new Person(101,"Bart","Simpsons",1987,"Springfield","USA");
	}
	
	@Test
	public void constructorInvokePopulateCollection() {
		assertFalse(persons.isEmpty());
	}
	
	@Test
	public void getPersonsReturnCollectionType() {
		Collection<Object> expectedDataCollection = new ArrayList<>();
		assertThat(expectedDataCollection, instanceOf(persons.getClass()));
	}
	
	@Test
	public void getPersonsReturnCollectionItemType() {
		Person expectedType = bart;
		assertThat(bart, instanceOf(persons.get(0).getClass()));
	}

	@Test
	public void getPersonsReturnCollectionSize() {
		int expectedSize = 3;
		assertEquals(expectedSize, persons.size());
	}
	
	@Test(timeout=1000) // milliseconds, i.e. 1000=1sec
	public void getPersonsInInfiniteLoop() {
		assertNotNull(mdp.getPersons());	
	}
	
}
