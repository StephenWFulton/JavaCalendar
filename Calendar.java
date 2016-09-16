import java.awt.EventQueue;
import java.io.IOException;

import calGUI.DayView;


public class Calendar {
	public static void main(String[] args) throws IOException{
		CalFile.CalInit();
		DateControl myDate = new DateControl();
		System.out.println(myDate.getCurDay());
		System.out.println(myDate.getCurYear());
		System.out.println(myDate.getCurMonth());
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
			System.out.println("Imagine a month view");
		}
		else if(CalFile.getView().equals("year")){
			System.out.println("Imagine a year view");
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
