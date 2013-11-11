package domain;

public class Produs {
	private String nume;
	private int cant;
	public Produs(){
		nume="";
		cant=0;
	}
	public Produs(String n,int c){
		nume=n;
		cant=c;
	}
	public String get_nume(){
		return nume;
	}
	public int get_cant(){
		return cant;
	}
	public void set_nume(String n){
		nume=n;
	}
	public void set_cant(int c){
		cant=c;
	}
}