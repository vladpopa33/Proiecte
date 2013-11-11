package repository;

import java.io.*;

import domain.Lista;
public class Fisier {
	public static Lista<String> CitesteFisier(String nume){
		BufferedReader br = null;
		Lista<String> l = new Lista<String>(String.class);
		try{
			String line;
			br = new BufferedReader(new FileReader(nume));
			while((line=br.readLine())!=null){
				//array = line.split("@");
					l.add(line);
			
			}
			br.close();
		}
		catch (Exception e) {
			System.err.println("Eroare citire "+e);
		}
		return l;
	}
	
	public static void ScriereFisier(Lista<String> l ,String nume){
		PrintWriter pw=null;
		try{
			pw=new PrintWriter(nume);
			//pw.print(l);
			int i=0,k;
			k=l.get_prim();
			while(i<l.size()){
				pw.print(l.element(k)+"\n");
				k=l.get_urm(k);
				i++;
			}
		} catch (FileNotFoundException e) {
		System.err.println("Eroare scriere PW "+e);
		}finally {
		if (pw!=null)
		pw.close();
		}
	}
}
