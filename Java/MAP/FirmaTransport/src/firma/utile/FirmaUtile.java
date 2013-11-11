package firma.utile;

import firma.FirmaException;
import firma.model.Cursa;
import firma.model.Rezervare;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 20, 2011
 * Time: 1:44:08 AM
 */
public class FirmaUtile {
    public static String salveazaLista(Cursa cursa, Rezervare[] lrezervari) throws FirmaException{
        System.out.println("Se salveaza lista rezervari...");
        PrintWriter pw=null;
        String numefis=getNumeFisier(cursa);
        try{
            pw=new PrintWriter(numefis);
            pw.printf("Tabel rezervari pentru cursa %s -> %s \n",cursa.getRuta().getPlecare(),cursa.getRuta().getDestinatie() );
            pw.printf("din data %s cu plecare la ora %s\n",cursa.getData(),cursa.getOra());
            pw.println();
            String linie=getLinie('-',50);
            int nrCurent=0;
            for(Rezervare rezer:lrezervari){
                for(int i=0;i<rezer.getNrLocuri();i++){
                    pw.println(linie);
                    pw.printf("| %3d | %-40s |\n", (++nrCurent), rezer.getNumeClient());
                }
            }
            for(; nrCurent<cursa.getNrLocuri();){
                pw.println(linie);
                pw.printf("| %3d | %-40s |\n", (++nrCurent), "");
            }
            pw.println(linie);
            return numefis;
        } catch (FileNotFoundException e) {
            throw new FirmaException("Lista rezervarilor nu a putut fi salvata. "+e.getMessage());
        }finally {
            if (pw!=null){
                pw.close();
            }
        }
    }

    private static String getNumeFisier(Cursa cursa){
        return cursa.getRuta().getPlecare()+cursa.getRuta().getDestinatie()+".txt";
       
    }

    private static String getLinie(char c, int lung){
        char[] sir=new char[lung];
        Arrays.fill(sir,c);
        return new String(sir);
    }
}
