package laborator1;

/**
 * 
 * @author Vlad
 * 
 */

public class StartApp {

	private static Analizator analizator;
	private static TS TSConstants;
	private static TS TSIdentifiers;

	public static void main(String[] args) {
		analizator = new Analizator();

		TSConstants = new TS();
		TSIdentifiers = new TS();

		FIP fip = new FIP();

		analizator.generateTS(args[0], TSConstants, TSIdentifiers);
		analizator.generateFIP(args[0], fip, TSConstants, TSIdentifiers);
	}

}
