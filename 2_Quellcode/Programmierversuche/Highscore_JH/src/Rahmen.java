import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Rahmen {
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

