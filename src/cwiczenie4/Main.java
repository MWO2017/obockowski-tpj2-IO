package cwiczenie4;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.Path;
import java.text.Format;

import static java.lang.System.out;

public class Main {

	public static void main(String args[]) throws Exception {
		/*
		 * printFilesSimple("/home/obockows/"); printFilesDetails("/home/obockows/");
		 * printFiles("/home/obockows/", ".txt");
		 */ printTree("/home/obockows/TESTY/");

	}

	public static void printFilesSimple(String path) {
		try {
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
			out.println(listOfFiles.length);
			for (File file : listOfFiles) {
				out.println(file.getName());
			}

		} catch (NullPointerException e) {
			System.err.format("NullPointerException: %s", e);
			e.printStackTrace();
		}

	}

	public static void printFilesDetails(String path) {
		try {
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
			String text1 = String.format("%-30s%-15s%-15%s\n", "name", "dir or size", "creation time");
			out.println(text1);
			for (File file : listOfFiles) {
				BasicFileAttributes attribute = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
				String name = file.getName();
				String dirOrsize;
				String t = attribute.creationTime().toString();
				if (attribute.isDirectory()) {
					dirOrsize = "DIR";
				} else {
					Long l = attribute.size();
					dirOrsize = l.toString();
				}
				String text2 = String.format("%-30s%-15s%-15s", name, dirOrsize, t);
				out.println(text2);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	public static void printFiles(String path, String extensionFilter) {
		try {
			File folder = new File(path);
			// stworzenie filtra
			FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File directory, String fileName) {
					return fileName.endsWith(extensionFilter);
				}
			};
			File[] listOfFiles = folder.listFiles(filter);
			String text1 = String.format("%-30s%-15s%-15s\n", "name", "dir or size", "creation time");
			out.println(text1);
			for (File file : listOfFiles) {
				BasicFileAttributes attribute = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
				String name = file.getName();
				String dirOrsize;
				String t = attribute.creationTime().toString();
				if (attribute.isDirectory()) {
					dirOrsize = "DIR";
				} else {
					Long l = attribute.size();
					dirOrsize = l.toString();
				}
				String text2 = String.format("%-30s%-15s%-15s", name, dirOrsize, t);
				out.println(text2);
			}
		} catch (NullPointerException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void printTree(String path) {
		// normalnie mozna zrobic listing i warunek File.isDirectory() ale to dla
		// cwiczenia on-fly implemenatacji interfejsu
		try {
			Files.walkFileTree((new File(path)).toPath(),
					new HashSet<FileVisitOption>(Arrays.asList(FileVisitOption.FOLLOW_LINKS)), Integer.MAX_VALUE,
					new FileVisitor<Path>() {
						public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
							out.println(dir);
							return FileVisitResult.CONTINUE;
						}

						public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
							return FileVisitResult.CONTINUE;
						}

						public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
							if (file.toFile().isDirectory()) {
								out.println("DIRECTORY: " + file + "\n");
							}
							return FileVisitResult.CONTINUE;
						}

						public FileVisitResult visitFileFailed(Path file, IOException exc) {
							out.println("FAILED: no access!");
							return FileVisitResult.CONTINUE;
						}
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
