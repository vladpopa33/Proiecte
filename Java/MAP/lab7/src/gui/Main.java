package gui;
import javax.swing.*;

import controller.Controller;



public class Main {
	
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Controller ctrl = new Controller();
			GUI p = new GUI("Biblioteca de CD-uri",ctrl);
			Valid valid = new Valid(p);
			Events ev = new Events(p,ctrl,valid);
			p.CreateObjects();
			ev.SetEvents();
			p.setSize(1000,300);
			p.setLocation(200,200);
			p.setVisible(true);
			p.sort1.setVisible(false);
			p.sort2.setVisible(false);
			p.sort3.setVisible(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
		
	}

}
