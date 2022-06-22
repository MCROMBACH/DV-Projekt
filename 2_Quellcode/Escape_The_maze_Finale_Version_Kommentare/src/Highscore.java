
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

/**
 * Speichert und Lädt die Highscoretabellen.
 * @author Gruppe 24
 *
 */
public class Highscore  {
	
	/**
	 * Sortieren der Tabelle
	 * @param n Gibt an welche Tabelle sotiert werde soll.
	 * @param Name Spielername
	 * @param Score Schrittzahl des Spielers
	 */
	public void insertScore(String n, String Name, int Score) {

		String score[][] = lesen(n);
		
		int smaller;
		int bigger;
		String schnell;
		String langsam;
		if(Score<Integer.parseInt(score[0][10])) {
			score[0][10]=Integer.toString(Score);
			score[1][10]=Name;
			System.out.println(score.length);
			for (int i = 0; i < 11 ; i++) {
				for (int y = 0; y < 10; y++) {
					if(Integer.parseInt(score[0][y]) > Integer.parseInt(score[0][y+1])) {
						bigger = Integer.parseInt(score[0][y]);
						langsam = score[1][y];
						smaller = Integer.parseInt(score[0][y+1]); 
						schnell = score[1][y+1]; 
						score[0][y+1] = Integer.toString(bigger);
						score[1][y+1] = langsam;
						score[0][y] = Integer.toString(smaller);
						score[1][y]= schnell;
					}
				}
			}
		}
		speichern(n, score);
	}
	
	/**
	 * Speichern der Tabelle
	 * @param n Gibt an um welche Tabelle es sich handelt.
	 * @param array Gibt das Objekt an (String array) welches gespeichert werden soll.
	 */
	private void speichern(String n, String[][] array) {

		try {
			ObjectOutputStream outStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Highscore"+n+".ser")));
			Save1 saveObject = new Save1();
			saveObject.setname(n);
			saveObject.setStringarray(array);
			outStream.writeObject(saveObject);
			outStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Laden der Tabelle
	 * @param n Gibt an um welche Tabelle es sich handelt.
	 * @return array wenn schon eine Tabelle vorhanden ist wird diese zurück gegeben 
	 * @return score ist keine Tabelle vorhanden wird die vordefinierte Tabelle verwendet.
	 */
	public String[][] lesen(String n) {
		String[][] array;
		String score[][] = {{"9999","9999","9999","9999","9999","9999","9999","9999","9999","9999","9999"},{"name","name","name","name","name","name","name","name","name","name","name"}};
		try {
			ObjectInputStream inStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Highscore"+n+".ser")));
			Save1 savedObject = (Save1) inStream.readObject();
			System.out.println(savedObject.getStringarray());
			array = savedObject.getStringarray();
			inStream.close(); 
			return array;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return score;
		} catch (IOException e) {
			e.printStackTrace();
			return score;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return score;
		}
	}
}

/**
 * Serialisierung
 * @author Gruppe 24
 *
 */
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
