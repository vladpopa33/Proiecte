package examen;

public class Program {
	public String nume,data,ora,durata,descriere;
	public Program(String nume, String data, String ora, String durata, String descriere){
		this.nume=nume;
		this.data=data;
		this.ora=ora;
		this.durata=durata;
		this.descriere=descriere;
	}
	
	public String toString(){
		return data+" "+" "+ora+" "+durata+" "+descriere;
	}
}

