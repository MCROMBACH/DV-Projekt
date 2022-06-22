

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * Klasse zur Sandbox Konfiguration, hier wird die Sandbox Konfiguartion definiert und erstellt.
 * @author Gruppe 24
 */
public class SandboxConfig extends JPanel {

	/**
	 * Erstellt ein Container mit 22x22 Button
	 */
	public JButton[][] squares = new JButton[22][22];
	
	/**
	 * Erstellt einen zurück Button
	 */
	JButton zurueck = new JButton();
	
	/**
	 * Erstellt einen Button um das Layout zu laden.
	 */
	JButton getLayout = new JButton();
	
	/**
	 * Erstellt einen Button um das Layout zu laden.
	 */
	JButton ladeLayout = new JButton();
	
	/**
	 * Erstellt ein leeres Array worin das Layout gespeichert werden kann.
	 */
	int[][] Layout = new int[22][22];
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Erstellt das Leere Sandbox Level.
	 */
	public SandboxConfig() {
		setLayout(new GridLayout(23, 22));

		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 22; j++) {
				squares[i][j] = new JButton();
				squares[i][j].setPreferredSize(new Dimension(70, 70));
				add(squares[i][j]);
				squares[i][j].setBackground(Color.white);
				squares[i][j].addActionListener(new AL(i, j));

			}
		}



		zurueck.setText("Zurueck");
		add(zurueck);
		zurueck.addActionListener(new ALZurueck());

		getLayout.setText("speichern");
		add(getLayout);
		getLayout.addActionListener(new ALgetLayout());

		ladeLayout.setText("laden");
        add(ladeLayout);
        ladeLayout.setPreferredSize(new Dimension(200, 30));
        ladeLayout.addActionListener(new ALladeLayout());







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
	 * Erstellt einen ActionListener für jeden Button um dieses zu färben.
	 * @author Gruppe 24
 	 *
	 */
	class AL implements ActionListener {
		int indX, indY;

		AL(int i, int j) {
			indX = i;
			indY = j;

		}

		public void actionPerformed(ActionEvent e) {
			if (squares[indX][indY].getBackground() != Color.black) {
				if (squares[indX][indY].getBackground() != Color.red) {
					if (squares[indX][indY].getBackground() != Color.green) {
						squares[indX][indY].setBackground(Color.green);
					} else
						squares[indX][indY].setBackground(Color.white);
					System.out.println("i= " + indX + "j= " + indY);
				}
			}
		}
	}

	/**
	 * AL für zurück Button
	 * @author Gruppe 24
	 *
	 */
	class ALZurueck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StartMenue.Menuefenster.dispose();


		}
	}

	/**
	 * Speichert das erzeugte Layout 
	 * @author Gruppe 24
	 *
	 */
	class ALgetLayout implements ActionListener {
		int indX, indY;

		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < 22; i++) {
				for (int j = 0; j < 22; j++) {
					if (squares[i][j].getBackground() == Color.green) {
						Layout[i][j] = 1;
					}
					if (squares[i][j].getBackground() == Color.black){
						Layout[i][j]=2;
					}
					if (squares[i][j].getBackground() == Color.white){
						Layout[i][j]=3;
					}

					// Levelauswahl.layout[i][j]= Layout[i][j];
				}
			}
			FesteLevel level = new FesteLevel();
			level.speichern("Sandbox" , Layout);
		}
	}

	/**
	 * Lädt das gespeicherte Layout
	 * @author Gruppe 24
	 *
	 */
    class ALladeLayout implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	FesteLevel level = new FesteLevel();
        	Layout=level.lesen("Sandbox");
            for (int i = 0; i < 22; i++) {
                for (int j = 0; j < 22; j++) {
                    //Layout[i][j]=Levelauswahl.layout[i][j];
                    if (Layout[i][j] == 1) {
                        squares[i][j].setBackground(Color.green);
                    }
                    if (Layout[i][j] == 3) {
                        squares[i][j].setBackground(Color.white);
                    }
                }
            }
        }
    }

}


