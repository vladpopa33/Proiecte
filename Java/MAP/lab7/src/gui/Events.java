package gui;
import java.util.*;
import model.CD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import repository.Repository;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.CD;

import controller.Controller;

public class Events implements ActionListener,ListSelectionListener{
	public GUI p;
	public Controller ctrl;
	public Valid valid;
	
	public Events(GUI p, Controller ctrl, Valid valid) {
		this.p = p;
		this.ctrl = ctrl;
		this.valid = valid;
	}
	
	public void SetEvents() {
		//p.lista.addListSelectionListener(this);
		p.afisare.addActionListener(this);
		p.cumpara.addActionListener(this);
		p.adauga.addActionListener(this);
		p.ord.addActionListener(this);
		p.sort1.addActionListener(this);
		p.sort2.addActionListener(this);
		p.sort3.addActionListener(this);
		p.lista.addListSelectionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == p.afisare) {
			try {
				p.inc=1;
				p.creare();
				
			} catch(Exception msg) { 
				JOptionPane.showMessageDialog(null, msg.getMessage());
			}
		}
		if (e.getSource() == p.cumpara) {
			try {
				/*String response1 = JOptionPane.showInputDialog(null,"Introduceti numele:");
				String response2 = JOptionPane.showInputDialog(null,"Introduceti tipul:");
				String comanda2 = valid.ComandaPanel(response2);
				String response3 = JOptionPane.showInputDialog(null,"Introduceti descrierea:");
				//p.ctrl.		
				//JOptionPane.showMessageDialog(null, " Ai cumparat cu succes !");*/
				Repository aux=new Repository();
				//aux=ctrl.Getrep();
				CD  nou=new CD();
				nou.setInfo(p.info.getText());
				nou.setNume(p.nume.getText());
				nou.setTip(p.tip.getText());
				aux=ctrl.Getrep().Search(nou);
				
			//	p.creare();
				
				
			} catch(Exception msg) {
				
				JOptionPane.showMessageDialog(null, "Cautarea nu a returnat niciun rezultat! ");
			}
		}
		if (e.getSource() == p.adauga) {
			try {
				valid.AdaugareValida();
				/*if(ctrl.Exista(p.den.getText())) {
					ctrl.Update(p.lista.getSelectedIndex(),Integer.parseInt(p.cant.getText()));
					JOptionPane.showMessageDialog(null,"Cantitatea a fost actualizata !");
					return;
				}*/
				ctrl.Add(p.nume.getText(),p.tip.getText(),p.info.getText());
				((DefaultListModel<String>)p.lista.getModel()).addElement(p.nume.getText());
				JOptionPane.showMessageDialog(null, "Ai adaugat cu succes !");
			} catch (Exception msg) { 
				JOptionPane.showMessageDialog(null, msg.getMessage());
			}
		}
	  if(e.getSource()==p.ord){
		    p.sort1.setVisible(true);
			p.sort2.setVisible(true);
			p.sort3.setVisible(true);
	  }
	  if(e.getSource()==p.sort1){
		  p.ctrl.Sort(100);
		  p.creare();
	  }
	  if(e.getSource()==p.sort2){
		  p.ctrl.Sort(10);
		  p.creare();
	  }
	  if(e.getSource()==p.sort3){
		  p.ctrl.Sort(1);
		  p.creare();
	  }
	}
	
	public void valueChanged(ListSelectionEvent e) {
	    CD aux = ctrl.GetCD(p.lista.getSelectedIndex());
		p.nume.setText(aux.getNume());
		p.tip.setText(aux.getTip());
		p.info.setText(aux.getInfo());
	}
}
