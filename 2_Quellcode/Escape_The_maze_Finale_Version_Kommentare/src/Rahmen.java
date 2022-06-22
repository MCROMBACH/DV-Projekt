import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Stellt die Basis f�r alles GUI Fenster
 * @author Gruppe 24
 *
 */
public class Rahmen {
	
	/**
	 * 
	 * @param title GUI Titel
	 * @param jp Hier muss der Konstrukter der zu �ffnenden Klasse eingetragen werden.
	 * @param width Breite des Fensters
	 * @param height H�he des Fensters
	 * @return Gibt das fertige GUI Fenster zur�ck.
	 */
	public static JFrame inFrame(String title, JPanel jp, int width,
			int height) {
		
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(jp,BorderLayout.CENTER);
		frame.setSize(width,height);
		frame.setResizable(true);
		frame.setVisible(true);

		return frame;
	}
}

