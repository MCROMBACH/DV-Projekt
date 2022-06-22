import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Rahmen {
	public static JFrame inFrame(String title, JPanel jp, int width,
			int height) {
		
/**
 * Hier wird der Rahmen für das Spielfeld Escape The Maze erstellt		
 */
	
		JFrame frame = new JFrame(title);
		/**
		 * JFrame frame = new Jframe(title) erzeugt ein Fenster
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * 
		 */
		frame.getContentPane().add(jp,BorderLayout.CENTER);
		frame.setSize(width,height);
		/**
		 * setSize() setzt die Größe fest
		 */
		frame.setResizable(true);
		/**
		 * Die Größe des Fensters Resizable ist nachträglich veränderbar
		 */
		frame.setVisible(true);
		/**
		 * setVisbile() lässt das frame auf dem Bildschrim erscheinen
		 */
		
		return frame;
		/**
		 * Gibt frame aus
		 */
	}
}
