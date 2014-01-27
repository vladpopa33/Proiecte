package controller;

import java.net.InetAddress;
import java.util.ArrayList;

import server.ServerClient;
import server.ServerOperator;

import model.Oferta;
import model.Oferte;

public class Controller {
	Oferte ofs=new Oferte();
	ArrayList<InetAddress> alerte=new ArrayList<InetAddress>();
	ArrayList<String> crit=new ArrayList<String>();
	ServerClient sc=new ServerClient(1234,this);
	ServerOperator so=new ServerOperator(4568,this);;
	public Controller(){
		alerte.add(null);
		crit.add(null);
		try {
			so.start();
			sc.start();
			so.join();
			sc.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addoferta(String tara,String pret,String transport){
		Oferta p=new Oferta(tara,pret,transport);
		ofs.add_oferta(p);
		for(int i=0;i<crit.size()-1;i++)
			if(tara.equals(crit.get(i)))
				System.out.println("");
				
	}
	
	public void addalerta(InetAddress ad,String tara){
		alerte.add(alerte.size()-1, ad);
		crit.add(crit.size()-1, tara);
	}
	public String getoferte(){
		String ret="\nOferte:\n";
		for(int i=0;i<ofs.length()-1;i++)
			ret=ret+ofs.get_oferta(i).toString()+"\n";
		return ret;
			
	}
}