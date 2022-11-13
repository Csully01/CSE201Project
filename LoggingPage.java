import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoggingPage extends JFrame
{
	
	private JPanel mainPanel, listPanel, entryPanel;
	
	public LoggingPage()
	{
		// Initializing the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600, 400);
		setTitle("Logging Page");
		// Panel setup
		listPanel = new JPanel();;
		JTextArea a = new JTextArea("", 20, 20);
		a.setEditable(false);
		JScrollPane scroll = new JScrollPane(a);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listPanel.add(scroll);
		
		entryPanel = new JPanel(new GridLayout(8, 2));
		JTextArea area6 = new JTextArea("Day: ");
		area6.setEditable(false);
		area6.setAlignmentX(CENTER_ALIGNMENT);
		area6.setAlignmentY(CENTER_ALIGNMENT);
		JTextArea area7 = new JTextArea("Meal # ");
		area7.setEditable(false);
		area7.setAlignmentX(CENTER_ALIGNMENT);
		area7.setAlignmentY(CENTER_ALIGNMENT);
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
		entryPanel.add(area6);
		JTextField field6 = new JTextField();
		entryPanel.add(field6);
		entryPanel.add(area7);
		JTextField field7 = new JTextField();
		entryPanel.add(field7);
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
				String str = (a.getText() + "\nDay: " + field6.getText() + " Meal #" + field7.getText() + "\n" + field1.getText() + "\nCalories: " + field2.getText() + "\nCarbs: " + field3.getText() + " grams\nFat: " + field4.getText() + " grams\nProtein: " + field5.getText() + " grams\n");
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
		mainPanel = new JPanel(new GridLayout(1,2));
		mainPanel.add(listPanel);
		mainPanel.add(entryPanel);
		add(mainPanel);
	}
}
