package calClass;

/*
    @file DateControl.java
    @author Ryan Niday
    @since 2016.02.27
    @details This class controls the date (year,month,day) that the calendar is specifically looking at.
                As the details of the date change, this class keeps track of it, and adjusts current
                year, month, and day respectively.
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

import calIO.CalFile;

public class DateControl {
	private Calendar myCal;						//The calendar keeping track of the date
	int month;									//Keeps track of the month currently being tracked
	int year;									//Keeps track of the year currently being tracked
	int day;									//Keeps track of the day currently being tracked
	
	
	
	
    /*
        @pre    CalFile has view of a txt file containing a date to start on
        @post   The calendar object is set to the start date found from CalFile
        @return None
     */
	public DateControl(){
		year = CalFile.getDate()/10000;
		month = (CalFile.getDate()/100) - (year*100);
		day = CalFile.getDate() - (((year*100)+month)*100);
		myCal = new GregorianCalendar(year,month-1,day);
	}
	
    /*
     @pre    None
     @post   None
     @return A single number representing the year, month, and day
     */
	public int setCurFileDate(){
		int buffer = year;
		buffer = buffer*100+month;
		buffer = buffer*100+day;
		return buffer;
	}
	
    /*
     @pre    Valid ints are inputed for year, month, and day
     @post   The current date of the Calendar object is set to the new input
     @return None
     */
	public void setCurDate(int year,int month,int day){
		this.year = year;
		this.month = month;
		this.day = day;
		myCal.set(year,month,day);
		CalFile.setDate(setCurFileDate());
	}
	
    /*
     @pre    Valid int is inputed for day
     @post   The current day of the Calendar object is set to the new input
     @return None
     */
	public void setCurDay(int day){
		myCal.set(Calendar.DATE, day);
		if(validDate()){
			this.day = day;
		}
		else{
			if(myCal.get(Calendar.DAY_OF_YEAR) < 182){
				myCal.set(2017,4,31);
			}
			else{
				myCal.set(2016,7,1);
			}
		}
		CalFile.setDate(setCurFileDate());
	}
	
    /*
     @pre    Valid int is inputed for month
     @post   The current month of the Calendar object is set to the new input
     @return None
     */
	public void setCurMonth(int month){
		myCal.set(Calendar.MONTH, month-1);
		if(validDate()){
			this.month = month;
		}
		else{
			if(myCal.get(Calendar.DAY_OF_YEAR) < 182){
				myCal.set(2017,4,31);
			}
			else{
				myCal.set(2016,7,1);
			}
		}
		CalFile.setDate(setCurFileDate());
	}
	
    /*
     @pre    Valid int is inputed for year
     @post   The current year of the Calendar object is set to the new input
     @return None
     */
	public void setCurYear(int year){
		this.year = year;
		myCal.set(Calendar.YEAR, year);
		CalFile.setDate(setCurFileDate());
	}
	
    /*
     @pre    None
     @post   None
     @return Current day of the week being tracked by the calendar
     */
	public int getCurDayOfWeek(){
		return myCal.get(Calendar.DAY_OF_WEEK);
	}
	
    /*
     @pre    None
     @post   None
     @return Current week of the year being tracked by the calendar
     */
	public int getCurWeek(){
		return myCal.get(Calendar.WEEK_OF_YEAR);
	}
	
    /*
     @pre    None
     @post   None
     @return Current day of the month being tracked by the calendar
     */
	public int getCurDay(){
		return myCal.get(Calendar.DATE);
	}
	
    /*
     @pre    None
     @post   None
     @return Current month being tracked by the calendar
     */
	public int getCurMonth(){
		return myCal.get(Calendar.MONTH) + 1;
	}
	
    /*
     @pre    None
     @post   None
     @return Current year bring tracked by the calendar
     */
	public int getCurYear(){
		return myCal.get(Calendar.YEAR);
	}
	
    /*
     @pre    None
     @post   None
     @return Day of the week for the first day of a month
     */
	public int firstDayOfMonth(){
		setCurDay(1);
		getCurDayOfWeek();
		myCal.set(year,month,day);
		return getCurDayOfWeek();
	}
	
    /*
     @pre    None
     @post   None
     @return Number of days in the currently tracked month
     */
	public int numDaysInMonth(){
		int curMonth = getCurMonth();
		setCurDay(28);
		while(getCurMonth() == curMonth){
			myCal.add(Calendar.DATE, 1);
		}
		myCal.add(Calendar.DATE, -1);
		myCal.set(year,month,day);
		return getCurDay();
	}
	
    
    /*
     @pre    None
     @post   None
     @return An array of the days in the selected month
     */
	public int[] daysOfTheMonth(){
		int[] daysOfMonth = new int[numDaysInMonth()];
		setCurDay(1);
		for(int i = 0; i < numDaysInMonth(); i++){
			daysOfMonth[i] = i + 1;
		}
		myCal.set(year,month,day);
		return daysOfMonth;
	}
	
    /*
     @pre    None
     @post   None
     @return An array of the days in the selected week
     */
	public int[] daysOfTheWeek(){
		int curWeek = getCurWeek();
		int[] daysOfWeek = new int[7];
		
		while(getCurWeek() == curWeek){
			myCal.add(Calendar.DATE, -1);
		}
		myCal.add(Calendar.DATE, 1);
		for(int i = 0;i < 7;i++){
			daysOfWeek[i] = getCurDay();
			myCal.add(Calendar.DATE, 1);
		}
		myCal.set(year,month,day);
		return daysOfWeek;
	}
	
	//Checks if date is in the calendar and returns true or false respectively
    /*
     @pre    None
     @post   None
     @return False if the selected day is after May 31, or before August 1
     */
	public boolean validDate(){
		if(myCal.get(Calendar.DAY_OF_YEAR) > 151 && myCal.get(Calendar.DAY_OF_YEAR) < 214){
			return false;
		}
		else{
			return true;
		}
	}
	
	//Converts the string name of a month into the number representation
    /*
     @pre    None
     @post   None
     @return The name corresponding to the number of the current month
     */
	public String monthName(){
        if(getCurMonth() == 8){
            return "August";
        }
        else if(getCurMonth() == 9){
            return "September";
        }
        else if(getCurMonth() == 10){
            return "October";
        }
        else if(getCurMonth() == 11){
            return "November";
        }
        else if(getCurMonth() == 12){
            return "December";
        }
        else if(getCurMonth() == 1){
            return "January";
        }
        else if(getCurMonth() == 2){
            return "February";
        }
        else if(getCurMonth() == 3){
            return "March";
        }
        else if(getCurMonth() == 4){
            return "April";
        }
        else if(getCurMonth() == 5){
            return "May";
        }
        else{
            return "Something weird happened";
        }
	}
}
