package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
   	private static final int NUM_TESTS = 100;
	
	public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"getApptRange", "deleteAppt"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly
    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    	public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER
    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	

	 /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest() throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 10);;
				 int startYear=ValuesGenerator.RandInt(random);
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
				 int startHour2=ValuesGenerator.RandInt(random);
				 int startMinute2=ValuesGenerator.RandInt(random);
				 int startDay2=ValuesGenerator.RandInt(random);
				 int startMonth2=ValuesGenerator.RandInt(random);
				 int startYear2=ValuesGenerator.RandInt(random);
				 String title2="Birthday Party";
				 String description2="This is my birthday party.";
				 //Construct a new Appointment object with the initial data	 
				 Appt appt2 = new Appt(startHour2,
				          startMinute2,
				          startDay2,
				          startMonth2,
				          startYear2,
				          title2,
				         description2);

				 Appt appt3 = new Appt(4, 40, 4, 4, 1990, "Hard to delete", "covers a specific branch");
				
				 int randYear = startYear;
				 int randMonth = startMonth;
				 //int randMonth = ValuesGenerator.getRandomIntBetween(random, 1, 10);
				 int randDay = startDay;
				 int randMonth2 = randMonth+2;
				 int randDay2 = startDay;
				
				 GregorianCalendar greg1 = new GregorianCalendar(randYear, 2, randDay, 6, 30);
				 GregorianCalendar greg2 = new GregorianCalendar(randYear, 4, randDay, 6, 30);
				 TimeTable tt = new TimeTable();
				 appt.setRecurrence(new int[] {}, 1, 1, 4);
				 appt2.setRecurrence(new int[] {}, 1, 1, 4);
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
				CalDay day1 = new CalDay(greg1);
				CalDay day2 = new CalDay(greg2);
				String methodName = TimeTableRandomTest.RandomSelectMethod(random);
				appt2.setStartMinute(ValuesGenerator.getRandomIntBetween(random, 0, 80));
				day1.addAppt(appt);
				day1.addAppt(appt2);
			        if (methodName.equals("getApptRange")){
				tt.getApptRange(day1.appts, greg1, greg2);
				assertEquals(61, tt.getApptRange(day1.appts, greg1, greg2).size());
				try{
					tt.getApptRange(day1.appts, greg2, greg1);
				}catch(DateOutOfRangeException ex) {}
				}	
				else if (methodName.equals("deleteAppt")){
					tt.deleteAppt(day1.appts, appt);
					tt.deleteAppt(null, appt);
					tt.deleteAppt(day1.appts, null);
					tt.deleteAppt(day1.appts, appt3);
				}
					
			}	
			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
		 if((iteration%10000)==0 && iteration!=0 )
			 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
		}
		}catch (NullPointerException e){	 
		} 
		 
	 }


	
}
