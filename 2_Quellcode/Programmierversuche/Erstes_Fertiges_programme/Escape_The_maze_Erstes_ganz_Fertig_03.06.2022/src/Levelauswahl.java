

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;





public class Levelauswahl extends JPanel{
	
	JButton Level1 = new JButton();
	JButton Level2 = new JButton();
	JButton Level3 = new JButton();
	JButton Sandbox = new JButton();
	JButton zurueck = new JButton();
	
	static int[][]layout = new int [20][20];
	
	
	Levelauswahl(){
		
		Level1 = new JButton();
		Level1.setPreferredSize(new Dimension(100,30));
		Level1.setText("Level1");
		add(Level1);
		Level1.addActionListener(new ALLevel1());
		
		Level2 = new JButton();
		Level2.setPreferredSize(new Dimension(100,30));
		Level2.setText("Level2");
		add(Level2);
		Level2.addActionListener(new ALLevel2());
		
		Level3 = new JButton();
		Level3.setPreferredSize(new Dimension(100,30));
		Level3.setText("Level3");
		add(Level3);
		Level3.addActionListener(new ALLevel3());
	
		Sandbox = new JButton();
		Sandbox.setPreferredSize(new Dimension(100,30));
		Sandbox.setText("Sandbox");
		add(Sandbox);
		Sandbox.addActionListener(new ALSandbox());
		
		zurueck = new JButton();
		zurueck.setText("Zurueck");
		zurueck.setPreferredSize(new Dimension(100,30));
	    add(zurueck);
	    zurueck.addActionListener(new ALZurueck());
	}
	
	class ALLevel1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Rahmen.inFrame("Level1",new Level1() , 1920, 1080);
			StartMenue.levelFrame= Rahmen.inFrame("Level1", new Level1(1), 1920, 1080);
		}
	}
	
	class ALLevel2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			StartMenue.levelFrame= Rahmen.inFrame("Level2",new Level2() , 1920, 1080);
		}
	}
	
	class ALLevel3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			StartMenue.levelFrame= Rahmen.inFrame("Level3",new Level3() , 1920, 1080);
		}
	}
	
	class ALSandbox implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			StartMenue.levelFrame= Rahmen.inFrame("Sandbox",new Sandbox() , 1920, 1080);
		}
	}
	
	  class ALZurueck implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            StartMenue.Menuefenster.dispose();


	        }
	    }
}
