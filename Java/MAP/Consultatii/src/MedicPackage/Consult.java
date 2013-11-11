package MedicPackage;

public class Consult {
	private String date, diagnosis,cnp;
	private Vector medication = new Vector(50);

	public Consult(String d, String diag, Vector m){
		date = d;
		diagnosis = diag;
		medication = m;
	}
	public void setCNP(String c){
		cnp = c;
	}
	public void setDate(String d){
		date = d;
	}

	public void setDiagnosis(String diag){
		diagnosis = diag;
	}

	public void setMedication(Vector m){
		medication = m;
	}

	public String getCNP(){
		return cnp;
	}
	public String getDate(){
		return date;
	}

	public String getDiagnosis(){
		return diagnosis;
	}

	public Vector getMedication(){
		return medication;
	}

	public void addMedication(String m){
		medication.addElem(m);
	}

	@Override public String toString(){
		String result = date + " -- " + diagnosis + ":  ";
		int n = medication.getNo();
		for (int i = 1; i <= n; i++){
			result = result + " " + medication.getElem(i);
		}
		return result;
	}

	public boolean searchDiagnosis(String d){
		return (diagnosis.toLowerCase().equals(d.toLowerCase()));
	}

	public boolean searchMed(String m){
		boolean found = false;
		int n = medication.getNo();
		int i = 1;
		while ((i <= n) && (found == false)){
			if (((String)medication.getElem(i)).toLowerCase().equals(m.toLowerCase()))
				found = true;
			i++;
		}
		return found;
	}
}
