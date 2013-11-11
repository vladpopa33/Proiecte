import java.io.BufferedReader;
import java.io.IOException;
//import java.io.PrintStream;

public class Start
{
  public static void main(String[] args)
  {
    CDList c = new CDList();
    String op = "";
    BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
    c.ReadFromFile("Date.txt");
    while (op != "4") {
      System.out.print("Alegeti una din urmatoarele optiuni:\n   1)Afiseaza CD-uri\n   2)Adauga CD\n   3)Cauta CD\n   4)Iesiti \nAlegeti una din variantele de mai sus: ");
      try {
          op = reader.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        } 
      if ((!op.equals("1")) && (!op.equals("2")) && (!op.equals("3")) && (!op.equals("4")))
        System.out.println("Optiune inexistenta"); 
      if (op.equals("1"))
      {
        String m = "";
        int n = 0;
        System.out.print("Doriti sortare dupa nume?\n1.Da \n2.Nu\n Alegeti optiunea:");
          try {
            m = reader.readLine();
          } catch (IOException e) {
            e.printStackTrace();
          } 
          if(m.equals("1"))
        	  n=n+100;
            
          System.out.print("Doriti sortare dupa tip?\n1.Da \n2.Nu\n Alegeti optiunea:");
            try {
              m = reader.readLine();
            } catch (IOException e) {
              e.printStackTrace();
            } 
            if(m.equals("1"))
          	  n=n+10;
     
            System.out.print("Doriti sortare dupa descriere?\n1.Da \n2.Nu\n Alegeti optiunea:");
              try {
                m = reader.readLine();
              } catch (IOException e) {
                e.printStackTrace();
              } 
            if(m.equals("1"))
            	  n=n+1;
              c.Sort(n);
              CD nou = new CD();
              int i = c.getlength();
              System.out.println("\n   Nume\t|   Tip\t|   Descriere");
              for (int j = 0; j < i; j++) {
                nou = c.getCD(j);
                System.out.println(nou.nume + "  | " + nou.tip + " | " + nou.info);
              } 
        }  
      if (op.equals("2")) {
        int ok = 0;
        String m = "";
        CD nou = new CD();
        while (ok == 0) {
          ok = 1;
          System.out.print("Cititi numele CD-ului:");
          try {
            m = reader.readLine();
          } catch (IOException e) {
            e.printStackTrace();
          } 
          
         nou.nume = m;
          if (m.equals(""))
            ok = 0; 
          System.out.print("Cititi tipul CD-ului:");
          try {
            m = reader.readLine();
          } catch (IOException e) {
            e.printStackTrace();
          } 
          nou.tip = m;
          if ((m.equals("")) || ((!m.equals("soft")) && (!m.equals("muzica")) && (!m.equals("joc")) && (!m.equals("filme"))))
            ok = 0; 
          System.out.print("Cititi descrierea CD-ului:");
          try {
            m = reader.readLine();
          } catch (IOException e) {
            e.printStackTrace();
          } 
         nou.info = m;
          if (m.equals(""))
            ok = 0; 
          if (ok == 0) {
            System.out.println("EROARE. Campurile nu trebuie sa fie goale, iar tipul trebuie sa fie unul dintre urmatoarele:soft,muzica,joc,filme!");
          } else {
            c.AddCD(nou);
            System.out.println("CD adaugat cu succes");
          } 
        } 
        c.WriteToFile("date.txt");
      } 
      if (op.equals("3")) {
        String m = "";
        CD nou = new CD();
        CDList aux = new CDList();
        System.out.println("Completati cu atentie campurile de mai jos.Daca nu aveti toate informatiile despre CD apasati ENTER.");
        System.out.print("Cititi numele CD-ului:");
        try {
          m = reader.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        } 
        nou.nume = m;
        System.out.print("Cititi tipul CD-ului:");
        try {
          m = reader.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        } 
        nou.tip = m;
        System.out.print("Cititi descrierea CD-ului:");
        try {
          m = reader.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        } 
        nou.info = m;
        aux = c.SearchCD(nou);
        System.out.println("\n   Nume   Tip   Descriere");
        for (int i = 0; i < aux.getlength(); i++) {
          nou = aux.getCD(i);
          System.out.println(nou.nume + "   " + nou.tip + "   " + nou.info);
        } 
        if (aux.getlength() > 0) {
          System.out.println("\n Au fost gasite " + aux.getlength() + " rezultate conform criteriilor");
        } else
          System.out.println("\n Nu s-a gasit niciun rezultat"); 
      } 
      if (op.equals("4")) {
    	System.out.println("Ati ales sa iesiti! La revedere!");
      	System.exit(0);
      }
      c.WriteToFile("Date.txt");
    } 
    
    } 
} 