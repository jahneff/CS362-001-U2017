package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	//this test will throw an exception in getApptRange because the end date is before the start date	
	 @Test(expected = DateOutOfRangeException.class) 
	  public void test01()  throws Throwable  {
	        TimeTable tt = new TimeTable();
	        GregorianCalendar start= new GregorianCalendar(2017, 7, 20, 6, 30);
	        GregorianCalendar end= new GregorianCalendar(2017, 7, 20, 6, 30);
      		CalDay startD = new CalDay(start);	
      		CalDay endD = new CalDay(end);
		Appt appt = new Appt(1, 1, 1, 1, 2000, "Valid Appt", "Valid Appt with default recurrence");
		startD.addAppt(appt);
		tt.getApptRange(startD.appts, start, end);
	}	
	//One month window, once a week recurrence on sundays  	
	 @Test 
	  public void test02()  throws Throwable  {
		TimeTable tt = new TimeTable();
		GregorianCalendar start= new GregorianCalendar(2017, 7, 20, 6, 30);
		GregorianCalendar end= new GregorianCalendar(2017, 8, 20, 6, 30);
		CalDay startD = new CalDay(start);	
		CalDay endD = new CalDay(end);	
		Appt appt = new Appt(23, 59, 21, 7, 2017, "Birthday", "Pool Party");
		appt.setRecurrence(new int[] {1}, 1, 1, 4);	
		startD.addAppt(appt);	
		assertEquals(tt.getApptRange(startD.appts, start, end).size(), 31); 
	 }
	//One month window, once a week recurrence on same day of week as start day  	
	 @Test 
	  public void test021()  throws Throwable  {
		TimeTable tt = new TimeTable();
		GregorianCalendar start= new GregorianCalendar(2017, 7, 20, 6, 30);
		GregorianCalendar end= new GregorianCalendar(2017, 8, 20, 6, 30);
		CalDay startD = new CalDay(start);	
		CalDay endD = new CalDay(end);	
		Appt appt = new Appt(23, 59, 21, 7, 2017, "Birthday", "Pool Party");
		appt.setRecurrence(new int[] {}, 1, 1, 4);	
		startD.addAppt(appt);	
		assertEquals(tt.getApptRange(startD.appts, start, end).size(), 31); 
	 }
	//appt date is after end of window, should return blank linked list	
	 @Test
	  public void test03()  throws Throwable  {
		TimeTable tt = new TimeTable();
		GregorianCalendar start= new GregorianCalendar(2017, 7, 20, 6, 30);
		GregorianCalendar end= new GregorianCalendar(2017, 8, 20, 6, 30);
		CalDay startD = new CalDay(start);	
		CalDay endD = new CalDay(end);	
		Appt appt = new Appt(23, 59, 21, 8, 2017, "Birthday", "Pool Party");
		appt.setRecurrence(new int[] {1}, 1, 1, 4);	
		startD.addAppt(appt);	
		assertEquals(tt.getApptRange(startD.appts, start, end).size(), 31);
	}
	//first appt is before start of window, should behave normally but will not mark appointments not in the window
	@Test
	  public void test04()  throws Throwable  {
		TimeTable tt = new TimeTable();
		GregorianCalendar start= new GregorianCalendar(2017, 7, 20, 6, 30);
		GregorianCalendar end= new GregorianCalendar(2017, 8, 20, 6, 30);
		CalDay startD = new CalDay(start);	
		CalDay endD = new CalDay(end);	
		Appt appt = new Appt(23, 59, 10, 7, 2017, "Birthday", "Pool Party");
		appt.setRecurrence(new int[] {1}, 1, 1, 4);	
		startD.addAppt(appt);	
		assertEquals(tt.getApptRange(startD.appts, start, end).size(), 31);
	}
	//two month window, once a month recurrence  	
	 @Test 
	  public void test05()  throws Throwable  {
		TimeTable tt = new TimeTable();
		GregorianCalendar start= new GregorianCalendar(2017, 7, 20, 6, 30);
		GregorianCalendar end= new GregorianCalendar(2017, 9, 20, 6, 30);
		CalDay startD = new CalDay(start);	
		CalDay endD = new CalDay(end);	
		Appt appt = new Appt(23, 59, 21, 7, 2017, "Birthday", "Pool Party");
		appt.setRecurrence(new int[] {1}, 2, 1, 4);	
		startD.addAppt(appt);	
		assertEquals(tt.getApptRange(startD.appts, start, end).size(), 61); 
	 }
	//Two year window, once a year recurrence  	
	 @Test 
	  public void test06()  throws Throwable  {
		TimeTable tt = new TimeTable();
		GregorianCalendar start= new GregorianCalendar(2017, 7, 20, 6, 30);
		GregorianCalendar end= new GregorianCalendar(2019, 7, 20, 6, 30);
		CalDay startD = new CalDay(start);	
		CalDay endD = new CalDay(end);	
		Appt appt = new Appt(23, 59, 21, 7, 2017, "Birthday", "Pool Party");
		appt.setRecurrence(new int[] {1}, 3, 1, 4);	
		startD.addAppt(appt);	
		assertEquals(tt.getApptRange(startD.appts, start, end).size(), 730); 
	 }
	//Tests the addiition of a non recurring appointment
	// should return a linked list with 31 caldays and 1 appt 
	@Test
	  public void test07()  throws Throwable  {
		TimeTable tt = new TimeTable();
		GregorianCalendar start= new GregorianCalendar(2017, 7, 20, 6, 30);
		GregorianCalendar end= new GregorianCalendar(2017, 8, 20, 6, 30);
		CalDay startD = new CalDay(start);	
		CalDay endD = new CalDay(end);	
		Appt appt = new Appt(23, 59, 21, 7, 2017, "Birthday", "Pool Party");
		appt.setRecurrence(new int[] {1}, 1, 1, 0);	
		startD.addAppt(appt);	
		assertEquals(tt.getApptRange(startD.appts, start, end).size(), 31);
	}
	@Test
	  public void test08()  throws Throwable  {
		TimeTable tt = new TimeTable();
		GregorianCalendar start= new GregorianCalendar(2017, 7, 20, 6, 30);
		GregorianCalendar end= new GregorianCalendar(2017, 8, 20, 6, 30);
		CalDay startD = new CalDay(start);	
		CalDay endD = new CalDay(end);	
		Appt appt1 = new Appt(23, 59, 21, 7, 2017, "11:59 appt", "Weekly, valid");
		appt1.setRecurrence(new int[] {}, 1, 1, 1000);	
		startD.addAppt(appt1);	
		Appt appt2 = new Appt(8, 70, 21, 7, 2017, "8:00 appt", "Weekly on 21st and then tuesdays, invalid");
		appt2.setRecurrence(new int[] {3}, 1, 1, 4);	
		startD.addAppt(appt2);	
		tt.deleteAppt(startD.appts, appt2);
		tt.deleteAppt(startD.appts, appt1);	
		assertEquals(tt.getApptRange(startD.appts, start, end).size(), 31);
	}
//add more unit tests as you needed
}
