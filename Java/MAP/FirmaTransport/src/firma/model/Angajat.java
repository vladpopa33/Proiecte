package firma.model;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 16, 2011
 * Time: 11:54:46 PM
 */
public class Angajat {
    private String userId, nume,passwd;
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPasswd(){
        return passwd;
    }
    public Angajat(String userId, String nume, String passwd) {

        this.userId = userId;
        this.passwd=passwd;
        this.nume = nume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Angajat angajat = (Angajat) o;

        if (userId != null ? !userId.equals(angajat.userId) : angajat.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }
}
