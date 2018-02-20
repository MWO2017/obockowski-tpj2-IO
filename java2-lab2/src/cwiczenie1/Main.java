package cwiczenie1;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		File poemFile = new File("poem.txt");
		Scanner scanner = new Scanner(poemFile);
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		scanner.close();
	}

}
