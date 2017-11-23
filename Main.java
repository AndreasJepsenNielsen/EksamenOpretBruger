import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);


        MedlemsListe medlemsListe = new MedlemsListe();



        System.out.println("Velkommen til Delfinen, vælg hvad du vil gøre ud fra de valgmuligheder i menuen");



        while(true)
        {
            System.out.println("Menu:\n" +
                "1. Opret bruger");

            String choice = input.next();

            switch (choice)
            {
                case "1":
                    medlemsListe.opretBruger();
                    break;
                case "2":
                    System.out.println(medlemsListe);
                    break;
                default:
                    break;
            }
        }

    }

}
