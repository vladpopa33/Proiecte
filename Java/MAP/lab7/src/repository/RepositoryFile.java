package repository;

import java.util.List;
import model.CD;
import java.io.*;
import java.util.ArrayList;

public class RepositoryFile implements IRepository{
	private String fileread;
	//private String filesell;
	private List<CD> l;
	public RepositoryFile(String file1) {
		fileread = file1;
		//filesell = file2;
	}
	
	public void Read() throws RepositoryException {
		BufferedReader br = null;
		CD p;
		String line, array[];
		l = new ArrayList<CD>();
		try {
			br = new BufferedReader(new FileReader(fileread));
			while((line = br.readLine()) != null) {
				array = line.split("@");
				p = new CD();
				p.setNume(array[0]);
				p.setTip(array[1]);
				p.setInfo(array[2]);
				l.add(p);
			} 
			br.close();
		} catch (Exception e) {
			throw new RepositoryException(e.toString());
		}
 	}
	
	public void Save(List<CD> l) throws RepositoryException {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(fileread);
			for(CD p:l)
				pw.println(p);
			pw.close();
		} catch (Exception e) {
			throw new RepositoryException(e.toString());
		}
	}
	
	public void Add(CD p) throws RepositoryException {
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileread,true);
			fw.write("S-a adaugat CD-ul " + p.getNume() + " !\n");
			fw.close();
		} catch (Exception e) {
			throw new RepositoryException(e.toString());
		}
	}
	
	public List<CD> FindAll() {
		return l;
	}
	public CD GetCD(int pozitie) {
		return null;
	}
	public void Sort(int pozitie){
		
	}
	public Repository Search(CD nou){
		return null;
	}
}
