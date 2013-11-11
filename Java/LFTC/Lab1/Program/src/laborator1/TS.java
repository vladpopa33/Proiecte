package laborator1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * 
 * @author Vlad
 * 
 */

public class TS {

	private HashMap<Integer, String> ts = new HashMap<>();

	
	public void insert(String symbol) {
		ts.put(symbol.hashCode(), symbol);
	}

	/**
	 * Verifica daca exista un simbol in TS
	 */
	private boolean existsSymbol(String symbol) {
		return ts.containsKey(symbol.hashCode());
	}

	/** 
	 * Cauta in TS simbolul. Daca nu exista il adauga in TS, altfel nu.
	 */
	public int searchInsert(String symbol) {
		boolean exists = existsSymbol(symbol);
		if (!exists) {
			insert(symbol);
		}
		return symbol.hashCode();
	}

	public void print(String fileName) {
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(new FileWriter(fileName, true));
			
			for (String symbol : ts.values()) {
				printWriter.println(symbol + "\t\t" + symbol.hashCode());
			}

			printWriter.close();
		} catch (IOException e) {
			System.out.println("Eroare scriere in fisier " + fileName + " " + e);
			e.printStackTrace();
		}
	}

}
