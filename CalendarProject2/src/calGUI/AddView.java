package calGUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import calClass.DateControl;
import calIO.CalFile;

import java.io.*;

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
	
	public AddView(){
		initialize();
	}
	
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
		final JComboBox monthList = new JComboBox();
		final JComboBox dayList = new JComboBox();
		multiPanel.add(monthList);
		monthList.setVisible(multiDay.isSelected());
		multiPanel.add(dayList);
		dayList.setVisible(multiDay.isSelected());
		multiPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		typePanel.add(multiPanel);
		
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
						}
				});
		
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
						}
				});
		
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
						}
				});
		
		JPanel eventPanel = new JPanel();
		eventPanel.setLayout(new FlowLayout());
		final JTextField eventText = new JTextField(20);
		eventText.setText("");
		final JButton addeventbtn = new JButton("Add Event");
		eventPanel.add(eventText);
		eventPanel.add(addeventbtn);
		
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
								writeEvent(eventCurDate, eventEndDate, "w", event);
							}
							else if(biweekly.isSelected()){
								//calcuate end date
								writeEvent(eventCurDate, eventEndDate, "b", event);
							}
							else if(monthly.isSelected()){
								//calculate end date
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
		
		frame.add(timePanel);
		frame.add(typePanel);
		frame.add(eventPanel);
	}
	
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
	
	private static void writeEvent(int date, int enddate, String modifier, String event){
		if(modifier.equals("s")){
			CalFile.CalWrite(date, event);
		}
		else{
			while(date <= enddate){
				CalFile.CalWrite(date, event);
				Date.getNextDay();
				date = Date.getCurDate();
				/*if(modifier.equals("w")) date = Date.getNextWeek(date);//weekly event
				else if(modifier.equals("b")) date = Date.getNextWeek(getNextWeek(date));//biweekly event
				else if(modifier.equals("m")) date++;//multiday event
				else date = getNextMonth(date);//monthly event*/
			}
			Date.resetDate();
		}
	}

}
