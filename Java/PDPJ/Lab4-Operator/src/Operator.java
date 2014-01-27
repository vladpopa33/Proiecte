import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

//import server.ServerOperator;



public class Operator {

	/**
	 * @param args
	 */
	private static final Logger LOG = Logger.getLogger(Operator.class);
	public static void main(String[] args) {
		BasicConfigurator.configure();
		// TODO Auto-generated method stub
		LOG.info("Operator Started! at port"+4567);
		try {
			Socket socket=new Socket("127.0.0.1 ",4568);
			PrintStream sout=new PrintStream(socket.getOutputStream());
			//BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
			/*out.write("Grecia");
			out.write(800);
			out.write("avion");*/
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
			System.out.println("Dati tara:");
			String tara=br.readLine();
			System.out.println("Dati pretul:");
			String pret=br.readLine();
			System.out.println("Dati metoda de transport:");
			String transport=br.readLine();
			sout.println(tara);
			sout.println(pret);
			sout.println(transport);
			LOG.info(((String)in.readObject()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error(e);
		}
		
	}

}
