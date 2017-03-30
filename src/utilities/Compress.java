package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Compress {

	/*
	 * Wandelt HMM-LogDatei in einen String,
	 * in welchem aus den Zeilen, die "Correctness" enthalten
	 * die Werte für Erkennqote und Intervall sowie das Modell
	 * mit Tabs getrennt aufgelistet werden.
	 */
	public static String compress(File logfile) {
		FileReader freader = null;
		try {
			freader = new FileReader(logfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    BufferedReader reader = new BufferedReader(freader);
	    char[] output = new char[100000];
	    int endstring = 0;
	    String out = "Extrahierung Fehlgeschlagen.";
	    String n = "\n";
	    String t = "\t";
	    char[] frame = new char[4];
	    Integer frm = 0;
	    Integer sampl = 0;
	    Integer sec = 0;
	    Integer msec = 0;
	    String tme = "";
	    int a;
	    int b;
		String line = "readLine see below";
	    while(line != null) {
	    	if((line.indexOf("D") == 0) || (line.indexOf("V") == 0)) {
	    		line.getChars(0,line.length(), output, endstring);
	    		endstring += line.length();
	    		n.getChars(0,1, output, endstring);
	    		endstring += 1;
	    		System.out.println(line);
	    		}
	    	if(line.indexOf("dec_init frm") > -1) {
	    		frm = 0;
	    		line.getChars( a=(line.indexOf("frm") + 4), b=(line.length()), frame, 0);
	    		for (int i = 0; i < (b-a); i++) {
	    		   int digit = ((int)frame[i] & 0xF);
	    		   for (int j = 0; j < 4-1-i; j++) {
	    		        digit *= 10;
	    		   }
	    		   frm += digit;
	    		}
	    		sampl = frm*160 + 200;
	    		msec = sampl/48;
	    		sec = msec/1000;
	    		
	    		tme = frm.toString() + t + sampl.toString() + t + 
	    				sec.toString() + "," + msec.toString() + t;
	    		tme.getChars(0, tme.length(), output, endstring);
	    		endstring += tme.length();	
	    	}
	    	
	    	if(line.indexOf("res fst -1") > -1) {
	    		line.getChars( a=(line.indexOf(": ") + 1), b=(line.length()), output, endstring);
	    		endstring += b-a;
	    		n.getChars(0, 1, output, endstring);
	    		endstring += 1;
	    	}
	    	try {
				line = reader.readLine();
			} catch (IOException e) {
				System.err.println("IO FEHLER");
			}
	    }
	    
	    System.out.println("\nFertig.");
	    out = String.valueOf(output);
	    try {
			reader.close();
		} catch (IOException e) {
			System.err.print("Buffered Reader kann nich geschlossen werden.");
		}

	    return (out);
	}
}
