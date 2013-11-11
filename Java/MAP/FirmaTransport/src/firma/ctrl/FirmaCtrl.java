package firma.ctrl;

import firma.model.Angajat;
import firma.model.FirmaTransport;
import firma.model.Ruta;
import firma.FirmaException;
import firma.gui.FirmaWindow;
import firma.gui.LoginWindow;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 17, 2011
 * Time: 1:09:57 AM
 */
public class FirmaCtrl {
    private FirmaTransport firma;
    private Angajat curent;
    private RuteTableModel ruteTM;
    private DefaultComboBoxModel dateCBM, hoursCBM;

    public FirmaCtrl(FirmaTransport firma) {
        this.firma = firma;
    }

    public void login(String userId, char[] parola) throws FirmaException{
        curent=firma.login(userId, new String(parola));
        ruteTM=new RuteTableModel();
        dateCBM=new DefaultComboBoxModel();
        hoursCBM=new DefaultComboBoxModel();
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                FirmaWindow firmaW=new FirmaWindow(FirmaCtrl.this);
                firmaW.setSize(400,500);
                firmaW.setLocation(300,100);
                firmaW.setVisible(true);
            }
        });

    }

    public String getNumeAngajat() {
        return curent.getNume();
    }
    public void logout(FirmaWindow w, boolean exit){
        curent=null;
        w.dispose();
        if (!exit){
            SwingUtilities.invokeLater(new Runnable(){
                public void run() {
                    LoginWindow lw=new LoginWindow("Login Transportus", FirmaCtrl.this);
                    lw.setSize(250,200);
                    lw.setLocation(300,100);
                    lw.setVisible(true);
                }
            });
        }
    }

  

  
    public RuteTableModel getRuteTableModel(){
        return ruteTM;
    }

    public void cautaRute(String text) {
        if (text==null){
            System.out.println("[FirmaCtrl: cautaRute ] text null");
            text="";
        }
        Ruta[] rez=firma.getDestinationsFromSt(text);
        ruteTM.setRute(rez);
        dateCBM.removeAllElements();
        hoursCBM.removeAllElements();
    }

    public void rutaSelectata(int index) {
        Ruta rutaCurenta=ruteTM.get(index);
        String[] dates=firma.getDatesForRuta(rutaCurenta);
        dateCBM.removeAllElements();
        for(String data:dates)
            dateCBM.addElement(data);

    }

    public ComboBoxModel getDatesComboBoxModel(){
        return dateCBM;
    }
    public ComboBoxModel getHoursComboBoxModel(){
        return hoursCBM;
    }
  
    public void dataSelectata(int rutaIndex, int dataIndex) {
        Ruta rutaCurenta=ruteTM.get(rutaIndex);
         String dataCurenta=(String)dateCBM.getElementAt(dataIndex);
        String[] hours=firma.getHoursForRuta(rutaCurenta,dataCurenta);
        hoursCBM.removeAllElements();
        for(String hour:hours)
            hoursCBM.addElement(hour);
    }

    public void rezervaLocuri(int indexRuta, int indexData, int indexOra, String numeClie, int nrL) throws FirmaException {
        Ruta ruta=ruteTM.get(indexRuta);
        String data=(String)dateCBM.getElementAt(indexData);
        String ora=(String)hoursCBM.getElementAt(indexOra);
        firma.rezervaLoc(ruta,data,ora,numeClie, nrL);
    }

    public String salveazaListaCursa(int indexRuta, int indexData, int indexOra) throws FirmaException {
         Ruta ruta=ruteTM.get(indexRuta);
        String data=(String)dateCBM.getElementAt(indexData);
        String ora=(String)hoursCBM.getElementAt(indexOra);
        return firma.salveazaListaCursa(ruta,data,ora);
    }

    public int getLocuriDisponibile(int indexRuta, int indexData, int indexOra) {
        Ruta ruta=ruteTM.get(indexRuta);
        String data=(String)dateCBM.getElementAt(indexData);
        String ora=(String)hoursCBM.getElementAt(indexOra);
        return firma.getLocuriDisponibile(ruta,data,ora);

    }

    public void stergeCampuri() {
         ruteTM.clear();
        dateCBM.removeAllElements();
        hoursCBM.removeAllElements();
    }
}
