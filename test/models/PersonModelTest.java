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
		assertEquals(bartAge, bart.getAge());
	}
	
	@Test
	public void toStringReturnItem() {
		assertEquals("firstName: Bart, lastName: Simpsons, age: "+bartAge, 
						bart.toString());
	}

}
