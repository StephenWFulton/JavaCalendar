package calGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		JButton btnMonth = new JButton("%Month");
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
				
			}
		});
		
		frame.getContentPane().add(btnMonth);
		
		JButton btnYear = new JButton("%Year");
		springLayout.putConstraint(SpringLayout.NORTH, btnYear, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnMonth, 0, SpringLayout.NORTH, btnYear);
		springLayout.putConstraint(SpringLayout.EAST, btnYear, -94, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnYear);
		
		JTextArea textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 18, SpringLayout.SOUTH, btnMonth);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 25, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textArea, 403, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textArea);
		
		JButton btnSave = new JButton("Save");
		springLayout.putConstraint(SpringLayout.NORTH, btnSave, 214, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -6, SpringLayout.NORTH, btnSave);
		springLayout.putConstraint(SpringLayout.EAST, btnMonth, 0, SpringLayout.EAST, btnSave);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 185, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnSave);
		
		springLayout.putConstraint(SpringLayout.SOUTH, btnweek, 0, SpringLayout.SOUTH, btnMonth);
		springLayout.putConstraint(SpringLayout.EAST, btnweek, -30, SpringLayout.WEST, btnMonth);
		frame.getContentPane().add(btnweek);
	}
}
