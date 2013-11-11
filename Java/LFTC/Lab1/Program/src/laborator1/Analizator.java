package laborator1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Vlad
 * 
 */

public class Analizator {

	private List<String> keywords, operators, separators, constants, identifiers, types;

	public Analizator() {
		types = new ArrayList<String>();
		keywords = new ArrayList<String>();
		operators = new ArrayList<String>();
		separators = new ArrayList<String>();
		constants = new ArrayList<String>();
		identifiers = new ArrayList<String>();

		readTypes();
		readKeywords();
		readOperators();
		readSeparators();
		readConstants();
	}

	private void readTypes (){
		types.add("BOOL");
		types.add("CHAR");
		types.add("INT");
		types.add("DOUBLE");
		types.add("ARRAY");

	}
	
	private void readKeywords() {
		keywords.add("DECLARATION");
		keywords.add("END_DECLARATION");
		keywords.add("START_CODE");
		keywords.add("END_CODE");
		keywords.add("BOOL");
		keywords.add("CHAR");
		keywords.add("INT");
		keywords.add("DOUBLE");
		keywords.add("ARRAY");
		keywords.add("READ");
		keywords.add("WRITE");
		keywords.add("IF");
		keywords.add("ELSE");
		keywords.add("END_IF");
		keywords.add("WHILE");
		keywords.add("DO");
		keywords.add("END_WHILE");
		keywords.add("FOR");
		keywords.add("END_FOR");
		
	}

	private void readOperators() {
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		operators.add("<");
		operators.add(">");
		operators.add("=");
		operators.add("<=");
		operators.add(">=");
		operators.add("==");
		operators.add("!=");
	}

	private void readSeparators() {
		separators.add("[");
		separators.add("]");
		separators.add("(");
		separators.add(")");
		separators.add(";");
		separators.add(" ");
	}

	private void readConstants() {
		constants.add("0");
		constants.add("1");
		constants.add("2");
		constants.add("3");
		constants.add("4");
		constants.add("5");
		constants.add("6");
		constants.add("7");
		constants.add("8");
		constants.add("9");
		constants.add("3.14");
	}

	private boolean exists(String symbol, List<String> list) {
		for (String newSymbol : list) {
			if (newSymbol.compareTo(symbol) == 0)
				return true;
		}
		return false;
	}

	private boolean isKeywords(String symbol) {
		return exists(symbol, keywords);
	}

	private boolean isOperators(String symbol) {
		return exists(symbol, operators);
	}

	private boolean isSeparators(String symbol) {
		return exists(symbol, separators);
	}

	private boolean isConstants(String symbol) {
		return exists(symbol, constants);
	}

	private boolean testValidityOfIdentifier(String symbol){
		int i;
		for (i=0; i<symbol.length();i++){
			if(!Character.isLetterOrDigit(symbol.charAt(i))){
				return false;
				}
			}
		i=0;
		if(Character.isDigit((symbol.charAt(0)))){
			for (i=1; i<symbol.length();i++){
				if(!Character.isDigit((symbol.charAt(i)))){
					return false;
				}
			}
		}
		return true;
	}
	public void generateTS(String filename, TS TSConstants, TS TSIdentifiers) {
		BufferedReader bufferedReader;
		String line;
		
		try {
			bufferedReader = new BufferedReader(new FileReader(filename));

			while ((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(" ");

				for (int i = 0; i < words.length; i++) {
					if(types.contains(words[i])){
						if (words[i+1].length() < 250) {
							if(testValidityOfIdentifier(words[i+1])){
								identifiers.add(words[i+1]);
								TSIdentifiers.searchInsert(words[i+1]);
								//i++;
							}
							else{
								System.err.println("Eroare lexicala! Numele identificatorului: " + words[i+1]
										+ " nu respecta regula ");
							}
						} else
							System.err.println("Eroare lexicala! Dimensiunea identificatorului: " + words[i]
								+ " depaseste 250 caractere ");
					}
					else if (isConstants(words[i])) {
						TSConstants.searchInsert(words[i]);
					}
				}
			}

			bufferedReader.close();
			File f = new File("TS-identifiers.txt");
			f.delete();
			try {
				f.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			File g = new File("TS-constants.txt");
			g.delete();
			try {
				g.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			TSIdentifiers.print("TS-identifiers.txt");
			TSConstants.print("TS-constants.txt");
		} catch (IOException e) {
			System.err.println("Eroare deschidere fisier " + filename + " " + e);
			e.printStackTrace();
		}

	}

	private void verify(String fileNAme) {
		
		int nrLine = 0;
		String line = "";
		String lastLine = "";

		int nrWhile = 0, nrExecute = 0, nrEndWhile = 0, nrIf = 0, nrElse = 0, nrEndIf = 0;

		BufferedReader bufferedReader;

		try {
			bufferedReader = new BufferedReader(new FileReader(fileNAme));

			while ((line = bufferedReader.readLine()) != null) {
				nrLine++;

				if (!line.equals("DECLARATION") && nrLine == 1)
					System.out.println("Eroare lexicala: programul nu incepe corespunzator");
				String[] words = line.split(" ");

				for (int i = 0; i < words.length; i++) {
					if (isKeywords(words[i]) || isOperators(words[i]) || isSeparators(words[i])) {
						
						if (words[i].equals("WHILE"))
							nrWhile++;
						if (words[i].equals("DO"))
							nrExecute++;
						if (words[i].equals("END_WHILE"))
							nrEndWhile++;

						if (words[i].trim().equals("IF")) {
							nrIf++;
						}
						if (words[i].trim().equals("ELSE")) {
							nrElse++;
						}
						if (words[i].trim().equals("END_IF")) {
							nrEndIf++;
						}
					}
				}
				lastLine = line;

			}
			if (nrWhile != nrEndWhile)
				System.out.println("Eroare lexicala la while - lipsa endwhile");
			if (nrIf != nrEndIf)
				System.out.println("Eroare lexicala la if - lipsa endif");
			if (!lastLine.equals("END_CODE"))
				System.out.println("Programul nu se termina corespunzator: cu END_CODE");

			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("Eroare deschidere fisier!" + e);
			e.printStackTrace();
		}
	}

	public void generateFIP(String filename, FIP fip, TS TSConstants, TS TSIdentifiers) {
		BufferedReader bufferedReader;
		String line = "";
		int nrLine = 0;

		verify(filename);

		try {
			bufferedReader = new BufferedReader(new FileReader(filename));

			while ((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(" ");
				nrLine++;

				for (int i = 0; i < words.length; i++) {
					if (isKeywords(words[i]) || isOperators(words[i]) || isSeparators(words[i]))
						fip.generateFIP(words[i], "", -1);
					else if (isConstants(words[i])) {
						fip.generateFIP(words[i], "c", TSConstants.searchInsert(words[i]) + 1);
					} else if (identifiers.contains(words[i])) {
						fip.generateFIP(words[i], "i", TSIdentifiers.searchInsert(words[i]) + 1);
					/*}else if(words[i].matches("[0-9]+.[a-z]+")){
						System.out.println("Eroare lexicala: " + words[i] + " la linia " + nrLine);*/
					} else if(testValidityOfIdentifier(words[i])){
						System.out.print("");
					}
					else
						System.out.println("Eroare lexicala: " + words[i] + " la linia " + nrLine);
		
				}
				fip.printFIP("FIP.txt");
			}

			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("Eroare deschidere fisier! " + e);
			e.printStackTrace();
		}

	}
}
//comis voiajor 2