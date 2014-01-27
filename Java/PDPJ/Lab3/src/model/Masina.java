package model;

public class Masina {
	public String marca,culoare,motor,viteza_maxima,pret,imagine;
	public Masina(String marca,String culoare,String motor,String viteza_maxima,String pret,String imagine){
		this.marca=marca;
		this.culoare=culoare;
		this.motor=motor;
		this.viteza_maxima=viteza_maxima;
		this.pret=pret;
		this.imagine=imagine;
	}
	public String toString(){
		return marca+" "+culoare+" "+motor+" "+viteza_maxima+" "+pret+" "+imagine;
	}
}
