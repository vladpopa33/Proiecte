package firma.repository;

import firma.model.Cursa;
import firma.model.Ruta;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 16, 2011
 * Time: 11:57:00 PM
 */
public interface CurseRepository {
     List<Cursa> findCurseFor(Ruta ruta);
     String[] findDatesFor(Ruta ruta);
     String[] findHoursFor(Ruta ruta, String data);
     Cursa findCursa(Ruta ruta, String data, String ora);
}
