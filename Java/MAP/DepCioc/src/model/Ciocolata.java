package model;

public class Ciocolata {
	private String denumire;
	private int cantitate;
	
	public String getDenumire() {
		return denumire;
	}
	
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	public String toString(){
		return denumire+","+cantitate;
	}
	
	
}
