package MedicPackage;

import java.util.Calendar;

public class Vector {
	private int n, cap;
	public Object[] elems;

	public Vector(int c){
		cap = c;
		n = 0;
		elems = new Object[cap];
	}

	public void addElem(Object el){
		if (n == cap - 1){
			cap = cap*2;
			Object aux[] = new Object[cap];
			for(int i = 0;i<n;i++)
				aux[i] = elems[i];
			elems = aux;
		}
		elems[n] = el;
		n++;
	}

	public void removeElem(Object el){
		int i = 1;
		boolean removed = false;
		while ((i <= n) && (removed == false)){
			if (elems[i].equals(el)){
				removed = true;
			}
			i++;
		}
		if (removed){
			for (int j = i - 1; j < n; j++)
				elems[j] = elems[j+1];
			n--;
		}
	}

	public void removePatient(Patient p){
		int i = 1;
		boolean removed = false;
		while ((i <= n) && (removed == false)){
			Patient auxP = (Patient)elems[i];
			if (p.equals(auxP))
				removed = true;
			i++;
		}
		if (removed){
			for (int j = i - 1; j < n; j++)
				elems[j] = elems[j+1];
			n--;
		}
	}

	public Object getElem(int pos){
		return elems[pos];
	}

	public int getNo(){
		return n;
	}
	public int length(){
		return n;
	}
	public boolean belongs(Object o){
		boolean found = false;
		int i = 1;
		while ((i <= n) && (found == false)){
			if (getElem(i).equals(o))
				found = true;
			i++;
		}
		return found;
	}

	public boolean belongsDoc(Doctor d){
		boolean found = false;
		int i = 1;
		while ((i <= n) && (found == false)){
			if (((Doctor)getElem(i)).equals(d))
				found = true;
			i++;
		}
		return found;
	}

	@Override public String toString(){
		String result = new String();
		for (int i = 0; i < n; i++)
			result = result + elems[i].toString() + "\n";
		return result;
	}

	public void sortPatients(){
		for (int i = 0; i < n; i++)
			for (int j = i+1; j < n; j++){
				Patient pi = (Patient)elems[i];
				Patient pj = (Patient)elems[j];
				if (pi.compare(pj) > 0){
					Patient auxP = pi;
					elems[i] = elems[j];
					elems[j] = auxP;
				}
			}
	}
	public Vector bornafter(int j){
		Vector aux=new Vector(50);
		for(int i = 0;i<n;i++){
			Patient p;
			p=(Patient)elems[i];
			if(p.bornyear()>j);
			aux.addElem(p);
		}
		return aux;

	}
	public Vector consulted(){
		Vector aux=new Vector(50);
		for(int i = 0;i<n;i++){
			Patient p;
			p=(Patient)elems[i];
			if(p.ConsultedLastMonth()){
				aux.addElem(p);
				//System.out.println(p.getConsults());
			}
		}
		return aux;
	}

	public Vector birthdays(){
		Vector aux=new Vector(50);
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		for(int i = 0;i<n;i++){
			Patient p;
			p=(Patient)elems[i];
			String m;
			m=p.month();
			if(m.equals(Integer.toString(month)))
				aux.addElem(p);
		}
		return aux;
	}
	public String classified(){
		int m;
		Vector c1=new Vector(50);
		Vector c2=new Vector(50);
		Vector c3=new Vector(50);
		Vector c4=new Vector(50);
		Vector c5=new Vector(50);
		Vector c6=new Vector(50);
		String clas=new String();
		Patient p;
		for (int i=0;i<n;i++) {
			p = (Patient)elems[i];
			if(p.bornyear()<12)
				m = 12-p.bornyear();
			else
				m= 100-p.bornyear()+12;
			if ((m>=0)&&(m<=1))
				c1.addElem(p);
			if ((m>1)&&(m<=4))
				c2.addElem(p);
			if ((m>4)&&(m<=10))
				c3.addElem(p);
			if ((m>10)&&(m<=18))
				c4.addElem(p);
			if ((m>18)&&(m<=60))
				c5.addElem(p);
			if (m>60)
				c6.addElem(p);
		}
		clas="\n Categoria 0-1 \n"+c1.toString()+"\n Between 1-4 \n"+c2.toString()+"\n Between 4-10\n";
		clas=clas+c3.toString()+"\n Between 10-18 \n"+c4.toString()+"\n Between 18-60\n"+c5.toString();
		clas=clas+"\n Over 60 "+c6.toString();
		return clas;
	}
	
	public Vector NoConsulted() {
		Vector aux=new Vector(50);
		Patient p;
		for(int i=0;i<n;i++){
			p=(Patient)elems[i];
			if (p.ConsultedLastYear()==false)
				aux.addElem(p);
		}			
		return aux;
	}
}
