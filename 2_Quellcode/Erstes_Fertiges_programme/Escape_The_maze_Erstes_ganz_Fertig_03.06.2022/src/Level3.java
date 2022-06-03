


import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Level3 extends JPanel {

	int x = 0;
    int y = 0;
    int num;

    JPanel grid;
    int schwarz = 0;
    int farbe = 0;
    public JButton[][] squares = new JButton[22][22];
    JButton zurueck = new JButton();
    int[][] Layout = new int[22][22];
    JButton Start = new JButton();
    JButton Ende = new JButton();
    int nochmal = 0;

   public Level3() {

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

        JTextField field = new JTextField(50);
        field.addKeyListener(new KL());
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
        squares[21][20].setBackground(Color.orange);


    }

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
                }
            }
        }

        public void keyReleased(KeyEvent e) {
        }

    }

    class ALZurueck implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StartMenue.levelFrame.dispose();


        }
    }


    class ALStart implements ActionListener {
        int x;
        int y;

        public void actionPerformed(ActionEvent e) {
        
        	FesteLevel level = new FesteLevel();
        	Layout=level.lesen("Sandbox");
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

            laufen();
                  
           

        }
    }
    
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
    
    }
}


