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
		
		JPanel timeTop = new JPanel();
		timeTop.setLayout(new BoxLayout(timeTop, BoxLayout.X_AXIS));
		JLabel timeLabel = new JLabel("Time:");
		timeTop.add(timeLabel);
		JRadioButton yes = new JRadioButton("Yes");
		JRadioButton no = new JRadioButton("No");
		no.setSelected(true);
		ButtonGroup timeGroup = new ButtonGroup();
		timeGroup.add(yes);
		timeGroup.add(no);
		timeTop.add(yes);
		timeTop.add(no);
		timePanel.add(timeTop);
		
		JPanel timeBegin = new JPanel();
		timeBegin.setLayout(new FlowLayout());
		JLabel start = new JLabel("Start");
		timeBegin.add(start);
		String[] hours = new String[24];
		final JComboBox startHour = new JComboBox();
		timeBegin.add(startHour);
		timePanel.add(timeBegin);
		
		JPanel timeEnd = new JPanel();
		timeEnd.setLayout(new FlowLayout());
		JLabel end = new JLabel("End");
		timeEnd.add(end);
		final JComboBox endHour = new JComboBox();
		timeEnd.add(endHour);
		timePanel.add(timeEnd);
		
		
		JPanel typePanel = new JPanel();
		typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
		typePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JRadioButton single = new JRadioButton("Single Day");
		single.setSelected(true);
		typePanel.add(single);
		JPanel multiPanel = new JPanel();
		multiPanel.setLayout(new FlowLayout());
		JRadioButton multiDay = new JRadioButton("Multi Day");
		multiPanel.add(multiDay);
		typePanel.add(multiPanel);
		JPanel recurringPanel = new JPanel();
		recurringPanel.setLayout(new FlowLayout());
		JRadioButton recurring = new JRadioButton("Recurring");
		recurringPanel.add(recurring);
		JRadioButton weekly = new JRadioButton("Weekly");
		recurringPanel.add(weekly);
		JRadioButton biweekly = new JRadioButton("BiWeekly");
		recurringPanel.add(biweekly);
		JRadioButton monthly = new JRadioButton("Monthly");
		recurringPanel.add(monthly);
		ButtonGroup recurringGroup = new ButtonGroup();
		recurringGroup.add(weekly);
		recurringGroup.add(biweekly);
		recurringGroup.add(monthly);
		typePanel.add(recurringPanel);
		ButtonGroup dayGroup = new ButtonGroup();
		dayGroup.add(single);
		dayGroup.add(multiDay);
		dayGroup.add(recurring);
		
		frame.add(timePanel);
		frame.add(typePanel);
	}

}
