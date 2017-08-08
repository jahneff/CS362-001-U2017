package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test //tests the default constructor
	  public void test01()  throws Throwable  {
		CalDay day = new CalDay();
		assertFalse(day.isValid());
	 }
	 @Test //tests getters and setters
	  public void test04() throws Throwable   {
		GregorianCalendar greg = new GregorianCalendar(1990, 2, 3);
		CalDay day4 = new CalDay(greg);
		assertEquals(1990, day4.getYear());
		assertEquals(2, day4.getMonth());
		assertEquals(3, day4.getDay());
		assertTrue(day4.isValid());
	 } 
	 @Test
	  public void test02()  throws Throwable  {
		GregorianCalendar greg = new GregorianCalendar();
		CalDay day2 = new CalDay(greg);
		Appt appt4= new Appt(4, 4, 4, 4, 4, "first appt", "4s in all fields");
		day2.addAppt(appt4);
		assertEquals(4, day2.appts.getFirst().getStartHour());
		Appt appt1= new Appt(1, 1, 1, 1, 1, "second appt", "1s in all fields");
		day2.addAppt(appt1);
		Appt appt2 = new Appt(2, 2, 2, 2, 2, "third appt", "2s in all fields");
		day2.addAppt(appt2);
		//make sure they are being added in correct order
		assertEquals(1, day2.appts.getFirst().getStartHour());
		//make sure all are added
		assertEquals(3, day2.getSizeAppts());
		//use the iterator and tostring function with a valid day
		day2.iterator();
		assertEquals(" --- 7/7/2017 --- --- -------- Appointments ------------ ---1/1/1 at 1:1am ,second appt, 1s in all fields 4/4/4 at 4:4am ,first appt, 4s in all fields 2/2/2 at 2:2am ,third appt, 2s in all fields ", day2.toString());
	 }
	 @Test
	  public void test03()   throws Throwable  {
		GregorianCalendar greg = new GregorianCalendar();
		CalDay day3 = new CalDay();
		//use the iterator and tostring function with an invalid day 
		day3.iterator();
		day3.toString(); 
	}	 
	 @Test //add an invalid appointment to calendar
	  public void test05()   throws Throwable  {
		GregorianCalendar greg = new GregorianCalendar();
		CalDay day5 = new CalDay(greg);
		Appt appt5= new Appt(-1, -1, -1, 1, 1, "Invalid", "Invalid Desc");
	  	day5.addAppt(appt5);
		assertEquals(0, day5.getSizeAppts());
	}
//add more unit tests as you needed	
}
