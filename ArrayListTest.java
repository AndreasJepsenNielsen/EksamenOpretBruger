import java.util.Random;
import java.util.Scanner;

public class ArrayListTest
{
    private static Random rand = new Random();
    private static MedlemsListe medlemsListe;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        medlemsListe = new MedlemsListe();

        for (int i = 0; i < 10; i++) {
            Medlem medlem = new Medlem(input.nextLine());
            medlem.tidsListe.TilføjTid(rand.nextInt(1) + 1, medlem.getNavn());

            medlemsListe.medlemsListe.add(medlem);
        }

        medlemsListe.DisplayTider();
    }

}


