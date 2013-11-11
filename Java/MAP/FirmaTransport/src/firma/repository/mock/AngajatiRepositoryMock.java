package firma.repository.mock;

import firma.repository.AngajatiRepository;
import firma.model.Angajat;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 17, 2011
 * Time: 12:08:27 AM
 */
public class AngajatiRepositoryMock implements AngajatiRepository {
    private Map<String, Angajat>  angajati;

    public AngajatiRepositoryMock() {
        angajati=new TreeMap<String, Angajat>();
        angajati.put("ana", new Angajat("ana", "Popescu Ana","ana"));
        angajati.put("ion", new Angajat("ion", "Vasilescu Ion", "ion"));
    }

    public Angajat find(String id, String passwd) {
        Angajat ang=angajati.get(id);
        if ((ang!=null) && (ang.getPasswd().equals(passwd)))
            return ang;
        return null;
    }
}
