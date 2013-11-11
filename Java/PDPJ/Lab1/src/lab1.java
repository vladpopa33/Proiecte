import java.io.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
public class lab1 {

	private static final Logger LOG = Logger.getLogger(lab1.class);
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		BasicConfigurator.configure();
		try {
			Runtime runtime=Runtime.getRuntime();
			String cmd="./comanda";
			Process proc=runtime.exec(cmd);
			reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line=null;
			PrintWriter writer = new PrintWriter("ips.txt");
			writer.print("");
			writer.close();
			writer = new PrintWriter("macs.txt");
			writer.print("");
			writer.close();
			while((line=reader.readLine())!=null){
				LOG.debug(line);
				threadb b=new threadb(line);
				threadc c=new threadc(line);
				b.start();
				c.start();
				try {
					b.join();
					c.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					LOG.error("Thread exception", e);
				}
	
				(new threadd()).start();
				
			    
			}
		} catch(IOException e) {
			LOG.error("I/O exception",e);
		} finally {
			reader.close();
		}
	}

}

