package pdpj;

public class Oferta {
	String destinatie,pret,transport;
	public Oferta(String destinatie,String pret,String transport){
		this.destinatie=destinatie;
		this.pret=pret;
		this.transport=transport;
	}
	public String toString(){
		return this.destinatie+" "+this.pret+" "+this.transport;
	}
}
