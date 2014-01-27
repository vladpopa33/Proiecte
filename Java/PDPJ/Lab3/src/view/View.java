package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class View {
	Logger LOG = Logger.getLogger(controller.Controller.class);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
	public View(){
		
	}
	public String menu(){
		String o="";
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		while(o.equals("")){
			//Scanner keyboard = new Scanner(System.in);
			System.out.println("Alege una din urmatoarele optiuni:");
			System.out.println("1. Vizualizeaza masini");
			System.out.println("2. Adauga masina");
			System.out.println("3. Sterge masina");
			System.out.println("4. Iesire");
			System.out.print("Scrie numarul optiunii dorite: ");
			try {
				o = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				LOG.debug(e);
			}
			System.out.println("");
		//o=keyboard.nextLine();
		//keyboard.close();
			if(!o.equals("1")&&!o.equals("2")&&!o.equals("3")&&!o.equals("4"))
				o="";
		}
		return o;
	}
	public String addmarca(){
		String o="";
		System.out.print("Marca: ");
		try {
			while(o.equals("")){
				o = br.readLine();
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.debug(e);
		}
		return o;
	}
	public String addculoare(){
		String o="";
		System.out.print("Culoare: ");
		try {
			while(o.equals("")){
				o = br.readLine();
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.debug(e);
		}
		return o;
	}
	public String addmotor(){
		String o="";
		System.out.print("Motor: ");
		try {
			while(o.equals("")){
				o = br.readLine();
				int i=Integer.parseInt(o);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.debug(e);
		}
		return o;
	}
	public String addviteza(){
		String o="";
		System.out.print("Viteza maxima: ");
		try {
			while(o.equals("")){
				o = br.readLine();
				int i=Integer.parseInt(o);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.debug(e);
		}
		return o;
	}
	public String addpret(){
		String o="";
		System.out.print("Pret: ");
		try {
			while(o.equals("")){
				o = br.readLine();
				int i=Integer.parseInt(o);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.debug(e);
		}
		return o;
	}
	public String addimagine(){
		String o="";
		System.out.print("Imagine: ");
		try {
			while(o.equals("")){
				o = br.readLine();
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.debug(e);
		}
		return o;
	}
	public String deletecar(){
		String o="";
		System.out.println("Sterge o marca");
		System.out.print("Numele marcii:");
		try {
			while(o.equals("")){
				o = br.readLine();
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.debug(e);
		}
		return o;
	}
	public void print(String s){
		System.out.println(s);
	}
}
