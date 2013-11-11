package repository;
import java.io.*;
import domain.*;
public class Fisier {
	public static Produse CitesteFisier(String nume){
		BufferedReader br = null;
		Produse list = new Produse();
		try{
			String line;
			String[] array;
			br = new BufferedReader(new FileReader(nume));
			 
			while((line=br.readLine())!=null){
				//System.out.print("mata");
				array = line.split("@");
				//System.out.print(array[0]+array[1]);
				Produs p=new Produs();
				p.set_nume(array[0]);
				p.set_cant(Integer.parseInt(array[1]));
				list.add(p);
				
				
				
			}
			
			
			br.close();
		}
		catch (Exception e) {
			System.err.println("Eroare citire "+e);
		}
		return list;
	}
	
	public static void ScriereFisier(Produse l ,String nume){
		PrintWriter pw=null;
		try{
			pw=new PrintWriter(nume);
			//pw.print(l);
			int i;
			//k=p.get_prim();
			for(i=0;i<l.length();i++)
				pw.print(l.get_nume(i)+" "+l.get_cantitate(i)+"\n");
			
			
		} catch (FileNotFoundException e) {
		System.err.println("Eroare scriere PW "+e);
		}finally {
		if (pw!=null)
		pw.close();
		}
	}
}
