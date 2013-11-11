package MedicPackage;
import java.io.*;
import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {

	public static void main(String[] args) {
		
		String op="";
		Vector DoctorList = new Vector(10);
		Vector PatientList = new Vector(10);
		Vector ConsultList = new Vector(10);
		File f=new File();
		
		List<String[]> l =f.ReadFromFile("Doctors.txt");
		for(String[] a:l){
			Doctor d = new Doctor(a[0],a[1]);
			DoctorList.addElem(d);
		}
		
		l =f.ReadFromFile("Consults.txt");
		for(String[] a:l){
			Vector m = new Vector(3);
			for(int i=2;i<a.length;i++)
				m.addElem(a[i]);
			Consult d = new Consult(a[1],a[2],m);
			d.setCNP(a[0]);
			ConsultList.addElem(d);
		}
		
		l =f.ReadFromFile("Patients.txt");
		int i=0;
		
		for(String[] a:l){
			Vector v=new Vector(50);
			for(int j=0;j<ConsultList.length();j++){
				Consult c=(Consult)ConsultList.getElem(j);
				if(a[0].equals(c.getCNP())){
					v.addElem(c);
					
				}
			}
			System.out.println("\n");	
			Patient p = new Patient(a[0],a[1],a[2],a[3],(Doctor)DoctorList.getElem(i),v);
			PatientList.addElem(p);
			i++;
			
		}
		
		while(!op.equals("7")){
			System.out.println("Alegeti una din optiunile : \n");
			System.out.println("	1)Creeaza un fisier pacientii alfabetic dupa nume ");
			System.out.println(" 	2)Creeaza un fisier toþi pacienþii ce au depãºit o limitã de vârstã, alfabetic dupã nume");
			System.out.println(" 	3)Afiseaza un tabel cu pacienþii ce au fost consultaþi în ultima lunã");
			System.out.println(" 	4)Afiseaza un tabel cu pacientii nãscuþi în luna curentã");
			System.out.println(" 	5)Creeaza un fiºier cu toþi pacienþii clasificaþi pe categorii de vârstã (0-1, 1-4, 4-10, 10-18, 18-60 ºi peste 60), alfabetic dupã nume");
			System.out.println(" 	6)Afiseaza un tabel cu pacienþii ce nu au fost consultaþi în ultimul an");
			System.out.println(" 	7)Iesire");
			System.out.println("Optiune : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try{
				op=br.readLine();
			}catch(IOException e){
		
			}
			if(op.equals("1")) {
				PatientList.sortPatients();
				f.WriteToFile(PatientList,"PatientsAlf.txt");
			}
			if(op.equals("2")) {
				try{
					String o;
					System.out.println("Dati varsta:");
					o=br.readLine();
					int j=Integer.parseInt(o);
					f.WriteToFile(PatientList.bornafter(j),"PatientsBorn.txt");
				}catch(IOException e){
			
				}
				
			}
			
			if(op.equals("3")) {
				Vector aux;
				String o;
				aux=PatientList.consulted();
				o=aux.toString();
				System.out.println("Lista pacientilor consultati in ultima luna este:");
				System.out.println(o);
			}
		
			if(op.equals("4")) {
				Vector aux;
				aux=PatientList.birthdays();
				System.out.println("Lista pacientilor este:");
				System.out.println(aux);
			}
			
			if(op.equals("5")) {
				Vector aux=new Vector(2);
				PatientList.sortPatients();
				aux.addElem(PatientList.classified());		
				f.WriteToFile(aux,"PatientsClassified.txt");
			}
			
			if(op.equals("6")) {
				System.out.println("Lista pacientilor care nu au fost consultati in ultimul an este:");
				System.out.println(PatientList.NoConsulted());
			}
			
			if(op.equals("7")){
				System.out.println("Goodbye");
				System.exit(0);
			}
			if((!op.equals("1"))&&(!op.equals("2"))&&(!op.equals("3"))&&(!op.equals("4"))&&(!op.equals("5"))&&(!op.equals("6"))&&(!op.equals("7")))
				System.out.println("\nERROR		Invalid command");
		}
		}
}