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
							relPath = path.substring((path.indexOf("sig")+3), (path.length()-4));
							absPath = path.substring(0,(path.indexOf("sig")+3));
							System.out.print("_");
							tempOut = relPath.substring((path.lastIndexOf("_")+1),(path.lastIndexOf("_")+7));
							newPath = Paths.get(absPath + "Meta" + relPath + ".txt");
							try {
								Files.createDirectories(newPath.getParent());
								Files.createFile(newPath);
								fstream = new FileWriter(newPath.toString(), true);
								toFile = new BufferedWriter(fstream);
								toFile.write("FRC   " + tempOut);
								toFile.close();
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
							out += NameToMetaFile(files[i]);
					} else {
						if (files[i].getName().startsWith("E")) {
						}
					}
				}
			}
		try {
			toFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Succeded";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
