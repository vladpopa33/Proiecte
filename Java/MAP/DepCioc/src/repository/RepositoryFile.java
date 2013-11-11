package repository;

import java.util.List;
import model.Ciocolata;
import java.io.*;
import java.util.ArrayList;

public class RepositoryFile implements IRepository{
	private String fileread;
	private String filesell;
	private List<Ciocolata> l;
	public RepositoryFile(String file1, String file2) {
		fileread = file1;
		filesell = file2;
	}
	
	public void Read() throws RepositoryException {
		BufferedReader br = null;
		Ciocolata p;
		String line, array[];
		l = new ArrayList<Ciocolata>();
		try {
			br = new BufferedReader(new FileReader(fileread));
			while((line = br.readLine()) != null) {
				array = line.split("[,]");
				p = new Ciocolata();
				p.setDenumire(array[0]);
				p.setCantitate(Integer.parseInt(array[1]));
				l.add(p);
			} 
			br.close();
		} catch (Exception e) {
			throw new RepositoryException(e.toString());
		}
 	}
	
	public void Save(List<Ciocolata> l) throws RepositoryException {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(fileread);
			for(Ciocolata p:l)
				pw.println(p);
			pw.close();
		} catch (Exception e) {
			throw new RepositoryException(e.toString());
		}
	}
	
	public void Add(Ciocolata p) throws RepositoryException {
		FileWriter fw = null;
		try {
			fw = new FileWriter(filesell,true);
			fw.write("S-a vandut din planta " + p.getDenumire() + " cantitatea "+ p.getCantitate() + " !\n");
			fw.close();
		} catch (Exception e) {
			throw new RepositoryException(e.toString());
		}
	}
	
	public List<Ciocolata> FindAll() {
		return l;
	}
	public Ciocolata GetCioco(int pozitie) {
		return null;
	}

}
