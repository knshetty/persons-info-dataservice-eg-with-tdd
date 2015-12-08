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
 * << Patterns >>
 * a. Test exceptions such as: NullPointerException, IndexOutOfBoundsException
 * 
 * << Anti-patterns >>
 * b. FileFormat Testing: Comma acts as the column separator
 * c. File Handling Testing: Open's csv-file and-only-there-after close's csv-file
 * d. Exception Handled By The Language: IOException a) while reading b) while closing
 * e. Exception Handled by The Language: FileNotFoundException
 */

public class CsvDataProviderTest {

	private CsvDataProvider cdp;
	private ArrayList<Person> persons;
	private Person bart;
	
	/**
	 * This method is a setup hook for test-cases, which ensures that each 
	 * test-case is dealing with known values.
	 */
	@Before
	public void setUp() throws Exception {
		cdp = new CsvDataProvider("resources/data.csv");
		persons = cdp.getPersons();
		bart = new Person(101,"Bart","Simpsons",1987,"Springfield","USA");
	}
	
	/**
	 * This method tests the side-effect of calling constructor i.e. populating 
	 * the dummy data-collection.
	 */
	@Test
	public void getPersonsReturnCollection() {
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
	 * This method tests the getPersons() method's return data-type item to match 
	 * with the IDataSource interface specification.
	 */
	@Test
	public void getPersonsReturnCollectionItemType() {
		Person expectedType = bart; 
		assertThat(expectedType, instanceOf(persons.get(0).getClass()));
	}
	
	/**
	 * This method tests if getPersons() method is an infinite loop 
	 */
	@Test(timeout=1000) // milliseconds, i.e. 1000=1sec
	public void getPersonsInInfiniteLoop() {
		assertNotNull(cdp.getPersons());	
	}
	
	/**
	 * This method tests the toggle mechanism for handling the absence of header
	 * field names within CSV file (i.e. first row in the CSV file). In essence,  
	 * this toggle mechanism injects also the first row into the 
	 * data-collection knowing there is no header present.
	 */
	@Test
	public void populateDataCollectionWithoutCsvFileHeader() {
		cdp = new CsvDataProvider("resources/data_no_header.csv");
		persons = cdp.getPersons();
		cdp.populateDataCollection(false);
		int expectedSize = 9;
		assertEquals(expectedSize, cdp.dataCollection.size());
	}
	
	/**
	 * This method tests the toggle mechanism for handling the presence of header
	 * field names within CSV file (i.e. first row in the CSV file). In essence,  
	 * this toggle mechanism avoids injecting header row into the data-collection.
	 */
	@Test
	public void populateDataCollectionWithCsvFileHeader() {
		cdp = new CsvDataProvider("resources/data_with_header.csv");
		persons = cdp.getPersons();
		cdp.populateDataCollection(true);
		int expectedSize = 9;
		assertEquals(expectedSize, cdp.dataCollection.size());
	}
	
}
