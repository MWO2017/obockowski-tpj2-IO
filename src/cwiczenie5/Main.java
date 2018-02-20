package cwiczenie5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String args[]) throws Exception {

		// CWICZENIE WSTEPNE
		// zapis
		try {
			String s1 = "dupa jasia";
			FileOutputStream fop = new FileOutputStream("./res/string.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fop);
			oos.writeObject(s1);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// odczyt
		try {
			FileInputStream fis = new FileInputStream("./res/string.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			String readed = (String) (ois.readObject());
			System.out.println("READED IS: " + readed);
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * Bureau bureau = initBureau(); printBureau(bureau); saveBureau(bureau,
		 * "mi6.ser"); Bureau loadedBureau = loadBureau("mi6.ser");
		 * printBureau(loadedBureau);
		 */
		Bureau bureau = initBureau();
		printBureau(bureau);
		saveBureau(bureau, "./res/mi6.ser");
		bureau = null;
		bureau = loadBureau("./res/mi6.ser");
		printBureau(bureau);

	}

	private static void saveBureau(Bureau bureau, String filename) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(bureau);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Bureau loadBureau(String filename) {
		Bureau bureau = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
			bureau = (Bureau) (ois.readObject());
			ois.close();
		} catch (ClassNotFoundException e) {
			System.out.println("no class");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bureau;
	}

	private static Bureau initBureau() {
		Bureau bureau = new Bureau("MI6");
		Agent agent007 = new Agent("James", "Bond", 35, "007");
		bureau.addAgent(agent007);

		Task task = new Task("darkMamba", "infiltrate, spy, destroy");
		agent007.addTask(task);

		return bureau;
	}

	private static void printBureau(Bureau bureau) {
		System.out.println(bureau.getName());
	}

}
