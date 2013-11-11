package gui;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import model.CD;

import controller.Controller;


public class GUI extends JFrame {
	public JList<String> lista,aux;
	public JPanel window;
	public JTextField nume,tip,info;
	public JButton adauga,cumpara,afisare,ord,sort1,sort2,sort3;
	public Controller ctrl;
	public int inc=0;
	public GUI(String title, Controller ctrl) {
		super(title);
		window = new JPanel();
		getContentPane().add(window);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.ctrl = ctrl;
	}
	
	public void CreateList() {
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		//ctrl=null;
		//System.out.println("asd"+ctrl.FindAll().toString());
		for(CD p:ctrl.FindAll()) {
			dlm.addElement(p.getNume());
		} 
		lista = new JList<String>(dlm);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public JPanel CreateLabels(String nume, String tip,String info) {
		JPanel panel = new JPanel(new GridLayout(3,1));
		panel.add(new JLabel(nume));
		panel.add(new JLabel(tip));
		panel.add(new JLabel(info));
		return panel;
	}
	
	public JPanel CreateTextFields(int size) {
		JPanel panou = new JPanel(new GridLayout(3,1));
		nume = new JTextField(size);
		tip = new JTextField(size);
		info= new JTextField(size);
		panou.add(nume);
		panou.add(tip);
		panou.add(info);
		return panou;
	}
	public JPanel CreateButoane() {
		JPanel panou = new JPanel();
		afisare = new JButton("Afisare");
		cumpara = new JButton("Cauta");
		adauga = new JButton("Adauga");
		ord=new JButton("Ordoneaza Alfabetic");
		sort1 = new JButton("Dupa nume");
		sort2 = new JButton("Dupa tip");
		sort3 = new JButton("Dupa descriere");
		panou.add(afisare);
		panou.add(adauga);
		panou.add(cumpara);
		panou.add(ord);
		panou.add(sort1);
		panou.add(sort2);
		panou.add(sort3);
		return panou;
	}
	
	public void CreateDetails() {
		JPanel panou = new JPanel();
		
		panou.add(CreateLabels("Nume","Tip","Descriere"));
		
		panou.add(CreateTextFields(15));
		
		panou.add(CreateButoane());
		
		panou.setBorder(new TitledBorder("DetaliiCD"));
		
		window.add(panou);
	}
	
	public void CreateObjects() {
		JPanel panel = new JPanel();
		CreateList();
		if(inc==0){
			aux=lista;
			DefaultListModel<String> dlm = new DefaultListModel<String>();
			JList l=new JList<String>(dlm);
			l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lista=l;
			
		}
		if(inc==1)
			lista=aux;
		JScrollPane scroll = new JScrollPane(lista);
		panel.add(scroll);
		scroll.setPreferredSize(new Dimension(200,110));
		window.add(panel);
		panel.setBorder(new TitledBorder("Lista CD-uri"));
		CreateDetails();
		
	}
	
	public void creare(){
		DefaultListModel<String> dlm = (DefaultListModel<String>)lista.getModel();
		dlm.removeAllElements();
		//ctrl=null;
		//System.out.println("asd"+ctrl.FindAll().toString());
		for(CD p:ctrl.FindAll()) {
			dlm.addElement(p.getNume());
		} 
		//CreateDetails();
	}
	
	
}

