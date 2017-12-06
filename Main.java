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
                    "1. Opret bruger\n" +
                    "2. Vis brugere\n" +
                    "3. Rediger bruger\n" +
                    "4. Slet bruger\n" +
                    "5. Luk system"
            );

            String choice = input.next();

            switch (choice)
            {
                case "1":
                    medlemsListe.opretMedlem();
                    break;
                case "2":
                    System.out.println(medlemsListe);
                    break;
                case "3":
                    medlemsListe.redigerMedlem();
                    break;
                case "4":
                    medlemsListe.sletMedlem();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }


    }

}
