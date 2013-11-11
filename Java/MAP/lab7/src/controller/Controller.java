package controller;
import java.util.List;

import model.CD;

import repository.*;

public class Controller {
	private IRepository repfile,rep;
	
	public Controller() throws RepositoryException {
		rep = new Repository();
		repfile = new RepositoryFile("CD.txt");
		repfile.Read();
		rep.Save(repfile.FindAll());	
	}
	
	public List<CD> FindAll() {
		//System.out.println("fgh"+rep.FindAll().toString());
		return rep.FindAll();
	}
	
	public CD GetCD(int pozitie) {
		return rep.GetCD(pozitie);
	}
	
	/*public void Sell(int pozitie, int tip) throws RepositoryException {
		CD p = rep.GetCD(pozitie);
		p.setTip(tip);
		repfile.Add(p);
	}*/
	
	/*public void Update(int pozitie, int tip) throws RepositoryException {
		CD p = rep.GetCD(pozitie);
		p.setTip(p.gettip()+tip);
		repfile.Save(rep.FindAll());
	}*/
	
	public void Add(String nume, String tip,String info) throws RepositoryException {
		CD p = new CD();
		p.setNume(nume);
		p.setTip(tip);
		p.setInfo(info);
		rep.Add(p);
		repfile.Save(rep.FindAll());
	}
	
	public void Save() throws RepositoryException {
		List<CD> l = rep.FindAll(); 
		repfile.Save(l);
	}
	
	public void Sort(int i){
		rep.Sort(i);
	}
	
	public Repository Getrep(){
		return (Repository)rep;
	}
	/*public boolean Exista(String nume) {
		for(CD p:rep.FindAll()) {
			if(p.getNume().equals(nume)) return true;
		}
		return false;
		
	}*/
}
