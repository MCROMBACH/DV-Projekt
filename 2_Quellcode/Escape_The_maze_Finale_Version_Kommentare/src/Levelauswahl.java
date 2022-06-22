

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Klasse zur Levelauswahl
 * @author Gruppe 24
 *
 */
public class Levelauswahl extends JPanel{

	/**
	 * Erstellt einen Button um Level1 zu starten.
	 */
	JButton Level1 = new JButton();
	
	/**
	 * Erstellt einen Button um Level2 zu starten.
	 */
	JButton Level2 = new JButton();
	
	/**
	 * Erstellt einen Button um Level3 zu starten.
	 */
	JButton Level3 = new JButton();
	
	/**
	 * Erstellt einen Button um das Sandbox Level zu starten.
	 */
	JButton Sandbox = new JButton();
	
	/**
	 * Erstellt einen zur�ck Button.
	 */
	JButton zurueck = new JButton();


	/** 
	 * Erstellt und definiert die Buttons.
	 */
	Levelauswahl(){
		
		setLayout(null);
		

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
		
		Level1.setBounds(660,200,600,120);
		Level2.setBounds(660,320,600,120);
		Level3.setBounds(660,440,600,120);
		Sandbox.setBounds(660,560,600,120);
		zurueck.setBounds(660,680,600,120);
		
		Level1.setOpaque(false);
		Level1.setBorderPainted(false);
		Level1.setContentAreaFilled(false);
		Level1.setForeground(Color.white);
		Level1.setFont(new Font("Dialog", 0, 50));
		
		Level2.setOpaque(false);
		Level2.setBorderPainted(false);
		Level2.setContentAreaFilled(false);
		Level2.setForeground(Color.white);
		Level2.setFont(new Font("Dialog", 0, 50));
		
		Level3.setOpaque(false);
		Level3.setBorderPainted(false);
		Level3.setContentAreaFilled(false);
		Level3.setForeground(Color.white);
		Level3.setFont(new Font("Dialog", 0, 50));
		
		Sandbox.setOpaque(false);
		Sandbox.setBorderPainted(false);
		Sandbox.setContentAreaFilled(false);
		Sandbox.setForeground(Color.white);
		Sandbox.setFont(new Font("Dialog", 0, 50));
		
		zurueck.setOpaque(false);
		zurueck.setBorderPainted(false);
		zurueck.setContentAreaFilled(false);
		zurueck.setForeground(Color.white);
		zurueck.setFont(new Font("Dialog", 0, 50));

	}

	/**
	 * �ffnet Level1
	 * @author Gruppe 24
	 *
	 */
	class ALLevel1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Rahmen.inFrame("Level1",new Level1() , 1920, 1080);
			StartMenue.levelFrame= Rahmen.inFrame("Level1", new Level1(), 1920, 1030);
		}
	}

	/**
	 * �ffnet Level2
	 * @author Gruppe 24
	 *
	 */
	class ALLevel2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			StartMenue.levelFrame= Rahmen.inFrame("Level2",new Level2() , 1920, 1030);
		}
	}

	/**
	 * �ffnet Level3
	 * @author Gruppe 24
	 *
	 */
	class ALLevel3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			StartMenue.levelFrame= Rahmen.inFrame("Level3",new Level3() , 1920, 1030);
		}
	}

	/**
	 * �ffnet das Sandbox Level
	 * @author Gruppe 24
	 *
	 */
	class ALSandbox implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			StartMenue.levelFrame= Rahmen.inFrame("Sandbox",new Sandbox() , 1920, 1030);
		}
	}

	/** 
	 * AL um die Levelauswahl zu schlie�en.
	 * @author mirco
	 *
	 */
	class ALZurueck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StartMenue.Menuefenster.dispose();


		}
	}

	/**
	 * F�gt das Hintergrundbild ein
	 */
	public void paint (Graphics g) {
		super.paint(g);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("F:\\DV_Projekt\\Escape_The_maze_Erstes_ganz_Fertig/Bild/Maze_Stein.jpg"),0,0,this);
		this.paintChildren(g);

	}
}
