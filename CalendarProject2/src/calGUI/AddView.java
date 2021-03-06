package calGUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import calClass.DateControl;
import calIO.CalFile;

import java.io.*;
/**
 * 
 * @author Stephen Fulton, Shawn Parkes, and Rebekah Manweiler
 * <h2>AddView Class</h2>
 * <p>Displays options for the user when creating a new event for the current day</p>
 *
 */
public class AddView {
	
	public JFrame frame;
	private static DateControl Date;
	private final static String[] months = {"August", "September", "October", "November", "December", "January", "February", "March", "April", "May"};
	private final static int[] days = {31,30,31,30,31,31,28,31,30,31};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddView window = new AddView();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	<p> Constructor for AddView </p>
	@author Shawn Parkes
	@post a new AddView frame is created
	*/
	public AddView(){
		initialize();
	}
	
	/**
	<p> initializes the AddView frame </p>
	@author Shawn Parkes, Stephen Fulton, Rebekah Manweiler
	@post the AddView frame is initialized with its default values
	*/
	private void initialize(){
		Date = new DateControl();
		frame = new JFrame();
		frame.setSize(600, 400);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		frame.setResizable(false);
		
		JPanel timePanel = new JPanel();
		timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.Y_AXIS));
		timePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel timeLabel = new JLabel("Time:");
		timePanel.add(timeLabel);
		
		JPanel timeBegin = new JPanel();
		timeBegin.setLayout(new FlowLayout());
		JLabel start = new JLabel("Start");
		timeBegin.add(start);
		Integer[] hours = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
		final JComboBox startHour = new JComboBox(hours);
		timeBegin.add(startHour);
		timePanel.add(timeBegin);
		
		JPanel timeEnd = new JPanel();
		timeEnd.setLayout(new FlowLayout());
		JLabel end = new JLabel("End");
		timeEnd.add(end);
		Integer[] endHours = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
		final JComboBox endHour = new JComboBox(endHours);
		timeEnd.add(endHour);
		timePanel.add(timeEnd);
		
		/**
		startHour actionListener
		this actionListener monitors the startHour combobox
		@post will update the endHour combobox with every hour after what is selected in StartHour
		@author Shawn Parkes
		*/
		startHour.addActionListener(
				new ActionListener(){
						public void actionPerformed(ActionEvent e){
								JComboBox sh = (JComboBox)e.getSource();
								Integer i = (Integer)sh.getSelectedItem();
								endHour.removeAllItems();
								for(Integer j = i; j <= 24; j++)
								{
									endHour.addItem(j);
								}
						}
				});
		
		JPanel typePanel = new JPanel();
		typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
		typePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		final JRadioButton single = new JRadioButton("Single Day");
		single.setSelected(true);
		single.setAlignmentX(Component.CENTER_ALIGNMENT);
		typePanel.add(single);
		
		JPanel multiPanel = new JPanel();
		multiPanel.setLayout(new FlowLayout());
		final JRadioButton multiDay = new JRadioButton("Multi Day");
		multiPanel.add(multiDay);
		final JLabel endDay = new JLabel("End day");
		multiPanel.add(endDay);
		endDay.setVisible(multiDay.isSelected());
		final JComboBox monthList = new JComboBox();
		final JComboBox dayList = new JComboBox();
		multiPanel.add(monthList);
		monthList.setVisible(multiDay.isSelected());
		multiPanel.add(dayList);
		dayList.setVisible(multiDay.isSelected());
		multiPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		typePanel.add(multiPanel);
		
		/**
		monthList actionListener
		this actionListener monitors the monthList combobox
		@post updates the dayList comboBox with the available days
		@author Shawn Parkes
		*/
		monthList.addActionListener(
				new ActionListener(){
						public void actionPerformed(ActionEvent e){
								JComboBox bx = (JComboBox)e.getSource();
								String x = (String)bx.getSelectedItem();
								if(x != null){
									updateDays(dayList, x);
								}
						}
				});
		
		final JPanel recurringPanel = new JPanel();
		recurringPanel.setLayout(new FlowLayout());
		final JRadioButton recurring = new JRadioButton("Recurring");
		recurringPanel.add(recurring);
		final JRadioButton weekly = new JRadioButton("Weekly");
		recurringPanel.add(weekly);
		final JRadioButton biweekly = new JRadioButton("BiWeekly");
		recurringPanel.add(biweekly);
		final JRadioButton monthly = new JRadioButton("Monthly");
		recurringPanel.add(monthly);
		weekly.setVisible(recurring.isSelected());
		biweekly.setVisible(recurring.isSelected());
		monthly.setVisible(recurring.isSelected());
		final ButtonGroup recurringGroup = new ButtonGroup();
		recurringGroup.add(weekly);
		recurringGroup.add(biweekly);
		recurringGroup.add(monthly);
		recurringPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		typePanel.add(recurringPanel);
		ButtonGroup dayGroup = new ButtonGroup();
		dayGroup.add(single);
		dayGroup.add(multiDay);
		dayGroup.add(recurring);
		
		final JPanel dayOfWeek = new JPanel();
		dayOfWeek.setLayout(new BoxLayout(dayOfWeek, BoxLayout.X_AXIS));
		final JCheckBox sunday = new JCheckBox("Sunday");
		dayOfWeek.add(sunday);
		final JCheckBox monday = new JCheckBox("Monday");
		dayOfWeek.add(monday);
		final JCheckBox tuesday = new JCheckBox("Tuesday");
		dayOfWeek.add(tuesday);
		final JCheckBox wednesday = new JCheckBox("Wednesday");
		dayOfWeek.add(wednesday);
		final JCheckBox thursday = new JCheckBox("Thursday");
		dayOfWeek.add(thursday);
		final JCheckBox friday = new JCheckBox("Friday");
		dayOfWeek.add(friday);
		final JCheckBox saturday = new JCheckBox("Saturday");
		dayOfWeek.add(saturday);
		typePanel.add(dayOfWeek);
		dayOfWeek.setVisible(weekly.isSelected());
		
		/**
		single actionListener
		this actionListener monitors the single radio button
		@post updates what is available in the panel
		@author Shawn Parkes
		*/
		single.addActionListener(
				new ActionListener(){
						public void actionPerformed(ActionEvent e){
								recurringGroup.clearSelection();
								weekly.setVisible(false);
								biweekly.setVisible(false);
								monthly.setVisible(false);
								monthList.setVisible(false);
								dayList.setVisible(false);
								monthList.removeAllItems();
								dayList.removeAllItems();
								endDay.setVisible(false);
								dayOfWeek.setVisible(false);
						}
				});
		
		/**
		multiDay actionListener
		this actionListener monitors the multiDay radio button
		@post updates what is available in the panel
		@author Shawn Parkes
		*/
		multiDay.addActionListener(
				new ActionListener(){
						public void actionPerformed(ActionEvent e){
								recurringGroup.clearSelection();
								weekly.setVisible(false);
								biweekly.setVisible(false);
								monthly.setVisible(false);
								monthList.setVisible(true);
								dayList.setVisible(true);
								fillBoxes(monthList, dayList);
								endDay.setVisible(true);
								dayOfWeek.setVisible(false);
						}
				});
		
		/**
		recurring actionListener
		this actionListener monitors the recurring radio button
		@post updates what is available in the panel
		@author Shawn Parkes
		*/
		recurring.addActionListener(
				new ActionListener(){
						public void actionPerformed(ActionEvent e){
								weekly.setSelected(true);
								weekly.setVisible(true);
								biweekly.setVisible(true);
								monthly.setVisible(true);
								monthList.setVisible(false);
								dayList.setVisible(false);
								monthList.removeAllItems();
								dayList.removeAllItems();
								endDay.setVisible(false);
								dayOfWeek.setVisible(weekly.isSelected());
						}
				});
		
		/**
		weekly actionListener
		this actionListener monitors the weekly radio button
		@post updates what is available in the panel
		@author Shawn Parkes
		*/
		weekly.addActionListener(
				new ActionListener(){
						public void actionPerformed(ActionEvent e){
								dayOfWeek.setVisible(true);
						}
				});
		
		/**
		biweekly actionListener
		this actionListener monitors the biweekly radio button
		@post updates what is available in the panel
		@author Shawn Parkes
		*/
		biweekly.addActionListener(
				new ActionListener(){
						public void actionPerformed(ActionEvent e){
								dayOfWeek.setVisible(false);
						}
				});
		
		/**
		monthly actionListener
		this actionListener monitors the monthly radio button
		@post updates what is available in the panel
		@author Shawn Parkes
		*/
		monthly.addActionListener(
				new ActionListener(){
						public void actionPerformed(ActionEvent e){
								dayOfWeek.setVisible(false);
						}
				});
		
		//new panel for a textfield (for event description), add button, and cancel button
		JPanel eventPanel = new JPanel();
		eventPanel.setLayout(new FlowLayout());
		final JTextField eventText = new JTextField(20);
		eventText.setText("");
		final JButton addeventbtn = new JButton("Add Event");
		final JButton cancelbtn = new JButton("Cancel");
		eventPanel.add(eventText);
		eventPanel.add(addeventbtn);
		eventPanel.add(cancelbtn);
		
		addeventbtn.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String startTime = startHour.getSelectedItem().toString();
						String endTime = endHour.getSelectedItem().toString();
						String event = startTime + " " + endTime + " " + eventText.getText();
						int eventCurDate = Date.setCurFileDate();
						int eventEndDate = eventCurDate;
						
						if(single.isSelected()) writeEvent(eventCurDate, eventEndDate, "s", event);
						else if(multiDay.isSelected()){
							eventEndDate = calculateEndDate(monthList.getSelectedItem().toString(), (int)dayList.getSelectedItem());
							
							writeEvent(eventCurDate, eventEndDate, "m", event);
						}
						else if(recurring.isSelected()){
							if(weekly.isSelected()){
								//calculate end date
								eventEndDate = 20170531;
								boolean daySelected = false;
								if(sunday.isSelected()){
									while(Date.getCurDayOfWeek() != 0 && Date.getCurDate() != 20170531)
									{
										Date.getNextDay();
									}
									eventCurDate = Date.getCurDate();
									writeEvent(eventCurDate, eventEndDate, "w", event);
									daySelected = true;
								}
								if(monday.isSelected()){
									while(Date.getCurDayOfWeek() != 1 && Date.getCurDate() != 20170531)
									{
										Date.getNextDay();
									}
									eventCurDate = Date.getCurDate();
									writeEvent(eventCurDate, eventEndDate, "w", event);
									daySelected = true;
								}
								if(tuesday.isSelected()){
									while(Date.getCurDayOfWeek() != 2 && Date.getCurDate() != 20170531)
									{
										Date.getNextDay();
									}
									eventCurDate = Date.getCurDate();
									writeEvent(eventCurDate, eventEndDate, "w", event);
									daySelected = true;
								}
								if(wednesday.isSelected()){
									while(Date.getCurDayOfWeek() != 3 && Date.getCurDate() != 20170531)
									{
										Date.getNextDay();
									}
									eventCurDate = Date.getCurDate();
									writeEvent(eventCurDate, eventEndDate, "w", event);
									daySelected = true;
								}
								if(thursday.isSelected()){
									while(Date.getCurDayOfWeek() != 4 && Date.getCurDate() != 20170531)
									{
										Date.getNextDay();
									}
									eventCurDate = Date.getCurDate();
									writeEvent(eventCurDate, eventEndDate, "w", event);
									daySelected = true;
								}
								if(friday.isSelected()){
									while(Date.getCurDayOfWeek() != 5 && Date.getCurDate() != 20170531)
									{
										Date.getNextDay();
									}
									eventCurDate = Date.getCurDate();
									writeEvent(eventCurDate, eventEndDate, "w", event);
									daySelected = true;
								}
								if(saturday.isSelected()){
									while(Date.getCurDayOfWeek() != 6 && Date.getCurDate() != 20170531)
									{
										Date.getNextDay();
									}
									eventCurDate = Date.getCurDate();
									writeEvent(eventCurDate, eventEndDate, "w", event);
									daySelected = true;
								}
								
								if(!daySelected)
								{
									writeEvent(eventCurDate, eventEndDate, "w", event);
								}
								
							}
							else if(biweekly.isSelected()){
								//calcuate end date
								eventEndDate = 20170531;
								writeEvent(eventCurDate, eventEndDate, "b", event);
							}
							else if(monthly.isSelected()){
								//calculate end date
								eventEndDate = 20170531;
								writeEvent(eventCurDate, eventEndDate, "n", event);
							}
						}
						frame.dispose();
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
		
		/**
		 * cancelbtn ActionListener
		 * this action listener monitors the cancel button
		 * @post disposes the frame and opens a new DayView window for the current day
		 * @author Rebekah Manweiler
		 */
		cancelbtn.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						frame.dispose();
						EventQueue.invokeLater(new Runnable() {
							public void run(){
								try{
									DayView window = new DayView();
									window.frame.setVisible(true);
								} catch (Exception e){
									e.printStackTrace();
								}
							}
						});
					}
				});
		
		frame.add(timePanel);
		frame.add(typePanel);
		frame.add(eventPanel);
	}
	
	/**
	<p> This method will first update the monthBox with available months for the multi day selection
	and then call the updateDays method to update the dayBox </p>
	@author Shawn Parkes
	@param monthBox - JComboBox: the monthList combo box that will be updated
	@param dayBox - JComboBox: the dayList combo box that will be updated
	@post the monthList and the dayList combo boxes are updated
	*/
	public static void fillBoxes(JComboBox monthBox, JComboBox dayBox)
	{
		String curMonth;
		int start;
		monthBox.removeAllItems();
		if(Date.getCurMonth() == 8)
		{
			curMonth = "August";
			start = 0;
		}
		else if(Date.getCurMonth() == 9)
		{
			curMonth = "September";
			start = 1;
		}
		else if(Date.getCurMonth() == 10)
		{
			curMonth = "October";
			start = 2;
		}
		else if(Date.getCurMonth() == 11)
		{
			curMonth = "November";
			start = 3;
		}
		else if(Date.getCurMonth() == 12)
		{
			curMonth = "December";
			start = 4;
		}
		else if(Date.getCurMonth() == 1)
		{
			curMonth = "January";
			start = 5;
		}
		else if(Date.getCurMonth() == 2)
		{
			curMonth = "February";
			start = 6;
		}
		else if(Date.getCurMonth() == 3)
		{
			curMonth = "March";
			start = 7;
		}
		else if(Date.getCurMonth() == 4)
		{
			curMonth = "April";
			start = 8;
		}
		else
		{
			curMonth = "May";
			start = 9;
		}
		for(int i = start; i < 10; i++)
		{
			monthBox.addItem(months[i]);
		}
		
		updateDays(dayBox, curMonth);
	}
	
	/**
	<p> This method will calculate the end date based on the user's selected options from the month and day combo boxes.</p>
	@author Stephen Fulton
	@param month - String: Name of the selected month
	@param day - Int: Index of date within month
	@post None
	@return new calculated end date
	*/
	public static int calculateEndDate(String month, int day)
	{
		if(month.equals("August"))
		{
			return 20160000+800+day;
		}
		else if(month.equals("September"))
		{
			return 20160000+900+day;
		}
		else if(month.equals("October"))
		{
			return 20160000+1000+day;
		}
		else if(month.equals("November"))
		{
			return 20160000+1100+day;
		}
		else if(month.equals("December"))
		{
			return 20160000+1200+day;
		}
		else if(month.equals("January"))
		{
			return 20170000+100+day;
		}
		else if(month.equals("February"))
		{
			return 20170000+200+day;
		}
		else if(month.equals("March"))
		{
			return 20170000+300+day;
		}
		else if(month.equals("April"))
		{
			return 20170000+400+day;
		}
		else
		{
			return 20170000+500+day;
		}
	}
	
	/**
	<p> This method will update the dayBox combo box based on the currently selected month</p>
	@author Shawn Parkes
	@param dayBox - JComboBox: the dayList combo box that will be updated
	@param month - String: the month that will determine how many days are in the dayBox
	@post the dayList combo box is updated
	*/
	public static void updateDays(JComboBox dayBox, String month)
	{
		Integer firstDay = 1;
		Integer numDays = 1;
		dayBox.removeAllItems();
		
		if(month.equals("September") || month.equals("November") || month.equals("April"))
		{
			numDays = 30;
		}
		else if(month.equals("February"))
		{
			numDays = 28;
		}
		else
		{
			numDays = 31;
		}
		
		if(Date.getCurMonth() == 8 && month.equals("August"))
		{
			firstDay = (Integer)Date.getCurDay();
		}
		else if(Date.getCurMonth() == 9 && month.equals("September"))
		{
			firstDay = (Integer)Date.getCurDay();
		}
		else if(Date.getCurMonth() == 10 && month.equals("October"))
		{
			firstDay = (Integer)Date.getCurDay();
		}
		else if(Date.getCurMonth() == 11 && month.equals("November"))
		{
			firstDay = (Integer)Date.getCurDay();
		}
		else if(Date.getCurMonth() == 12 && month.equals("December"))
		{
			firstDay = (Integer)Date.getCurDay();
		}
		else if(Date.getCurMonth() == 1 && month.equals("January"))
		{
			firstDay = (Integer)Date.getCurDay();
		}
		else if(Date.getCurMonth() == 2 && month.equals("February"))
		{
			firstDay = (Integer)Date.getCurDay();
		}
		else if(Date.getCurMonth() == 3 && month.equals("March"))
		{
			firstDay = (Integer)Date.getCurDay();
		}
		else if(Date.getCurMonth() == 4 && month.equals("April"))
		{
			firstDay = (Integer)Date.getCurDay();
		}
		else if(Date.getCurMonth() == 5 && month.equals("May"))
		{
			firstDay = (Integer)Date.getCurDay();
		}
		
		for(Integer j = firstDay; j <= numDays; j++)
		{
			dayBox.addItem(j);
		}
		
	}
	
	/**
	 * <p>This method calls the CalFile.CalWrite method for each day that contains the event. 
	 * For example, a weekly event occurs on the current day and every 7 days after until the enddate is reached,
	 *  and for each of those days CalWrite is called to write the event to the file for that day.</p>
	 * @author Rebekah Manweiler
	 * @since 10/10/2016
	 * @param date - int: the current(starting) date
	 * @param enddate - int: the last day included in the event time range
	 * @param modifier - String: the type of event chosen (single, multiday, weekly, biweekly, monthly)
	 * @param event - String: the comment/detail associated with the event
	 * @post new event(s) are written to CalInfo.txt
	 * @return void
	 */
	private static void writeEvent(int date, int enddate, String modifier, String event){
		if(modifier.equals("s")){
			CalFile.CalWrite(date, event);
		}
		else{
			while(date <= enddate){
				CalFile.CalWrite(date, event);
				if(modifier.equals("w")) Date.nextDayOfWeek();//weekly event
				else if(modifier.equals("b")){
					Date.nextDayOfWeek();//biweekly event
					Date.nextDayOfWeek();
				}
				else if(modifier.equals("m")) Date.getNextDay();//multiday event
				else Date.getNextMonth();//monthly event
				
				date = Date.getCurDate();
			}
			Date.resetDate();
		}
	}

}
