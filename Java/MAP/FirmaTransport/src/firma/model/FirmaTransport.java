package firma.model;

import firma.FirmaException;
import firma.utile.FirmaUtile;
import firma.repository.*;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 17, 2011
 * Time: 12:41:42 AM
 */
public class FirmaTransport {
    private AngajatiRepository angajati;
    private RuteRepository rute;
    private CurseRepository curse;
    private RezervariRepository rezervari;

    public FirmaTransport(AngajatiRepository angajati, RuteRepository rute, CurseRepository curse, RezervariRepository rezervari) {
        this.angajati = angajati;
        this.rute=rute;
        this.curse=curse;
        this.rezervari=rezervari;
    }

    public Angajat login(String userId, String parola) throws FirmaException {
        Angajat angLogat =angajati.find(userId,parola);
        if (angLogat==null)
            throw new FirmaException("Nu a fost gasit un angajat cu datele introduse");
        return angLogat;
        
    }

  
    public Ruta[] getDestinationsFromSt(String text){
        return rute.findFromStartsWith(text);
    }

    public String[] getDatesForRuta(Ruta ruta) {
        return curse.findDatesFor(ruta);
    }

    public String[] getHoursForRuta(Ruta ruta, String data)  {

        return curse.findHoursFor(ruta,data);
        
    }

    public void rezervaLoc(Ruta ruta, String data, String ora, String numeClie, int nrL) throws FirmaException {
        Cursa cursa=curse.findCursa(ruta,data,ora);
        if (cursa.getNrLocuriDisponibile()<nrL)
           throw new FirmaException("Mai sunt doar "+cursa.getNrLocuriDisponibile()+" locuri disponibile!");
        Rezervare rezervare=new Rezervare(cursa,numeClie, nrL);
        cursa.adaugaLocRezervat(nrL);
        rezervari.add(rezervare);

    }

    public String salveazaListaCursa(Ruta ruta, String data, String ora) throws FirmaException {
        Cursa cursa=curse.findCursa(ruta,data,ora);
        Rezervare[] lrezervari=rezervari.getRezervari(cursa);
        Arrays.sort(lrezervari, new Comparator<Rezervare>(){
            public int compare(Rezervare o1, Rezervare o2) {
                if (o1.getId()<o2.getId())
                    return -1;
                if (o1.getId()>o2.getId())
                    return 1;
                return 0;
            }
        });
        return FirmaUtile.salveazaLista(cursa, lrezervari);
    }

    public int getLocuriDisponibile(Ruta ruta, String data, String ora) {
        Cursa cursa=curse.findCursa(ruta,data,ora);
        return cursa.getNrLocuriDisponibile();

    }
}
