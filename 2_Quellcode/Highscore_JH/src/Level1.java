import java.awt.event.*;
import javax.swing.*;

import java.awt.*;

public class Level1 extends JPanel{

	int x=0;
	int y=0;

	JPanel grid;
	int schwarz = 0;
	int farbe = 0;
	public JButton[][] squares = new JButton[20][20];
	JButton zurück = new JButton();
	
	

	Level1() {

		setLayout(new GridLayout(21,20));

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				squares[i][j] = new JButton();
				squares[i][j].setPreferredSize(new Dimension(70, 70));
				add(squares[i][j]);
				squares[i][j].setBackground(Color.white);
				squares[i][j].addActionListener(new AL(i,j));


			}
		}

		JTextField field = new JTextField(50);
		field.addKeyListener(new KL());
		add(field);
		field.setText("Hier rein klicken um zu steuern");
		
		zurück.setText("Zurück");
		add(zurück);
		zurück.addActionListener(new ALZurück());
	



		for (int i = 0; i < 20; i++) {
			squares[0][i].setBackground(Color.black);
			squares[i][0].setBackground(Color.black);
			squares[i][19].setBackground(Color.black);
			squares[19][i].setBackground(Color.black);
		}

		squares[10][10].setBackground(Color.RED);

	
	}

	class AL implements ActionListener {
		int indX,indY;
		AL(int i,int j){
			indX = i;
			indY = j;

		}
		public void actionPerformed(ActionEvent e) {
			if (squares[indX][indY].getBackground()!=Color.black) {
				if (squares[indX][indY].getBackground()!=Color.red) {
					if (squares[indX][indY].getBackground()!=Color.green) {
						squares[indX][indY].setBackground(Color.green);
					}
					else
						squares[indX][indY].setBackground(Color.white);	
					System.out.println("i= "+indX+"j= "+indY);
				}
			}
		}
	}

	class KL implements KeyListener{
		int indX=10;
		int indY=10;


		public void keyTyped(KeyEvent e) {}

		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();
			System.out.println(key);


			if (key == KeyEvent.VK_LEFT) {

				if (squares[indX][indY-1].getBackground()==Color.black||squares[indX][indY-1].getBackground()==Color.green)
					System.out.println("fehler");
				else {
					squares[indX][indY-1].setBackground(Color.red);
					squares[indX][indY].setBackground(Color.white);
					indY--;
				}

			}

			if (key == KeyEvent.VK_RIGHT) {

				if (squares[indX][indY+1].getBackground()==Color.black||squares[indX][indY+1].getBackground()==Color.green)
					System.out.println("fehler");
				else {
					squares[indX][indY+1].setBackground(Color.red);
					squares[indX][indY].setBackground(Color.white);  
					indY++;
					System.out.println("du dödel");
				}
			}

			if (key == KeyEvent.VK_UP) {

				if (squares[indX-1][indY].getBackground()==Color.black||squares[indX-1][indY].getBackground()==Color.green)
					System.out.println("fehler");
				else {
					squares[indX-1][indY].setBackground(Color.red);
					squares[indX][indY].setBackground(Color.white);
					indX--;
					System.out.println("du dödel");

				}
			}

			if (key == KeyEvent.VK_DOWN) {

				if (squares[indX+1][indY].getBackground()==Color.black||squares[indX+1][indY].getBackground()==Color.green)
					System.out.println("fehler");
				else {
					squares[indX+1][indY].setBackground(Color.red);
					squares[indX][indY].setBackground(Color.white);
					indX++;
					System.out.println("du dödel");
				}
			}
		}


		public void keyReleased(KeyEvent e) {}


	}
	
	class ALZurück implements ActionListener{
		public void actionPerformed(ActionEvent e) {	
			StartMenue.levelFrame.dispose();
			
		}
	}

	public class Coler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			farbe = 1;
			System.out.println("du dödel");
		}

	}


}