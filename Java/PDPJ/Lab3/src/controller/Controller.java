package controller;

import model.Masina;
import model.Masini;

import org.apache.log4j.Logger;

import view.View;

public class Controller extends Thread{
	Logger LOG = Logger.getLogger(Controller.class);
	public Controller(){		
	}
	public void run(){
		View v=new View();
		Masini m=new Masini();
		String o="";
		//LOG.debug("meniu");
		while(!o.equals("4")){
			v.print("");
			o=v.menu();
			if(o.equals("1")){
				for(int i=0;i<m.length()-1;i++)
					v.print(m.get_car(i).toString());
			}
			if(o.equals("2")){
				v.print("Adaugati o noua masina");
				Masina mi=new Masina(v.addmarca(),v.addculoare(),v.addmotor(),v.addviteza(),v.addpret(),v.addimagine());
				m.add_car(mi);
			}
			if(o.equals("3"))
				while(m.delete_car(v.deletecar())==false)
					v.print("Marca nu exista!");
		}
	  v.print("");
	  v.print("Ati ales sa iesiti! La revedere!");		
	}
}
