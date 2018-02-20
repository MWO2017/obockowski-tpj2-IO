package zadanie1;

import java.util.Scanner;
// in case of multithreading it would be enum 
class ScannerSingleton {

	private static ScannerSingleton instance;
	private Scanner scanner;

	private ScannerSingleton() {
		scanner = new Scanner(System.in);
	}

	protected static ScannerSingleton get() {
		if (instance == null) {
			instance = new ScannerSingleton();
			return instance;
		} else {
			return instance;
		}
	}

	protected Scanner getScanner() {
		return scanner;
	}

	protected void closeScanner() {
		scanner.close();
	}
}
