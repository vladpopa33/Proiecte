package controller;
import java.util.List;

import model.Ciocolata;

import repository.*;

public class Controller {
	private IRepository repfile,rep;
	
	public Controller() throws RepositoryException {
		rep = new Repository();
		repfile = new RepositoryFile("citire.txt","vanzari.txt");
		repfile.Read();
		rep.Save(repfile.FindAll());	
	}
	
	public List<Ciocolata> FindAll() {
		return rep.FindAll();
	}
	
	public Ciocolata GetCioco(int pozitie) {
		return rep.GetCioco(pozitie);
	}
	
	public void Sell(int pozitie, int cantitate) throws RepositoryException {
		Ciocolata p = rep.GetCioco(pozitie);
		p.setCantitate(cantitate);
		repfile.Add(p);
	}
	
	public void Update(int pozitie, int cantitate) throws RepositoryException {
		Ciocolata p = rep.GetCioco(pozitie);
		p.setCantitate(p.getCantitate()+cantitate);
		repfile.Save(rep.FindAll());
	}
	
	public void Add(String denumire, String cantitate) throws RepositoryException {
		Ciocolata p = new Ciocolata();
		p.setDenumire(denumire);
		p.setCantitate(Integer.parseInt(cantitate));
		rep.Add(p);
		repfile.Save(rep.FindAll());
	}
	
	public void Save() throws RepositoryException {
		List<Ciocolata> l = rep.FindAll(); 
		repfile.Save(l);
	}
	
	public boolean Exista(String denumire) {
		for(Ciocolata p:rep.FindAll()) {
			if(p.getDenumire().equals(denumire)) return true;
		}
		return false;
	}
}
