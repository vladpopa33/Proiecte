package domain;
import repository.Fisier;
import repository.Serialize;


public class Lab {
	public static void main(String [] args){
		Lista<String> list=new Lista<String>(String.class);
		Lista<String> list1=new Lista<String>(String.class);
		Serialize<String> s=new Serialize<String>();
		//Fisier f=new Fisier();
		list.add("Luni");
		list.add("123");
		list.add("-");
		list.add("EU");
		s.printSerializabil(list, "serial.txt");
		list1=s.citesteSerializabil("serial.txt");
		Fisier.ScriereFisier(list1, "fisier.txt");
		list=Fisier.CitesteFisier("fisier.txt");
		//list.delete(0);
		//IIterator <String> i = new Iterator<String>(list);
		//i=Iterator(list);
		System.out.println("Elementele listei sunt: ");
		int i=0,k;
		k=list.get_prim();
		while(i<list1.size()){
			System.out.print(list1.element(k));
			k=list1.get_urm(k);
			if(k==list1.size())
				System.out.print(" . ");
			else
				System.out.print(" , ");
			i++;
		}
		//System.out.println(i.val()+" ");
		Fisier.ScriereFisier(list, "fisier.txt");
		System.out.println("\nProgram terminat.");
	}
}
