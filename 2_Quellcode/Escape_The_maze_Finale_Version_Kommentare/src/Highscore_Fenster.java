import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


/**
 * Erstellt das Grundger�st der Grafischen Oberfl�che
 * @author Gruppe 24
 *
 */
public class Highscore_Fenster extends JPanel{

    /**
     * Erzeugt leere Buttons
     */
    public JButton[][] squares = new JButton[10][3];
    
    /**
     * Erzeugt den Button f�r den zur�ck Knopf
     */
    JButton zur�ck = new JButton();

//////////////////////////////////////////////////////////////////////////////////////

    /**
     * Definiert alle Buttons.
     * @param n Gibt an um welches Level es sich handelt
     */
    Highscore_Fenster(String n) {
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
        
     
      
      

        zur�ck.setText("Zur�ck");
        add(zur�ck);
        zur�ck.addActionListener(new ALZur�ck());


    }


    /**
     * schlie�t das Highscorefenster
     * @author Gruppe 24
     *
     */
    class ALZur�ck implements ActionListener{
        public void actionPerformed(ActionEvent e) {
          StartMenue.Highscorefenster.dispose();

        }
    }




}