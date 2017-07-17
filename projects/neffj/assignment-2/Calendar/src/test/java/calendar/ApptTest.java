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
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
		 assertEquals(0, appt.getRecurDays().length);
		 assertEquals(2, appt.getRecurBy());
		 assertEquals(0, appt.getRecurIncrement());
		 assertEquals(0, appt.getRecurNumber());
		 assertFalse(appt.isRecurring());
         		
	 }

	 @Test
	  public void test02()  throws Throwable  {
		Appt appt2 = new Appt(1, 1, 1, 1, 1, null, null);
		appt2.setStartHour(25);
		appt2.setStartHour(-1);
		appt2.setStartHour(0);
		appt2.setStartMinute(61);
		appt2.setStartMinute(-1);
		appt2.setStartMinute(1);
		appt2.setStartDay(40);		 
		appt2.setStartDay(1);		 
		appt2.setStartDay(2);
		//appt2.setStartMonth(100); any month outside of bounds causes a crash when calling NumDaysInMonth from calendarUtil.java
		appt2.setStartMonth(2);		 
		appt2.setStartYear(2017);
		appt2.setTitle("Title");	
		appt2.setDescription("Desc");	
		appt2.toString();
		appt2.setStartHour(23);
		appt2.toString(); 
	}
//add more unit tests as you needed


}
