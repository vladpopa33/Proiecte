package firma.model;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 16, 2011
 * Time: 11:56:31 PM
 */
public class Cursa {
    private int id;
    private Ruta ruta;
    private String data, ora;
    private int nrLocuri, nrLocuriRezervate;


    public Cursa(int id, Ruta ruta, String data, String ora, int nrL) {
        this.id = id;
        this.ruta = ruta;
        this.data = data;
        this.ora = ora;
        nrLocuri=nrL;
        nrLocuriRezervate =0;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void adaugaLocRezervat(int nrLocuri){
        nrLocuriRezervate+=nrLocuri;

    }
    public int getNrLocuriDisponibile(){
        return nrLocuri-nrLocuriRezervate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cursa cursa = (Cursa) o;

        if (id != cursa.id) return false;
        if (!data.equals(cursa.data)) return false;
        if (!ora.equals(cursa.ora)) return false;
        if (!ruta.equals(cursa.ruta)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + ruta.hashCode();
        result = 31 * result + data.hashCode();
        result = 31 * result + ora.hashCode();
        return result;
    }

    public int getId() {

        return id;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public String getData() {
        return data;
    }

    public String getOra() {
        return ora;
    }

    @Override
    public String toString() {
        return ruta+" "+data+" "+ora+" "+nrLocuri;
    }
}
