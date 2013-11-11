package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Ciocolata;

import controller.Controller;

public class CiocoEvents implements ActionListener, ListSelectionListener {
	public CiocoGUI p;
	public Controller ctrl;
	public Valid valid;
	
	public CiocoEvents(CiocoGUI p, Controller ctrl, Valid valid) {
		this.p = p;
		this.ctrl = ctrl;
		this.valid = valid;
	}
	
	public void SetEvents() {
		p.lista.addListSelectionListener(this);
		p.cumpara.addActionListener(this);
		p.adauga.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == p.cumpara) {
			try {
				String response = JOptionPane.showInputDialog(null,"Introduceti cantitatea");
				int c = valid.ComandaValida();
				int comanda = valid.ComandaPanel(response);
				p.cant.setText(String.format("%d",c-comanda));
				
				ctrl.Sell(p.lista.getSelectedIndex(), c-comanda);
				JOptionPane.showMessageDialog(null, " Ai cumparat cu succes !");
				ctrl.Save();
			} catch(Exception msg) { 
				JOptionPane.showMessageDialog(null, msg.getMessage());
			}
		}
		if (e.getSource() == p.adauga) {
			try {
				valid.AdaugareValida();
				if(ctrl.Exista(p.den.getText())) {
					ctrl.Update(p.lista.getSelectedIndex(),Integer.parseInt(p.cant.getText()));
					JOptionPane.showMessageDialog(null,"Cantitatea a fost actualizata !");
					return;
				}
				ctrl.Add(p.den.getText(),p.cant.getText());
				((DefaultListModel<String>)p.lista.getModel()).addElement(p.den.getText());
				JOptionPane.showMessageDialog(null, "Ai adaugat cu succes !");
			} catch (Exception msg) { 
				JOptionPane.showMessageDialog(null, msg.getMessage());
			}
		}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		Ciocolata Cioco = ctrl.GetCioco(p.lista.getSelectedIndex());
		p.den.setText(Cioco.getDenumire());
		p.cant.setText(String.format("%d",Cioco.getCantitate()));

	}
}
