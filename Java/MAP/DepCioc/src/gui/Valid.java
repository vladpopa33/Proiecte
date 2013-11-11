	package gui;

public class Valid {
	CiocoGUI gui;
	public Valid(CiocoGUI gui) {
		this.gui = gui;
	}
	
	public int ComandaValida() throws Exception {
		if(gui.lista.isSelectionEmpty()) throw new Exception ("Nu ai selectat niciun element !");
		try {
			return Integer.parseInt(gui.cant.getText());
		} catch (Exception e) {
			throw new Exception("Cantitatea nu este numar valid !");
		}
	}
	
	public void AdaugareValida() throws Exception {
		String s = new String();
		if(gui.den.getText().length()<3)
			s += "Denumirea este prea scurta !\n";
		try {
			Integer.parseInt(gui.cant.getText());
		} catch(Exception e) {
			s += "Cantitatea nu este numar valid !\n";
		}
		
		if(s.length()>1) throw new Exception(s);
	}
	
	public int ComandaPanel(String response) throws Exception {
		int comanda;
		try {
			comanda = Integer.parseInt(response);
		} catch (Exception e) {
			throw new Exception("Nu ai introdus un nr valid !");
		}
		if(comanda == 0 ) throw new Exception ("Comanda este prea mica !");
		
		if(comanda > Integer.parseInt(gui.cant.getText()))
				throw new Exception("Comanda depaseste cantitatea de pe stoc !");
		return comanda;
	}
}
