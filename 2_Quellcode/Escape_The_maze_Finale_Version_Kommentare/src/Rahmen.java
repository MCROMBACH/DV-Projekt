import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Stellt die Basis für alles GUI Fenster
 * @author Gruppe 24
 *
 */
public class Rahmen {
	
	/**
	 * 
	 * @param title GUI Titel
	 * @param jp Hier muss der Konstrukter der zu öffnenden Klasse eingetragen werden.
	 * @param width Breite des Fensters
	 * @param height Höhe des Fensters
	 * @return Gibt das fertige GUI Fenster zurück.
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

