package calGUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import calClass.DateControl;

public class YearView {

	public JFrame frame;
	DateControl Date = new DateControl();
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
		btnAugust.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAugust.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to August 1
				Date.setCurDate(2016, 7, 1);
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
		btnSeptember.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSeptember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to September 1
				Date.setCurDate(2016, 8, 1);
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
		btnOctober.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnOctober.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to October 1
				Date.setCurDate(2016, 9, 1);
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
		btnNovember.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNovember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to November 1
				Date.setCurDate(2016, 10, 1);
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
		btnDecember.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDecember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to December 1
				Date.setCurDate(2016, 11, 1);
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
		btnJanuary.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnJanuary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnJanuary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to January 1
				Date.setCurDate(2017, 0, 1);
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
		btnFebruary.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFebruary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to February 1
				Date.setCurDate(2017, 1, 1);
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
		btnMarch.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMarch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to March 1
				Date.setCurDate(2017, 2, 1);
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
		btnApril.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnApril.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to April 1
				Date.setCurDate(2017, 3, 1);
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
		btnMay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//update the current date to May 1
				Date.setCurDate(2017, 4, 1);
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
