import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CalendarPage extends JFrame
{
	private JPanel mainPanel;
	private JTextArea textArea;
	
	public CalendarPage()
	{
		// Initializing the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600, 400);
		setTitle("Calendar Page");
		
		mainPanel = new JPanel();
		textArea = new JTextArea(20, 20);
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
		
		add(mainPanel);
	}
}
