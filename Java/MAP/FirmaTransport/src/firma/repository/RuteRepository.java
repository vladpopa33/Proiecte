package firma.repository;

import firma.model.Ruta;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 16, 2011
 * Time: 11:56:05 PM
 */
public interface RuteRepository {
    Ruta[] findAll();
    Ruta[] findFromStartsWith(String text);
}
