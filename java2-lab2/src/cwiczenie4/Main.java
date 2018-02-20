package cwiczenie4;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String args[]) throws Exception {
		//printFilesSimple("C:\\");
		printFilesDetails("C:\\");
	}

	public static void printFilesSimple(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			System.out.println(file.getName());
		}
	}

	public static void printFilesDetails(String path) throws Exception {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			System.out.print(file.getName());
			BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
			
			printSpacesToMargin(file.getName(), 30);
			
			if (attr.isDirectory()) {
				System.out.print("DIR");
				printSpacesToMargin("DIR", 15);
			} else {
				System.out.print(attr.size());
				printSpacesToMargin(String.valueOf(attr.size()), 15);
			}
			
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd mm:ss");
			System.out.println(df.format(attr.creationTime().toMillis()));

		}

	}
	
	private static void printSpacesToMargin(String previousString, int spacesCount) {
		int spacesLeftToPrint = spacesCount - previousString.length();
		for (int i = 0; i<spacesLeftToPrint; i++) {
			System.out.print(" ");
		}
	}

	public static void printFiles(String path, String extensionFilter) {
		// to be implemented
	}

	public static void printTree(String path) {
		// to be implemented
		// Example
		// dirname
		// dirname/file1
		// dirname/file2
		// dirname/dirname1
		// dirname/dirname1/file1
		// dirname/dirname1/file2
		// dirname/dirname2/file1
	}

}
