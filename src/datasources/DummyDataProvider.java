package datasources;

import java.util.ArrayList;

import models.Person;

/**
 * This class implements a simple dummy data-provider, which is of 
 * IDataSource interface type. This data-provider yields persons dataset from 
 * following resource >> A prebuilt static data collection.
 * @author Nash
 */
public class DummyDataProvider implements IDataSource {
	
	private final ArrayList<Person> dataCollection = new ArrayList<>();
	
	/**
	 * This constructors a mockup data collection of persons.
	 */
	public DummyDataProvider() {
		this.populateDataCollection();
	}
	
	/* -----------------
	 * INTERFACE METHODS
	 * -----------------
	 */
	/**
	 * This method returns a static data collection of mockup persons
	 * @return persons collection 
	 */
	@Override
	public ArrayList<Person> getPersons() {
		return dataCollection;
	}
	
	/* -------------
	 * LOCAL METHODS
	 * -------------
	 */
	private void populateDataCollection() {
		dataCollection.add(new Person(101,"Bart","Simpsons",1987,"Springfield","USA"));
		dataCollection.add(new Person(102,"Lisa","Simpsons",1987,"Springfield","USA"));
		dataCollection.add(new Person(103,"Johnny","Tightlips",2000,"Springfield","USA"));
	}
}
