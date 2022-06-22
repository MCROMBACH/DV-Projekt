
import java.util.Properties;

import javax.swing.JOptionPane;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Highscore  {
	/**
	 * Array definieren
	 */
	//Array definieren 
	//private String name[] = {"","","","",""}; 
	//private String score[][] = {{"9999","9999","9999","9999","9999"},{"name","name","name","name","name"}}; 
	private Properties props= new Properties();
	String level;

	/*public Highscore(String levelname) {
		level = levelname;
	}*/

	public void insertScore(String n, String Name, int Score) {

		//String score[][] = {{"9999","9999","9999","9999","9999"},{"name","name","name","name","name"}};
		/*while(true) {
			score = lesen(n);

			if (score.equals(lesen(n)))
				break;
			else
				speichern(n, score);

		}*/
		String score[][] = lesen(n);
		
/**
 * Sortieren der Highscore Werte, der mit den niedricgsten Schritten ist der erste
 */
		boolean run = false;
		int smaller;
		int bigger;
		String schnell;
		String langsam;
/**
 * 	Prüfen ob Wert größer dem kleinsten Highscore	
 */
		if(Score<Integer.parseInt(score[0][10])) {
			score[0][10]=Integer.toString(Score);//einfügen
			score[1][10]=Name;
			System.out.println(score.length);
/**
 * Wenn der Wert kleiner ist, wird er in die Highscore Liste einsortiert und dem entsprechenden Platz zugewiesen
 */
			for (int i = 0; i < 11 ; i++) {
				//run = false;

				for (int y = 0; y < 10; y++) {
					if(Integer.parseInt(score[0][y]) > Integer.parseInt(score[0][y+1])) {
						bigger = Integer.parseInt(score[0][y]); // lansame anzahl
						/**
						 * Langsamerer Spieler -> viele Schritte
						 */
						langsam = score[1][y]; // name langsamer
						smaller = Integer.parseInt(score[0][y+1]); // schenllerer anzahl
						/**
						 * Schnellerer Spieler -> wenig Schritte
						 */
						schnell = score[1][y+1]; // name schnellerer
						score[0][y+1] = Integer.toString(bigger);
						score[1][y+1] = langsam;
						score[0][y] = Integer.toString(smaller);
						score[1][y]= schnell;
						//run = true;
					}
				}
			}
		}
		speichern(n, score);
	}
	/*public void saveData(){
		props.setProperty("Platz1Name",name[0]);
		props.setProperty("Platz2Name",name[1]);
		props.setProperty("Platz3Name",name[2]);
		props.setProperty("Platz4Name",name[3]);
		props.setProperty("Platz5Name",name[4]);
		props.setProperty("Platz1Steps",Integer.toString(score[0]));
		props.setProperty("Platz2Steps",Integer.toString(score[1]));
		props.setProperty("Platz3Steps",Integer.toString(score[2]));
		props.setProperty("Platz4Steps",Integer.toString(score[3]));
		props.setProperty("Platz5Steps",Integer.toString(score[4]));

		try {
			props.store(new FileOutputStream("C:\\User\\Fabia\\Documents\\Workspace\\DV Highscore\\src\\highscore\\SpeicherDatei"+level+".txt"), null);
			}
			catch (FileNotFoundException e) {
			  e.printStackTrace();
			}
			catch (IOException e) {
			  e.printStackTrace();
			}

	}*/

	private void speichern(String n, String[][] array) {

		try {
			ObjectOutputStream outStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Highscore"+n+".ser")));
			Save1 saveObject = new Save1();
			saveObject.setname(n);
			saveObject.setStringarray(array);
			outStream.writeObject(saveObject);
			outStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[][] lesen(String n) {
		String[][] array;
		String score[][] = {{"9999","9999","9999","9999","9999","9999","9999","9999","9999","9999","9999"},{"name","name","name","name","name","name","name","name","name","name","name"}};
		try {
			ObjectInputStream inStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Highscore"+n+".ser")));
			Save1 savedObject = (Save1) inStream.readObject();
			//System.out.println(savedObject.getname());
			System.out.println(savedObject.getStringarray());
			array = savedObject.getStringarray();
			inStream.close(); 
			return array;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return score;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return score;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return score;
		}
		
		
	//	return null;
	}

	/*public static void main(String[] args) {
		int[][] array = new int[10][10];

		Highscore festeLevel = new Highscore();
		festeLevel.speichern("Name", array);		!! FEHLER IM PROGRAMM
		System.out.println(festeLevel.lesen("Name"));
	}*/
	/*public void sortierenUndSpeichern(String n, int Score) {
		String name = JOptionPane.showInputDialog("gebe deinen Namen ein");
		this.insertScore(name, Score);
		this.speichern(n, score);
	}*/
}

class Save1 implements Serializable{

	private static final long serialVersionUID = 5259437753701152287L;
	private String name;
	private String[][] stringarray;

	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String[][] getStringarray() {
		return stringarray;
	}
	public void setStringarray(String[][] stringarray) {
		this.stringarray = stringarray;
	}

}
