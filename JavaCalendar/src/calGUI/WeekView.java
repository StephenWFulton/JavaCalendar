package calGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;


public class WeekView {

	private JFrame frame;

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
		txtWednesday.setBounds(182, 75, 67, 20);
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
		sundayBTN.setBounds(6, 106, 48, 40);
		frame.getContentPane().add(sundayBTN);
		
		JButton mondayBTN = new JButton("31");
		mondayBTN.setBounds(62, 106, 48, 40);
		frame.getContentPane().add(mondayBTN);
		
		JButton tuesdayBTN = new JButton("32");
		tuesdayBTN.setBounds(122, 106, 48, 40);
		frame.getContentPane().add(tuesdayBTN);
		
		JButton wednesdayBTN = new JButton("33");
		wednesdayBTN.setBounds(192, 106, 48, 40);
		frame.getContentPane().add(wednesdayBTN);
		
		JButton thursdayBTN = new JButton("34");
		thursdayBTN.setBounds(259, 106, 48, 40);
		frame.getContentPane().add(thursdayBTN);
		
		JButton fridayBTN = new JButton("35");
		fridayBTN.setBounds(323, 106, 48, 40);
		frame.getContentPane().add(fridayBTN);
		
		JButton saturdayBTN = new JButton("36");
		saturdayBTN.setBounds(373, 106, 48, 40);
		frame.getContentPane().add(saturdayBTN);
		
		JButton btnPrevWeek = new JButton("< Prev. Week");
		btnPrevWeek.setBounds(6, 23, 102, 23);
		frame.getContentPane().add(btnPrevWeek);
		
		JButton btnNextWeek = new JButton("Next Week >");
		btnNextWeek.setBounds(323, 23, 102, 23);
		frame.getContentPane().add(btnNextWeek);
		
		JButton btnmonth = new JButton("%Month");
		btnmonth.setBounds(167, 11, 89, 23);
		frame.getContentPane().add(btnmonth);
		
		JButton btnFullYear = new JButton("Full Year");
		btnFullYear.setBounds(167, 41, 89, 23);
		frame.getContentPane().add(btnFullYear);
	}
}
