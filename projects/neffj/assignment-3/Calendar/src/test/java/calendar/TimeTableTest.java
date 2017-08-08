package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.*;


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
		LinkedList<CalDay> days = new LinkedList<CalDay>();
		days = tt.getApptRange(startD.appts, start, end);
		assertEquals(tt.getApptRange(startD.appts, start, end).size(), 31);
		CalDay day1 = new CalDay();
		CalDay day2 = new CalDay();
		CalDay day3 = new CalDay();
		CalDay day4 = new CalDay();
		day1 = days.get(7);
		day2 = days.get(14);
		day3 = days.get(21);
		day4 = days.get(28);
		assertEquals(day1.getAppts().getFirst(), day2.getAppts().getFirst());
		assertEquals(day3.getAppts().getFirst(), day4.getAppts().getFirst());

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
		LinkedList<CalDay> days = new LinkedList<CalDay>();
		days = tt.getApptRange(startD.appts, start, end);
		CalDay day1 = new CalDay();
		CalDay day2 = new CalDay();
		CalDay day3 = new CalDay();
		CalDay day4 = new CalDay();
		day1 = days.get(1);
		day2 = days.get(8);
		day3 = days.get(15);
		day4 = days.get(22);
		assertEquals(day1.getAppts().getFirst(), day2.getAppts().getFirst());
		assertEquals(day3.getAppts().getFirst(), day4.getAppts().getFirst());

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
		LinkedList<CalDay> days = new LinkedList<CalDay>();
		days = tt.getApptRange(startD.appts, start, end);
		CalDay day1 = new CalDay();
		CalDay day2 = new CalDay();
		day1 = days.get(1);
		day2 = days.get(32);
		assertEquals(day1.getAppts().getFirst(), day2.getAppts().getFirst());
 
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
	 	LinkedList<CalDay> days = new LinkedList<CalDay>();
		days = tt.getApptRange(startD.appts, start, end);
		CalDay day1 = new CalDay();
		CalDay day2 = new CalDay();
		day1 = days.get(1);
		day2 = days.get(366);
		assertEquals(day1.getAppts().getFirst(), day2.getAppts().getFirst());
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
	//tests the deleteAppt function. Deletes two valid appointment, attempts to
	//delete an invalid appt and one that has already been deleted  
	  public void test08()  throws Throwable  {
		TimeTable tt = new TimeTable();
		GregorianCalendar start= new GregorianCalendar(2017, 7, 20, 6, 30);
		GregorianCalendar end= new GregorianCalendar(2017, 9, 20, 6, 30);
		CalDay startD = new CalDay(start);	
		CalDay endD = new CalDay(end);	
		Appt appt1 = new Appt(8, 45, 21, 7, 2017, "8:45 appt", "Monthly, valid");
		appt1.setRecurrence(new int[] {1}, 2, 1, 1000);	
		startD.addAppt(appt1);	
		Appt appt2 = new Appt(8, 40, 21, 7, 2017, "8:40 appt", "Weekly on 21st and then tuesdays, valid");
		appt2.setRecurrence(new int[] {3}, 1, 1, 2);	
		startD.addAppt(appt2);	
		Appt appt3 = new Appt(8, 50, 21, 7, 2017, "8:50 appt", "Weekly on 21st and then tuesdays, valid");
		appt3.setRecurrence(new int[] {3}, 1, 1, 2);	
		startD.addAppt(appt3);
		Appt appt4 = new Appt(9, 70, 21, 7, 2017, "9:70 appt", "Invalid");

	
		tt.deleteAppt(startD.appts, appt2);
		LinkedList<CalDay> days = new LinkedList<CalDay>();
		days = tt.getApptRange(startD.appts, start, end);
		CalDay day1 = new CalDay();
		CalDay day2 = new CalDay();
		day1 = days.get(1);
		day2 = days.get(32);
		assertEquals(day1.getAppts().getFirst(), day2.getAppts().getFirst());		

		tt.deleteAppt(startD.appts, appt1);
		tt.deleteAppt(startD.appts, appt2);	
		tt.deleteAppt(startD.appts, appt3);	
		tt.deleteAppt(startD.appts, appt4);
		tt.deleteAppt(startD.appts, null);
		assertEquals(startD.appts.size(), 0);  	
	}
	@Test
	//tests the permute function. 
	  public void test09()  throws Throwable  {
		TimeTable tt = new TimeTable();
		GregorianCalendar start= new GregorianCalendar(2017, 7, 20, 6, 30);
		GregorianCalendar end= new GregorianCalendar(2017, 9, 20, 6, 30);
		CalDay startD = new CalDay(start);	
		CalDay endD = new CalDay(end);	
		Appt appt1 = new Appt(8, 20, 21, 7, 2017, "8:20 appt", "Weekly, valid");
		appt1.setRecurrence(new int[] {1}, 2, 1, 1000);	
		startD.addAppt(appt1);	
		Appt appt2 = new Appt(10, 0, 21, 7, 2017, "10:00 appt", "Weekly, valid");
		appt2.setRecurrence(new int[] {1}, 2, 1, 1000);	
		startD.addAppt(appt2);	
		Appt appt3 = new Appt(11, 50, 21, 7, 2017, "11:50 appt", "Weekly, valid");
		appt3.setRecurrence(new int[] {1}, 2, 1, 1000);	
		startD.addAppt(appt3);
		//tt.permute(startD.appts, new int[] {2, 1, 0});
		
		//tt.deleteAppt(startD.appts, appt2);
		
		LinkedList<CalDay> days = new LinkedList<CalDay>();
		days = tt.getApptRange(startD.appts, start, end);
		CalDay day1 = new CalDay();
		CalDay day2 = new CalDay();
		day1 = days.get(1);
		day2 = days.get(32);
		tt.permute(day1.appts, new int[] {2, 1, 0});
		tt.permute(day2.appts, new int[] {0, 2, 1});
		assertEquals(day1.getAppts().getFirst(), day2.getAppts().getFirst());		
	}
}
