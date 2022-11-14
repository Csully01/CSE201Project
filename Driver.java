import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class Driver extends JFrame{
	private int dailyCalories,goal,dailyCarbs,dailyFats,dailyProtein, day, meal;
	
	public static void main(String[] args){
		Driver d = new Driver();
	}
	
	public Driver() {
		//intialize variables
		dailyCalories=0;
		goal=0;
		dailyCarbs=0;
		dailyFats=0;
		dailyProtein=0;
		day=1;
		meal=1;
		
		//Check for past info from user and set accurate day and meal
		File f = new File("calendar.txt");
		if(f.exists()) {
			try {
				Scanner sc = new Scanner(f);
				ArrayList<String> pastInfo = new ArrayList<String>();
				boolean lastInt = false;
				int currIndex =-1;
				while(sc.hasNextLine()) {
					String temp= sc.nextLine();
					for(int i = 0;i<temp.length();i++) {
						if(Character.isDigit(temp.charAt(i))) {
							if(lastInt) {
								pastInfo.set(currIndex,pastInfo.get(currIndex)+temp.charAt(i));
							}else {
								pastInfo.add(temp.charAt(i)+"");
								currIndex++;
								lastInt = true;
							}
						}else {
							lastInt = false;
						}
					}
				}
				if(pastInfo.size()>0) {
					day= Integer.parseInt(pastInfo.get(pastInfo.size()-6));
					meal= Integer.parseInt(pastInfo.get(pastInfo.size()-5));
				}
			}catch (Exception e) {
				e.getStackTrace();
			}
		}
		
		//Panel setup
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600, 400);
		setTitle("Home Page");
		
		//Panel setup
		JPanel homePanel = new JPanel();
		
		//Buttons
		JButton infoButton = new JButton("Open Info Page");
		infoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				infoPage();
			}
		});
		homePanel.add(infoButton);
		
		JButton loggingButton = new JButton("Open Logging Page");
		loggingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				LoggingPage();
			}
		});
		homePanel.add(loggingButton);
		
		JButton calendarButton = new JButton("Open Calendar Page");
		calendarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				CalendarPage();
			}
		});
		homePanel.add(calendarButton);
		
		JButton goalButton = new JButton("Enter Goal");
		goalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				goalPage();
			}
		});
		homePanel.add(goalButton);
		
		JButton newDayButton = new JButton("New Day");
		newDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				newDay();
			}
		});
		homePanel.add(newDayButton);
		
		
		add(homePanel);
	}
	
	private void infoPage() {
		// Initializing the frame
		JFrame infoFrame = new JFrame();
		infoFrame.setAlwaysOnTop(true);
		infoFrame.setVisible(true);
		infoFrame.setSize(600, 600);
		infoFrame.setTitle("Info Page");
		
		// Panel setup
		JPanel infoPanel = new JPanel();
		Font font = new Font("Arial", Font.BOLD, 50);
		if(goal>dailyCalories) {
			JTextArea a = new JTextArea("Welcome User!"+
					"\nToday is day "+day+
					"\nYou are on meal #"+meal+
					"\nGoal = "+goal+
					"\nCalories Today = "+dailyCalories+
					"\nCalories Left  = "+(goal-dailyCalories)+
					"\nCarbs Today ="+dailyCarbs+
					"\nFats Today ="+dailyFats+
					"\nProtein Today ="+dailyProtein);
			a.setFont(font);
			a.setAlignmentX(CENTER_ALIGNMENT);
			a.setAlignmentY(CENTER_ALIGNMENT);
			a.setEditable(false);
			infoPanel.add(a);
		}else {
			JTextArea a = new JTextArea("Welcome User!"+
					"\nToday is day "+day+
					"\nYou are on meal #"+meal+
					"\nGoal = "+goal+
					"\nCalories Today = "+dailyCalories+
					"\nGoal Complete!"+
					"\nCarbs Today ="+dailyCarbs+
					"\nFats Today ="+dailyFats+
					"\nProtein Today ="+dailyProtein);
			a.setFont(font);
			a.setAlignmentX(CENTER_ALIGNMENT);
			a.setAlignmentY(CENTER_ALIGNMENT);
			a.setEditable(false);
			infoPanel.add(a);
		}
		infoFrame.add(infoPanel);
	}
	
	public void LoggingPage()
	{
		// Initializing the frame
		JFrame loggingFrame = new JFrame();
		loggingFrame.setVisible(true);
		loggingFrame.setSize(600, 400);
		loggingFrame.setTitle("Logging Page");
		// Panel setup
		JPanel listPanel = new JPanel();;
		JTextArea a = new JTextArea("", 20, 20);
		a.setEditable(false);
		JScrollPane scroll = new JScrollPane(a);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listPanel.add(scroll);
		
		JPanel entryPanel = new JPanel(new GridLayout(6, 2));
		JTextArea area1 = new JTextArea("Food Item: ");
		area1.setEditable(false);
		area1.setAlignmentX(CENTER_ALIGNMENT);
		area1.setAlignmentY(CENTER_ALIGNMENT);
		JTextArea area2 = new JTextArea("Calories: ");
		area2.setEditable(false);
		area2.setAlignmentX(CENTER_ALIGNMENT);
		area2.setAlignmentY(CENTER_ALIGNMENT);
		JTextArea area3 = new JTextArea("Carbs (in grams): ");
		area3.setEditable(false);
		area3.setAlignmentX(CENTER_ALIGNMENT);
		area3.setAlignmentY(CENTER_ALIGNMENT);
		JTextArea area4 = new JTextArea("Fat (in grams): ");
		area4.setEditable(false);
		area4.setAlignmentX(CENTER_ALIGNMENT);
		area4.setAlignmentY(CENTER_ALIGNMENT);
		JTextArea area5 = new JTextArea("Protein (in grams): ");
		area5.setEditable(false);
		area5.setAlignmentX(CENTER_ALIGNMENT);
		area5.setAlignmentY(CENTER_ALIGNMENT);
		entryPanel.add(area1);
		JTextField field1 = new JTextField();
		entryPanel.add(field1);
		entryPanel.add(area2);
		JTextField field2 = new JTextField();
		entryPanel.add(field2);
		entryPanel.add(area3);
		JTextField field3 = new JTextField();
		entryPanel.add(field3);
		entryPanel.add(area4);
		JTextField field4 = new JTextField();
		entryPanel.add(field4);
		entryPanel.add(area5);
		JTextField field5 = new JTextField();
		entryPanel.add(field5);
		JButton addButton = new JButton("Add Food Item");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String str = (a.getText() + "\nDay: " + day + " Meal #" + meal + "\n" + field1.getText() + "\nCalories: " + field2.getText() + "\nCarbs: " + field3.getText() + " grams\nFat: " + field4.getText() + " grams\nProtein: " + field5.getText() + " grams\n");
				log(field2.getText(),field3.getText(),field4.getText(),field5.getText());
				a.setText(str);
				try
				{
					File file = new File("calendar.txt");
					file.createNewFile();
					FileWriter fw = new FileWriter(file, true);
					PrintWriter pw = new PrintWriter(fw);
						
					pw.println(str);
						
					pw.close();
					fw.close();
				}
				catch (FileNotFoundException f)
				{
					f.printStackTrace();
				}
				catch (IOException f)
				{
					f.printStackTrace();
				}
			}
		});
		JButton resetButton = new JButton("Clear History");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				a.setText("");
				newDay();
				day=1;
				try
				{
					File file = new File("calendar.txt");
					file.createNewFile();
					FileWriter fw = new FileWriter(file, false);
					PrintWriter pw = new PrintWriter(fw);
					
					pw.println("");
					
					pw.close();
					fw.close();
				}
				catch (FileNotFoundException f)
				{
					f.printStackTrace();
				}
				catch (IOException f)
				{
					f.printStackTrace();
				}
			}
		});
		entryPanel.add(addButton);
		entryPanel.add(resetButton);
		//Put panels in frame and arrange them
		listPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		entryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel mainPanel = new JPanel(new GridLayout(1,2));
		mainPanel.add(listPanel);
		mainPanel.add(entryPanel);
		loggingFrame.add(mainPanel);
	}

	private void log(String cals, String carbs, String fats, String protein) {
		try {
	        dailyCalories += Integer.parseInt(cals);
	    } catch (NumberFormatException nfe) {
	        return;
	    }
		try {
	        dailyCarbs += Integer.parseInt(carbs);
	    } catch (NumberFormatException nfe) {
	        return;
	    }
		try {
	        dailyFats += Integer.parseInt(fats);
	    } catch (NumberFormatException nfe) {
	        return;
	    }
		try {
	        dailyProtein += Integer.parseInt(protein);
	    } catch (NumberFormatException nfe) {
	        return;
	    }
		meal++;
	}
	
	private void goalPage() {
		// Initializing the frame
		JFrame goalFrame = new JFrame();
		goalFrame.setAlwaysOnTop(true);
		goalFrame.setVisible(true);
		goalFrame.setSize(800, 300);
		goalFrame.setTitle("Goal Page");
				
		// Panel setup
		JPanel entryPanel = new JPanel(new GridLayout(1, 2));
		Font font = new Font("Arial", Font.BOLD, 20);
		JTextArea a = new JTextArea("Enter Calorie Goal:");
		a.setFont(font);
		a.setAlignmentX(CENTER_ALIGNMENT);
		a.setAlignmentY(CENTER_ALIGNMENT);
		a.setEditable(false);
		entryPanel.add(a);
		JTextField f = new JTextField();
		entryPanel.add(f);
		
		JPanel buttonPanel = new JPanel();
		JButton enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
					goal=Integer.parseInt(f.getText());
				}catch(NumberFormatException nfe){}
				f.setText("");
			}
		});
		buttonPanel.add(enterButton);
		
		JPanel mainPanel = new JPanel(new GridLayout(1,2));
		mainPanel.add(entryPanel);
		mainPanel.add(buttonPanel);
		goalFrame.add(mainPanel);
	}

	private void newDay() {
		dailyCalories=0;
		dailyCarbs=0;
		dailyFats=0;
		dailyProtein=0;
		day++;
		meal=1;
	}
	
	public void CalendarPage()
	{
		// Initializing the frame
		JFrame calendarFrame = new JFrame();
		calendarFrame.setVisible(true);
		calendarFrame.setSize(600, 400);
		calendarFrame.setTitle("Calendar Page");
		
		JPanel mainPanel = new JPanel();
		JTextArea textArea = new JTextArea(20, 20);
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		Scanner scanner;
		try
		{
			File file = new File("calendar.txt");
			file.createNewFile();
			scanner = new Scanner(file);
			
			while (scanner.hasNextLine())
			{
				textArea.setText(textArea.getText() + "\n" + scanner.nextLine());
			}
			
			scanner.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		JButton resetButton = new JButton("Clear History");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText("");
				newDay();
				day=1;
				try
				{
					File file = new File("calendar.txt");
					file.createNewFile();
					FileWriter fw = new FileWriter(file, false);
					PrintWriter pw = new PrintWriter(fw);
					
					pw.println("");
					
					pw.close();
					fw.close();
				}
				catch (FileNotFoundException f)
				{
					f.printStackTrace();
				}
				catch (IOException f)
				{
					f.printStackTrace();
				}
			}
		});
		
		mainPanel.add(scroll);
		mainPanel.add(resetButton);
		
		calendarFrame.add(mainPanel);
	}
}