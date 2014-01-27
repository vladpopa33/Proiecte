package examen;

public class User {
	public String nume,parola;
	public User(String user, String parola){
		this.nume=user;
		this.parola=parola;
	}
	
	public String toString(){
		return nume+" "+" "+parola;
	}
}
