package calGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class WeekView {

	public JFrame frame;

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public WeekView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtSunday = new JTextPane();
		txtSunday.setText("Sunday");
		txtSunday.setBounds(6, 75, 46, 20);
		frame.getContentPane().add(txtSunday);
		
		JTextPane txtMonday = new JTextPane();
		txtMonday.setText("Monday");
		txtMonday.setBounds(62, 75, 46, 20);
		frame.getContentPane().add(txtMonday);
		
		JTextPane txtTuesday = new JTextPane();
		txtTuesday.setText("Tuesday");
		txtTuesday.setBounds(118, 75, 54, 20);
		frame.getContentPane().add(txtTuesday);
		
		JTextPane txtWednesday = new JTextPane();
		txtWednesday.setText("Wednesday");
		txtWednesday.setBounds(182, 75, 69, 20);
		frame.getContentPane().add(txtWednesday);
		
		JTextPane txtThursday = new JTextPane();
		txtThursday.setText("Thursday");
		txtThursday.setBounds(259, 75, 54, 20);
		frame.getContentPane().add(txtThursday);
		
		JTextPane txtFriday = new JTextPane();
		txtFriday.setText("Friday");
		txtFriday.setBounds(323, 75, 46, 20);
		frame.getContentPane().add(txtFriday);
		
		JTextPane txtSaturday = new JTextPane();
		txtSaturday.setText("Saturday");
		txtSaturday.setBounds(373, 75, 52, 20);
		frame.getContentPane().add(txtSaturday);
				
		JButton sundayBTN = new JButton("30");
		sundayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				
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
		
		JButton mondayBTN = new JButton("31");
		mondayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				
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
		
		JButton tuesdayBTN = new JButton("32");
		tuesdayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				
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
		
		JButton wednesdayBTN = new JButton("33");
		wednesdayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				
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
		
		JButton thursdayBTN = new JButton("34");
		thursdayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				
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
		
		JButton fridayBTN = new JButton("35");
		fridayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				
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
		
		JButton saturdayBTN = new JButton("36");
		saturdayBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set current day to selected day
				
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
		
		JButton btnmonth = new JButton("%Month");
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
		
		JButton btnFullYear = new JButton("Full Year");
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
		txtpnweek.setText("%Week");
		txtpnweek.setBounds(182, 14, 67, 20);
		frame.getContentPane().add(txtpnweek);
	}
}
