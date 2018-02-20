package cwiczenie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {

	public static void main(String args[]) throws Exception {
/*		String keyword = "but";
		out.println("===>scanFile<===");
		scanFile("res/cwiczenie1/poem.txt", keyword);
		out.println("===>readFile<===");
		readFile("res/cwiczenie1/poem.txt", "but", "and", "http");
		out.println("===>readChars<===");
		//readChars("res/cwiczenie1/poem.txt");
*/		readChars("../res/cwiczenie1/poem.txt");
	}

	private static void scanFile(String filename, String keyword) throws Exception {
		File poemFile = new File(filename);
		Scanner scanner = new Scanner(poemFile);
		int tokens = 0;
		while (scanner.hasNext()) {
			if (scanner.next().equals(keyword)) {
				System.out.println(keyword);
				tokens++;
			}
		}
		scanner.close();
		String path = poemFile.getAbsolutePath();
		long freeSpace = poemFile.getFreeSpace();
		String summary = String.format(
				"Source:\nhttp://www.familyfriendpoems.com/poem/dale\n-------------------------------------\nFound tokens: %d\nFile path: %s\nFree space:\n%d Bytes\n\n",
				tokens, path, freeSpace);
		System.out.print(summary);
	}

	private static void readFile(String file, String... keywords) {
		try (BufferedReader br = Files.newBufferedReader(new File(file).toPath())) {
			String line;
			int counter = 0;
			boolean contains = false;
			while ((line = br.readLine()) != null) {
				for (String k : keywords) {
					if (line.contains(k)) {
						contains = true;
						break;
					}
				}
				if (contains) {
					System.out.println(counter + ". " + line);
				}
				counter++;
				contains = false;
			}
			System.out.println("All lines: " + counter);
		} catch (IOException e) {
			System.err.format("IOException: %s", e);
			e.printStackTrace();
		}
	}

	private static void readChars(String filename) {
		try (BufferedReader bf = Files.newBufferedReader(new File(filename).toPath())) {
			int c;
			int characters = 0;
			int newlines = 0;
			while ((c = bf.read()) != -1) {
				if (c == 0x0a) {
					newlines++;
				} else {
					characters++;
				}
				char cc = (char) c;
				System.out.print((char) c);
			}
			System.out.println();
			out.println("Characters:\t" + characters);
			out.println("Newlines:\t" + newlines);
		} catch (IOException e) {
			System.err.format("IOException: %s", e);
			e.printStackTrace();
		}
	}

	private static void readChars2(String fileName) {
		int ch = 0;
		File poemFile = new File(fileName);
		int character;
		try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
			while (((character = reader.read()) != -1)) {
				if (character != ' ' && character != '\n') {
//				if (character != ' ' && character != 0x0a && character !=0x20 && character !=0x0d  ) {
					System.out.print((char) character);
					ch += 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Count: " + ch);
	}
}
