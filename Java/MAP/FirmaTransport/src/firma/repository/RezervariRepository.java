package firma.repository;

import firma.model.Rezervare;
import firma.model.Cursa;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 16, 2011
 * Time: 11:57:30 PM
 */
public interface RezervariRepository {
    void add(Rezervare rezervare);
    Rezervare[] getRezervari(Cursa cursa);
}
