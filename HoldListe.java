import java.util.Scanner;

public class HoldListe
{
    static Hold rød = new Hold("rød");
    static Hold blå = new Hold("blå");

    static Scanner input = new Scanner(System.in);

    public static MedlemsListe medlemsListe = new MedlemsListe();

    public static void redigerHold()
    {
        System.out.println("Hold rød eller hold blå?");

        String choice2 = input.nextLine();

        if (choice2.equalsIgnoreCase("rød"))
        {
            rød.redigerHold(medlemsListe);
        }
        else if (choice2.equalsIgnoreCase("blå"))
        {
            blå.redigerHold(medlemsListe);
        }
    }

    public void visHold()
    {
        System.out.print(rød);
        System.out.println(blå);
    }
}
