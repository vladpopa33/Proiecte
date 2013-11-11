	package gui;

public class Valid {
	GUI gui;
	public Valid(GUI gui) {
		this.gui = gui;
	}
	
	public int ComandaValida() throws Exception {
		if(gui.lista.isSelectionEmpty()) throw new Exception ("Nu ai selectat niciun element !");
		try {
			return Integer.parseInt(gui.tip.getText());
		} catch (Exception e) {
			throw new Exception("Cantitatea nu este numar valid !");
		}
	}
	
	public void AdaugareValida() throws Exception {
		String s = new String();
		if((!gui.tip.equals("soft"))||(!gui.tip.equals("muzica"))||(!gui.tip.equals("joc"))||(!gui.tip.equals("filme")))
			s += "Tip invalid !\n";
		
		try {
			//Integer.parseInt(gui.tip.getText());
		} catch(Exception e) {
			//s += "Tip invalid !\n";
		}
		throw new Exception(s);
		// if(m.equals("")||!m.equals("soft")&&!m.equals("muzica")&&!m.equals("joc")&&!m.equals("filme"))
			 
	//	if(s.length()>1) throw new Exception(s);
	}
	
	public String ComandaPanel(String response) throws Exception {
		String comanda="";
		try {
			comanda = response;
		} catch (Exception e) {
			//throw new Exception("Tip invalid !");
		}
		if(!(comanda.equals("soft")&&(!comanda.equals("filme"))&&(!comanda.equals("muzica"))&&(!comanda.equals("joc"))&&(!comanda.equals("")))) 
				throw new Exception ("Tip invalid !");
		return comanda;
	}
}
