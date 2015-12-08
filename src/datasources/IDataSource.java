package datasources;

import java.util.ArrayList;

import models.Person;

/**
 * This interface specifies a generic data-provider to extract persons dataset 
 * from various resources.
 * @author Nash
 */
public interface IDataSource {
	
	/**
	 * This method implements the extraction mechanics of persons dataset 
	 * from a given resource.
	 * @return dataset of persons
	 */
	ArrayList<Person> getPersons();

}
