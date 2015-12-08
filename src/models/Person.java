package models;

import java.util.Calendar;
/**
 * This class implements a person model by defining its properties and public methods.
 * @author Nash
 */
public class Person {
	
	private int id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private String city;
	private String country;
	
	private final Calendar now = Calendar.getInstance();
	private final int currentYear = now.get(Calendar.YEAR);

	/**
	 * This constructors the person model by initialising its properties
	 * @param id unique identifier of this person
	 * @param firstName person's first name
	 * @param lastName  person's last name
	 * @param birthYear person's year-of-birth
	 * @param city person's city of residence
	 * @param country person's country-of-origin
	 */
	public Person(int id, String firstName, String lastName,
				  int birthYear, String city, String country) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.city = city;
		this.country = country;
	}
	
	/* -------------
	 * LOCAL METHODS
	 * -------------
	 */
	/**
	 * This method computes this person's age
	 * @return this person age
	 */
	public int getAge() {
		return (currentYear - birthYear);
	}
	
	/**
	 * This method overrides the native toString method
	 * @return first name, last name & age of this person
	 */
    public String toString() {
        return String.format("firstName: " + firstName + ", " 
        					+ "lastName: " + lastName + ", " 
        					+ "age: " + getAge());
    }
	
	/* -------
	 * GETTERS
	 * -------
	 */
    /**
     * This method retrieves the local property of the person's unique identifier
     * @return id unique identifier of this person
     */
	public int getId() {
		return id;
	}
	/**
     * This method retrieves the local property of the person's first name
     * @return firstName first name of this person
     */
	public String getFirstName() {
		return firstName;
	}
	/**
     * This method retrieves the local property of the person's last name
     * @return lastName last name of this person
     */
	public String getLastName() {
		return lastName;
	}
	/**
     * This method retrieves the local property of the person's year-of-birth
     * @return birthYear year-of-birth of this person
     */
	public int getBirthYear() {
		return birthYear;
	}
	/**
     * This method retrieves the local property of the person's city of residence
     * @return city resident city of this person
     */
	public String getCity() {
		return city;
	}
	/**
     * This method retrieves the local property of the person's country-of-origin
     * @return country country-of-origin of this person
     */
	public String getCountry() {
		return country;
	}
	
	/* -------
	 * SETTERS
	 * -------
	 */
	/**
     * This method assigns the local property of the person's unique identifier
     * @param id unique identifier of this person
     */
	public void setId(int id) {
		this.id = id;
	}
	/**
     * This method assigns the local property of the person's first name
     * @param firstName first name of this person
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
     * This method assigns the local property of the person's last name
     * @param lastName last name of this person
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
     * This method assigns the local property of the person's year-of-birth
     * @param birthYear year-of-birth of this person
     */
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	/**
     * This method assigns the local property of the person's city of residence
     * @param city resident city of this person
     */
	public void setCity(String city) {
		this.city = city;
	}
	/**
     * This method assigns the local property of the person's country-of-origin
     * @param country country-of-origin of this person
     */
	public void setCountry(String country) {
		this.country = country;
	}
	
}
