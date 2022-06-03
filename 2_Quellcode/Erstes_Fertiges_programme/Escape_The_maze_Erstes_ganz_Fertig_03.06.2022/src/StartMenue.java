


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;


public class StartMenue extends JPanel {


	JButton Levelauswahl = new JButton();
	JButton Highscore = new JButton();
	JButton Sandbox = new JButton();
	static JFrame levelFrame;
	static JFrame Menuefenster;

	StartMenue(){

		Levelauswahl = new JButton();
		Highscore = new JButton();
		Sandbox = new JButton();

		Levelauswahl.setText("Levelauswahl");
		Highscore.setText("Highscore");
		Sandbox.setText("Sandbox Erstellen");
		Levelauswahl.setPreferredSize(new Dimension(200, 30));
		Highscore.setPreferredSize(new Dimension(200, 30));
		Sandbox.setPreferredSize(new Dimension(200, 30));
		add(Levelauswahl);
		add(Highscore);
		add(Sandbox);
		Levelauswahl.addActionListener(new ALLevel());
		Highscore.addActionListener(new ALHigh());
		Sandbox.addActionListener(new ALSand());

	}

	class ALLevel implements ActionListener{
		public void actionPerformed(ActionEvent d) {
			StartMenue.Menuefenster=Rahmen.inFrame("Levelauswahl", new Levelauswahl(), 1920, 1080);

		}
	}

	class ALHigh implements ActionListener{
		public void actionPerformed(ActionEvent e) {

		}
	}

	class ALSand implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			StartMenue.Menuefenster=Rahmen.inFrame("Sandboxlevel Konfigurieren",new SandboxConfig() , 1920, 1080);
		}
	}

	public static void main(String[] args) {

		StartMenue.Menuefenster=Rahmen.inFrame("Startmenue", new StartMenue(), 1920, 1080);

	}
	
	public void paint (Graphics g) {
		super.paint(g);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Bild/Maze.png"),0,0,this);
		
	}

}
