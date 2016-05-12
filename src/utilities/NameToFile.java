package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NameToFile {

	public static String NameToMetaFile (File dir) {	
		String out = new String();
		String path = new String();
		String absPath = new String(); //Pfad zu sig
		String relPath = new String(); //Pfad von sig zur Datei
		Path newPath = null; //neuer Pfad
		String tempOut = ""; //String für Datei
		BufferedWriter toFile = null;
		FileWriter fstream = null;
		
		File[] files = dir.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()){
					path = files[i].getAbsolutePath();

					if (path.endsWith(".wav")) { //WAV-Datei gefunden
						try {
							relPath = path.substring((path.indexOf("sig")+10), (path.length()-4));
							absPath = path.substring(0,(path.indexOf("sig")+3));
							tempOut = relPath.substring((relPath.lastIndexOf("HS-")+3),(relPath.length()-5));
							newPath = Paths.get(absPath + "_meta" + relPath + ".txt");

							try {
								Files.createDirectories(newPath.getParent());
								Files.createFile(newPath);
								fstream = new FileWriter(newPath.toString(), true);
								toFile = new BufferedWriter(fstream);
								toFile.write("FRC   " + tempOut);
								toFile.close();
								System.out.println(tempOut);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.err.print("IO Exception Create Dir/File");
							}
						} catch (StringIndexOutOfBoundsException e) {	
							//Dateinamen mit falschem Schema werden ignoriert
						}
					}
				} else if (files[i].isDirectory()) { //Verzeichnis gefunden, rekursiver Aufruf
					if (files[i].getName().startsWith("V") || files[i].getName().startsWith("D")
							|| files[i].getName().startsWith("B"))
							NameToMetaFile(files[i]);
					} else {
						if (files[i].getName().startsWith("E")) {
						}
					}
				}
		}
		return "Succeded";
		
	}

		public static String renameIt (File dir) {	
			String path = new String();
			String start = new String(); //Pfad zu sig
			String end = new String(); //Pfad von sig zur Datei
			File newPath = null;
			int number;
			boolean success = false;
			
			File[] files = dir.listFiles();
			if (files != null) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isFile()){
						path = files[i].getAbsolutePath();

						if (path.endsWith(".wav")) { //WAV-Datei gefunden
							try {
								start = path.substring(0,(path.lastIndexOf("\\")+10));
								end = path.substring(path.indexOf(".")-4,path.length());
							//	System.out.println(start + end);
								newPath = new File(start + end);
								success = files[i].renameTo(newPath);
								if (!success) {
									number = new Integer(end.substring(0,3));
									number += 20;
									end = path.substring(path.lastIndexOf(".wav"),path.length());
									newPath = new File (start + "00" + number + end);
									System.out.println(newPath);
									success = files[i].renameTo(newPath);
									while (!success) {
										number += 1;
										end = path.substring(path.lastIndexOf(".wav"),path.length());
										newPath = new File (start + "00" + number + end);
										System.out.println(newPath);
										success = files[i].renameTo(newPath);
									}
								}
							} catch (StringIndexOutOfBoundsException e) {	
								//Dateinamen mit falschem Schema werden ignoriert
							}
						}
					} else if (files[i].isDirectory()) { //Verzeichnis gefunden, rekursiver Aufruf
						if (files[i].getName().startsWith("V") || files[i].getName().startsWith("D")
								|| files[i].getName().startsWith("B"))
								renameIt(files[i]);
						} 
					}
				}

			return "Succeded";
			}
		}
