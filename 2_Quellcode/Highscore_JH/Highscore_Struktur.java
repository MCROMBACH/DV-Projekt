import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;



public class Highscore_Struktur extends JPanel{

	JButton Highscore_Level1 = new JButton();
	JButton Highscore_Level2 = new JButton();
	JButton Highscore_Level3 = new JButton();
	JButton Highscore_Level4 = new JButton();
	
	//JButton Highscore_SandBox = new JButton(); -> erstmal später machen, muss sich immer erweitern
	
	Highscore_Struktur(){
		//Level1
		Highscore_Level1 = new JButton();
		Highscore_Level1.setPreferredSize(new Dimension(100,30));
		Highscore_Level1.setText("Highscore Level 1");
		Highscore_Level1.addActionListener(new ALHighscore_Level1());
		
		//Level1
		Highscore_Level2 = new JButton();
		Highscore_Level2.setPreferredSize(new Dimension(100,30));
		Highscore_Level2.setText("Highscore Level ");
		Highscore_Level2.addActionListener(new ALHighscore_Level2());
		
	}
	
	class ALHighscore_Level1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Rahmen.inFrame("Level1",new Level1() , 1920, 1080);
			Highscore_AufbauGUI.inFrame("Highscore Level1", new Highscore_Level1(), 1920, 1080);
			
			
			
	
		class ALHighscore_Level2 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				//Rahmen.inFrame("Level1",new Level1() , 1920, 1080);
			Highscore_AufbauGUI.levelFrame= Highscore_AufbauGUI.inFrame("Highscore Level2", new Highscore_Level2(), 1920, 1080);
			
			
			}
	
	
	
	
	
	
	
	/*	public static void main (String[] args) {
	Highscore_AufbauGUI.inFrame("Highscore", jp, 12, 12); //BSP
}
*/
	

