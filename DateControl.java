import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateControl {
	private Calendar myCal;								//The calendar keeping track of the date
	int month;								//Keeps track of the month currently being tracked
	int year;									//Keeps track of the year currently being tracked
	int day;									//Keeps track of the day currently being tracked
	
	
	
	
	//Initializes the the calendar
	public DateControl(/*year,month,day*/){
		//this.year = year;
		//this.month = (month - 1);
		//this.day = day;
		myCal = new GregorianCalendar(2017,1,1);
	}
	
	//resets the overall date being tracked by the calendar
	public void setCurDate(int year,int month,int day){
		this.year = year;
		this.month = month;
		this.day = day;
		myCal.set(year,month,day);
	}
	
	//resets the current day being tracked by the calendar
	public void setCurDay(int day) {
		this.day = day;
		myCal.set(Calendar.DATE, /*this.*/day);
	}
	
	//resets the current month being tracked by the calendar
	public void setCurMonth(int month){
		month = month - 1;
		this.month = month - 1;
		myCal.set(Calendar.MONTH, /*this.*/month);
	}
	
	//resets the current year being tracked by the calendar
	public void setCurYear(int year){
		this.year = year;
		myCal.set(Calendar.YEAR, /*this.*/year);
	}
	
	public int getCurDayOfWeek(){
		return myCal.get(Calendar.DAY_OF_WEEK);
	}
	
	//returns the current week of the year being tracked by the calendar
	public int getCurWeek(){
		return myCal.get(Calendar.WEEK_OF_YEAR);
	}
	
	//returns the current day of the month being tracked by the calendar
	public int getCurDay(){
		return myCal.get(Calendar.DATE);
	}
	
	//returns the current month of the year being tracked by the calendar
	public int getCurMonth(){
		return myCal.get(Calendar.MONTH);
	}
	
	//returns the current year being tracked by the calendar
	public int getCurYear(){
		return myCal.get(Calendar.YEAR);
	}
	
	//returns the day of the week the first day of the selected month falls on
	public int firstDayOfMonth(){
		setCurDay(1);
		getCurDayOfWeek();
		myCal.set(year,month,day);
		return getCurDayOfWeek();
	}
	
	//returns the number of days in selected month
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
	
	//returns an array of all the days in the selected month
	public int[] daysOfTheMonth(){		
		int[] daysOfMonth = new int[numDaysInMonth()];
		setCurDay(1);
		for(int i = 0; i < numDaysInMonth(); i++){
			daysOfMonth[i] = i + 1;
			//System.out.println(daysOfMonth[i]);
		}
		myCal.set(year,month,day);
		return daysOfMonth;
	}
	
	//returns an array of all the days in the selected week
	public int[] daysOfTheWeek(){
		int curWeek = getCurWeek();
		int[] daysOfWeek = new int[7];
		
		while(getCurWeek() == curWeek){
			myCal.add(Calendar.DATE, -1);
		}
		myCal.add(Calendar.DATE, 1);
		for(int i = 0;i < 7;i++){
			daysOfWeek[i] = getCurDay();
			//System.out.println(daysOfWeek[i]);
			myCal.add(Calendar.DATE, 1);
		}
		myCal.set(year,month,day);
		return daysOfWeek;
	}
	
	//Converts the string name of a month into the number representation
	public int monthNum(String monthName){
		if(monthName.toLowerCase().equals("january")){
			return 1;
		}
		else if(monthName.toLowerCase().equals("february")){
			return 2;
		}
		else if(monthName.toLowerCase().equals("march")){
			return 3;
		}
		else if(monthName.toLowerCase().equals("april")){
			return 4;
		}
		else if(monthName.toLowerCase().equals("may")){
			return 5;
		}
		else if(monthName.toLowerCase().equals("june")){
			return 6;
		}
		else if(monthName.toLowerCase().equals("july")){
			return 7;
		}
		else if(monthName.toLowerCase().equals("august")){
			return 8;
		}
		else if(monthName.toLowerCase().equals("september")){
			return 9;
		}
		else if(monthName.toLowerCase().equals("october")){
			return 10;
		}
		else if(monthName.toLowerCase().equals("november")){
			return 11;
		}
		else if(monthName.toLowerCase().equals("december")){
			return 12;
		}
		else{
			return 0;
		}
	}
}
