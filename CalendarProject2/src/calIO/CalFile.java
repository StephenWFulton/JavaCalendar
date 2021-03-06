package calIO;

/**
 *	@file CalFile.java
 *	@author Stuart Wreath
 *	@since 2016.09.17
 *
 */

import java.io.*;
import java.util.Scanner;

public class CalFile{
    /**
     *	@pre None.
     *	@post None.
     *	@return Allows user to run methods of this file at will.
     *
     */
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String str = "";
        int choice = 1000;
        int date = 0;
        boolean result = false;
        while(choice != 0){
            System.out.println("-----------------------------------------------------------");
            System.out.println("1.Initialize  2.Read     3.Write     4.getDate  5.setDate \n6.getView     7.setView  8.getFirst  9.getLast  0.quit");
            choice = kb.nextInt();
            if(choice == 1){
                result = CalInit();
                System.out.println(result);
            }
            if(choice == 2){
                System.out.println("Enter a date in YYYYMMDD: ");
                date = kb.nextInt();
                str = CalRead(date);
                System.out.println("Event at that date: " + str);
            }
            if(choice == 3){
                System.out.print("Enter a date in YYYYMMDD: ");
                date = kb.nextInt();
                kb.nextLine();
                System.out.print("Enter an Event: ");
                String event = kb.nextLine();
                result = CalWrite(date,event);
                if(result == true){System.out.println("Success");}
                else{System.out.println("Failure");}
            }
            if(choice == 4){
                date = getDate();
                System.out.println("Current date: " + date);
            }
            if(choice == 5){
                System.out.print("Enter new current date: ");
                date = kb.nextInt();
                result = setDate(date);
                if(result == true){System.out.println("Success");}
                else{System.out.println("Failure");}
            }
            if(choice == 6){
                str = getView();
                System.out.println("Current view: " + str);
            }
            if(choice == 7){
                kb.nextLine();
                System.out.print("Enter new view: ");
                str = kb.nextLine();
                result = setView(str);
                if(result == true){System.out.println("Success");}
                else{System.out.println("Failure");}
            }
            if(choice == 8){
                date = getFirst();
                System.out.println("First date in calendar: " + date);
            }
            if(choice == 9){
                date = getLast();
                System.out.println("Last date in calendar: " + date);
            }
	    if(choice == 10){
		result = CalExist();
                if(result == true){System.out.println("The File Exists");}
                else{System.out.println("The File does not Exist");}
	    }
        }
        kb.close();
    }

    /**
     *	@pre None.
     *	@post None.
     *	@return If the file exists it returns true, if not returns false.
     *
     */
    public static boolean CalExist(){
	File file = new File("CalendarInfo.txt");
	boolean Existance = file.exists();
	return Existance;
    }
    
    /**
     *	@pre None.
     *	@post A file called CalendarInfo.txt exists with proper information and formatting
     *	@return None
     *
     */
    public static boolean CalInit(){
        try{
            File file = new File("CalendarInfo.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("***************Current_Open_Settings***************");
            bw.newLine();
            //fw.write(System.lineSeparator());
            bw.write("Current_date: 20160801");
            bw.newLine();
            bw.write("Current_View: year");
            bw.newLine();
            bw.write("First_Date: 20160801");
            bw.newLine();
            bw.write("Last_Date: 20170531");
            bw.newLine();
            bw.write("*******************Saved_Events********************");
            bw.newLine();
            
            int date = 20160801;
            int dpm = 31;
            int m = 1;
            
            while(m < 11)
            {
                if(m == 1 || m == 3 || m == 5 || m == 6 || m == 8 || m == 10){dpm = 31;}
                else if(m == 2 || m == 4 || m == 9){dpm = 30;}
                else{dpm = 28;}
                
                for(int i = 0; i < dpm; i ++){
                    bw.write(Integer.toString(date));
                    bw.newLine();
                    date ++;
                }
                date -= dpm;
                date += 100;
                if(m == 5){date += 8800;}
                m++;
            }
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return(true);
    }
    
    /**
     * <p>Removes the given event at the given date, or removes all instances of the given event from the Calendar</p>
     * @param event - String: Event in the form of "starttime endtime event"
     * @param date - Int: Date at which the event will be removed (presuming single is selected)
     * @param removeAll - Boolean: True if all events removed, false if single event removed
     * @author Stephen Fulton
     * @pre event is valid, date is valid, bool is valid
     * @post None
     * @return None
     */
    public static void remove(String event, int date, boolean removeAll)
    {
    	try{
    		String curDate = String.valueOf(date);
    		BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
            File file2 = new File("2CalendarInfo.txt");
            file2.createNewFile();
            File file = new File("CalendarInfo.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
            String line = br.readLine();
            if(removeAll)
            {
            	while(line != null)
            	{
            		if(line.equals(event)){}
            		else
            		{
            			bw.write(line);
            			bw.newLine();
            		}
            		line = br.readLine();
            	}
            }
            else
            {
            	while(!line.equals(curDate))
            	{
            		bw.write(line);
            		bw.newLine();
            		line = br.readLine();
            	}
            	while(!line.equals(event))
            	{
            		bw.write(line);
            		bw.newLine();
            		line = br.readLine();
            	}
            	line = br.readLine();
            	while(line != null)
            	{
            		bw.write(line);
            		bw.newLine();
            		line = br.readLine();
            	}
            }
            bw.close();
            br.close();
            file.delete();
            file2.renameTo(file);
    	}catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    /**
     *	@pre The CalendarInfo.txt file exists and has proper information and dates in it.
     *	@post None.
     *	@return String that holds the event written at the date inputed.
     *
     */
    public static String CalRead(int date){
        try{
            String curDate = Integer.toString(date);
            String nextDate = Integer.toString(getNextDay(date));
            int Enddate = 0;
            if(nextDate.equals("20170531")) Enddate = 1;
            BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
            
            String sb = "";
            String line = br.readLine();
            for(int y = 0; y < 5; y ++){
                line = br.readLine();
            }
            while(!(line.equals(curDate))){
                line = br.readLine();
            }
            if(Enddate == 0){
            	line = br.readLine();
            	while(!(line.equals(nextDate))){
            		if(sb.equals("") || line.equals("")){
            			sb = sb + line;
            		}
            		else{
            			sb = sb + "\n" +line;
            		}
            		line = br.readLine();
            	}
            }
            else {
            	while((line = br.readLine())!= null){
            		if(sb.equals("") || line.equals("")){
            			sb = sb + line;
            		}
            		else{
            			sb = sb + "\n" +line;
            		}
            	}
            	Enddate = 0;
            }
            br.close();
            return sb;
        }
        catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    
    /**
     * <p>Gets the events from the given date and returns them as one string.
     * @param date - Int: Indicates the date from which events are pulled.
     * @return String of all events on given date
     * @author Stephen Fulton
     * @pre Date is valid
     * @post None
     */
    public static String getEvents(int date)
    {
    	String temp = "";
    	String[] x = CalReadV2(date, false);
    	for (int i = 0; i < x.length; i++)
    	{
    		temp += x[i] + "\n";
    	}
    	return temp;
    }
    
    /**
     * <p> Reads in all events on a given date from file, returns them as an array of strings
     * @param date: Int: Date at which the events will be read in
     * @param box - Boolean: Indicates whether the function should return just the events themselves or an array in which the events are marked if they conflict.
     * @return Array of Events (box - true: just the events, false: Events are marked if conflicting)
     * @author: Stephen Fulton
     * @pre: date is valid, box is valid
     * @post: None
     */
    public static String[] CalReadV2(int date, boolean box)
    {
    	try{
    		String curDate = Integer.toString(date);
            String nextDate = Integer.toString(getNextDay(date));
            
            BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
            String line = br.readLine();
            int[] startTimes = new int[0];
            int[] endTimes = new int[0];
            String[] events = new String[0];
            
            for(int y = 0; y < 5; y ++){
                line = br.readLine();
            }
            while(!(line.equals(curDate))){
                line = br.readLine();
            }
            line = br.readLine();
            if(curDate.equals("20170531"))
            {
            	while(line != null)
            	{
            		int startTime = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                	line = line.substring(line.indexOf(" ")+1);
                	startTimes = updateIntArr(startTime, startTimes);
                	int endTime = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                	line = line.substring(line.indexOf(" ")+1);
                	endTimes = updateIntArr(endTime, endTimes);
                	events = updateStringArr(line, events);
                	line = br.readLine();
            	}
            }
            else
            {
            	while(!(line.equals(nextDate)))
                {
                		int startTime = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                    	line = line.substring(line.indexOf(" ")+1);
                    	startTimes = updateIntArr(startTime, startTimes);
                    	int endTime = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                    	line = line.substring(line.indexOf(" ")+1);
                    	endTimes = updateIntArr(endTime, endTimes);
                    	events = updateStringArr(line, events);
                    	line = br.readLine();
                }
            }
            br.close();
            if(!box)
            {
                return checkConflicts(startTimes, endTimes, events);
            }
            else
            {
            	for (int i = 0; i < events.length; i++)
            	{
            		events[i] = startTimes[i] + " " + endTimes[i] + " " + events[i];
            	}
            	return events;
            }
            
    	}catch (IOException e)
    	{
    		e.printStackTrace();
    		return new String[0];
    	}
    }
    
    /**
     * <p>Updates an array of integers by adding in newInt, mimicing dynamic arrays
     * @param newInt - Int: New int to be added to array
     * @param oldArr - Int[]: Array for newInt to be added to
     * @return Array of Integers with newInt added to it
     * @author Stephen Fulton
     * @pre None
     * @post None
     */
    public static int[] updateIntArr(int newInt, int[] oldArr)
    {
    	int[] temp = new int[oldArr.length+1];
    	for(int i = 0; i < oldArr.length; i++)
    	{
    		temp[i] = oldArr[i];
    	}
    	temp[oldArr.length] = newInt;
    	return temp;
    }
    
    /**
     * <p>Updates an array of strings by adding in x, mimicing dynamic arrays
     * @param x - String: new String to be added to array
     * @param oldArr - String[]: array of strings which x will be added to
     * @author Stephen Fulton
     * @pre None
     * @post None
     * @return Array of Strings with x added to it
     */
    public static String[] updateStringArr(String x, String[] oldArr)
    {
    	String[] temp = new String[oldArr.length+1];
    	for(int i = 0; i < oldArr.length; i++)
    	{
    		temp[i] = oldArr[i];
    	}
    	temp[oldArr.length] = x;
    	return temp;
    }
    
    /**
     * <p>Returns the next day after the given date</p>
     * @param date Int: Date which the next day will be calculated from (in the form YYYYMMDD)
     * @return int that is the next day after the given date (in the form YYYYMMDD)
     * @author Stephen Fulton
     * @pre Date is valid
     * @post none
     * 
     */
    public static int getNextDay(int date)
    {
    	 int nextDate = date;
    	 if(date == 20161231){
             nextDate = date+8870;
         }
         else if(date == 20160831 || date == 20161031 || date == 20170131 || date == 20170331){
             nextDate = date+70;
         }
         else if(date == 20160930 || date == 20161130 || date == 20170430){
             nextDate = date+71;
         }
         else if(date == 20170228){
             nextDate = date+73;
         }
         else if(date == 20170531)
         {
        	 nextDate = date;
         }
         else
         {
        	 nextDate = date + 1;
         }
    	 return nextDate;
    }
    
    /**
     *	@pre The CalendarInfo.txt file exists with proper information and formatting.
     *	@post A new event is added to the CalendarInfo file.
     *	@return Boolean that tells you if the writing was successful.
     *  @author edited by Rebekah Manweiler
     *  @since 10/10/2016
     */
    public static boolean CalWrite(int date, String event){
        try{
            String curDate = Integer.toString(date);
            String nextDate = Integer.toString(getNextDay(date));
            //**********************************************
            
            BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
            File file2 = new File("2CalendarInfo.txt");
            file2.createNewFile();
            File file = new File("CalendarInfo.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
            
            String line = "";
            for(int x = 0; x < 6; x ++){
                line = br.readLine();
                bw.write(line);
                bw.newLine();
            }
            while(!(line.equals(curDate))){
                line = br.readLine();
                bw.write(line);
                bw.newLine();
            }
            line = br.readLine();
            //write event
            boolean eventWritten = false;
            while(line != null){
            	if(line.equals(nextDate))
            	{
            		break;
            	}
            	int lineStartTime = Integer.parseInt(line.substring(0, line.indexOf(" ")));
            	int eventStartTime = Integer.parseInt(event.substring(0, line.indexOf(" ")));
            	if(lineStartTime < eventStartTime){
            		bw.write(line);
            	}
            	else if(lineStartTime > eventStartTime){
            		bw.write(event);
            		bw.newLine();
            		bw.write(line);
            		eventWritten = true;
            	}
            	else if(lineStartTime == eventStartTime){
            		String temp = line.substring(line.indexOf(" ")+1);
            		String tempEvent = event.substring(event.indexOf(" ") + 1);
            		int lineEndTime = Integer.parseInt(temp.substring(0, temp.indexOf(" ")));
            		int eventEndTime = Integer.parseInt(tempEvent.substring(0, tempEvent.indexOf(" ")));
            		if(lineEndTime < eventEndTime){
            			bw.write(line);
            		}
            		else if(lineEndTime >= eventEndTime){
            			bw.write(event);
            			bw.newLine();
            			bw.write(line);
            			eventWritten = true;
            		}
            	}
            	bw.newLine();
            	line = br.readLine();
            	if(eventWritten){break;}
            }
            if(!eventWritten){
            	bw.write(event);
            	bw.newLine();
            	if(line != null)
            	{
                	bw.write(line);
                	bw.newLine();
            	}
            }
            else
            {
            	if(line != null)
            	{
            		bw.write(line);
                    bw.newLine();
            	}
            }
            
            line = br.readLine();
            while(line != null){
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }
            bw.close();
            br.close();
            file.delete();
            file2.renameTo(file);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return(true);
    }
    
    /**
     *	@pre The CalendarInfo.txt file exists with proper information and formatting
     *	@post None.
     *	@return Integer of the date stored as current date.
     *
     */
    public static int getDate(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
            String line = br.readLine();
            line = br.readLine();
            line = line.substring(14);
            int date = Integer.parseInt(line);
            br.close();
            return date;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     *	@pre The CalendarInfo.txt file exists with proper information and formatting
     *	@post None.
     *	@return Boolean stating if the writing was completed.
     *
     */
    public static boolean setDate(int date){
        try{
        	File file = new File("CalendarInfo.txt");
        	File file2 = new File("2CalendarInfo.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
            String curDate = Integer.toString(date);
            
            String line = "";
            line = br.readLine();
            bw.write(line);
            bw.newLine();
            bw.write("Current_date: " + curDate);
            bw.newLine();
            line = br.readLine();
            line = br.readLine();
            bw.write(line);
            bw.newLine();
            line = br.readLine();
            bw.write(line);
            bw.newLine();
            while((line = br.readLine())!= null){
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            br.close();
            
            file.delete();
            file2.renameTo(new File("CalendarInfo.txt"));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return(true);
    }
    
    /**
     *	@pre The CalendarInfo.txt file exists with proper information and formatting
     *	@post None.
     *	@return String containing the current view of the calendar.
     *
     */
    public static String getView(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
            String view = br.readLine();
            view = br.readLine();
            view = br.readLine();
            view = br.readLine();
            view = br.readLine();
            br.close();
            return view;
        }
        catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    
    /**
     *	@pre The CalendarInfo.txt file exists with proper information and formatting
     *	@post None.
     *	@return Boolean stating if the writing was successful.
     *
     */
    public static boolean setView(String view){
        try{		
            BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
            File file2 = new File("2CalendarInfo.txt");
            file2.createNewFile();
            File file = new File("CalendarInfo.txt");
            FileWriter fw = new FileWriter(file2);
            
            String line = "";
            for(int j = 0; j < 4; j ++){
                line = br.readLine();
                fw.write(line + "\n");
            }
            fw.write(view + "\n");
            line = br.readLine();
            while((line = br.readLine())!= null){
                fw.write(line + "\n");
            }
            file.delete();
            file2.renameTo(file);
            br.close();
            fw.flush();
            fw.close();
            return(true);
        }
        catch(Exception e){
            e.printStackTrace();
            return true;
        }
    }
    
    /**
     *	@pre The CalendarInfo.txt file exists with proper information and formatting
     *	@post None.
     *	@return Integer of the date stored as the First date of the Calendar.
     *
     */
    public static int getFirst(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
            String line = br.readLine();
            for(int i = 0; i < 6; i ++){line = br.readLine();}
            int date = Integer.parseInt(line);
            br.close();
            return date;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     *	@pre The CalendarInfo.txt file exists with proper information and formatting
     *	@post None.
     *	@return Integer of the date stored as the last date of the Calendar.
     *
     */
    public static int getLast(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
            String line = br.readLine();
            for(int i = 0; i < 8; i ++){line = br.readLine();}
            int date = Integer.parseInt(line);
            br.close();
            return date;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        
    }
    
    /**
     * @author Rebekah Manweiler and Stephen Fulton
     * @param startTimes - int[] the array of start times for events that occur in the same day
     * @param endTimes - int[] the array of end times for events that occur in the same day
     * @param events - String[] the array of 'events' (example: 9 8 workout *conflict*) that occur in the same day
     * @post attaches '*conflict*' to the end of each event that occurs during the same time period as another event in the day
     * @return String[] - events
     */
    public static String[] checkConflicts(int[] startTimes, int[] endTimes, String[] events){
    	String[] conflicts = new String[startTimes.length];
    	int[] hours = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    	
    	for(int i = 0; i < conflicts.length; i++){
    		conflicts[i] = "";
    	}
    	
    	for(int i = 0; i < startTimes.length; i++){
    		for( int j = startTimes[i]; j <= endTimes[i]; j++){
    			if(hours[j] != 0) conflicts[i] = " *conflict*";
    			else hours[j]++;
    		}
    	}
    	
    	for(int i = 0; i < startTimes.length; i++){
    		events[i] = startTimes[i] + "-" + endTimes[i] + " " + events[i] + conflicts[i];
    	}
    	
    	return events;
    	
    }
    
}

