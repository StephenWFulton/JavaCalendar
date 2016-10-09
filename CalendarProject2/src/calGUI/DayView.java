package calGUI;

/**
 * @file DayView.java
 * @author Adam Van Hal
 * @since 2016.09.17
 * @details This class generates the GUI responsible for displaying the Day portion of the calendar. All 
 * date data it needs is retrieved using get methods from DateControl.java. When a new date is selected it uses 
 * set methods in DateControl.java to change the date and then it launches the corresponding GUI window
 * If a new event is entered in the text field it calls CalFile.Java to save it. Previously saved events are 
 * retrieved also from CalFile.java
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import calClass.DateControl;
import calIO.CalFile;
import javax.swing.JTextPane;


public class DayView {
	
	public JFrame frame;
	private DateControl Date = new DateControl();

    /**
    * @pre    None
    * @post   Launches the Day GUI, primarily used in standalone testing. 
    * @return None
    */
	public static void main(String[] args) {
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

	/**
	* @pre    None
    * @post   Starts the initialize function 
    * @return None
    */
	public DayView() {
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
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		frame.setResizable(false);
		
		JButton btnMonth = new JButton(Date.monthName());
		btnMonth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//dispose current view
				frame.dispose();
				//launch day view
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
		
		JButton btnweek = new JButton("Week: " + Integer.toString(Date.getCurWeek()));
		springLayout.putConstraint(SpringLayout.SOUTH, btnMonth, -10, SpringLayout.NORTH, btnweek);
		btnweek.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//dispose current view
				frame.dispose();
				//launch day view
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
		
		frame.getContentPane().add(btnMonth);
		
		JButton btnYear = new JButton(Integer.toString(Date.getCurYear()));
		springLayout.putConstraint(SpringLayout.EAST, btnweek, -26, SpringLayout.WEST, btnYear);
		springLayout.putConstraint(SpringLayout.WEST, btnYear, -188, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnYear, -107, SpringLayout.EAST, frame.getContentPane());
		btnYear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//dispose current view
				frame.dispose();
				//launch day view
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
		frame.getContentPane().add(btnYear);
		
		final JTextArea textArea = new JTextArea();
		JScrollPane Pane = new JScrollPane(textArea);
		springLayout.putConstraint(SpringLayout.SOUTH, btnweek, -6, SpringLayout.NORTH, Pane);
		springLayout.putConstraint(SpringLayout.NORTH, Pane, 6, SpringLayout.SOUTH, btnYear);
		textArea.setText("");
		textArea.setText(CalFile.CalReadV2(Date.setCurFileDate()));
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 85, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnYear, -16, SpringLayout.NORTH, textArea);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 25, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textArea, 403, SpringLayout.WEST, frame.getContentPane());
		textArea.setEditable(false);
		//frame.getContentPane().add(textArea);
		frame.getContentPane().add(Pane);
		
		JButton btnSave = new JButton("Add Event");
		springLayout.putConstraint(SpringLayout.SOUTH, Pane, -8, SpringLayout.NORTH, btnSave);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -6, SpringLayout.NORTH, btnSave);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//save current content to text file
				/*int curdate = Date.setCurFileDate();
				String event = textArea.getText();
				CalFile.CalWrite(curdate, event);
				*/
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddView window = new AddView();
							window.frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 185, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnSave);
		frame.getContentPane().add(btnweek);
		
		JButton btnPrevDay = new JButton("< Prev. Day");
		springLayout.putConstraint(SpringLayout.WEST, btnMonth, 27, SpringLayout.EAST, btnPrevDay);
		springLayout.putConstraint(SpringLayout.WEST, Pane, 0, SpringLayout.WEST, btnPrevDay);
		btnPrevDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//set current day - 1
				int curDay = Date.getCurDay() -1;
				Date.setCurDate(Date.getCurYear(), Date.getCurMonth()-1, curDay);
				//dispose current view
				frame.dispose();
				//launch day view
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
		springLayout.putConstraint(SpringLayout.NORTH, btnPrevDay, 21, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnPrevDay, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnPrevDay);
		
		JButton btnNextDay = new JButton("Next Day >");
		springLayout.putConstraint(SpringLayout.EAST, Pane, 0, SpringLayout.EAST, btnNextDay);
		btnNextDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//set current day + 1
				int curDay = Date.getCurDay() + 1;
				Date.setCurDate(Date.getCurYear(), Date.getCurMonth()-1, curDay);
				//dispose current view
				frame.dispose();
				//launch day view
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
		springLayout.putConstraint(SpringLayout.SOUTH, btnNextDay, 0, SpringLayout.SOUTH, btnPrevDay);
		springLayout.putConstraint(SpringLayout.EAST, btnNextDay, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNextDay);
		
		JTextPane txtpnday = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnday, 0, SpringLayout.NORTH, btnMonth);
		springLayout.putConstraint(SpringLayout.WEST, txtpnday, 22, SpringLayout.EAST, btnMonth);
		springLayout.putConstraint(SpringLayout.EAST, txtpnday, 87, SpringLayout.EAST, btnMonth);
		txtpnday.setEditable(false);
		txtpnday.setText("Day: " + Integer.toString(Date.getCurDay()));
		frame.getContentPane().add(txtpnday);
	}
}
