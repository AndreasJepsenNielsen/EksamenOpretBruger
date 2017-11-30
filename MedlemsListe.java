import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class MedlemsListe implements Serializable{
    private ArrayList<Medlem> medlemsListe;
    private static Scanner input = new Scanner(System.in);
    private CreateFile x;
    private ReadFile y;

    public MedlemsListe()

    {
        this.medlemsListe = new ArrayList<>();

    }

    public void opretBruger() {
        //Husk kommentarer til alt
        Medlem medlem =

                new Medlem
                (
                    indtastNavn(),
                    indtastTelefonnummer(),
                    indtastAdresse(),
                    indtastEmail(),
                    indtastAlder(),
                    indtastSvømmeDisciplin(),
                    indtastKontingentType(),
                    erKonkurrenceSvømmer()
                );

                this.medlemsListe.add(medlem);

        System.out.println("Bruger oprettet!\n");
    }

    private Boolean erKonkurrenceSvømmer()
    {
        System.out.println("Er det nye medlem en konkurrencesvømmer?");
        System.out.println("J/N");
        if (input.nextLine().equalsIgnoreCase("J"))
        {
            return true;
        } else {
            return false;
        }

    }

    public void tilføjBruger(Medlem medlem)
    {
        this.medlemsListe.add(medlem);
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

    public SvømmeDiscipliner indtastSvømmeDisciplin() {
        System.out.println("Svømmedisciplin");
        return SvømmeDiscipliner.valueOf(input.nextLine().toUpperCase());
    }

    public KontingentType indtastKontingentType() {
        System.out.println("KontingentType: ");
        return KontingentType.valueOf(input.nextLine().toUpperCase());
    }



    public Medlem findBruger(){
        System.out.println("Indtast navn, adresse eller telefonnumer");
        String choice = input.nextLine();
        for(Medlem find : medlemsListe)
        {
            if(choice.equalsIgnoreCase(find.getNavn()) || choice.equalsIgnoreCase(find.getAdresse()) || choice.equalsIgnoreCase(find.getTelefonNummer())){
                return  find;
            }
        }
       return null;
    }

    public void redigerBruger(){
        Medlem bruger = findBruger();
        System.out.println("Hvad skal ændres?\n" +
                "1. Navn\n" +
                "2. Telefonnumer\n" +
                "3. Adresse\n" +
                "4. Email\n" +
                "5. Alder\n" +
                "6. Svømmedisciplin\n" +
                "7. Kontingenttype");
        String choice = input.nextLine();

        switch (choice)
        {
            case "1":
                System.out.println("Indtast nyt navn: ");
                bruger.setNavn(input.nextLine());
                break;
            case "2":
                System.out.println("Indtast nyt telefonnummer: ");
                bruger.setTelefonNummer(input.nextLine());
                break;
            case "3":
                System.out.println("Indtast ny adresse: ");
                bruger.setAdresse(input.nextLine());
                break;
            case "4":
                System.out.println("Indtast ny email: ");
                bruger.setEmail(input.nextLine());
                break;
            case "5":
                System.out.println("Indtast ny alder: ");
                bruger.setAlder(input.nextLine());
                break;
            case "6":
                System.out.println("Indtast ny svømmedisciplin: ");
                bruger.setSvømmeDiscipliner(SvømmeDiscipliner.valueOf(input.nextLine().toUpperCase()));
                break;
            case "7":
                System.out.println("Indtast ny kontingenttype: ");
                bruger.setKontingentType(KontingentType.valueOf(input.nextLine().toUpperCase()));
                break;
            default:
                break;

        }
        System.out.println("Informationen er ændret\n");
    }

    public void sletBruger(){
        Medlem bruger = findBruger();
        System.out.println("Er du sikker på at du vil slette brugeren: "+ bruger.getNavn() + " ? J/N");
        String choice = input.nextLine();

        if(choice.equalsIgnoreCase("J")) //Denne har vi fundet på oracle (equalsIgnoreCase). Link: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
        {
            medlemsListe.remove(bruger);
            System.out.println("Bruger slettet");
        }
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
