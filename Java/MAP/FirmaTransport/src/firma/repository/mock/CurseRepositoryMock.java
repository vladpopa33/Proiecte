package firma.repository.mock;

import firma.repository.CurseRepository;
import firma.repository.RepositoryException;
import firma.model.Cursa;
import firma.model.Ruta;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 17, 2011
 * Time: 12:22:16 AM
 */
public class CurseRepositoryMock implements CurseRepository{
    private Map<Ruta, List<Cursa>> curse;
    private RuteRepositoryMock rute;
    private static int generateId=0;
    public CurseRepositoryMock(RuteRepositoryMock rute) {
        this.rute=rute;
        this.curse = new TreeMap<Ruta, List<Cursa>>();
        populate();
    }

    private void populate() {
        Ruta[] lrute=rute.findAll();
        for(Ruta ruta:lrute){
            List<Cursa> lcurse=new ArrayList<Cursa>();
            for(int i=0; i<Math.max(rand.nextInt(4),1);i++){
                Cursa c1=new Cursa(generateId++,ruta,date[rand.nextInt(4)],ore[rand.nextInt(4)], nrLocuri[rand.nextInt(3)]);
                System.out.println("Am adaugat cursa "+c1);
                lcurse.add(c1);
            }
            curse.put(ruta, lcurse);

        }
        
    }

    public List<Cursa> findCurseFor(Ruta ruta) {
         List<Cursa> lcurse=curse.get(ruta);
        if (lcurse==null)
            throw new RepositoryException("Nu exista curse pentru ruta "+ruta);
        return lcurse; 
    }

    public String[] findDatesFor(Ruta ruta) {
        Set<String> result=new TreeSet<String>();
        List<Cursa> lcurse=curse.get(ruta);
        if (lcurse==null)
            throw new RepositoryException("Nu exista curse pentru ruta "+ruta);
        for(Cursa curent:lcurse){
            System.out.println("Am gasit cursa"+curent);
            result.add(curent.getData());
        }
        return result.toArray(new String[result.size()]);
    }

    public String[] findHoursFor(Ruta ruta, String data) {
       Set<String> result=new TreeSet<String>();
        List<Cursa> lcurse=curse.get(ruta);
        if (lcurse==null)
            throw new RepositoryException("Nu exista curse pentru ruta "+ruta);
        for(Cursa curent:lcurse){
            if (curent.getData().equals(data))
                result.add(curent.getOra());
        }
        return result.toArray(new String[result.size()]);
    }

    public Cursa findCursa(Ruta ruta, String data, String ora) {
         List<Cursa> lcurse=curse.get(ruta);
        if (lcurse==null)
            throw new RepositoryException("Nu exista curse pentru ruta "+ruta);
        for(Cursa curent:lcurse){
            if (curent.getData().equals(data) && curent.getOra().equals(ora))
                return curent;

        }
        throw new RepositoryException("Nu exista cursa pentru "+ruta+" data "+data+ " ora "+ora);
    }

    private Random rand=new Random(47);
    private static final String[] date={"25/11/2011", "28/11/2011", "29/11/2011", "30/11/2011"};
    private static final String[] ore={"6:30","11:00", "15:00", "18:30"};
    private static final int[] nrLocuri={18, 40, 60};
}
