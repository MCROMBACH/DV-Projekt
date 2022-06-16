


import java.awt.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;


public class StartMenue extends JPanel {


	JButton Levelauswahl = new JButton();
	JButton Highscore = new JButton();
	JButton Sandbox = new JButton();
	JTextField Headline = new JTextField();
	static JFrame levelFrame;
	static JFrame Menuefenster;
	static JFrame Highscorefenster;
	
	

	StartMenue(){
		
		setLayout(null);

		Levelauswahl = new JButton();
		Highscore = new JButton();
		Sandbox = new JButton();
		Headline = new JTextField();

		Levelauswahl.setText("Levelauswahl");
		Highscore.setText("Highscore");
		Sandbox.setText("Sandbox Erstellen");
		Headline.setText("Escape The Maze");
		
		Levelauswahl.setPreferredSize(new Dimension(200, 30));
		Highscore.setPreferredSize(new Dimension(200, 30));
		Sandbox.setPreferredSize(new Dimension(200, 30));
		
		add(Levelauswahl);
		add(Highscore);
		add(Sandbox);
		add(Headline);
		
		Levelauswahl.addActionListener(new ALLevel());
		Highscore.addActionListener(new ALHigh());
		Sandbox.addActionListener(new ALSand());
		
		Levelauswahl.setBounds(660,300,600,120);
		Highscore.setBounds(660,420,600,120);
		Sandbox.setBounds(660,540,600,120);
		Headline.setBounds(570,100,1920,200);
		
		Headline.setOpaque(false);
		Headline.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Headline.setForeground(Color.white);
		Headline.setFont(new Font("Dialog", 0, 100));
		
		Levelauswahl.setOpaque(false);
		Levelauswahl.setBorderPainted(false);
		Levelauswahl.setContentAreaFilled(false);
		Levelauswahl.setForeground(Color.white);
		Levelauswahl.setFont(new Font("Dialog", 0, 50));
		
		Highscore.setOpaque(false);
		Highscore.setBorderPainted(false);
		Highscore.setContentAreaFilled(false);
		Highscore.setForeground(Color.WHITE);
		Highscore.setFont(new Font("Dialog", 0, 50));
		
		Sandbox.setOpaque(false);
		Sandbox.setBorderPainted(false);
		Sandbox.setContentAreaFilled(false);
		Sandbox.setForeground(Color.WHITE);
		Sandbox.setFont(new Font("Dialog", 0, 50));
		
		
	}

	class ALLevel implements ActionListener{
		public void actionPerformed(ActionEvent d) {
			StartMenue.Menuefenster=Rahmen.inFrame("Levelauswahl", new Levelauswahl(), 1920, 1030);

		}
	}

	class ALHigh implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			StartMenue.Menuefenster=Rahmen.inFrame("Highscore", new Highscore_Struktur(), 1920, 1030);

		}
	}

	class ALSand implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			StartMenue.Menuefenster=Rahmen.inFrame("Sandboxlevel Konfigurieren",new SandboxConfig() , 1920, 1030);
		}
	}

	public static void main(String[] args) {

		StartMenue.Menuefenster=Rahmen.inFrame("Startmenue", new StartMenue(), 1920, 1030);

	}
	
	public void paint (Graphics g) {
		super.paint(g);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("F:\\DV_Projekt\\Escape_The_maze_Erstes_ganz_Fertig/Bild/Maze_Stein.jpg"),0,0,this);
		this.paintChildren(g);
		
	}
}
