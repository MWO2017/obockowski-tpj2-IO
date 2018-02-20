package zadanie1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Skynet {
	
	private String login = "Reese";
	private String password = "#Terminate";
	Scanner scanner = new Scanner(System.in);
		
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
		do {
			readLogin = getTextFromInput("Login");
			readPassword = getTextFromInput("Password");
		} while (!verifyCredentials(readLogin, readPassword));
		System.out.println();
		System.out.println("Welcome to SKYNET");
		scanner.close();
	}
	
	private String getTextFromInput(String label) {
		System.out.print(label + ": ");
		return scanner.nextLine();
	}
	
	private boolean verifyCredentials(String login, String password) {
		return this.login.equals(login) && this.password.equals(password);
	}
	
	private void readCredentials() {
		File conf = new File("bin/zadanie1/skynet.conf");
		try (Scanner scanner = new Scanner(conf)) {
			String tempLogin = scanner.nextLine();
			String tempPassword = scanner.nextLine();
			login = tempLogin;
			password = tempPassword;
			System.out.println("INFO System reconfigured...");
		} catch (Exception ex) {
			System.out.println("INFO No valid conf data");
		}
	}
	
	private void printSkyNetLogo() {
		String logo = "";
		File logoFile = new File("bin/zadanie1/logo.txt");
		try {
			logo = new String(Files.readAllBytes(Paths.get(logoFile.toURI())));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(logo);
		
	}
}
