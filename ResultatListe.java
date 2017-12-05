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
        System.out.println("1. Træningsresultat\n" +
                "2. Stævneresultat");

        String choice = input.nextLine();

        if (choice.equals("1"))
        {
        this.resultatListe.add(
                new Resultat
                    (
                        indtastTid(),
                        indtastNavn(),
                        indtastDato(),
                        indtastSvømmeDiscipliner()
                    ));

        } else if (choice.equals("2")) {
            this.resultatListe.add(
                new StævneResultat
                    (
                        indtastTid(),
                        indtastNavn(),
                        indtastDato(),
                        indtastSvømmeDiscipliner(),
                        indtastStævne(),
                        indtastPlacering()
                    ));
        }


        System.out.println("Resultat tilføjet\n");
    }

    private String indtastPlacering()
    {
        System.out.println("Indtast Placering");
        String placering = input.nextLine();
        return placering;
    }

    private String indtastStævne()
    {
        System.out.println("Indtast stævne");
        String stævne = input.nextLine();
        return stævne;
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

    public static int sammenlign(Object o1, Object o2)
    {
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
