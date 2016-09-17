package calGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class YearView {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public YearView() {
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
		
		JButton btnJanuary = new JButton("January");
		btnJanuary.setBounds(208, 92, 89, 70);
		frame.getContentPane().add(btnJanuary);
		
		JButton btnAugust = new JButton("August");
		btnAugust.setBounds(109, 11, 89, 70);
		frame.getContentPane().add(btnAugust);
		
		JButton btnSeptember = new JButton("September");
		btnSeptember.setBounds(208, 11, 89, 70);
		frame.getContentPane().add(btnSeptember);
		
		JButton btnOctober = new JButton("October");
		btnOctober.setBounds(307, 11, 89, 70);
		frame.getContentPane().add(btnOctober);
		
		JButton btnNovember = new JButton("November");
		btnNovember.setBounds(10, 92, 89, 70);
		frame.getContentPane().add(btnNovember);
		
		JButton btnDecember = new JButton("December");
		btnDecember.setBounds(109, 92, 89, 70);
		frame.getContentPane().add(btnDecember);
		
		JButton btnFebruary = new JButton("February");
		btnFebruary.setBounds(307, 92, 89, 70);
		frame.getContentPane().add(btnFebruary);
		
		JButton btnMarch = new JButton("March");
		btnMarch.setBounds(10, 173, 89, 70);
		frame.getContentPane().add(btnMarch);
		
		JButton btnApril = new JButton("April");
		btnApril.setBounds(109, 173, 89, 70);
		frame.getContentPane().add(btnApril);
		
		JButton btnMay = new JButton("May");
		btnMay.setBounds(208, 173, 89, 70);
		frame.getContentPane().add(btnMay);
	}

}
