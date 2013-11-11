import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;


public class threadd extends Thread{
	private static final Logger LOG = Logger.getLogger(lab1.class);
	public void run(){
		try {
			long t_max=0;
			long aux;
			String scan;
		    FileReader file = new FileReader("ips.txt");
		    BufferedReader br = new BufferedReader(file);
		    Set<String> ips=new HashSet<String>();
		    while((scan = br.readLine()) != null)
		                {
	        			ips.add(scan.substring(0, scan.indexOf(",")));
	        			aux=Long.parseLong(scan.substring(scan.indexOf(",")+2));
	        			if(t_max<aux)
	        				t_max=aux;
		                }
		    br.close();
		    file = new FileReader("macs.txt");
		    br = new BufferedReader(file);
		    Set<String> macs=new HashSet<String>();
		    
		    while((scan = br.readLine()) != null)
		                {
	        			macs.add(scan.substring(0, scan.indexOf(",")));
	        			aux=Long.parseLong(scan.substring(scan.indexOf(",")+2));
	        			if(t_max<aux)
	        				t_max=aux;
		                }
		    br.close();
			PrintWriter writer = new PrintWriter("rezultate.txt");
			writer.print("Ip-uri distincte: ");
			writer.println(ips.size());
			writer.print("Mac-uri distincte: ");
			writer.println(macs.size());
			writer.print("Timp maxim: ");
			writer.println(t_max);
			writer.close();
		} catch (IOException e) {
			LOG.error("I/O exception",e);
		}
	}
}