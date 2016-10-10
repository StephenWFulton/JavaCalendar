package calGUI;

/**
 * @file MonthView.java
 * @author Adam Van Hal
 * @since 2016.09.17
 * @details This class generates the GUI responsible for displaying the month portion of the calendar. It
 * generates a two dimensional table that is headed with the days of the week and then receives a one 
 * dimensional array from DateControl.java which it maps to this table, padding it with empty strings to 
 * format it correctly. All other data it needs is retrieved using get methods from DateControl.java. When
 * a new date is selected it uses set methods in DateControl.java to change the date and then it launches 
 * the corresponding GUI window
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import calClass.DateControl;
import javax.swing.JButton;

public class MonthView {

	public JFrame frame;
	private DateControl Date = new DateControl();
	private JTable table;
	private TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return 7; }
        public int getRowCount() { return 7;}
        public Object getValueAt(int row, int col) { 
        	if(row == 0){
        		String[] WeekNames = {"Sunday", "Monday", "Tuesday", "Wed.", "Thursday", "Friday", "Saturday"};
        		return WeekNames[col];
        	}
        	if(row == 1 && col < Date.firstDayOfMonth()){
        		return new String();
        	}
        	if(((row-1)*7+col) > (Date.daysOfTheMonth().length-1 + Date.firstDayOfMonth())){
        		return new String();
        	}
        	int Day = Date.daysOfTheMonth()[(col-Date.firstDayOfMonth())+((row-1)*7)];
        	return Day;
        	}
    };



    /**
    * @pre    None
    * @post   Launches the month GUI, primarily used in standalone testing. 
    * @return None
    */
	public static void main(String[] args) {
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

	/**
	* @pre    None
    * @post   Starts the initialize function 
    * @return None
    */
	public MonthView() {
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
		frame.setResizable(false);
		
		table = new JTable(dataModel);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//allow only a single cell to be selected
		table.setBounds(0, 42, 434, 208);
		table.setShowGrid(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//get the selected value
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				Object Cell = table.getValueAt(row, col);
				//check if the cell contained an int
				if(Cell.getClass() == Integer.class){
					//set the day to the new value
					int NewDay = (Integer) Cell;
					Date.setCurDay(NewDay);
					//dispose current view
					frame.dispose();
					//open day view
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
			}
		});
		frame.getContentPane().add(table);
		
		JTextPane txtpnmonth = new JTextPane();
		txtpnmonth.setEditable(false);
		txtpnmonth.setText(Date.monthName());
		txtpnmonth.setBounds(175, 11, 85, 20);
		frame.getContentPane().add(txtpnmonth);
		
		JButton btnPrevMonth = new JButton("< Prev. Month");
		btnPrevMonth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set to previous month after adjusting for the off by 1 error, set day to the first.
				int curMonth = Date.getCurMonth() -1 -1;
				Date.setCurDate(Date.getCurYear(), curMonth, 1);
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
		btnPrevMonth.setBounds(10, 11, 113, 23);
		frame.getContentPane().add(btnPrevMonth);
		
		JButton btnNextMonth = new JButton("Next Month >");
		btnNextMonth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//set to next month after adjusting for the off by 1 error, set day to the first.
				int curMonth = Date.getCurMonth() + 1 - 1;
				Date.setCurDate(Date.getCurYear(), curMonth, 1);
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
		btnNextMonth.setBounds(305, 11, 119, 23);
		frame.getContentPane().add(btnNextMonth);
	}
}
