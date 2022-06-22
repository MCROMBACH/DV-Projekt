import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;



public class Highscore_Struktur extends JPanel{

	JButton Highscore_Level1 = new JButton();
	JButton Highscore_Level2 = new JButton();
	JButton Highscore_Level3 = new JButton();
	JButton Highscore_Sandbox = new JButton();
	JButton zurueck = new JButton();

	//JButton Highscore_SandBox = new JButton(); -> erstmal später machen, muss sich immer erweitern

	Highscore_Struktur(){
		
		setLayout(null);
		//Level1
		Highscore_Level1 = new JButton();
		Highscore_Level1.setPreferredSize(new Dimension(200,30));
		Highscore_Level1.setText("Highscore Level 1");
		Highscore_Level1.addActionListener(new ALHighscore_Level1());
		add(Highscore_Level1);

		//Level2
		Highscore_Level2 = new JButton();
		Highscore_Level2.setPreferredSize(new Dimension(200,30));
		Highscore_Level2.setText("Highscore Level 2");
		Highscore_Level2.addActionListener(new ALHighscore_Level2());
		add(Highscore_Level2);

		//Level3
		Highscore_Level3 = new JButton();
		Highscore_Level3.setPreferredSize(new Dimension(200,30));
		Highscore_Level3.setText("Highscore Level 3");
		Highscore_Level3.addActionListener(new ALHighscore_Level3());
		add(Highscore_Level3);

		//Sandbox
		Highscore_Sandbox = new JButton();
		Highscore_Sandbox.setPreferredSize(new Dimension(200,30));
		Highscore_Sandbox.setText("Highscore Sandbox");
		Highscore_Sandbox.addActionListener(new ALHighscore_Sandbox());
		add(Highscore_Sandbox);
		
		zurueck = new JButton();
		zurueck.setPreferredSize(new Dimension(200,30));
		zurueck.setText("Zurück");
		zurueck.addActionListener(new ALZurueck());
		add(zurueck);
		
		Highscore_Level1.setBounds(660,180,600,120);
		Highscore_Level2.setBounds(660,300,600,120);
		Highscore_Level3.setBounds(660,420,600,120);
		Highscore_Sandbox.setBounds(660,540,600,120);
		zurueck.setBounds(660,660,600,120);
		
		Highscore_Level1.setOpaque(false);
		Highscore_Level1.setBorderPainted(false);
		Highscore_Level1.setContentAreaFilled(false);
		Highscore_Level1.setForeground(Color.white);
		Highscore_Level1.setFont(new Font("Dialog", 0, 50));
		
		Highscore_Level2.setOpaque(false);
		Highscore_Level2.setBorderPainted(false);
		Highscore_Level2.setContentAreaFilled(false);
		Highscore_Level2.setForeground(Color.white);
		Highscore_Level2.setFont(new Font("Dialog", 0, 50));
		
		Highscore_Level3.setOpaque(false);
		Highscore_Level3.setBorderPainted(false);
		Highscore_Level3.setContentAreaFilled(false);
		Highscore_Level3.setForeground(Color.white);
		Highscore_Level3.setFont(new Font("Dialog", 0, 50));
		
		Highscore_Sandbox.setOpaque(false);
		Highscore_Sandbox.setBorderPainted(false);
		Highscore_Sandbox.setContentAreaFilled(false);
		Highscore_Sandbox.setForeground(Color.white);
		Highscore_Sandbox.setFont(new Font("Dialog", 0, 50));
		
		zurueck.setOpaque(false);
		zurueck.setBorderPainted(false);
		zurueck.setContentAreaFilled(false);
		zurueck.setForeground(Color.white);
		zurueck.setFont(new Font("Dialog", 0, 50));
	}

	class ALHighscore_Level1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Rahmen.inFrame("Level1",new Level1() , 1920, 1080);
			StartMenue.Highscorefenster= Rahmen.inFrame("Highscore Level1", new Highscore_Fenster("level_1"), 400, 400);	
		}
	}


	class ALHighscore_Level2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Rahmen.inFrame("Level1",new Level1() , 1920, 1080);
			StartMenue.Highscorefenster=Rahmen.inFrame("Highscore Level2", new Highscore_Fenster("level_2"), 400, 400);			
		}
	}

	class ALHighscore_Level3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Rahmen.inFrame("Level1",new Level1() , 1920, 1080);
			StartMenue.Highscorefenster=Rahmen.inFrame("Highscore Level3", new Highscore_Fenster("level_3"), 400, 400);	
		}
	}
	class ALHighscore_Sandbox implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Rahmen.inFrame("Level1",new Level1() , 1920, 1080);
			StartMenue.Highscorefenster=Rahmen.inFrame("Highscore Sandbox", new Highscore_Fenster("Sandbox"), 400, 400);	
		}
	}	
	
	class ALZurueck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StartMenue.Menuefenster.dispose();


		}
	}



public void paint (Graphics g) {
	super.paint(g);
	g.drawImage(Toolkit.getDefaultToolkit().getImage("D:/Informatik Übungen/Escape The Maze Dokumentation zu Final/Bild/Maze_Stein.jpg"),0,0,this);
	this.paintChildren(g);
	
}
}



/*	public static void main (String[] args) {
	Highscore_AufbauGUI.inFrame("Highscore", jp, 12, 12); //BSP
}
 */