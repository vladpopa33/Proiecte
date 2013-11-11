package firma;

import firma.gui.LoginWindow;
import firma.model.FirmaTransport;
import firma.repository.AngajatiRepository;
import firma.repository.RezervariRepository;
import firma.repository.CurseRepository;
import firma.repository.mock.AngajatiRepositoryMock;
import firma.repository.mock.RuteRepositoryMock;
import firma.repository.mock.CurseRepositoryMock;
import firma.repository.mock.RezervariRepositoryMock;
import firma.ctrl.FirmaCtrl;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 17, 2011
 * Time: 12:46:55 AM
 */
public class StartApp {
    public static void main(String[] args) {
        AngajatiRepository angajati=new AngajatiRepositoryMock();
        RuteRepositoryMock rute=new RuteRepositoryMock();
        CurseRepository curse=new CurseRepositoryMock(rute);
        RezervariRepository rezervari=new RezervariRepositoryMock();
        FirmaTransport firma=new FirmaTransport(angajati, rute,curse, rezervari);
        final FirmaCtrl ctrl=new FirmaCtrl(firma);
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                LoginWindow lw=new LoginWindow("Login Transportus", ctrl);
                lw.setSize(250,200);
                lw.setLocation(300,100);
                lw.setVisible(true);
            }
        });
    }
}
