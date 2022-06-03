
import java.awt.*;
import javax.swing.*;

import Highscore_Struktur.ALHighscore_Level1;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StartMenue extends JPanel {
	
	
	JButton Levelauswahl = new JButton();
	JButton Highscore = new JButton();
	JButton Sandbox = new JButton();
	JButton Highscore_Level1 = new JButton();
	JButton Highscore_Level2 = new JButton();
	JButton Highscore_Level3 = new JButton();
	JButton Highscore_Level4 = new JButton();
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
		//Level1 Highscore
		Highscore_Level1 = new JButton();
		Highscore_Level1.setPreferredSize(new Dimension(100,30));
		Highscore_Level1.setText("Highscore Level 1");
		Highscore_Level1.addActionListener(new ALHighscore_Level1());
		
		//Level2 Highscore
		Highscore_Level2 = new JButton();
		Highscore_Level2.setPreferredSize(new Dimension(100,30));
		Highscore_Level2.setText("Highscore Level ");
		//Highscore_Level2.addActionListener(new ALHighscore_Level2());
		
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
	class ALHighscore_Level1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
			
	
		class ALHighscore_Level2 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				//Rahmen.inFrame("Level1",new Level1() , 1920, 1080);
			}
		}
	}
}

