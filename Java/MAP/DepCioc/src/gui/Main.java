package gui;
import javax.swing.*;

import controller.Controller;



public class Main {
	
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Controller ctrl = new Controller();
			CiocoGUI p = new CiocoGUI("Depozit de ciocolata",ctrl);
			Valid valid = new Valid(p);
			CiocoEvents ev = new CiocoEvents(p,ctrl,valid);
			p.CreateObjects();
			ev.SetEvents();
			p.setSize(500,300);
			p.setLocation(200,200);
			p.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
		
	}

}
