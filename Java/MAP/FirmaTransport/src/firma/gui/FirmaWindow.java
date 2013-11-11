package firma.gui;

import firma.ctrl.FirmaCtrl;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.*;
import java.awt.*;
import static firma.gui.UtileGUI.*;
import firma.FirmaException;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 17, 2011
 * Time: 1:13:29 AM
 */
public class FirmaWindow extends JFrame {
    private FirmaCtrl ctrl;
    private JPanel cautaCursaP=null,panouRezer=null;
    public FirmaWindow(final FirmaCtrl ctrl) {
        super("Utilizator: "+ctrl.getNumeAngajat());
        this.ctrl = ctrl;
        setJMenuBar(creeazaMeniu());
        add(new JLabel("<html><font color=\"blue\" size=\"+2\">Bine ati venit!", JLabel.CENTER));
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Se inchide ferestra");
                ctrl.logout(FirmaWindow.this, true);
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel creeazaPanouAdaugRezervare(){
        JPanel panou=new JPanel();
        panou.setLayout(new BorderLayout());
        if (cautaCursaP==null)
            cautaCursaP= panouCautaCursa();
        else
            clearFields();
        panou.add(cautaCursaP,BorderLayout.CENTER);
        if (panouRezer==null)
            panouRezer=creeazaRezervare();
        panou.add(panouRezer, BorderLayout.SOUTH);
        return panou;
    }

    private JPanel creeazaGenLista(){
        JPanel panou=new JPanel();
        JButton salLista;
        panou.add(salLista=new JButton("Salveaza lista rezervari..."));
        salLista.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int indexRuta=tabel_rute.getSelectedRow();
                if (indexRuta<0){
                    JOptionPane.showMessageDialog(FirmaWindow.this,"Trebuie sa selectati ruta! ", "Eroare", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int indexData=data.getSelectedIndex();
                if (indexData<0){
                     JOptionPane.showMessageDialog(FirmaWindow.this,"Trebuie sa selectati data! ", "Eroare", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int indexOra=ora.getSelectedIndex();
                if (indexOra<0){
                     JOptionPane.showMessageDialog(FirmaWindow.this,"Trebuie sa selectati ora! ", "Eroare", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    String numefis=ctrl.salveazaListaCursa(indexRuta,indexData, indexOra);
                    JOptionPane.showMessageDialog(FirmaWindow.this,"Lista a fost salvata in fisierul "+numefis, "Rezultat", JOptionPane.INFORMATION_MESSAGE);
                } catch (FirmaException e1) {
                    JOptionPane.showMessageDialog(FirmaWindow.this,e1.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        return panou;
    }
    private JPanel panouGenLista=null;
    private JPanel creeazaPanouGenLista(){
        JPanel panou=new JPanel();
        panou.setLayout(new BorderLayout());
        if (cautaCursaP==null){
            cautaCursaP= panouCautaCursa();
        }else
            clearFields();
        panou.add(cautaCursaP,BorderLayout.CENTER);
        if (panouGenLista==null)
            panouGenLista=creeazaGenLista();
        panou.add(panouGenLista, BorderLayout.SOUTH);
        return panou;
    }

    private void clearFields() {
       ctrl.stergeCampuri();
       nrLocDispon.setText("");
        txtPlec.setText("");

    }

    protected JMenuBar creeazaMeniu(){
        JMenuBar mb=new JMenuBar();
        //Rezervari
        JMenu rezervari=new JMenu("Rezervari");
        JMenuItem adaugRez=new JMenuItem("Adauga rezervare", KeyEvent.VK_A);
        JMenuItem anulRez=new JMenuItem("Anuleaza rezervare");
        anulRez.setEnabled(false);
        rezervari.add(adaugRez);
        rezervari.add(anulRez);
        //Rapoarte
        JMenu rapoarte=new JMenu("Rapoarte");
        JMenuItem genLista=new JMenuItem("Genereaza tabel rezervari cursa");
        rapoarte.add(genLista);
        //Iesire
        JMenuItem logout=new JMenuItem("Logout");

        mb.add(rezervari);
        mb.add(rapoarte);
        mb.add(logout);

        ActionListener al=new MeniuListener();
        adaugRez.setActionCommand("adaugaRezervare");
        genLista.setActionCommand("genereazaLista");
        logout.setActionCommand("logout");
        adaugRez.addActionListener(al);
        genLista.addActionListener(al);
        logout.addActionListener(al);
        return mb;
    }

    private JComboBox data,ora;
    private JTextField nrLocDispon;
    private JPanel creeazaCursa(){
        JPanel panou=new JPanel();
        panou.add(new JLabel("Data:"));
        panou.add(data=new JComboBox(ctrl.getDatesComboBoxModel()));
        data.addItemListener(new DataItemListener());
        panou.add(new JLabel("Ora:"));
        panou.add(ora=new JComboBox(ctrl.getHoursComboBoxModel()));
        ora.addItemListener(new OraItemListener());
        panou.add(new JLabel("Locuri disponibile:"));
        panou.add(nrLocDispon=new JTextField("",3));
        nrLocDispon.setEditable(false);

        return panou;
    }
   

    private JPanel panouCautaCursa(){
        JPanel panou=new JPanel();
        panou.setLayout(new BorderLayout());
        panou.add(panouCautaRuta(), BorderLayout.NORTH);
        panou.add(creeazaTabelRute(), BorderLayout.CENTER);
        panou.add(creeazaCursa(), BorderLayout.SOUTH);
        panou.setBorder(BorderFactory.createTitledBorder("Cautare cursa"));
        return panou;
    }
   private JTable tabel_rute;
    private JPanel creeazaTabelRute() {
        JPanel panou=new JPanel();
        panou.setLayout(new GridLayout(1,1));
        tabel_rute=new JTable(ctrl.getRuteTableModel());
        JScrollPane pane=new JScrollPane(tabel_rute);
        tabel_rute.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabel_rute.getSelectionModel().addListSelectionListener(new RuteListener());
        panou.add(pane);
        panou.setBorder(BorderFactory.createTitledBorder("Rute"));
        return panou;
    }
   private JButton cautaRu;
    private JTextField txtPlec;
    private JPanel panouCautaRuta() {
        JPanel panou=new JPanel();
        panou.add(new JLabel("Plecare:"));
        panou.add(txtPlec=new JTextField(7));
        panou.add(cautaRu=new JButton("Cauta"));
        ActionListener al=new CautaRutaListener();
        cautaRu.addActionListener(al);
        txtPlec.addActionListener(al);
        return panou;
    }
   private JButton butRez, butCancel;
   private  JTextField numeClient, nrLocuri;
    private JPanel creeazaRezervare(){
        JPanel panou=new JPanel();
        panou.setLayout(new GridLayout(3,1));
        JPanel linia1=putInPanel(new JLabel("Nume:"));
        linia1.add(numeClient=new JTextField(15));
        panou.add(linia1);

        JPanel linia2=putInPanel(new JLabel("Nr locuri:"));
        linia2.add(nrLocuri=new JTextField("1",3));
        panou.add(linia2);

        JPanel linia3=putInPanel(butRez=new JButton("Rezerva locuri"));
        linia3.add(butCancel=new JButton("Sterge date client"));
        panou.add(linia3);
        panou.setBorder(BorderFactory.createTitledBorder("Rezervare"));
        ActionListener al=new ButRezervareListener();
        butRez.setActionCommand("rezervare");
        butCancel.setActionCommand("cancel");
        butRez.addActionListener(al);
        butCancel.addActionListener(al);
        return panou;
    }

    private class MeniuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd=e.getActionCommand();
            if ("adaugaRezervare".equals(cmd)){
                System.out.println("Adauga rezervare...");
                getContentPane().removeAll();
                getContentPane().add(creeazaPanouAdaugRezervare());
                getContentPane().validate();
                return;
            }
            if ("genereazaLista".equals(cmd)){
                System.out.println("Genereaza lista ...");
                getContentPane().removeAll();
                getContentPane().add(creeazaPanouGenLista());
                getContentPane().validate();
                return;
            }
            if ("logout".equals(cmd)){
                System.out.println("Logout ...");
                ctrl.logout(FirmaWindow.this, false);

            }
        }
    }

   
    private class CautaRutaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("S-a apasat [Cauta ruta]");
            String text=txtPlec.getText();
            nrLocDispon.setText("");
            ctrl.cautaRute(text);
        }
    }

    private class RuteListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()){
                int index=tabel_rute.getSelectedRow();
                if (index>=0){
                    nrLocDispon.setText("");
                    ctrl.rutaSelectata(index);
                }

            }
        }
    }

    private class DataItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange()==ItemEvent.SELECTED){
                System.out.println("Data selectata ...");
                ctrl.dataSelectata(tabel_rute.getSelectedRow(),data.getSelectedIndex());
            }
        }
    }

    private class ButRezervareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd=e.getActionCommand();
            System.out.println("S-a apasat ..."+cmd);
            if ("rezervare".equals(cmd)){
                int indexRuta=tabel_rute.getSelectedRow();
                if (indexRuta<0){
                    JOptionPane.showMessageDialog(FirmaWindow.this,"Trebuie sa selectati ruta! ", "Eroare", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int indexData=data.getSelectedIndex();
                if (indexData<0){
                     JOptionPane.showMessageDialog(FirmaWindow.this,"Trebuie sa selectati data! ", "Eroare", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int indexOra=ora.getSelectedIndex();
                if (indexOra<0){
                     JOptionPane.showMessageDialog(FirmaWindow.this,"Trebuie sa selectati ora! ", "Eroare", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String numeClie=numeClient.getText();
                if ((numeClie==null)||(numeClie.length()==0)){
                    JOptionPane.showMessageDialog(FirmaWindow.this,"Trebuie sa introduceti numele clientului! ", "Eroare", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String snrLocuri=nrLocuri.getText();
                try{
                    int nrL=Integer.parseInt(snrLocuri);
                    ctrl.rezervaLocuri(indexRuta, indexData, indexOra, numeClie, nrL);
                }catch(NumberFormatException ex){
                     JOptionPane.showMessageDialog(FirmaWindow.this,"Numarul de locuri trebuie sa fie numar intreg!", "Eroare", JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (FirmaException e1) {
                     JOptionPane.showMessageDialog(FirmaWindow.this,e1.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            }
            if ("cancel".equals(cmd)) {
                   numeClient.setText("");
                   nrLocuri.setText("1");
            }
        }
    }

    private class OraItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            System.out.println("OraItemListener");
            if (e.getStateChange()==ItemEvent.SELECTED){
                int locDis=ctrl.getLocuriDisponibile(tabel_rute.getSelectedRow(), data.getSelectedIndex(), ora.getSelectedIndex());
                System.out.println("locDis = " + locDis);
                if (locDis==0){
                    nrLocDispon.setForeground(Color.red);
                    nrLocDispon.setText(""+locDis);
                } else {
                    nrLocDispon.setForeground(Color.blue);
                    nrLocDispon.setText(""+locDis);
                }
            }
        }
    }
}
