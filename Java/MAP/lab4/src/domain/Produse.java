package domain;
import java.util.ArrayList;
import java.util.List;

//import repository.*;

public class Produse{
	int maxlength=5;
	
	//Produs[] l=new Produs[maxlength];
	List<Produs> l=new ArrayList<Produs>();
	public Produse(){
		//Fisier f=new Fisier();
		//CitesteFisier("Produse.txt");
	}
	public int length(){
		return l.size();
	}
	public String get_nume(int i){
		return l.get(i).get_nume();
	}
	public int get_cantitate(int i){
		return l.get(i).get_cant();
	}
	public void add(Produs p){
		l.add(p);
	}
	public void buy(Produs p,int i){
		int j;
		for(j=0;j<l.size();j++)
			if(p.get_nume()==l.get(j).get_nume()){
				l.get(j).set_cant(l.get(j).get_cant()-i);
				if(l.get(j).get_cant()==0);
					l.remove(j);
			}
		
	}
}