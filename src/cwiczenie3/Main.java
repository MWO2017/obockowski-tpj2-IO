package cwiczenie3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static String[] stringsToBeWritten = { "Joh Woo 001", "Robert Duval 002", "James Bond 007" };

	public static void main(String args[]) throws Exception {
		saveAgents(stringsToBeWritten, "res/cwiczenie3/special-agents.txt");
		saveAdditionalAgents(stringsToBeWritten, "res/cwiczenie3/special-agents.txt");
		readRawAgents(stringsToBeWritten, "res/cwiczenie3/special-agents.txt");
		createDirs();
		//copyFile();
		//delete();
		listFiles();
	}

	private static void saveAgents(String[] agents, String filename) {
		try (PrintWriter pw = new PrintWriter(filename)) {
			for (String s : agents) {
				pw.println(s);
			}
		} catch (IOException e) {
			System.err.format("IOException: %s", e);
			e.printStackTrace();
		} catch (RuntimeException e) {
			System.err.format("IOException: %s", e);
			e.printStackTrace();
		}
	}

	// metoda z appendem
	private static void saveAdditionalAgents(String[] agents, String filename) {
		try (FileOutputStream fos = new FileOutputStream(new File(filename), true);
				PrintWriter pw = new PrintWriter(fos)) {
			for (String s : agents) {
				pw.println(s);
			}
		} catch (IOException e) {
			System.err.format("IOException: %s", e);
			e.printStackTrace();
		} catch (RuntimeException e) {
			System.err.format("IOException: %s", e);
			e.printStackTrace();
		}
	}

	private static void readRawAgents(String[] agents, String filename) {
		try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
			for (int i = 1; i < 10; i++) {
				Byte b = raf.readByte();
				System.out.println("hex representation: 0x" + Integer.toHexString(b));
			}
			Byte b1 = 0x41;
			Byte b2 = 0x5A;
			long l = raf.length();
			raf.seek(l);
			raf.writeByte(b1);
			raf.writeByte(b2);
		} catch (Exception e) {
			System.err.format("IOException: %s", e);
			e.printStackTrace();
		}
	}

	private static void createDirs() {
		File katalog1 = new File("res/agents/active-agents/");
		File katalog2 = new File("res/agents/missing-agents/");
		katalog1.mkdirs();
		katalog2.mkdirs();
		try {
			Files.createDirectories(Paths.get("res/agents/test/1/"));
		} catch (IOException e) {
			System.err.format("IOException: %s", e);
		}
	}

	private static void copyFile() {
		Path source = Paths.get("res/cwiczenie3/special-agents.txt");
		Path target = Paths.get("res/agents/active-agents/special-agents-copy.txt");
		try {
			Files.copy(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void delete() {
		Path katalog = Paths.get("res/agents/");
		try {
			Files.delete(katalog);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private static void listFiles() {
		File katalog=new File("/home/obockows/");
		File[] pliki=katalog.listFiles();
		for (File plik: pliki) {
			System.out.println(plik.getName());
		}
	}
}
