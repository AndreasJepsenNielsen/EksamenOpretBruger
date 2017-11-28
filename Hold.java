import java.util.ArrayList;
import java.util.Scanner;

public class Hold {

    String holdNavn;
    ArrayList<Medlem> holdListe;
    private Scanner input = new Scanner(System.in);

    public Hold(String holdNavn)
    {
        this.holdNavn = holdNavn;
        this.holdListe = new ArrayList<>();
    }

    public void redigerHold(MedlemsListe medlemsListe)
    {
        System.out.println("1. Tilføj medlem\n" +
                            "2. Slet bruger\n" +
                            "3. Tilbage");
        String choice = input.nextLine();
        switch (choice)
        {
            case "1":
                tilføjMedlem(medlemsListe.findBruger());
                break;
            case "2":
                fjernMedlem(medlemsListe.findBruger());
                break;
            default:
                break;
        }
    }

    public void tilføjMedlem(Medlem medlem)
    {
        this.holdListe.add(medlem);
        System.out.println(medlem.getNavn() + " er blevet tilmeldt hold " + this.holdNavn);
    }


    public void fjernMedlem(Medlem medlem)
    {
        this.holdListe.remove(medlem);
        System.out.println(medlem.getNavn() + " er nu fjernet fra hold" + this.holdNavn);
    }



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
