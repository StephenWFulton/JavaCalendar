package calGUI;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		JButton btnAugust = new JButton("August");
		btnAugust.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to August 1
				
				//close current view
				frame.dispose();
				//launch Month view
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
		btnAugust.setBounds(109, 11, 89, 70);
		frame.getContentPane().add(btnAugust);
		
		JButton btnSeptember = new JButton("September");
		btnSeptember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to September 1
				
				//close current view
				frame.dispose();
				//launch Month view
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
		btnSeptember.setBounds(208, 11, 89, 70);
		frame.getContentPane().add(btnSeptember);
		
		JButton btnOctober = new JButton("October");
		btnOctober.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to October 1
				
				//close current view
				frame.dispose();
				//launch Month view
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
		btnOctober.setBounds(307, 11, 89, 70);
		frame.getContentPane().add(btnOctober);
		
		JButton btnNovember = new JButton("November");
		btnNovember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to November 1
				
				//close current view
				frame.dispose();
				//launch Month view
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
		btnNovember.setBounds(10, 92, 89, 70);
		frame.getContentPane().add(btnNovember);
		
		JButton btnDecember = new JButton("December");
		btnDecember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to December 1
				
				//close current view
				frame.dispose();
				//launch Month view
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
		btnDecember.setBounds(109, 92, 89, 70);
		frame.getContentPane().add(btnDecember);
		
		JButton btnJanuary = new JButton("January");
		btnJanuary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to January 1
				
				//close current view
				frame.dispose();
				//launch Month view
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
		btnJanuary.setBounds(208, 92, 89, 70);
		frame.getContentPane().add(btnJanuary);
		
		JButton btnFebruary = new JButton("February");
		btnFebruary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to February 1
				
				//close current view
				frame.dispose();
				//launch Month view
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
		btnFebruary.setBounds(307, 92, 89, 70);
		frame.getContentPane().add(btnFebruary);
		
		JButton btnMarch = new JButton("March");
		btnMarch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to March 1
				
				//close current view
				frame.dispose();
				//launch Month view
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
		btnMarch.setBounds(10, 173, 89, 70);
		frame.getContentPane().add(btnMarch);
		
		JButton btnApril = new JButton("April");
		btnApril.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to April 1
				
				//close current view
				frame.dispose();
				//launch Month view
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
		btnApril.setBounds(109, 173, 89, 70);
		frame.getContentPane().add(btnApril);
		
		JButton btnMay = new JButton("May");
		btnMay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to May 1
				
				//close current view
				frame.dispose();
				//launch Month view
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
		btnMay.setBounds(208, 173, 89, 70);
		frame.getContentPane().add(btnMay);
	}

}
