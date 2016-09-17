package calGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DayView {

	public JFrame frame;

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public DayView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton btnMonth = new JButton("%Month");
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
		springLayout.putConstraint(SpringLayout.NORTH, btnMonth, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnMonth, 169, SpringLayout.WEST, frame.getContentPane());
		btnMonth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 //Dummy action, replace by calling up month view
			}
		});
		
		JButton btnweek = new JButton("%Week");
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
		
		JButton btnYear = new JButton("%Year");
		springLayout.putConstraint(SpringLayout.NORTH, btnweek, 0, SpringLayout.NORTH, btnYear);
		springLayout.putConstraint(SpringLayout.EAST, btnweek, -26, SpringLayout.WEST, btnYear);
		springLayout.putConstraint(SpringLayout.EAST, btnYear, -149, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnYear);
		
		JTextArea textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.SOUTH, btnYear, -16, SpringLayout.NORTH, textArea);
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 52, SpringLayout.SOUTH, btnMonth);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 25, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textArea, 403, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textArea);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//save current content to text file
				
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -6, SpringLayout.NORTH, btnSave);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 185, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnSave);
		frame.getContentPane().add(btnweek);
		
		JButton btnPrevDay = new JButton("< Prev. Day");
		btnPrevDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//set current day - 1
				
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
		btnNextDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//set current day + 1
				
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
	}
}
