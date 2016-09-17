package calGUI;

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


public class MonthView {

	public JFrame frame;
	private DateControl Date = new DateControl();
	private JTable table;
	private TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return 7; }
        public int getRowCount() { return 7;}
        public Object getValueAt(int row, int col) { 
        	if(row == 0){
        		String[] WeekNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        		return WeekNames[col];
        	}
        	//System.out.println(Date.daysOfTheMonth().length);
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
	 * Launch the application.
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
	 * Create the application.
	 */
	public MonthView() {
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
		
		table = new JTable(dataModel);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//allow only a single cell to be selected
		table.setBounds(0, 42, 434, 208);
		table.setShowGrid(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println(table.getSelectionModel().getLeadSelectionIndex()); //get selected cell row index
				System.out.println(table.getColumnModel().getSelectionModel().getLeadSelectionIndex()); //get selected cell column index
			}
		});
		frame.getContentPane().add(table);
		
		JTextPane txtpnmonth = new JTextPane();
		txtpnmonth.setText(Date.monthName());
		txtpnmonth.setBounds(162, 11, 85, 20);
		frame.getContentPane().add(txtpnmonth);
	}
}
