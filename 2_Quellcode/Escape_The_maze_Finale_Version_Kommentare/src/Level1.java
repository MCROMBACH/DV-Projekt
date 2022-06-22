

import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

/**
 * Klasse zu Level1, hier wird das Level1 definiert und erstellt. Selbiges gilt für Level2, Level3 und Sandbox.
 * @author Gruppe 24
 */

public class Level1 extends JPanel {

	/**
	 * für die Klasse ALStart wichtig
	 */
	int x = 0;
	
	/**
	 * für die Klasse ALStart wichtig
	 */
	int y = 0;
	
	/** 
	 * Speichert die Schritte, wichtig für den Highscore.
	 */
	int score = -1;
	
	/**
	 * Erstellt ein Container mit 22x22 Button
	 */
	public JButton[][] squares = new JButton[22][22];
	
	/**
	 * Erstellt einen Button für den Zurück Knopf.
	 */
	JButton zurueck = new JButton();
	
	/**
	 * Erstellt ein leeres Array worin das Layout gespeichert wird.
	 */
	int[][] Layout = new int[22][22];
	
	/**
	 * Erstellt einen Button für den Start Knopf.
	 */
	JButton Start = new JButton();
	
	/**
	 * Erstellt einen Textfeld, wichtig für den KL (Pfeiltastensteuerung).
	 */
	JTextField field = new JTextField();
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Erstellt das Level1 in seiner Grundform wie es vor Levelstart zu sehen ist.
	 */
	public Level1() {

		setLayout(new GridLayout(23, 22));

		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 22; j++) {
				squares[i][j] = new JButton();
				squares[i][j].setPreferredSize(new Dimension(70, 70));
				add(squares[i][j]);
				squares[i][j].setBackground(Color.white);
			}
		}


		field.addKeyListener(new KL());
		field.setPreferredSize(new Dimension(300,40));
		add(field);
		field.setText("Hier rein klicken um zu steuern");

		zurueck.setText("Zurueck");
		add(zurueck);
		zurueck.addActionListener(new ALZurueck());

		Start.setText("Start");
		add(Start);
		Start.addActionListener(new ALStart());




		for (int i = 0; i < 22; i++) {
			squares[0][i].setBackground(Color.black);
			squares[i][0].setBackground(Color.black);
			squares[i][21].setBackground(Color.black);
			squares[21][i].setBackground(Color.black);
		}

		squares[1][1].setBackground(Color.RED);
		squares[20][20].setBackground(Color.orange);


	}

	/**
	 * AL für die Pfeiltastensteuerung.
	 * @author Gruppe 24
	 *
	 */
	class KL implements KeyListener {
		int indX = 1;
		int indY = 1;

		public void keyTyped(KeyEvent e) {
		}

		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();
			System.out.println(key);

			if (key == KeyEvent.VK_LEFT) {

				if (squares[indX][indY - 1].getBackground() == Color.black
						|| squares[indX][indY - 1].getBackground() == Color.green)
					System.out.println("fehler");
				else {
					squares[indX][indY - 1].setBackground(Color.red);
					squares[indX][indY].setBackground(Color.white);
					indY--;
					laufen();
					ziel_Level1();


				}

			}

			if (key == KeyEvent.VK_RIGHT) {

				if (squares[indX][indY + 1].getBackground() == Color.black
						|| squares[indX][indY + 1].getBackground() == Color.green)
					System.out.println("fehler");
				else {
					squares[indX][indY + 1].setBackground(Color.red);
					squares[indX][indY].setBackground(Color.white);
					indY++;
					laufen();
					ziel_Level1();


				}
			}

			if (key == KeyEvent.VK_UP) {

				if (squares[indX - 1][indY].getBackground() == Color.black
						|| squares[indX - 1][indY].getBackground() == Color.green)
					System.out.println("fehler");
				else {
					squares[indX - 1][indY].setBackground(Color.red);
					squares[indX][indY].setBackground(Color.white);
					indX--;
					laufen();
					ziel_Level1();


				}
			}

			if (key == KeyEvent.VK_DOWN) {

				if (squares[indX + 1][indY].getBackground() == Color.black
						|| squares[indX + 1][indY].getBackground() == Color.green)
					System.out.println("fehler");
				else {
					squares[indX + 1][indY].setBackground(Color.red);
					squares[indX][indY].setBackground(Color.white);
					indX++;
					laufen();
					System.out.println(indX+"//"+indY);
					ziel_Level1();
				}
			}
		}

		public void keyReleased(KeyEvent e) {
		}

	}
	
	/**
	 * AL für den Zurückbutton.
	 * @author Gruppe 24
	 *
	 */
	class ALZurueck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StartMenue.levelFrame.dispose();


		}
	}

	/**
	 * Färbt das Spielfeld schwarz ein und speichert das Layout im Hintergrund. Das Spiel wird durch diesen AL gestartet.
	 * @author Gruppe 24
	 *
	 */
	class ALStart implements ActionListener {
		int x;
		int y;

		public void actionPerformed(ActionEvent e) {

			FesteLevel level = new FesteLevel();
			Layout=level.lesen("Level_1");
			for (int i = 0; i < 22; i++) {
				for (int j = 0; j < 22; j++) {
					if (Layout[i][j] == 1) {
						squares[i][j].setBackground(Color.green);
					}
				}
			}


			for (int i = 0; i < 22; i++) {
				for (int j = 0; j < 22; j++) {
					if (squares[i][j].getBackground() == Color.red) {
						x = i;
						y = j;
						System.out.println(x + "," + y);
					}

					squares[i][j].setBackground(Color.black);
				}
			}

			squares[x][y].setBackground(Color.red);
			field.requestFocus();

			laufen();









		}
	}

	/**
	 * Deckt die Felder passend zum gespeicherten Layout im Umkreis von einem Feld um den Spieler herum auf.
	 */
	void laufen(){

		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 22; j++) {
				if (squares[i][j].getBackground() == Color.red) {
					x = i;
					y = j;
				}
			}
		}

		if (Layout[x + 1][y] == 1)
			squares[x + 1][y].setBackground(Color.green);
		else if (Layout[x + 1][y] == 2)
			squares[x+1][y].setBackground(Color.black);
		else
			squares[x + 1][y].setBackground(Color.white);

		if (Layout[x - 1][y] == 1)
			squares[x - 1][y].setBackground(Color.green);
		else if (Layout[x - 1][y] == 2)
			squares[x-1][y].setBackground(Color.black);
		else
			squares[x - 1][y].setBackground(Color.white);

		if (Layout[x][y + 1] == 1 )
			squares[x][y + 1].setBackground(Color.green);
		else if (Layout[x][y+1] == 2)
			squares[x][y+1].setBackground(Color.black);
		else
			squares[x][y + 1].setBackground(Color.white);

		if (Layout[x][y - 1] == 1)
			squares[x][y - 1].setBackground(Color.green);
		else if (Layout[x][y-1] == 2)
			squares[x][y-1].setBackground(Color.black);
		else
			squares[x][y - 1].setBackground(Color.white);

		if (Layout[x - 1][y - 1] == 1)
			squares[x - 1][y - 1].setBackground(Color.green);
		else if (Layout[x - 1][y-1] == 2)
			squares[x-1][y-1].setBackground(Color.black);
		else
			squares[x - 1][y - 1].setBackground(Color.white);

		if (Layout[x + 1][y - 1] == 1)
			squares[x + 1][y - 1].setBackground(Color.green);
		else if (Layout[x + 1][y-1] == 2)
			squares[x+1][y-1].setBackground(Color.black);
		else
			squares[x + 1][y - 1].setBackground(Color.white);

		if (Layout[x - 1][y + 1] == 1)
			squares[x - 1][y + 1].setBackground(Color.green);
		else if (Layout[x - 1][y+1] == 2)
			squares[x-1][y+1].setBackground(Color.black);
		else
			squares[x - 1][y + 1].setBackground(Color.white);

		if (Layout[x + 1][y + 1] == 1)
			squares[x + 1][y + 1].setBackground(Color.green);
		else if (Layout[x + 1][y+1] == 2)
			squares[x+1][y+1].setBackground(Color.black);
		else
			squares[x + 1][y + 1].setBackground(Color.white);

		score++;

	}

	/**
	 * Erstellt einen Highscore wenn das Ziel erreicht wurde und greift auf die Klasse Highscore zu.
	 */
	void ziel_Level1() {
		if (squares[20][20].getBackground()==Color.red) {
			String name = JOptionPane.showInputDialog("Gebe deinen Namen ein");
			Highscore h1 = new Highscore();
			h1.insertScore("Level_1", name, score);
			StartMenue.levelFrame.dispose();
		}
	}


}

