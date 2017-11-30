import java.util.Scanner;

public class HoldListe
{

    static Scanner input = new Scanner(System.in);
    Hold rød = new Hold("rød");
    Hold blå = new Hold("blå");
    MedlemsListe medlemsListe;


   


    public MedlemsListe getMedlemsListe() {
        return medlemsListe;
    }

    public void setMedlemsListe(MedlemsListe medlemsListe) {
        this.medlemsListe = medlemsListe;
    }

    public void redigerHold()
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
