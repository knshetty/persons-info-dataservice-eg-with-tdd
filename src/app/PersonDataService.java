package app;

import java.util.ArrayList;

import models.Person;
import datasources.*;
/**
 * This class implements a Person-Info Service. This service can perform 
 * data-extraction from multiple resources and performs simple transformation 
 * operations on the extracted dataset. In addition, this service can filter 
 * persons based on their age group before outputting info to the screen.
 * @author Nash
 */
public class PersonDataService {

	/**
	 * This method is the main loop of this Person-Info Service.
	 * @param nuoriso an optional argument, which could be passed while invoking 
	 * this service. On using this argument one can list persons who are Minors
	 * (i.e. age below 18 years).
	 */
	public static void main(String[] args) {
		
		System.out.println("-------------------------------------");
		System.out.println("|   Workshop: Person-Info Service   |");
		System.out.println("-------------------------------------");
		
		final IDataSource csvSource = new CsvDataProvider("resources/data.csv");
		final IDataSource dummySource = new DummyDataProvider();

		// --- Request data ---
		final ArrayList<Person> persons_Csv = csvSource.getPersons();
		final ArrayList<Person> persons_Dummy = dummySource.getPersons();

		// --- Print all persons, when no arguments is passed ---
		if (args.length == 0) {
			System.out.println("<< Entire Dataset >>");
			printAll(persons_Csv);
			printAll(persons_Dummy);
		}
		// --- Print all Minors when "nuoriso" is passed as an argument ---
		else if (args[0].equals("nuoriso")) {
			System.out.println("<< Nuoriso >>");
			printMinors(persons_Csv);
			printMinors(persons_Dummy);
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
