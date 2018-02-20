package zadanie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.System.out;

public class Skynet {

	private String login = "Reese";
	private String password = "#Terminate";
	private Scanner scanner = ScannerSingleton.get().getScanner();

	public static void main(String args[]) {
		Skynet skynet = new Skynet();
		skynet.run();
	}

	public void run() {
		readCredentials();
		printSkyNetLogo();
		runLoginPanel();
	}

	private void runLoginPanel() {
		String readLogin;
		String readPassword;
		boolean credentialsOK;
		do {
			readLogin = getTextFromInput("Login");
			readPassword = getTextFromInput("Password");
			credentialsOK = verifyCredentials(readLogin, readPassword);
			if (!credentialsOK) {
				System.out.println("Wrong login or password. Try again.");
			}
		} while (!credentialsOK);
		System.out.println();
		System.out.println("Welcome to SKYNET...");
	}

	private String getTextFromInput(String label) {
		String text = "";
		try {
			out.println(label);
			text = scanner.nextLine();
		} catch (NoSuchElementException | IllegalStateException e) {
			System.err.format("exception: %s", e);
		}
		return text;
	}

	private boolean verifyCredentials(String login, String password) {
		return this.login.equals(login) && this.password.equals(password);
	}

	private void readCredentials() {
		// strange... reads credentials? for what? if later login. Maybe it should be a config file?
		// read credentials from the file "res/zadanie1/skynet.conf"
		// print "INFO System reconfigured..." if correctly read
		// print "INFO No valid conf data" if could not read credentials
		File file=new File("res/zadanie1/skynet.conf");
		
		if (file.exists()) {
			try (BufferedReader bf = Files.newBufferedReader(file.toPath())) {
				out.println("INFO System reconfigured...");
			} catch (SecurityException | IOException e) {
				System.err.format("exception: %s", e);
			} 
		}
		else {
			out.println("INFO No valid conf data");
		}
	}

	private void printSkyNetLogo() {
		// print logo from file "res/zadanie1/logo.txt"
		String path = "res/zadanie1/logo.txt";
		try (BufferedReader bf = Files.newBufferedReader(Paths.get(path))) {
			String line = "";
			while ((line = bf.readLine()) != null) {
				out.println(line);
			}
		} catch (IOException e) {
			System.err.format("IOException: %s", e);
			e.printStackTrace();
		}
	}
}
