package cwiczenie3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static String[] stringsToBeWritten = { "Joh Woo 001", "Robert Duval 002", "James Bond 007" };

	public static void main(String args[]) throws Exception {
		// PrintWriter writer = new PrintWriter("test.txt");
		// writer.println("Coœ piszê");
		// writer.close();

		//saveStrings(stringsToBeWritten, "special-agentx.txt");
		//RandomAccessFile raf = new RandomAccessFile("special-agentx.txt", "rw");
		//raf.seek(0);
//		raf.writeBytes("newString\n");
		
		Files.delete(Paths.get("agents/missing-agents"));
	}

	private static void saveStrings(String[] strings, String filename) throws Exception {
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File(filename), true));

		for (String s : strings) {
			pw.println(s);
		}
		pw.close();
	}
}
