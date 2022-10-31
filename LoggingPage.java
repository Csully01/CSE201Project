import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		JTextArea a = new JTextArea("");
		a.setEditable(false);
		a.add(new JScrollPane());
		listPanel.add(a);
		
		entryPanel = new JPanel(new GridLayout(6, 2));
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
				a.setText(a.getText() + "\n" + field1.getText() + "\n" + field2.getText() + "\n" + field3.getText() + "\n" + field4.getText() + "\n" + field5.getText() + "\n" );	
			}
		});
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				a.setText("");
			}
		});
		entryPanel.add(addButton);
		entryPanel.add(resetButton);
		
		listPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		entryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel = new JPanel(new GridLayout(1,2));
		mainPanel.add(listPanel);
		mainPanel.add(entryPanel);
		// Put panels in frame and arrange them
		add(mainPanel);
	}
}
