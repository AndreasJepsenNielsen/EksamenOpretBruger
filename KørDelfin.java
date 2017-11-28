import java.util.Scanner;

public class KørDelfin
{
    static Scanner input = new Scanner(System.in);


    static HoldListe holdListe = new HoldListe();

    public static Medlem medlem = new Medlem("Jens", "75849384", "Nyvej", "wer@gorkei.com",
            "25", SvømmeDiscipliner.CRAWL, KontingentType.PASSIV, true);



    public static void main(String[] args)
    {

        holdListe.medlemsListe.tilføjBruger(medlem);
        menu();

    }

    public static void menu()
    {
        System.out.println("Velkommen til Delfinen, vælg hvad du vil gøre ud fra de valgmuligheder i menuen");

        while(true)
        {
            System.out.println("Menu:\n" +
                    "1. Opret bruger\n" +
                    "2. Vis brugere\n" +
                    "3. Rediger bruger\n" +
                    "4. Slet bruger\n" +
                    "5. Rediger hold\n"+
                    "6. Vis hold\n"+
                    "7. Luk system"
            );

            String choice = input.next();

            switch (choice)
            {
                case "1":
                    holdListe.medlemsListe.opretBruger();
                    break;
                case "2":
                    System.out.println(holdListe.medlemsListe);
                    break;
                case "3":
                    holdListe.medlemsListe.redigerBruger();
                    break;
                case "4":
                    holdListe.medlemsListe.sletBruger();
                    break;
                case "5":
                    holdListe.redigerHold();
                    break;
                case "6":
                    holdListe.visHold();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }

    }
}
