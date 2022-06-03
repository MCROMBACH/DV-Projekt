import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.*;
import javax.swing.event.*;
import java.util.Arrays;

/**Beschreibung
 * 
 * 
 * @version Bearbeitung: 27.05.2022
 * @author Julia Heizmann
 * @param <Player>
 * @param <Main>
 * **/

public class Highscore_try1<Player, Main> extends JFrame {
  // Anfang Attribute
  Player player;
  Main main;
  static BufferedReader br;
  FileReader fr;
  Image hintergrund;
	
  private JLabel platz = new JLabel();
  private JLabel score = new JLabel();
  private JLabel name = new JLabel();
  private JLabel platz1 = new JLabel();
  private JLabel platz2 = new JLabel();
  private JLabel platz3 = new JLabel();
  private JLabel platz4 = new JLabel();
  private JLabel platz5 = new JLabel();
  private JTextField textbox = new JTextField();
  public static JButton speichern = new JButton();
  private static JLabel name1 = new JLabel();
  private static JLabel name2 = new JLabel();
  private static JLabel name4 = new JLabel();
  private static  JLabel name5 = new JLabel();
  private static  JLabel name3 = new JLabel();
  private static  JLabel jLabel11 = new JLabel();
  private static JLabel score1 = new JLabel();
  private static  JLabel score2 = new JLabel();
  private static  JLabel score3 = new JLabel();
  private static  JLabel score4 = new JLabel();
  private static  JLabel score5 = new JLabel();
  private JLabel fehler = new JLabel();
  public static JButton schlieﬂen = new JButton();
  
  static String Name[]= new String[5]; //Name und Score
  static int[] Score = new int[5];
  int flagge=1;
  static int punkte;
  int n = 0;
  int sc = 0;
  //name1 = Highscore[1][1];
  // Ende Attribute

  public Highscore_try1(String title) 
{
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 532;
    int frameHeight = 489;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);
    cp.setBackground(Color.GREEN);
    // Anfang Komponenten

