package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=3;
		 int startMinute=16;
		 int startDay=4;
		 int startMonth=7;
		 int startYear=2017;
		 String title="Fourth of July";
		 String description="Be there at 3:16.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
	// first assert the appt created by the constructor is valid 	
		 assertTrue(appt.getValid());   
	// now make sure the variables are set correctly, and that the following get functions work   
		 assertEquals(3, appt.getStartHour());
		 assertEquals(16, appt.getStartMinute());
		 assertEquals(4, appt.getStartDay());
		 assertEquals(7, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Fourth of July", appt.getTitle());
		 assertEquals("Be there at 3:16.", appt.getDescription());         		
	// now make sure set functions work correctly
		 appt.setStartHour(1);
		 appt.setStartMinute(2);
		 appt.setStartDay(3);
		 appt.setStartMonth(4);
		 appt.setStartYear(2000);
		 appt.setTitle("Ides of March");
		 appt.setDescription("New desc.");
		 assertTrue(appt.getValid());   
	 	 assertEquals(1, appt.getStartHour());
		 assertEquals(2, appt.getStartMinute());
		 assertEquals(3, appt.getStartDay());
		 assertEquals(4, appt.getStartMonth());
		 assertEquals(2000, appt.getStartYear());
		 assertEquals("Ides of March", appt.getTitle());
		 assertEquals("New desc.", appt.getDescription());         		
	 }
	 @Test
	 public void test02()  throws Throwable  {
		 Appt appt2 = new Appt(1, 1, 1, 1, 1, "Appointment A", "Description A");  	
		 assertEquals(0, appt2.getRecurDays().length);
		 assertEquals(2, appt2.getRecurBy());
		 assertEquals(0, appt2.getRecurIncrement());
		 assertEquals(0, appt2.getRecurNumber());
		 assertFalse(appt2.isRecurring());
		 int[] recurdays = new int[] {1, 2, 4};
		 appt2.setRecurrence(recurdays, appt2.RECUR_BY_WEEKLY, 2, appt2.RECUR_NUMBER_FOREVER);	
		 assertEquals(3, appt2.getRecurDays().length);
		 assertEquals(1, appt2.getRecurBy());
		 assertEquals(2, appt2.getRecurIncrement());
		 assertEquals(1000, appt2.getRecurNumber());
		 assertTrue(appt2.isRecurring());
         }

	 @Test
	  public void test03()  throws Throwable  {
		Appt appt3 = new Appt(1, 1, 1, 1, 1, null, null);
	//these tests are to cover all the branches in the getValid() function
		appt3.setStartHour(25);
		assertFalse(appt3.getValid());
		appt3.setStartHour(-1);
		assertFalse(appt3.getValid());
		appt3.setStartHour(0);
		assertTrue(appt3.getValid());
		appt3.setStartHour(24);
		assertTrue(appt3.getValid());

		appt3.setStartMinute(61);
		assertFalse(appt3.getValid());
		appt3.setStartMinute(60);
		assertTrue(appt3.getValid());
		appt3.setStartMinute(-1);
		assertFalse(appt3.getValid());
		appt3.setStartMinute(0);
		assertTrue(appt3.getValid());
		
		appt3.setStartDay(33);		 
		assertFalse(appt3.getValid());
		appt3.setStartDay(0);		 
		assertFalse(appt3.getValid());
		appt3.setStartDay(1);
		assertTrue(appt3.getValid());
		appt3.setStartDay(28);
		assertTrue(appt3.getValid());
		
		//any month outside of bounds causes a crash when calling NumDaysInMonth from calendarUtil.java
		//appt2.setStartMonth(13); 
		//appt3.setStartMonth(-1);		 
		//appt3.setStartMonth(1);		 
		appt3.setStartYear(2018);
		assertTrue(appt3.getValid());
	//any year outside of bounds causes a crash when calling NumDaysInMonth from calendarUtil.java
		//appt3.setStartYear(-1);
	//these cover all the branches in toString()	
		appt3.setTitle("Title");	
		appt3.setDescription("Desc");	
		assertEquals("1/28/2018 at 12:0pm ,Title, Desc", appt3.toString()); 
		appt3.setStartHour(23);
		assertEquals("1/28/2018 at 11:0pm ,Title, Desc", appt3.toString()); 
		appt3.setStartHour(-1);
		assertEquals(null, appt3.toString());
		appt3.setStartHour(11);
		assertEquals("1/28/2018 at 11:0am ,Title, Desc", appt3.toString()); 
	}
}
