package MedicPackage;
import java.util.Calendar;
import java.io.*;

public class Patient {
	private String cnp, first_name, last_name, address;
	private Doctor attenddoc;
	private Vector consults;

	public Patient(String c, String f, String l, String a, Doctor ad, Vector cons){
		cnp = c;
		first_name = f;
		last_name = l;
		address = a;
		attenddoc = ad;		//numele doct de fam
		consults = cons;
	}

	public Patient(String c, String f, String l, String a, Doctor ad){
		cnp = c;
		first_name = f;
		last_name = l;
		address = a;
		attenddoc = ad;
	}

	public void setCnp(String c){
		cnp = c;
	}

	public void setFirstName(String f){
		first_name = f;
	}

	public void setLastName(String l){
		last_name = l;
	}

	public void setAddress(String a){
		address = a;
	}

	public void setAttenddoc(Doctor ad){
		attenddoc = ad;
	}

	public void setConsults(Vector cons){
		consults = cons;
	}

	public String getCnp(){
		return cnp;
	}

	public String getFirstName(){
		return first_name;
	}

	public String getLastName(){
		return last_name;
	}

	public String getAddress(){
		return address;
	}

	public Doctor getAttenddoc(){
		return attenddoc;
	}

	public Vector getConsults(){
		return consults;
	}

	public void addConsult(Consult c){
		consults.addElem(c);
	}

	@Override public String toString(){
		String result = cnp + " " + first_name + " " + last_name + "  " + address;
		return result;
	}

	public int compare(Patient p){
		String p1 = first_name + " " + last_name;
		String p2 = p.first_name + " " + p.last_name;
		if (p1.equals(p2))
			return cnp.compareTo(p.cnp);
		else
			return p1.compareTo(p2);
	}

	public boolean equals(Patient p){
		return (cnp.equals(p.cnp));
	}
	public int bornyear(){
		int n;
		String m;
		m=cnp.substring(1, 2);
		n=Integer.parseInt(m);
		return n;
	}
	public boolean ConsultedLastMonth(){
		int i;
		String m,n;
		Consult c;
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		for(i=0;i<consults.length();i++){
			c=(Consult)consults.getElem(i);
			m=c.getDate().substring(3, 10);
			n=month+"/2012";
			if(m.equals(n)){
				//System.out.println(m+"   "+n);
				return true;
			}
				
		}
		return false; 
	}
	public boolean ConsultedLastYear(){
		int i;
		String m;
		Consult c;
		for(i=0;i<consults.getNo();i++){
			c=(Consult)consults.getElem(i);
			m=c.getDate().substring(6, 10);
			if(m.equals("2012"))
				return true;
		}
		return false; 
	}
	public String month(){
		return cnp.substring(3,5);
	}
}
