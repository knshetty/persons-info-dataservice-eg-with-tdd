package app;

import java.util.ArrayList;

import models.Person;
import datasources.*;
/**
 * This class implements is a Person-Info Service. This service can perform 
 * lookup operations on persons data from multiple resources and filter results.
 * @author Nash
 */
public class PersonDataService {

	/**
	 * This method is the main loop of this Person-Info Service.
	 * @param nuoriso an optional argument, which could be passed while invoking 
	 * this service. This argument filters the results, who's ages are below 
	 * 18 years (i.e. enlist only Minors).
	 */
	public static void main(String[] args) {
		
		System.out.println("-------------------------------------");
		System.out.println("|   Workshop: Person-Info Service   |");
		System.out.println("-------------------------------------");
		
		final IDataSource csv = new CsvDataProvider("resources/data.csv");
		final IDataSource mockup = new MockDataProvider();

		// --- Request data ---
		final ArrayList<Person> persons_Csv = csv.getPersons();
		final ArrayList<Person> persons_Mockup = mockup.getPersons();

		// --- Print all persons, when no arguments is passed ---
		if (args.length == 0) {
			System.out.println("<< Entire Dataset >>");
			printAll(persons_Csv);
			printAll(persons_Mockup);
		}
		// --- Print all Minors when "nuoriso" is passed as an argument ---
		else if (args[0].equals("nuoriso")) {
			System.out.println("<< Nuoriso >>");
			printMinors(persons_Csv);
			printMinors(persons_Mockup);
		}
		// --- Handle invalid arguments ---
		else {
			System.out.println("Invalid argument!");
			System.out.println("Please input a valid argument, for e.g. 'nuoriso'");
		}
		
	}

	/*
	 * -------------
	 * LOCAL METHODS
	 * -------------
	 */
	private static void printMinors(ArrayList<Person> dataCollection) {
		for (Person person : dataCollection) {
			if (person.getAge() < 18) {
				System.out.println(person);
			}
		}
	}

	private static void printAll(ArrayList<Person> dataCollection) {
		for (Person person : dataCollection) {
			System.out.println(person);
		}
	}	
}