    platz.setBounds(40, 24, 52, 29);
    platz.setText("Platz");
    platz.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    platz.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(platz);
    score.setBounds(416, 24, 64, 29);
    score.setText("Score");
    score.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    score.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(score);
    name.setBounds(224, 24, 65, 29);
    name.setText("Name");
    name.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    name.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(name);
    platz1.setBounds(50, 80, 19, 29);
    platz1.setText("1.");
    platz1.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(platz1);
    platz2.setBounds(50, 136, 19, 29);
    platz2.setText("2.");
    platz2.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(platz2);
    platz3.setBounds(50, 192, 19, 29);
    platz3.setText("3.");
    platz3.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(platz3);
    platz4.setBounds(50, 248, 19, 29);
    platz4.setText("4.");
    platz4.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(platz4);
    platz5.setBounds(50, 304, 19, 29);
    platz5.setText("5.");
    platz5.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(platz5);
    textbox.setBounds(200, 384, 113, 24);
    textbox.setText("Name");
    textbox.setFont(new Font("MS Sans Serif", Font.ITALIC, 13));
    cp.add(textbox);
    speichern.setBounds(200, 416, 113, 41);
    speichern.setText("Speichern");
    speichern.setMargin(new Insets(2, 2, 2, 2));
    speichern.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent evt) 
      {	
    	  speichern_ActionPerformed(evt);
		
		}
      });
    
    cp.add(speichern);
    schlieﬂen.setBounds(350, 416, 113, 41);
    schlieﬂen.setText("Schlieﬂen");
    schlieﬂen.setMargin(new Insets(2, 2, 2, 2));
    //cp.add(schlieﬂen);
    name1.setBounds(208, 80, 101, 32);
    name1.setText("");
    name1.setHorizontalAlignment(SwingConstants.CENTER);
    name1.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(name1);
    name2.setBounds(208, 136, 101, 32);
    name2.setText("");
    name2.setHorizontalAlignment(SwingConstants.CENTER);
    name2.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(name2);
    name4.setBounds(208, 248, 101, 32);
    name4.setText("");
    name4.setHorizontalAlignment(SwingConstants.CENTER);
    name4.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(name4);
    name5.setBounds(208, 304, 101, 32);
    name5.setText("");
    name5.setHorizontalAlignment(SwingConstants.CENTER);
    name5.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(name5);
    name3.setBounds(208, 192, 101, 32);
    name3.setText("");
    name3.setHorizontalAlignment(SwingConstants.CENTER);
    name3.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(name3);
    jLabel11.setBounds(82, 16, 3, 16);
    jLabel11.setText("");
    jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel11.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
    cp.add(jLabel11);
    score1.setBounds(408, 80, 85, 32);
    score1.setHorizontalAlignment(SwingConstants.CENTER);
    score1.setText("");
    score1.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(score1);
    score2.setBounds(408, 136, 85, 32);
    score2.setHorizontalAlignment(SwingConstants.CENTER);
    score2.setText("");
    score2.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(score2);
    score3.setBounds(408, 192, 85, 32);
    score3.setText("");
    score3.setHorizontalAlignment(SwingConstants.CENTER);
    score3.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(score3);
    score4.setBounds(408, 248, 85, 32);
    score4.setText("");
    score4.setHorizontalAlignment(SwingConstants.CENTER);
    score4.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(score4);
    score5.setBounds(408, 304, 85, 32);
    score5.setText("");
    score5.setHorizontalAlignment(SwingConstants.CENTER);
    score5.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
    cp.add(score5);
    fehler.setBounds(320, 384, 179, 24);
    fehler.setBackground(Color.RED);
    fehler.setText("<~ Bitte Name eingeben!");
    fehler.setFont(new Font("MS Sans Serif", Font.PLAIN, 14));
    fehler.setVisible(false);
    cp.add(fehler);
    // Ende Komponenten

    setResizable(false);
    setVisible(true);
  }
  
  public void init()
  {
	  setBackground(Color.GREEN);
  }
  
  public static void ¸bergabe(int finalscore)
	{
		punkte = finalscore;
	}

  // Anfang Methoden
  public void speichern_ActionPerformed(ActionEvent evt)
  {	  	  
	  try {
		schlieﬂen();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  
	  try {
		auslesen();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }	
  

  // Ende Methoden

  public void schlieﬂen() throws IOException
  {
	  sortiere(Score, Name);
	  
	  //Arrays.sort(Score);
	  
	  Writer output_name = null;
	  Writer output_score = null;
	  
  	  File highscore_name = new File("D:\\Eclipse\\RunAway!\\bin\\name.txt");
  	  File highscore_score = new File("D:\\Eclipse\\RunAway!\\bin\\score.txt");
  	   
  	  output_name = new BufferedWriter(new FileWriter(highscore_name));
  	  output_score = new BufferedWriter(new FileWriter(highscore_score));
  	  
	  
  	  for(int n=0; n<Score.length; n++)
  	  {
	  	  output_name.write(Name[n] + "\r\n"); //Ausgabe in der .txt datei
  	  }
  	  
  	for(int n=0; n<Name.length; n++)
	  { 
	  	  output_score.write(Score[n] + "\r\n");
	  }
  	  
  	  output_name.close();
  	  output_score.close();
  
	  System.out.println();
	  System.out.println("Datei wurde geschrieben.");//System.exit(Highscore_Frame);
	  System.out.println(Name[0]+" = "+Score[0]);
	  System.out.println(Name[1]+" = "+Score[1]);
	  System.out.println(Name[2]+" = "+Score[2]);
	  System.out.println(Name[3]+" = "+Score[3]);
	  System.out.println(Name[4]+" = "+Score[4]);
	  
  }
  
  public static void auslesen() throws IOException
  {
	  	FileReader fr_name = new FileReader("D:\\Eclipse\\RunAway!\\bin\\name.txt");
	  	FileReader fr_score = new FileReader("D:\\Eclipse\\RunAway!\\bin\\score.txt");
		BufferedReader na = new BufferedReader(fr_name);
		BufferedReader sc = new BufferedReader(fr_score);
		  
		//Score
		String seins = sc.readLine();
		String szwei = sc.readLine();
		String sdrei = sc.readLine();
		String svier = sc.readLine();
		String sfuenf = sc.readLine();
		//Name
		String neins = na.readLine();
		String nzwei = na.readLine();
		String ndrei = na.readLine();
		String nvier = na.readLine();
		String nfuenf = na.readLine();

	    Score[0] = Integer.parseInt(seins);
	    Score[1] = Integer.parseInt(szwei);
	    Score[2] = Integer.parseInt(sdrei);
	    Score[3] = Integer.parseInt(svier);
	    Score[4] = Integer.parseInt(sfuenf);
	    
	    Name[0] = neins;
	    Name[1] = nzwei;
	    Name[2] = ndrei;
	    Name[3] = nvier;
	    Name[4] = nfuenf;
	    
	      name1.setText(Name[0]);
		  score1.setText(""+Score[0]);
	 
		  name2.setText(Name[1]);
		  score2.setText(""+Score[1]);
	 
		  name3.setText(Name[2]);
		  score3.setText(""+Score[2]);
	  
		  name4.setText(Name[3]);
		  score4.setText(""+Score[3]);
	 
		  name5.setText(Name[4]);
		  score5.setText(""+Score[4]);
  }
  
  public static void sortiere(int[] x, String[] y) //Bubblesort
  {
	 /* boolean unsortiert=true;
	  int temp;
	  String name;
	
	  while (unsortiert)
	  {
		  unsortiert = false;
		  for (int i=0; i < x.length-1; i++)
			  if (x[i] < x[i+1])
			  {
				  temp = x[i];
				  x[i] = x[i+1];
				  x[i+1] = temp;
				  
				  name = y[i];
				  y[i] = y[i+1];
				  y[i+1] = name;
				  
				  unsortiert = true;
			  }
		  }*/
	  Arrays.sort(Score);
	  
	  
  }
 
 
  public static void main(String[] args)
  {
   	  

	  new Highscore_try1("Highscore");
	  
	  sortiere(Score, Name);  
	  
	  try {
			auslesen();
		  } 
	  catch (IOException e) 
		  {
			e.printStackTrace();
		  }
	  
	  }
  	
  }