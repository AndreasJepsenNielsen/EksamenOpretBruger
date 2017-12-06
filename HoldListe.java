import java.io.Serializable;
import java.util.Scanner;

public class HoldListe implements Serializable
{
    //Fields:
    static Scanner input = new Scanner(System.in);
    Hold junior = new Hold("junior");
    Hold senior = new Hold("senior");
    MedlemsListe medlemsListe;


    //En metode som sætter medlemslisten
    public void setMedlemsListe(MedlemsListe medlemsListe) {
        this.medlemsListe = medlemsListe;
    }

    //En metode som
    public void redigerHold()
    {
        System.out.println("Hold junior eller hold senior?");

        String choice2 = input.nextLine();

        if (choice2.equalsIgnoreCase("junior"))
        {
            System.out.println("Hold junior er valgt");
            junior.redigerHold(medlemsListe);
        }
        else if (choice2.equalsIgnoreCase("senior"))
        {
            System.out.println("Hold senior er valgt");
            senior.redigerHold(medlemsListe);
        }
    }

    //En metode som viser hold junior og hold senior
    public void visHold()
    {
        System.out.print(junior);
        System.out.println(senior);

    }
}
