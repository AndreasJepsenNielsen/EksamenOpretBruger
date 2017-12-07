import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Hold implements Serializable {
    //Fields:
    String holdNavn;
    ArrayList<Medlem> holdListe;
    static private Scanner input = new Scanner(System.in);

    //Constructor
    public Hold(String holdNavn)
    {
        this.holdNavn = holdNavn;
        this.holdListe = new ArrayList<>();
    }

    //Metode som giver formanden mulighed for at redigere et hold, med en switch case og scanner input
    public void redigerHold(MedlemsListe medlemsListe)
    {
        System.out.println("1. Tilføj medlem\n" +
                            "2. Slet medlem\n" +
                            "3. Tilbage");
        String choice = input.nextLine();
        switch (choice)
        {
            case "1":
                tilføjKonkurrenceSvømmer(medlemsListe.findMedlem());
                break;
            case "2":
                fjernKonkurrenceSvømmer(medlemsListe.findMedlem());
                break;
            default:
                break;
        }
    }

    //Metode som tilføjer en konkurrencesvømmer til et hold. Metoden tager et medlem som parameter.
    public void tilføjKonkurrenceSvømmer(Medlem medlem)
    {
        this.holdListe.add(medlem);
        System.out.println(medlem.getNavn() + " er blevet tilmeldt hold " + this.holdNavn);
    }

    //Metode som fjerner en konkurrencesvømmer fra et hold. Metoder tager et medlem som parameter.
    public void fjernKonkurrenceSvømmer(Medlem medlem)
    {
        this.holdListe.remove(medlem);
        System.out.println(medlem.getNavn() + " er nu fjernet fra hold " + this.holdNavn);
    }

    //En toString metode, som bruger et enhanced forloop til at tage alle medlemmer ud af holdlisten, og lister dem under hinanden
    @Override
    public String toString()
    {
        String string = "";

        System.out.println("\nHold " + this.holdNavn + ":");

        for (Medlem medlem : this.holdListe)
        {
            string += medlem.getNavn() + "\n";
        }
        return string;
    }
}
