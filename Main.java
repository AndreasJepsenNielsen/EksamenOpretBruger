import java.util.Scanner;

public class Main
{
    Scanner input;

    public static void main(String[] args)
    {



        MedlemsListe medlemsListe = new MedlemsListe();

        medlemsListe.opretBruger();

        System.out.println(medlemsListe.getMedlemsListe().get(0).getKontingentType());

        System.out.println("Velkommen til Delfinen, vælg hvad du vil gøre ud fra de valgmuligheder i menuen");

        System.out.println("Menu:\n " +
                "1. Opret bruger");




    }
}
