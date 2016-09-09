package calGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;

public class DayView {

	private JFrame frame;

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
		
		JButton btnMonth = new JButton("Month");
		springLayout.putConstraint(SpringLayout.NORTH, btnMonth, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnMonth, 88, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnMonth);
		
		JButton btnYear = new JButton("Year");
		springLayout.putConstraint(SpringLayout.NORTH, btnYear, 0, SpringLayout.NORTH, btnMonth);
		springLayout.putConstraint(SpringLayout.WEST, btnYear, 60, SpringLayout.EAST, btnMonth);
		frame.getContentPane().add(btnYear);
		
		JTextArea textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 18, SpringLayout.SOUTH, btnMonth);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 25, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, 175, SpringLayout.SOUTH, btnMonth);
		springLayout.putConstraint(SpringLayout.EAST, textArea, 403, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textArea);
		
		JButton btnSave = new JButton("Save");
		springLayout.putConstraint(SpringLayout.NORTH, btnSave, 6, SpringLayout.SOUTH, textArea);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 185, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnSave);
	}
}
