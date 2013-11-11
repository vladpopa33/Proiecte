package domain;
import interfaces.*;
import repository.*;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Produse l=new Produse();
		 Fisier f=new Fisier();
		 l=f.CitesteFisier("Stoc.txt");
		 //System.out.print(l.get_nume(0));
		 Meniu m=new Meniu(l);
		 m.setSize(300,45*l.length());
         m.setLocation(300,100);
         m.setVisible(true);
	}	
	}
