package calGUI;

/**
 * @file WeekView.java
 * @author Adam Van Hal
 * @since 2016.09.17
 * @details This class generates the GUI responsible for displaying the Week portion of the calendar. All 
 * data it needs is retrieved using get methods from DateControl.java. When a new date is selected it uses 
 * set methods in DateControl.java to change the date and then it launches the corresponding GUI window
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import calClass.DateControl;


public class WeekView {

	public JFrame frame;
	private DateControl Date = new DateControl();
	int[] visibleDates = Date.daysOfTheWeek();

    /**
    * @pre    None
    * @post   Launches the Week GUI, primarily used in standalone testing. 
    * @return None
    */
	public static void main(String[] args) {
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

	/**
	* @pre    None
    * @post   Starts the initialize function 
    * @return None
    */
	public WeekView() {
		initialize();
	}

	/**
	* @pre    None
    * @post   Initializes the contents of the JFrame adding all the swing components and event handlers.
    * @return None
    */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtSunday = new JTextPane();
		txtSunday.setEditable(false);
		txtSunday.setText("Sunday");
		txtSunday.setBounds(6, 75, 46, 20);
		frame.getContentPane().add(txtSunday);
		
		JTextPane txtMonday = new JTextPane();
		txtMonday.setEditable(false);
		txtMonday.setText("Monday");
		txtMonday.setBounds(62, 75, 46, 20);
		frame.getContentPane().add(txtMonday);
		
		JTextPane txtTuesday = new JTextPane();
		txtTuesday.setEditable(false);
		txtTuesday.setText("Tuesday");
		txtTuesday.setBounds(118, 75, 54, 20);
		frame.getContentPane().add(txtTuesday);
		
		JTextPane txtWednesday = new JTextPane();
		txtWednesday.setEditable(false);
		txtWednesday.setText("Wednesday");
		txtWednesday.setBounds(182, 75, 69, 20);
		frame.getContentPane().add(txtWednesday);
		
		JTextPane txtThursday = new JTextPane();
		txtThursday.setEditable(false);
		txtThursday.setText("Thursday");
		txtThursday.setBounds(259, 75, 54, 20);
		frame.getContentPane().add(txtThursday);
		
		JTextPane txtFriday = new JTextPane();
		txtFriday.setEditable(false);
		txtFriday.setText("Friday");
		txtFriday.setBounds(323, 75, 46, 20);
		frame.getContentPane().add(txtFriday);
		
		JTextPane txtSaturday = new JTextPane();
		txtSaturday.setEditable(false);
		txtSaturday.setText("Saturday");
		txtSaturday.setBounds(373, 75, 52, 20);
		frame.getContentPane().add(txtSaturday);
				
		JButton sundayBTN = new JButton(Integer.toString(visibleDates[0]));
		sundayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				int curDay = Date.getCurDay() + (0-Date.getCurDayOfWeek());
				Date.setCurDate(Date.getCurYear(), Date.getCurMonth()-1, curDay);
				//close current window
				frame.dispose();
				//open DayView window
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
		});
		sundayBTN.setBounds(6, 106, 48, 40);
		frame.getContentPane().add(sundayBTN);
		
		JButton mondayBTN = new JButton(Integer.toString(visibleDates[1]));
		mondayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				int curDay = Date.getCurDay() + (1-Date.getCurDayOfWeek());
				Date.setCurDate(Date.getCurYear(), Date.getCurMonth()-1, curDay);
				//close current window
				frame.dispose();
				//open DayView window
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
		});
		mondayBTN.setBounds(62, 106, 48, 40);
		frame.getContentPane().add(mondayBTN);
		
		JButton tuesdayBTN = new JButton(Integer.toString(visibleDates[2]));
		tuesdayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				int curDay = Date.getCurDay() + (2-Date.getCurDayOfWeek());
				Date.setCurDate(Date.getCurYear(), Date.getCurMonth()-1, curDay);
				//close current window
				frame.dispose();
				//open DayView window
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
		});
		tuesdayBTN.setBounds(122, 106, 48, 40);
		frame.getContentPane().add(tuesdayBTN);
		
		JButton wednesdayBTN = new JButton(Integer.toString(visibleDates[3]));
		wednesdayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				int curDay = Date.getCurDay() + (3-Date.getCurDayOfWeek());
				Date.setCurDate(Date.getCurYear(), Date.getCurMonth()-1, curDay);
				//close current window
				frame.dispose();
				//open DayView window
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
		});
		wednesdayBTN.setBounds(192, 106, 48, 40);
		frame.getContentPane().add(wednesdayBTN);
		
		JButton thursdayBTN = new JButton(Integer.toString(visibleDates[4]));
		thursdayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				int curDay = Date.getCurDay() + (4-Date.getCurDayOfWeek());
				Date.setCurDate(Date.getCurYear(), Date.getCurMonth()-1, curDay);
				//close current window
				frame.dispose();
				//open DayView window
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
		});
		thursdayBTN.setBounds(259, 106, 48, 40);
		frame.getContentPane().add(thursdayBTN);
		
		JButton fridayBTN = new JButton(Integer.toString(visibleDates[5]));
		fridayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				int curDay = Date.getCurDay() + (5-Date.getCurDayOfWeek());
				Date.setCurDate(Date.getCurYear(), Date.getCurMonth()-1, curDay);
				//close current window
				frame.dispose();
				//open DayView window
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
		});
		fridayBTN.setBounds(323, 106, 48, 40);
		frame.getContentPane().add(fridayBTN);
		
		JButton saturdayBTN = new JButton(Integer.toString(visibleDates[6]));
		saturdayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				int curDay = Date.getCurDay() + (6-Date.getCurDayOfWeek());
				Date.setCurDate(Date.getCurYear(), Date.getCurMonth()-1, curDay);
				//close current window
				frame.dispose();
				//open DayView window
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
		});
		saturdayBTN.setBounds(373, 106, 48, 40);
		frame.getContentPane().add(saturdayBTN);
		
		JButton btnPrevWeek = new JButton("< Prev. Week");
		btnPrevWeek.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day-7
				int curDay = Date.getCurDay() - 7;
				Date.setCurDate(Date.getCurYear(), Date.getCurMonth()-1, curDay);
				//close current window
				frame.dispose();
				//open DayView window
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
		});
		btnPrevWeek.setBounds(6, 23, 121, 23);
		frame.getContentPane().add(btnPrevWeek);
		
		JButton btnNextWeek = new JButton("Next Week >");
		btnNextWeek.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day+7
				int curDay = Date.getCurDay() + 7;
				Date.setCurDate(Date.getCurYear(), Date.getCurMonth()-1, curDay);
				//close current window
				frame.dispose();
				//open DayView window
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
		});
		btnNextWeek.setBounds(311, 23, 114, 23);
		frame.getContentPane().add(btnNextWeek);
		
		JButton btnmonth = new JButton(Date.monthName());
		btnmonth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//close current window
				frame.dispose();
				//open DayView window
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
		});
		btnmonth.setBounds(125, 45, 89, 23);
		frame.getContentPane().add(btnmonth);
		
		JButton btnFullYear = new JButton(Integer.toString(Date.getCurYear()));
		btnFullYear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//close current window
				frame.dispose();
				//open DayView window
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
		});
		btnFullYear.setBounds(224, 45, 89, 23);
		frame.getContentPane().add(btnFullYear);
		
		JTextPane txtpnweek = new JTextPane();
		txtpnweek.setEditable(false);
		txtpnweek.setText(Integer.toString(Date.getCurWeek()));
		txtpnweek.setBounds(182, 14, 67, 20);
		frame.getContentPane().add(txtpnweek);
	}
}
