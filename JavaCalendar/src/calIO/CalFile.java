import java.io.*;
import java.util.Scanner;

public class CalFile{
	public static void main(String[] args)throws IOException{
		Scanner kb = new Scanner(System.in);
		String str = "";
		int choice = 1000;
		int date = 0;
		boolean result = false;
		while(choice != 0){
		System.out.println("-----------------------------------------------------------");
		System.out.println("1.Initialize, 2.Read,    3.Write,    4.getDate, 5.setDate, \n6.getView,    7.setView, 8.getFirst, 9.getLast, 0.quit:");
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
		}
		
	}
	
	//Change CalInit to take in the current date and view as arguments
	public static boolean CalInit()throws IOException{
		
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
		return(true);
	}

	public static String CalRead(int date)throws IOException{
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
		try{
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
			return sb;
			
		}finally{
			br.close();
		}
		
	}
	
	public static boolean CalWrite(int date, String event)throws IOException{
		String curDate = Integer.toString(date);
		BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
		File file2 = new File("2CalendarInfo.txt");
		file2.createNewFile();
		File file = new File("CalendarInfo.txt");
		FileWriter fw = new FileWriter(file2);
		try{
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
			while((line = br.readLine())!= null){
				fw.write(line + "\n");
			}
			file.delete();
			file2.renameTo(file);

		}finally{
			br.close();
			fw.close();
		}
		return(true);
	}
	
	public static int getDate()throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
		String line = br.readLine();
		line = br.readLine();
		line = br.readLine();
		int date = Integer.parseInt(line);
		return date;
	}
	public static boolean setDate(int date)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
		File file2 = new File("2CalendarInfo.txt");
		file2.createNewFile();
		File file = new File("CalendarInfo.txt");
		String curDate = Integer.toString(date);
		FileWriter fw = new FileWriter(file2);
		try{
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

		}finally{
			br.close();
			fw.close();
		}
		return(true);
	}
	public static String getView()throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
		String view = br.readLine();
		view = br.readLine();
		view = br.readLine();
		view = br.readLine();
		view = br.readLine();
		return view;
	}
	public static boolean setView(String view)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
		File file2 = new File("2CalendarInfo.txt");
		file2.createNewFile();
		File file = new File("CalendarInfo.txt");
		FileWriter fw = new FileWriter(file2);
		try{
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

		}finally{
			br.close();
			fw.close();
		}
		return(true);
	}
	public static int getFirst()throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
		String line = br.readLine();
		for(int i = 0; i < 6; i ++){line = br.readLine();}
		int date = Integer.parseInt(line);
		return date;
	}
	public static int getLast()throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("CalendarInfo.txt"));
		String line = br.readLine();
		for(int i = 0; i < 8; i ++){line = br.readLine();}
		int date = Integer.parseInt(line);
		return date;
	}

	
}

