package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 10 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	public static int RandomSelectRecur(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly
    		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        	return RecurArray[n] ; // return the value of the  appointments to recur 
        	}
	public static int RandomSelectRecurForEverNever(Random random){
        	int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER
	    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
	        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
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
				 int startDay=ValuesGenerator.RandInt(random);;
				 int startMonth=ValuesGenerator.RandInt(random);;
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
				 int startDay2=ValuesGenerator.RandInt(random);;
				 int startMonth2=ValuesGenerator.RandInt(random);;
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

				 int randYear = ValuesGenerator.getRandomIntBetween(random, 1900, 2100);
				 int randMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
				 int randDay = ValuesGenerator.getRandomIntBetween(random, 1, 30);
			 	
				 GregorianCalendar greg = new GregorianCalendar(randYear, randMonth, randDay);
				 CalDay day = new CalDay(greg);
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
				appt.setStartHour(ValuesGenerator.getRandomIntBetween(random, 1, 30)); 
				day.addAppt(appt);
				day.addAppt(appt2);
			}
		 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
		 if((iteration%10000)==0 && iteration!=0 )
			 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
		 } 
	 }catch (NullPointerException e){
	
	}

}
	
}
