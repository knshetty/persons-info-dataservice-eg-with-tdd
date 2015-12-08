package datasources;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import models.Person;

import org.junit.Before;
import org.junit.Test;

/*
 * Hint! http://programmers.stackexchange.com/questions/212309/how-do-i-test-a-file-reader
 * Summary:
 * 1. Avoid file formats testing
 * 2. Write small tests which test different functions in isolation
 * 3. Design functions such that you don't need to read the data out of a file
 * 4. FileReaders: Don't mask any errors when reading that data - create in-built
 * 	  checks/assertions, throw exceptions when an unexpected situation arises.
 * 
 * Therefore, patterns & anti-pattern are:
 * Patterns >>
 * a. Test for Exceptions: NullPointerException, IndexOutOfBoundsException
 * 
 * Anti-patterns >>
 * b. FileFormat Testing: Comma acts as the column separator
 * c. File Handling Testing: Open's csv-file and-only-there-after close's csv-file
 * d. Exception Handled By The Language: IOException a) while reading b) while closing
 * e. Exception Handled by The Language: FileNotFoundException
 */

public class CsvDataProviderTest {

	private CsvDataProvider cdp;
	private ArrayList<Person> persons;
	private Person bart;
	
	@Before
	public void setUp() throws Exception {
		cdp = new CsvDataProvider("resources/data.csv");
		persons = cdp.getPersons();
		bart = new Person(101,"Bart","Simpsons",1987,"Springfield","USA");
	}
	
	@Test
	public void getPersonsReturnCollection() {
		assertFalse(persons.isEmpty());
	}
	
	@Test
	public void getPersonsReturnCollectionType() {
		Collection<Object> dataCollection = new ArrayList<>();
		assertThat(dataCollection, instanceOf(persons.getClass()));
	}
	
	@Test
	public void getPersonsReturnCollectionItemType() {
		assertThat(bart, instanceOf(persons.get(0).getClass()));
	}
	
	@Test
	public void getPersonsReturnCollectionSize() {
		assertEquals(9, persons.size());
	}
	
	@Test(timeout=1000) // milliseconds, i.e. 1000=1sec
	public void getPersonsInInfiniteLoop() {
		assertNotNull(cdp.getPersons());	
	}
	
	@Test
	public void populateDataCollectionWithoutCsvFileHeader() {
		cdp = new CsvDataProvider("resources/data_no_header.csv");
		persons = cdp.getPersons();
		cdp.populateDataCollection(false);
		assertEquals(9, cdp.dataCollection.size());
	}
	
}
