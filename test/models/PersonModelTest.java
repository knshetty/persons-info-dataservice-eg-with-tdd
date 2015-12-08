package models;
import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;


public class PersonModelTest {
	private Calendar now = Calendar.getInstance();
	private int currentYear = now.get(Calendar.YEAR);
	private Person bart;
	private int bartAge;
	
	@Before
	public void setUp() throws Exception {
		bart = new Person(101,"Bart","Simpsons",1987,"Springfield","USA");
		bartAge = (currentYear - bart.getBirthYear());
	}

	@Test
	public void getAgeReturnItem() {
		int expectedAge = bartAge;
		assertEquals(expectedAge, bart.getAge());
	}
	
	@Test
	public void toStringReturnItem() {
		String expectedToString = "firstName: Bart, lastName: Simpsons, age: " + bartAge; 
		assertEquals(expectedToString, bart.toString());
	}

}
