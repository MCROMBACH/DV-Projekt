import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;



public class Highscore_Fenster extends JPanel{

    int x=0;
    int y=0;
    String level;

    JPanel grid;
    int schwarz = 0;
    int farbe = 0;
    public JButton[][] squares = new JButton[10][3];
    JButton zurück = new JButton();



    Highscore_Fenster(String n) {
        level=n;
        Highscore h = new Highscore();

        String score[][]= h.lesen(n);

        setLayout(new GridLayout(11,3));

        for (int i = 0; i < 10; i++) {
        	squares[i][0]= new JButton();
        	add(squares[i][0]);
        	squares[i][0].setText((i+1)+". Platz");
        	squares[i][0].setBackground(Color.gray);
            for (int j = 1; j < 3; j++) {
                squares[i][j] = new JButton();
                squares[i][j].setText(score[j-1][i]);
                add(squares[i][j]);
                squares[i][j].setBackground(Color.white);
               
             


            }
        }
        
     
      
      

        zurück.setText("Zurück");
        add(zurück);
        zurück.addActionListener(new ALZurück());


    }


    class ALZurück implements ActionListener{
        public void actionPerformed(ActionEvent e) {
          StartMenue.Highscorefenster.dispose();

        }
    }




}