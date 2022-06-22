package src;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StartMenue extends JPanel {
	
	
	JButton Levelauswahl = new JButton();
	JButton Highscore = new JButton();
	JButton Sandbox = new JButton();
	static JFrame levelFrame;
	
	StartMenue(){
		
		Levelauswahl = new JButton();
		Highscore = new JButton();
	 	Sandbox = new JButton();
		
		Levelauswahl.setText("Levelauswahl");
		Highscore.setText("Highscore");
		Sandbox.setText("Sandbox");
		Levelauswahl.setPreferredSize(new Dimension(100, 30));
		Highscore.setPreferredSize(new Dimension(100, 30));
		Sandbox.setPreferredSize(new Dimension(100, 30));
		add(Levelauswahl);
		add(Highscore);
		add(Sandbox);
		Levelauswahl.addActionListener(new ALLevel());
		Highscore.addActionListener(new ALHigh());
		Sandbox.addActionListener(new ALSand());
		
	}
	
	class ALLevel implements ActionListener{
		public void actionPerformed(ActionEvent d) {
			Rahmen.inFrame("Levelauswahl", new Levelauswahl(), 1920, 1080);
			
		}
	}
	
	class ALHigh implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	class ALSand implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public static void main(String[] args) {

		Rahmen.inFrame("Mein erstes GUI-Programm", new StartMenue(), 1920, 1080);

	}

}
