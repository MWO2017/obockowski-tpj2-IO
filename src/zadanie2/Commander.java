package zadanie2;

import static java.lang.System.out;

import java.io.File;
import java.util.Scanner;

public class Commander {

	Scanner scanner;
	String path;

	public Commander() {
		//skladowa glownego obiektu
		scanner = new Scanner(System.in);
	}

	public static void main(String args[]) {
		Commander commander = new Commander();
		while (!commander.pickUpPath()) {
			out.println("wrong file or directory, try again.");
		}

		commander.selectOperation();
		// String extension = commander.getExtension();
		// commander.listByExtension(extension);
	}

	protected void listSimple(String path) {
		//wykorzystany package
		cwiczenie4.Main.printFilesSimple(path);
	}

	protected void listExtended(String path) {
		//wykorzystany package
		cwiczenie4.Main.printFilesDetails(path);
	}

	protected void listByExtension(String path) {
		//wykorzystany package
		String extension=getExtension();
		cwiczenie4.Main.printFiles(path, extension);
	}

	//metoda pomocnicza dla listByExtension
	protected String getExtension() {
		String extension = "";
		out.println("give extension");
		extension = this.scanner.next();
		return extension;
	}

	protected void listTree(String path) {
		//wykorzystany package
		cwiczenie4.Main.printTree(path);
	}

	//metoda do validation, zeby nie trafiac na exceptions
	protected boolean pickUpPath() {
		out.println("please give a proper path: ");
		String candidate = this.scanner.nextLine();
		File fileOrDictionary = new File(candidate);
		if (fileOrDictionary.exists()) {
			this.path = candidate;
			return true;
		} else {
			return false;
		}

	}

	protected int selectOperation() {
		String question = String.format("Pick up operation:\n%-10d%-30s\n%-10d%-30s\n%-10d%-30s\n%-10d%-30s\n", 1,
				"simple list", 2, "extended list", 3, "list by extension", 4, "tree");
		out.println(question);
		// mozna by dac enumy i na return tez - w celu rozbudowy
		int operation = 0;

		while (operation == 0) {
			while (!scanner.hasNextInt()) {
				out.print("please give a proper integer value");
				scanner.nextLine();
			}

			operation = this.scanner.nextInt();
			out.println("An answer is: " + operation);

			switch (operation) {
			case 1:
				operation = 1;
				listSimple(this.path);
				break;
			case 2:
				operation = 2;
				listExtended(this.path);
				break;
			case 3:
				operation = 3;
				listByExtension(this.path);
				break;
			case 4:
				operation = 4;
				listTree(this.path);
				break;
			default:
				break;
			}
		}
		return operation;
	}
}
