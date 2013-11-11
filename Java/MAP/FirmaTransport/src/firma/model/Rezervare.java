package firma.model;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 16, 2011
 * Time: 11:57:11 PM
 */
public class Rezervare {
    private static int generateId;
    private final int id=generateId++;
    private String numeClient;
    private Cursa cursa;
    private int nrLocuri;

    public Rezervare(Cursa cursa, String numeClient, int nrLocuri) {
        this.numeClient = numeClient;
        this.cursa = cursa;
       this.nrLocuri=nrLocuri;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public Cursa getCursa() {
        return cursa;
    }
    public int getNrLocuri(){
        return nrLocuri;
    }

    public int getId(){
        return id;
    }
    public String toString(){
        return ""+id+" "+numeClient+" "+nrLocuri;
    }
}
