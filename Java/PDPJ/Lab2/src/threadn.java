import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class threadn extends Thread{
	private int i;
	private threaddaemon dm;
	public threadn(threaddaemon d,int nr){
			i=nr;
			dm=d;
	}
	public void run(){
		//for(int i=0;i<n;i++)
		String fisier="date";
		fisier=fisier.concat(Integer.toString(i)+".txt");
		//System.out.println(fisier);
		String scan;
	    try {
			FileReader file = new FileReader(fisier);
		    BufferedReader br = new BufferedReader(file);
		  	while((scan = br.readLine()) != null)
			            {
		  				scan=scan+"   ==> thread"+Integer.toString(i);
						dm.print(scan,this);
			            }
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
			
	}

}