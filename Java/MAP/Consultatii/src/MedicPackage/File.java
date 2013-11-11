package MedicPackage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class File {
	public List<String[]> ReadFromFile(String name){
		List<String[]> l = new ArrayList<String[]>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(name));
		    String strLine;
		    while ((strLine=br.readLine()) != null){		    	
		    	String[] n;
	    		n=strLine.split(" ");
		    	l.add(n);
		    }
		    try{
		    	br.close();
		    } catch (IOException e){
		    	System.err.println("Fisierul nu poate fi inchis!");
		    	e.printStackTrace();
		    }
		    
		} catch (FileNotFoundException e) {
			System.err.println("Fisierul nu a fost gasit!");
			System.err.println("Exceptie: " + e.getMessage());
		} catch (IOException e){
			System.err.println("Eroare la citirea din fisier!");
			e.printStackTrace();
		}
		return l;
	}
	
	public void WriteToFile(Vector l,String name){
		try{
			PrintWriter pw = new PrintWriter(new FileWriter(name));
			for(int i=0;i<l.getNo();i++)
				pw.println(l.getElem(i));
			pw.close();
		}catch(Exception e){}
	}
}
