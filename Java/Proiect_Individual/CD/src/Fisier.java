import java.io.*;

public class Fisier {
	public String[] array = new String[100];
	public int length;
	public void CitireFisier(String filename) {
		String line;
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(filename));
			int count=0;
		while((line = buffer.readLine()) !=null ) {
			array[count++]=line;
		}
		length=count;
		buffer.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void ScriereFisier(String filename) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(filename));
			for(int i=0;i<100;i++) {
				if(array[i] != null) pw.println(array[i]);
			}
		pw.close();
	}catch(Exception e) {
		System.out.println(e);
	}
	}
}