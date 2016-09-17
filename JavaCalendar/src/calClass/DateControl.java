import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateControl {
	private Calendar myCal;						//The calendar keeping track of the date
	int month;									//Keeps track of the month currently being tracked
	int year;									//Keeps track of the year currently being tracked
	int day;									//Keeps track of the day currently being tracked
	
	
	
	
	//Initializes the the calendar
	public DateControl() throws IOException{
		year = CalFile.getDate()/10000;
		month = (CalFile.getDate()/100) - (year*100);
		day = CalFile.getDate() - (((year*100)+month)*100);
		myCal = new GregorianCalendar(year,month-1,day);
	}
	
	//converts year, month, and day into one number
	public int setCurFileDate(){
		int buffer = year;
		buffer = buffer*100+month;
		buffer = buffer*100+day;
		return buffer;
	}
	
	//resets the overall date being tracked by the calendar
	public void setCurDate(int year,int month,int day) throws IOException{
		this.year = year;
		this.month = month;
		this.day = day;
		myCal.set(year,month,day);
		CalFile.setDate(setCurFileDate());
	}
	
	//resets the current day being tracked by the calendar
	public void setCurDay(int day) throws IOException {
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
	
	//resets the current month being tracked by the calendar
	public void setCurMonth(int month) throws IOException{
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
	
	//resets the current year being tracked by the calendar
	public void setCurYear(int year) throws IOException{
		this.year = year;
		myCal.set(Calendar.YEAR, year);
		CalFile.setDate(setCurFileDate());
	}
	
	//returns the current day of the week being tracked by the calendar
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
		return myCal.get(Calendar.MONTH) + 1;
	}
	
	//returns the current year being tracked by the calendar
	public int getCurYear(){
		return myCal.get(Calendar.YEAR);
	}
	
	//returns the day of the week the first day of the selected month falls on
	public int firstDayOfMonth() throws IOException{
		setCurDay(1);
		getCurDayOfWeek();
		myCal.set(year,month,day);
		return getCurDayOfWeek();
	}
	
	//returns the number of days in selected month
	public int numDaysInMonth() throws IOException{
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
	public int[] daysOfTheMonth() throws IOException{		
		int[] daysOfMonth = new int[numDaysInMonth()];
		setCurDay(1);
		for(int i = 0; i < numDaysInMonth(); i++){
			daysOfMonth[i] = i + 1;
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
			myCal.add(Calendar.DATE, 1);
		}
		myCal.set(year,month,day);
		return daysOfWeek;
	}
	
	//Checks if date is in the calendar and returns true or false respectively
	public boolean validDate(){
		if(myCal.get(Calendar.DAY_OF_YEAR) > 151 && myCal.get(Calendar.DAY_OF_YEAR) < 214){
			return false;
		}
		else{
			return true;
		}
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
