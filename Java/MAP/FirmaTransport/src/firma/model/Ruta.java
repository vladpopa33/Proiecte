package firma.model;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 16, 2011
 * Time: 11:56:16 PM
 */
public class Ruta implements Comparable<Ruta>{
    private int id;
    private String plecare, destinatie;

    public Ruta(int id, String plecare, String destinatie) {
        this.id = id;
        this.plecare = plecare;
        this.destinatie = destinatie;
    }

    public int getId() {
        return id;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public String getPlecare() {
        return plecare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ruta ruta = (Ruta) o;

        if (id != ruta.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (plecare != null ? plecare.hashCode() : 0);
        result = 31 * result + (destinatie != null ? destinatie.hashCode() : 0);
        return result;
    }

    public int compareTo(Ruta o) {
        if (plecare.equals(o.plecare))
            return destinatie.compareTo(o.destinatie);
        return plecare.compareTo(o.plecare);
    }

    @Override
    public String toString() {
        return "["+plecare+" "+destinatie+"]";
    }
}
