import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ResultatListe implements Serializable{
    //Fields
    ArrayList<Resultat> resultatListe;
    static Scanner input = new Scanner(System.in);

    //Constructor som initialisere arraylisten resultatliste
    public ResultatListe() {
        this.resultatListe = new ArrayList<>();
    }

    //Metode som tilføjer et resultat til et medlem, som tager imod et scanner input
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

    //Metode hvor svømmetræneren skal skrive placeringen som konkurrencesvømmeren fik til stævnet, som tager imod et scanner input
    private String indtastPlacering()
    {
        System.out.println("Indtast Placering");
        String placering = input.nextLine();
        return placering;
    }

    //Metode hvor svømmetræneren skal skrive navet på stævnet som konkurrencesvømmeren deltog i, som tager imod et scanner input
    private String indtastStævne()
    {
        System.out.println("Indtast stævne");
        String stævne = input.nextLine();
        return stævne;
    }

    //Metode hvor svømmetræneren skal skrive tiden som konkurrencesvømmeren fik til stævnet, som tager imod et scanner input
    public int indtastTid()
    {
        System.out.println("Indtast tid");
        int sek = Integer.parseInt(input.nextLine());
        return sek;
    }

    //Metode hvor svømmetræneren skal navnet på konkurrencesvømmeren som deltog i stævnet, som tager imod et scanner input
    public String indtastNavn()
    {
        System.out.println("Indtast navn");
        String navn = input.nextLine();
        return navn;
    }

    //Metode hvor svømmetræneren skal skrive datoen på stævnet som konkurrencesvømmeren deltog i, som tager imod et scanner input
    public String indtastDato()
    {
        System.out.println("Indtast dato");
        String dato = input.nextLine();
        return dato;
    }

    //Metode hvor svømmetræneren skal skrive svømmedisciplinen som konkurrencesvømmeren deltog i, som tager imod et scanner input
    public SvømmeDiscipliner indtastSvømmeDiscipliner()
    {
        System.out.println("Indtast svømmedisciplin");
        SvømmeDiscipliner svømmeDiscipliner = SvømmeDiscipliner.valueOf(input.nextLine().toUpperCase());
        return svømmeDiscipliner;
    }
}
