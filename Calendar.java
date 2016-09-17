import java.awt.EventQueue;
import java.io.IOException;

import calGUI.DayView;
import calGUI.MonthView;
import calGUI.WeekView;
import calGUI.YearView;


public class Calendar {
	public static void main(String[] args) throws IOException{
		CalFile.CalInit();
		DateControl myDate = new DateControl();
		myDate.setCurDate(2016, 11, 29);
		myDate.setCurDay(myDate.getCurDay()+7);
		System.out.println(myDate.getCurDay());
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
