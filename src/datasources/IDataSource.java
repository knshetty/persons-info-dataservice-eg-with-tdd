package datasources;

import java.util.ArrayList;

import models.Person;

/**
 * This interface specifies a generic data-provider to obtain persons dataset 
 * from various resources.
 * @author Nash
 */
public interface IDataSource {
	
	/**
	 * This method implements the extraction of persons dataset from resource.
	 * @return dataset of persons
	 */
	ArrayList<Person> getPersons();

}
