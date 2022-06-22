

import java.io.*;
import java.util.*;

public class FesteLevel{
	
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
	
	public int[][] lesen(String n) {
		int[][] array;
		int[][] vergleich = new int[1][1];
		vergleich[0][0] = 0;
		try {
			ObjectInputStream inStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(n+".ser")));
			Save savedObject = (Save) inStream.readObject();
			//System.out.println(savedObject.getname());
			System.out.println(savedObject.getintarray());
			array = savedObject.getintarray();
			inStream.close(); 
			return array;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*public static void main(String[] args) {
		int[][] array = new int[10][10];
		
		FesteLevel festeLevel = new FesteLevel();
		festeLevel.speichern("Name", array);
		System.out.println(festeLevel.lesen("Name"));
	}*/
}

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