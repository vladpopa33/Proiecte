import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import org.apache.log4j.Logger;


public class threadc extends Thread{
	private static final Logger LOG = Logger.getLogger(lab1.class);
	private String line;
	public threadc(String l){
		this.line=l;
		
		
	}
	public void run(){
		try {
			//LOG.debug("threadc");
			if(this.line.indexOf("HWaddr")>-1){
			    String l=this.line.substring(this.line.indexOf("HWaddr")+7,this.line.indexOf("HWaddr")+24);
			    //String ip=l.substring(0,l.indexOf(" "));
	 			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("macs.txt", true)));
	 		    out.print(l+", ");
	 			long unixTime = System.currentTimeMillis() / 1000L;
	 			out.println(unixTime);
	 		    out.close();
 		   	
	 
		}
		} catch (IOException e) {
			LOG.error("I/O exception",e);
		
		}
	}
}
