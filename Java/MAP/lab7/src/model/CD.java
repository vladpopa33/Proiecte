package model;

public class CD {
	public String nume=new String();
	public String tip=new String();
	public String info=new String();
	
	public String getNume() {
		return nume;
	}
	
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	public String toString(){
		return nume+"@"+tip+"@"+info;
	}
	
	
}
