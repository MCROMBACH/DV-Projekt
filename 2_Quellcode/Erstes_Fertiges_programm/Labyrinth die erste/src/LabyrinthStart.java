import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class LabyrinthStart extends JPanel {

	int x=0;
	int y=0;

	JPanel grid;
	int schwarz = 0;
	int farbe = 0;
	public JButton[][] squares = new JButton[10][10];
	// public int [] squaresArray = new int[100];

	LabyrinthStart() {

		// JButton [][] squares = new JButton[10][10];
		JTextField field = new JTextField(1);
		field.addKeyListener(new KL());
		add(field);
		


		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				squares[i][j] = new JButton();
				squares[i][j].setPreferredSize(new Dimension(70, 70));
				add(squares[i][j]);
				squares[i][j].setBackground(Color.white);
				squares[i][j].addActionListener(new AL(i,j));
				//squares[i][j].addKeyListener(new KL());


			}
		}




		for (int i = 0; i < 10; i++) {
			squares[0][i].setBackground(Color.black);
		}
		for (int i = 0; i < 10; i++) {
			squares[i][0].setBackground(Color.black);
		}
		for (int i = 0; i < 10; i++) {
			squares[i][9].setBackground(Color.black);
		}
		for (int i = 0; i < 10; i++) {
			squares[9][i].setBackground(Color.black);
		}

		squares[4][4].setBackground(Color.RED);

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
		int indX=4;
		int indY=4;

		public void keyTyped(KeyEvent e) {}
		
		public void keyPressed(KeyEvent e) {
			
			int key = e.getKeyCode();
			System.out.println(key);

			if (key == KeyEvent.VK_LEFT) {
				squares[indX][indY-1].setBackground(Color.red);
				squares[indX][indY].setBackground(Color.white);
				indY--;
		
			}

			if (key == KeyEvent.VK_RIGHT) {
				squares[indX][indY+1].setBackground(Color.red);
				squares[indX][indY].setBackground(Color.white);  
				indY++;
				System.out.println("du dödel");

			}

			if (key == KeyEvent.VK_UP) {
				squares[indX-1][indY].setBackground(Color.red);
				squares[indX][indY].setBackground(Color.white);
				indX--;
				System.out.println("du dödel");


			}

			if (key == KeyEvent.VK_DOWN) {
				squares[indX+1][indY].setBackground(Color.red);
				squares[indX][indY].setBackground(Color.white);
				indX++;
				System.out.println("du dödel");

			}
		}
		public void keyReleased(KeyEvent e) {}


	}







	public class Coler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			farbe = 1;
			System.out.println("du dödel");
		}

	}

	int getPositionX(){
		for(int i=0;i<9;i++){
			for (int j=0;j<9;j++){
				Color s = squares[i][j].getBackground();  
				if (s==Color.RED){
					x= i+1;
					// System.out.println(x);
				}
			}
		}
		return x;
	}


	int getPositionY(){
		for(int i=0;i<9;i++){
			for (int j=0;j<9;j++){
				Color s = squares[i][j].getBackground();  
				if (s==Color.RED){
					y= j+1;
					//System.out.println(y);
				}
			}
		}
		return y;
	}

	void laufen(){
		int i = Integer.parseInt(JOptionPane.showInputDialog("zu welchem x möchtest du gehen"));
		int j = Integer.parseInt(JOptionPane.showInputDialog("zu welchem y möchtest du gehen"));
		//squares[x][y].setBackground(Color.white);
		squares[i][j].setBackground(Color.RED);
		System.out.println("hier sollte ich jetzt stehn: "+i+"  "+j);

	}


	public static void main(String[] args) {

		Rahmen.inFrame("Mein erstes GUI-Programm", new LabyrinthStart(), 800, 800);

		LabyrinthStart start;
		start = new LabyrinthStart();


		int xPosition = start.getPositionX();
		int yPosition = start.getPositionY();
		// start.laufen();
		start.repaint();

		System.out.println("Hier stand ich: "+xPosition+"   "+yPosition);


	}
}