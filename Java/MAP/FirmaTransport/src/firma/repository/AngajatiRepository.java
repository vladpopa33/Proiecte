package firma.repository;

import firma.model.Angajat;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 16, 2011
 * Time: 11:54:27 PM
 */
public interface AngajatiRepository {
     Angajat find(String id, String passwd);
}
