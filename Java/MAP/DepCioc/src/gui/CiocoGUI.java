package gui;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import model.Ciocolata;

import controller.Controller;


public class CiocoGUI extends JFrame {
	public JList<String> lista;
	public JPanel window;
	public JTextField den,cant;
	public JButton adauga,cumpara;
	public Controller ctrl;
	
	public CiocoGUI(String title, Controller ctrl) {
		super(title);
		window = new JPanel();
		getContentPane().add(window);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.ctrl = ctrl;
	}
	
	public void CreateList() {
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for(Ciocolata p:ctrl.FindAll()) {
			dlm.addElement(p.getDenumire());
		} 
		lista = new JList<String>(dlm);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public JPanel CreateLabels(String denumire, String cantitate) {
		JPanel panel = new JPanel(new GridLayout(3,1));
		panel.add(new JLabel(denumire));
		panel.add(new JLabel(cantitate));
		return panel;
	}
	
	public JPanel CreateTextFields(int size) {
		JPanel panou = new JPanel(new GridLayout(3,1));
		den = new JTextField(size);
		cant = new JTextField(size);
		panou.add(den);
		panou.add(cant);
		return panou;
	}
	public JPanel CreateButoane() {
		JPanel panou = new JPanel();
		cumpara = new JButton("Cumpara");
		adauga = new JButton("Adauga");
		panou.add(cumpara);
		panou.add(adauga);
		return panou;
	}
	
	public void CreateDetails() {
		JPanel panou = new JPanel();
		panou.add(CreateLabels("Denumire","Cantitate"));
		panou.add(CreateTextFields(15));
		panou.add(CreateButoane());
		panou.setBorder(new TitledBorder("Detalii Ciocolata"));
		window.add(panou);
	}
	
	public void CreateObjects() {
		JPanel panel = new JPanel();
		CreateList();
		JScrollPane scroll = new JScrollPane(lista);
		panel.add(scroll);
		scroll.setPreferredSize(new Dimension(200,110));
		window.add(panel);
		panel.setBorder(new TitledBorder("Lista Produse ciocolata"));
		CreateDetails();
	}
	
}

