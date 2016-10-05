package calGUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import calClass.DateControl;
import calIO.CalFile;

import java.io.*;

public class AddView {
	
	public JFrame frame;
	private DateControl Date = new DateControl();
	
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
		
		JRadioButton single = new JRadioButton("Single Day");
		single.setSelected(true);
		single.setAlignmentX(Component.CENTER_ALIGNMENT);
		typePanel.add(single);
		
		JPanel multiPanel = new JPanel();
		multiPanel.setLayout(new FlowLayout());
		JRadioButton multiDay = new JRadioButton("Multi Day");
		multiPanel.add(multiDay);
		final JComboBox monthList = new JComboBox();
		final JComboBox dayList = new JComboBox();
		multiPanel.add(monthList);
		monthList.setVisible(multiDay.isSelected());
		multiPanel.add(dayList);
		dayList.setVisible(multiDay.isSelected());
		multiPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		typePanel.add(multiPanel);
		
		final JPanel recurringPanel = new JPanel();
		recurringPanel.setLayout(new FlowLayout());
		JRadioButton recurring = new JRadioButton("Recurring");
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
						}
				});
		
		frame.add(timePanel);
		frame.add(typePanel);
	}
	
	private void writeEvent(int date, int enddate, String modifier, String event){
		if(modifier.equals("s")){
			CalFile.CalWrite(date, event);
		}
		else{
			while(date <= enddate){
				CalFile.CalWrite(date, event);
				/*if(modifier.equals("w")) date = Date.getNextWeek(date);//weekly event
				else if(modifier.equals("b")) date = Date.getNextWeek(getNextWeek(date));//biweekly event
				else if(modifier.equals("m")) date++;//multiday event
				else date = getNextMonth(date);//monthly event*/
			}
		}
	}

}
