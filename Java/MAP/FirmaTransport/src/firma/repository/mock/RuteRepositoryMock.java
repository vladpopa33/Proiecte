package firma.repository.mock;

import firma.repository.RuteRepository;
import firma.repository.RepositoryException;
import firma.model.Ruta;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 17, 2011
 * Time: 12:21:14 AM
 */
public class RuteRepositoryMock implements RuteRepository{
    private Map<String, List<Ruta>> rute;

    public RuteRepositoryMock() {
        rute=new TreeMap<String, List<Ruta>>();
        populeaza();
    }

    public Ruta[] findAll() {
        List<Ruta> rez=new ArrayList<Ruta>();
        for(List<Ruta> lr:rute.values())
            rez.addAll(lr);
        return rez.toArray(new Ruta[rez.size()]);
    }

   

    public Ruta[] findFromStartsWith(String text){
        Set<String> froms=rute.keySet();
        List<Ruta> rez=new ArrayList<Ruta>();
        String textLow=text.toLowerCase();
        for(String from:froms){
            if (from.toLowerCase().startsWith(textLow))
                rez.addAll(rute.get(from));

        }
        return rez.toArray(new Ruta[rez.size()]);
    }
    /*public String[] findDestinationsFrom(String plecare){
        List<Ruta> rez=rute.get(plecare);
        if (rez==null)
            throw new RepositoryException("NU exista rute de la "+plecare);
        String[] dests=new String[rez.size()];
        int i=0;
        for(Ruta r:rez){
          dests[i++]=r.getDestinatie();
        }
        return dests;
    }*/
   
    private void populeaza(){
        List<Ruta> spre=new ArrayList<Ruta>();
        spre.add(new Ruta(1, "Cluj-Napoca","Sibiu"));
        spre.add(new Ruta(2, "Cluj-Napoca", "Oradea"));
        spre.add(new Ruta(4, "Cluj-Napoca", "Brasov"));
        rute.put("Cluj-Napoca", spre);

        spre=new ArrayList<Ruta>();
        spre.add(new Ruta(3, "Oradea", "Cluj-Napoca"));
        spre.add(new Ruta(6, "Oradea", "Arad"));
        rute.put("Oradea", spre);

        spre=new ArrayList<Ruta>();
        spre.add(new Ruta(5, "Brasov", "Cluj-Napoca"));
        spre.add(new Ruta(5, "Brasov", "Oradea"));
        rute.put("Brasov", spre);
    }
}
