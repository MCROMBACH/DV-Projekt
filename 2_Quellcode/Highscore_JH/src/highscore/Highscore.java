package highscore;

import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Highscore {
	//Array definieren 
	private String name[] = {"","","","",""}; 
	private int score[] = {0,0,0,0,0}; 
	private Properties props= new Properties();
	String level;
	
	
	//Konstruktor
	public Highscore(String level) {
		
	}
	
	public void insertScore(String Name, int Score) {
		
		boolean run = false;
		int smaller;
		int bigger;
		//prüfen ob Wert größer dem kleinsten Highscore
		if(Score<score[4]) {
			score[4]=Score;//einfügen
			//neu sortieren
			for (int i = 0; i < score.length && run == true; i++) {
			    run = false;

			   for (int y = 0; y < score.length-1; y++) {
			        if(score[y] > score[y + 1]) {
			            bigger = score[y];
			            smaller = score[y + 1];
			            score[y] = smaller;
			            score[y + 1] = bigger;
			            run = true;
			          }
			    }
			}
		}
	}
	public void saveData(){
		props.setProperty("Platz1Name",name[0]);
		props.setProperty("Platz2Name",name[1]);
		props.setProperty("Platz3Name",name[2]);
		props.setProperty("Platz4Name",name[3]);
		props.setProperty("Platz5Name",name[4]);
		props.setProperty("Platz1Zeit",Integer.toString(score[0]));
		props.setProperty("Platz2Zeit",Integer.toString(score[1]));
		props.setProperty("Platz3Zeit",Integer.toString(score[2]));
		props.setProperty("Platz4Zeit",Integer.toString(score[3]));
		props.setProperty("Platz5Zeit",Integer.toString(score[4]));
		
		try {
			props.store(new FileOutputStream("D:\\Informatik Übungen\\Escape The Maze\\src\\highscore\\SpeicherDatei"+level+".txt"), null);
			}
			catch (FileNotFoundException e) {
			  e.printStackTrace();
			}
			catch (IOException e) {
			  e.printStackTrace();
			}
		
	}
	
	
	
}
