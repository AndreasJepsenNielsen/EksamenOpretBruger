import java.util.ArrayList;
import java.util.Scanner;

public class MedlemsListe {
    private ArrayList<Medlem> medlemsListe;
    private Scanner input = new Scanner(System.in);

    public MedlemsListe() {
        this.medlemsListe = new ArrayList<>();
    }


    public void opretBruger() {
        //Husk kommentarer til alt
        this.medlemsListe.add(
                new Medlem(
                    indtastNavn(),
                    indtastTelefonnummer(),
                    indtastAdresse(),
                    indtastEmail(),
                    indtastAlder()
                )
        );

        System.out.println("Bruger oprettet!\n");
    }

    //METHODS
    public String indtastNavn() {
        System.out.println("Navn");
        return input.nextLine();
    }

    public String indtastTelefonnummer() {
        System.out.println("Telefonnummer");
        return input.nextLine();
    }

    public String indtastAdresse() {
        System.out.println("Adresse");
        return input.nextLine();
    }

    public String indtastEmail() {
        System.out.println("Email");
        return input.nextLine();
    }

    public String indtastAlder() {
        System.out.println("Alder");
        return input.nextLine();
    }


    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.medlemsListe.size(); i++) {
            result += this.medlemsListe.get(i);
        }
        return result;
    }


}
