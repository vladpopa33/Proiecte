package MedicPackage;

public class Doctor {
	private String first_name, last_name;

	public Doctor(String f, String l){
		first_name = f;
		last_name = l;
	}

	public void setFirstName(String f){
		first_name = f;
	}

	public void setlastName(String l){
		last_name = l;
	}

	public String getFirstName(){
		return first_name;
	}

	public String getlastName(){
		return last_name;
	}

	@Override public String toString(){
		String result = first_name + " " + last_name;
		return result;
	}

	public boolean equaals(Doctor d){
		String d1 = first_name + " " + last_name;
		String d2 = d.first_name + " " + d.last_name;
		return (d1.equals(d2));
	}
}
