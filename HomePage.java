import java.awt.*;
import javax.swing.*;

public class HomePage extends JFrame{
	private JPanel panel;
	private int dailyCalories,goal,dailyCarbs,dailyFats,dailyProtein;
	
	public HomePage() {
		dailyCalories=0;
		goal=0;
		dailyCarbs=0;
		dailyFats=0;
		dailyProtein=0;
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
					"\nCalories Left  = "+(goal-dailyCalories)+
					"\nCarbs Today ="+dailyCarbs+
					"\nFats Today ="+dailyFats+
					"\nProtein Today ="+dailyProtein);
			a.setFont(font);
			a.setAlignmentX(CENTER_ALIGNMENT);
			a.setAlignmentY(CENTER_ALIGNMENT);
			panel.add(a);
		}else {
			JTextArea a = new JTextArea("Goal = "+goal+
					"\nCalories Today = "+dailyCalories+
					"\nGoal Complete!"+
					"\nCarbs Today ="+dailyCarbs+
					"\nFats Today ="+dailyFats+
					"\nProtein Today ="+dailyProtein);
			a.setFont(font);
			a.setAlignmentX(CENTER_ALIGNMENT);
			a.setAlignmentY(CENTER_ALIGNMENT);
			a.setEditable(false);
			panel.add(a);
		}
		add(panel);
	}
	
	public HomePage(int cals, int g,int carbs, int fat, int pro) {
		dailyCalories=cals;
		goal=g;
		dailyCarbs=carbs;
		dailyFats=fat;
		dailyProtein=pro;
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
					"\nCalories Left  = "+(goal-dailyCalories)+
					"\nCarbs Today ="+dailyCarbs+
					"\nFats Today ="+dailyFats+
					"\nProtein Today ="+dailyProtein);
			a.setFont(font);
			a.setAlignmentX(CENTER_ALIGNMENT);
			a.setAlignmentY(CENTER_ALIGNMENT);
			a.setEditable(false);
			panel.add(a);
		}else {
			JTextArea a = new JTextArea("Goal = "+goal+
					"\nCalories Today = "+dailyCalories+
					"\nGoal Complete!"+
					"\nCarbs Today ="+dailyCarbs+
					"\nFats Today ="+dailyFats+
					"\nProtein Today ="+dailyProtein);
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
