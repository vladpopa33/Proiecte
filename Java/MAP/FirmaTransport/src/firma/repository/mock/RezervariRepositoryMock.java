package firma.repository.mock;

import firma.repository.RezervariRepository;
import firma.model.Rezervare;
import firma.model.Cursa;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 17, 2011
 * Time: 12:22:55 AM
 */
public class RezervariRepositoryMock implements RezervariRepository{
    private Map<Cursa, List<Rezervare>> rezervari;

    public RezervariRepositoryMock() {
        rezervari=new HashMap<Cursa, List<Rezervare>>();
    }

    public void add(Rezervare rezervare) {
        List<Rezervare> rezer=rezervari.get(rezervare.getCursa());
        if (rezer==null)
            rezer=new ArrayList<Rezervare>();
        rezer.add(rezervare);
        System.out.println("S-a adaugat rezervarea "+rezervare);
        rezervari.put(rezervare.getCursa(), rezer);

    }

    public Rezervare[] getRezervari(Cursa cursa) {
        List<Rezervare> lrezevari=rezervari.get(cursa);
        if (lrezevari==null)
            return new Rezervare[0];
        return lrezevari.toArray(new Rezervare[lrezevari.size()]);
    }
}
