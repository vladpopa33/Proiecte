import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class threaddaemon extends Thread{
	private int n;
	private ArrayList<threadn> thrds;
	private int linii[];
	public threaddaemon(int nr){
			n=nr;
			ArrayList<threadn> thrds=new ArrayList<threadn>();
			int linii[] = new int[10];
	}
	public void run(){
		int i;
		PrintWriter writer;
		try {
			writer = new PrintWriter("rezultate.txt");
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(i=0;i<n;i++) {
			threadn t = new threadn(this,i);
			thrds.add(t);
			t.start();
			
		}
		for(i=0;i<n;i++)
			try {
				thrds.get(i).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	public synchronized void print(String s, threadn th){
		System.out.println(s);
		PrintWriter out;
		int ind=thrds.indexOf(th);
		if(ind!=-1)
			linii[ind]++;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("rezultate.txt", true)));
			out.println(s);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void sfarsit(){
		for(int i=0;i<thrds.size();i++)
			System.out.println("Thread-ul "+thrds.get(i).toString()+" ");
	}

}

