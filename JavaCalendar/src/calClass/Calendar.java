package calClass;

/*
 @file Calendar.java
 @author Ryan Niday
 @since 2016.09.17
 @details This class is the main startup class being used to run the calendar. It initializes the file
            keeping track of the dates, and then calls up the appropriate view from the GUI classes.
 */

import java.awt.EventQueue;

import calGUI.DayView;
import calGUI.MonthView;
import calGUI.WeekView;
import calGUI.YearView;
import calIO.CalFile;



public class Calendar {
	public static void main(String[] args){
		CalFile.CalInit();
		//DateControl myDate = new DateControl();
		CalFile.setView("week");
		if(CalFile.getView().equals("day")){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DayView window = new DayView();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else if(CalFile.getView().equals("month")){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MonthView window = new MonthView();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else if(CalFile.getView().equals("year")){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						YearView window = new YearView();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else if(CalFile.getView().equals("week")){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						WeekView window = new WeekView();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DayView window = new DayView();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
