//package calIO;

/**
 *	@file CalFile.java
 *	@author Stuart Wreath
 *	@since 2016.09.17
 *
 */

import java.io.*;
import java.util.Scanner;

public class CalFile{
    /*
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
        
    }

    public static boolean CalExist(){
	File file = new File("CalendarInfo.txt");
	boolean Existance = file.exists();
	return Existance;
    }
    
    /*
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
            
            fw.write("***************Current_Open_Settings***************\n");
            //fw.write(System.lineSeparator());
            fw.write("Current_date:\n20160801\n");
            fw.write("Current_View:\nyear\n");
            fw.write("First_Date: \n20160801\n");
            fw.write("Last_Date: \n20170531\n");
            fw.write("*******************Saved_Events********************\n");
            
            int date = 20160801;
            int dpm = 31;
            int m = 1;
            
            while(m < 11)
            {
                if(m == 1 || m == 3 || m == 5 || m == 6 || m == 8 || m == 10){dpm = 31;}
                else if(m == 2 || m == 4 || m == 9){dpm = 30;}
                else{dpm = 28;}
                
                for(int i = 0; i < dpm; i ++){
                    fw.write(Integer.toString(date) + "\n");
                    date ++;
                }
                date -= dpm;
                date += 100;
                if(m == 5){date += 8800;}
                m++;
            }
            fw.flush();
            fw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return(true);
    }
    
    /*
     *	@pre The CalendarInfo.txt file exists and has proper information and dates in it.
     *	@post None.
     *	@return String that holds the event written at the date inputted.
     *
     */
    public static String CalRead(int date){
        try{
            String curDate = Integer.toString(date);
            String nextDate = "";
            int Enddate = 0;
            if(date == 20161231){
                nextDate = Integer.toString((date+8870));
            }
            else if(date == 20160831 || date == 20161031 || date == 20170131 || date == 20170331){
                nextDate = Integer.toString((date+70));
            }
            else if(date == 20160930 || date == 20161130 || date == 20170430){
                nextDate = Integer.toString((date+71));
            }
            else if(date == 20170228){
                nextDate = Integer.toString((date+73));
            }
            else if(date == 20170531){
                Enddate = 1;
            }
            else
            {
                nextDate = Integer.toString((date+1));
            }
            BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
            
            String sb = "";
            String line = br.readLine();
            for(int y = 0; y < 9; y ++){
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
    
    /*
     *	@pre The CalendarInfo.txt file exists with proper information and formatting.
     *	@post A new event is added to the CalendarInfo file.
     *	@return Boolean that tells you if the writing was successful.
     *
     */
    public static boolean CalWrite(int date, String event){
        try{
            String curDate = Integer.toString(date);
            //**********************************************
            
            
            String nextDate = "";
            int Enddate = 0;
            if(date == 20161231){
                nextDate = Integer.toString((date+8870));
            }
            else if(date == 20160831 || date == 20161031 || date == 20170131 || date == 20170331){
                nextDate = Integer.toString((date+70));
            }
            else if(date == 20160930 || date == 20161130 || date == 20170430){
                nextDate = Integer.toString((date+71));
            }
            else if(date == 20170228){
                nextDate = Integer.toString((date+73));
            }
            else if(date == 20170531){
                Enddate = 1;
            }
            else
            {
                nextDate = Integer.toString((date+1));
            }
            
            //*****************************************************
            
            
            BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
            File file2 = new File("2CalendarInfo.txt");
            file2.createNewFile();
            File file = new File("CalendarInfo.txt");
            FileWriter fw = new FileWriter(file2);
            
            String line = "";
            for(int x = 0; x < 11; x ++){
                line = br.readLine();
                fw.write(line + "\n");
            }
            while(!(line.equals(curDate))){
                line = br.readLine();
                fw.write(line + "\n");
            }
            //write event
            fw.write(event + "\n");
            //*******************************
            
            if(Enddate == 0){
                while(!(line.equals(nextDate))){
                    line = br.readLine();
                }
            }
            else {
                while((line = br.readLine())!= null){}
                Enddate = 0;
            }
            
            //********************************
            while(line != null){
                fw.write(line + "\n");
                line = br.readLine();
            }
            file.delete();
            file2.renameTo(file);
            br.close();
            fw.flush();
            fw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return(true);
    }
    
    /*
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
            line = br.readLine();
            int date = Integer.parseInt(line);
            br.close();
            return date;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    /*
     *	@pre The CalendarInfo.txt file exists with proper information and formatting
     *	@post None.
     *	@return Boolean stating if the writing was completed.
     *
     */
    public static boolean setDate(int date){
        try{
            BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
            File file2 = new File("2CalendarInfo.txt");
            file2.createNewFile();
            File file = new File("CalendarInfo.txt");
            String curDate = Integer.toString(date);
            FileWriter fw = new FileWriter(file2);
            
            String line = "";
            line = br.readLine();
            fw.write(line + "\n");
            line = br.readLine();
            fw.write(line + "\n");
            fw.write(curDate + "\n");
            line = br.readLine();
            while((line = br.readLine())!= null){
                fw.write(line + "\n");
            }
            file.delete();
            file2.renameTo(file);
            br.close();
            fw.flush();
            fw.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return(true);
    }
    
    /*
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
    
    /*
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
    
    /*
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
    
    /*
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
    
    
}

