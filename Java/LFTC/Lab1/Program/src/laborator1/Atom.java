package laborator1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Vlad
 * 
 */

public class Atom {

	private static List<String> atomi;
	private String fileName = "tabela_atomi.txt";

	Atom() {
		atomi = new ArrayList<String>();
		readFromFile();
	}

	private void readFromFile() {
		BufferedReader bufferedReader;
		String line;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			while ((line = bufferedReader.readLine()) != null) {
				atomi.add(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("Eroare deschidere fisier " + fileName + " " + e);
			e.printStackTrace();
		}
	}

	public static List<String> getAtomi() {
		return atomi;
	}

	public int getCode(String word, String type) {
		for (int i = 0; i < atomi.size(); i++) {
			if (atomi.get(i).compareTo(word) == 0)
				return i + 1;
		}
		if (type.equals("c"))
			return -2;
		else if (type.equals("i"))
			return 0;
		return -56;

	}

}
