import com.sun.org.apache.regexp.internal.RE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ResultatListe implements Serializable{
    ArrayList<Resultat> resultatListe;
    static Scanner input = new Scanner(System.in);

    public ResultatListe() {
        this.resultatListe = new ArrayList<>();
    }

    public void tilføjResultat()
    {
        this.resultatListe.add(
                new Resultat
                (
                        indtastTid(),
                        indtastNavn(),
                        indtastDato(),
                        indtastSvømmeDiscipliner()
                ));
    }

    public int indtastTid()
    {
        System.out.println("Indtast tid");
        int sek = Integer.parseInt(input.nextLine());
        return sek;
    }

    public String indtastNavn()
    {
        System.out.println("Indtast navn");
        String navn = input.nextLine();
        return navn;
    }

    public String indtastDato()
    {
        System.out.println("Indtast dato");
        String dato = input.nextLine();
        return dato;
    }

    public SvømmeDiscipliner indtastSvømmeDiscipliner()
    {
        System.out.println("Indtast svømmedisciplin");
        SvømmeDiscipliner svømmeDiscipliner = SvømmeDiscipliner.valueOf(input.nextLine().toUpperCase());
        return svømmeDiscipliner;
    }

    public static int compare(Object o1, Object o2) {
        Integer i1 = ((Resultat) o1).getSek();
        Integer i2 = ((Resultat) o2).getSek();

        int sComp = i1.compareTo(i2);

        if (sComp != 0) {
            return sComp;
        } else {
            String s1 = ((Resultat) o1).getNavn();
            String s2 = ((Resultat) o2).getNavn();
            return s1.compareTo(s2);
        }
    }
}
