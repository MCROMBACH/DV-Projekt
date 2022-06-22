

import java.io.*;
import java.util.*;

/**
 * Speichern und lesen der Level Dateien
 * @author Gruppe 24
 *
 */
public class FesteLevel{
	
	/**
	 * Speichern des Layouts
	 * @param n Gibt an um welches Level es sich handelt
	 * @param array ist das Layout
	 */
	public void speichern(String n, int[][] array) {
	
		try {
			ObjectOutputStream outStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(n+".ser")));
			Save saveObject = new Save();
			saveObject.setname(n);
			saveObject.setintarray(array);
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
	
	/**
	 * Lesen des Layouts
	 * @param n Gibt an um welches Level es sich handelt
	 * @return Gibt das Layout zurück, falls eines vorhanden ist.
	 */
	public int[][] lesen(String n) {
		int[][] array;
		int[][] vergleich = new int[1][1];
		vergleich[0][0] = 0;
		try {
			ObjectInputStream inStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(n+".ser")));
			Save savedObject = (Save) inStream.readObject();
			System.out.println(savedObject.getintarray());
			array = savedObject.getintarray();
			inStream.close(); 
			return array;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

/**
 * Serialisierung
 * @author Gruppe 24
 *
 */
class Save implements Serializable{
	
	private static final long serialVersionUID = 5259437753701152286L;
	private String name;
	private int[][] intarray;
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public int[][] getintarray() {
		return intarray;
	}
	public void setintarray(int[][] intarray) {
		this.intarray = intarray;
	}
}