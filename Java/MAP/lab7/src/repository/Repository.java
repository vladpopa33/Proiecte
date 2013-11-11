package repository;

//import CDList;

import java.util.*;
import model.CD;

public class Repository implements IRepository{
	private List<CD> l;

	/* (non-Javadoc)
	 * @see repository.IRepository#Read()
	 */
	/* (non-Javadoc)
	 * @see repository.IRepository#Read()
	 */
	//@Override

	@Override
	public void Read() {
	
	}

	/* (non-Javadoc)
	 * @see repository.IRepository#Save(java.util.List)
	 */
	/* (non-Javadoc)
	 * @see repository.IRepository#Save(java.util.List)
	 */
	//@Override
	@Override
	public void Save(List<CD> l) {
		this.l = l;
	}

	/* (non-Javadoc)
	 * @see repository.IRepository#Add(model.Ciocolata)
	 */
	/* (non-Javadoc)
	 * @see repository.IRepository#Add(model.CD)
	 */
	//@Override
	@Override
	public void Add(CD p) {
		l.add(p);
	}
	
	/* (non-Javadoc)
	 * @see repository.IRepository#GetPlanta(int)
	 */
	/* (non-Javadoc)
	 * @see repository.IRepository#GetCioco(int)
	 */
	//@Override
	@Override
	public CD GetCD(int pozitie) {
		return l.get(pozitie);
	}

	public void Sort(int i){
		if(i%10==1)
			sortinfo();
		if(i%100==10||i%100==11)
			sorttip();
		if(i>=100)
			sortname();
		
		
	}
	public void sortname(){
		CD aux=new CD();
		int k=0;
		while(k<l.size()){
			for(int j=0;j<l.size();j++)
				if(l.get(k).nume.compareTo(l.get(j).nume)<0){
					aux=l.get(k);
					l.set(k,l.get(j));
					l.set(j,aux);
						}
		k++;}
	
	}
	public void sorttip(){
		CD aux=new CD();
		int k=0;
		while(k<l.size()){
			for(int j=0;j<l.size();j++)
				if(l.get(k).tip.compareTo(l.get(j).tip)<0){
						aux=l.get(k);
						l.set(k,l.get(j));
						l.set(j,aux);
						}
		k++;}
	
	}
	public void sortinfo(){
		CD aux=new CD();
		int k=0;
		while(k<l.size()){
			for(int j=0;j<l.size();j++)
				if(l.get(k).info.compareTo(l.get(j).info)<0){
					aux=l.get(k);
					l.set(k,l.get(j));
					l.set(j,aux);
						}
		k++;}
	
	}
	/* (non-Javadoc)
	 * @see repository.IRepository#FindAll()
	 */
	/* (non-Javadoc)
	 * @see repository.IRepository#FindAll()
	 */
	//@Override
	@Override
	public List<CD> FindAll() {
		return l;
	}
	public Repository Search(CD nou){
		Repository rez=new Repository();
		//System.out.println("asd");
		for(int i=0;i<l.size();i++)
			if(l.get(i).getInfo().contains(nou.info)&&l.get(i).getInfo().contains(nou.nume)&&l.get(i).getInfo().contains(nou.tip))
				{rez.Add(l.get(i));
				 System.out.println(l.get(i).toString());
				}
		return rez; 
		
	}
}
