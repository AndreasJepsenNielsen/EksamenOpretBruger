import java.io.*;
import java.util.Scanner;

public class KørDelfin
{
    static Scanner input = new Scanner(System.in);
    static HoldListe holdListe = new HoldListe();




    public static void main(String[] args)
    {
        menu();
    }

    public static void menu()
    {
        /* et lille forsøg på at sørge for at den laver en fil første gang
        try {
            File file = new File("medlemmer.txt");
            file.createNewFile();

        }
        catch (IOException eIOE)
        {
            eIOE.printStackTrace();
        }
        */


        holdListe.setMedlemsListe(readFile());

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
                    "7. Luk og gem"
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
                    createStream(holdListe.medlemsListe);
                    System.exit(0);
                    break;
            }
        }
    }

    public static void createStream(MedlemsListe medlemmer)
    {
        try
        {
            File file = new File("medlemmer.txt");

            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(medlemmer);

            oos.close();
        }
        catch(FileNotFoundException eFNFE)
        {

            System.out.println("Error eFNFE");
            eFNFE.printStackTrace();
        }
        catch (IOException eIOE)
        {
            System.out.println("Error eIOE");
            eIOE.printStackTrace();
        }
    }

    public static MedlemsListe readFile()
    {
        MedlemsListe medlemsListe = new MedlemsListe();
        try {


            File file = new File("medlemmer.txt");

            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            medlemsListe = (MedlemsListe) ois.readObject();

            ois.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return medlemsListe;
    }


}
