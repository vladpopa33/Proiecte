package laborator1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 
 * @author Vlad
 * 
 */

public class FIP {

	private Atom atomi;
	private ArrayList<Integer> attribute;
	private ArrayList<Integer> value;

	public FIP() {
		atomi = new Atom();
		attribute = new ArrayList<Integer>();
		value = new ArrayList<Integer>();
	}

	public void generateFIP(String word, String type, int pos) {
		attribute.add(atomi.getCode(word, type));
		value.add(pos);
	}

	public void printFIP(String filename) {
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(filename);
			for (int i = 0; i < attribute.size(); i++) {
				if(value.get(i)==-1)
					printWriter.println(attribute.get(i) + "\t\t" +(value.get(i)));
				else
					printWriter.println(attribute.get(i) + "\t\t" +(value.get(i)-1));
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
