import java.awt.Color;
import java.awt.Font;
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

public class HomePage extends JFrame{
	private JPanel panel;
	private int dailyCalories,goal;
	
	public HomePage() {
		dailyCalories=0;
		goal=0;
		// Initializing the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
		setSize(600, 400);
		setTitle("Home Page");
		
		// Panel setup
		panel = new JPanel();;
		Font font = new Font("Arial", Font.BOLD, 50);
		if(goal>dailyCalories) {
			JTextArea a = new JTextArea("Goal = "+goal+
					"\nCalories Today = "+dailyCalories+
					"\nCalories Left  = "+(goal-dailyCalories));
			a.setFont(font);
			a.setAlignmentX(CENTER_ALIGNMENT);
			a.setAlignmentY(CENTER_ALIGNMENT);
			panel.add(a);
		}else {
			JTextArea a = new JTextArea("Goal = "+goal+
					"\nCalories Today = "+dailyCalories+
					"\nGoal Complete!");
			a.setFont(font);
			a.setAlignmentX(CENTER_ALIGNMENT);
			a.setAlignmentY(CENTER_ALIGNMENT);
			a.setEditable(false);
			panel.add(a);
		}
		add(panel);
	}
	
	public HomePage(int dc, int g) {
		dailyCalories=dc;
		goal=g;
		// Initializing the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
		setSize(600, 400);
		setTitle("Home Page");
		
		// Panel setup
		panel = new JPanel();;
		Font font = new Font("Arial", Font.BOLD, 50);
		if(goal>dailyCalories) {
			JTextArea a = new JTextArea("Goal = "+goal+
					"\nCalories Today = "+dailyCalories+
					"\nCalories Left  = "+(goal-dailyCalories));
			a.setFont(font);
			a.setAlignmentX(CENTER_ALIGNMENT);
			a.setAlignmentY(CENTER_ALIGNMENT);
			a.setEditable(false);
			panel.add(a);
		}else {
			JTextArea a = new JTextArea("Goal = "+goal+
					"\nCalories Today = "+dailyCalories+
					"\nGoal Complete!");
			a.setFont(font);
			a.setAlignmentX(CENTER_ALIGNMENT);
			a.setAlignmentY(CENTER_ALIGNMENT);
			a.setEditable(false);
			panel.add(a);
		}
		add(panel);
	}
	
	public void addCalories(int cals) {
		dailyCalories+=cals;
	}
	
	public void newDay() {
		dailyCalories=0;
	}
	
	public void updateGoal(int cals) {
		goal=cals;
	}
	
	public int getCalories() {
		return dailyCalories;
	}
	
	public int getGoal() {
		return goal;
	}
}
