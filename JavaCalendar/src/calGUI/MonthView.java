package calGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MonthView {

	public JFrame frame;
	private JTable table;
	private TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return 7; }
        public int getRowCount() { return 6;}
        public Object getValueAt(int row, int col) { 
        	if(row == 0){
        		String[] WeekNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        		return WeekNames[col];
        	}
        	return new Integer(row*col); }
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
		table.setBounds(0, 0, 434, 261);
		table.setShowGrid(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println(table.getSelectionModel().getLeadSelectionIndex()); //get selected cell row index
				System.out.println(table.getColumnModel().getSelectionModel().getLeadSelectionIndex()); //get selected cell column index
			}
		});
		frame.getContentPane().add(table);
	}
}
