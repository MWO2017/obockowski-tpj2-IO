package cwiczenie2;

import java.util.Scanner;
import static java.lang.System.out;

public class Main {

	public static void main(String args[]) {

		try (Scanner scanner = new Scanner(System.in)) {
			String input="";
			while (! (input.equals("exit"))) {
				out.println("podaj tekst");
				input=scanner.nextLine();
				out.println(input);
			} 
		} 		
	}

}
