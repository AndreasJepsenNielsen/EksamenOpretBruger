import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class MedlemsListe implements Serializable{
    private ArrayList<Medlem> medlemsListe;
    private static Scanner input = new Scanner(System.in);

    public MedlemsListe()
    {
        this.medlemsListe = new ArrayList<>();
    }

    public void opretMedlem() {
        //Husk kommentarer til alt

        if (erKonkurrenceSvømmer())
        {
            KonkurrenceSvømmer konkurrenceSvømmer =
                    new KonkurrenceSvømmer
                            (
                                    indtastNavn(),
                                    indtastTelefonnummer(),
                                    indtastAdresse(),
                                    indtastEmail(),
                                    indtastAlder(),
                                    indtastSvømmeDisciplin(),
                                    indtastKontingentType()
                            );

            this.medlemsListe.add(konkurrenceSvømmer);

        } else {
            Medlem medlem =

                    new Medlem
                            (
                                    indtastNavn(),
                                    indtastTelefonnummer(),
                                    indtastAdresse(),
                                    indtastEmail(),
                                    indtastAlder(),
                                    indtastSvømmeDisciplin(),
                                    indtastKontingentType()
                                    //erKonkurrenceSvømmer()
                            );

            this.medlemsListe.add(medlem);
        }

        System.out.println("Medlem oprettet!\n");
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

    public void tilføjMedlem(Medlem medlem)
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



    public Medlem findMedlem(){
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

    public void redigerMedlem(){
        Medlem medlem = findMedlem();
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
                medlem.setNavn(input.nextLine());
                break;
            case "2":
                System.out.println("Indtast nyt telefonnummer: ");
                medlem.setTelefonNummer(input.nextLine());
                break;
            case "3":
                System.out.println("Indtast ny adresse: ");
                medlem.setAdresse(input.nextLine());
                break;
            case "4":
                System.out.println("Indtast ny email: ");
                medlem.setEmail(input.nextLine());
                break;
            case "5":
                System.out.println("Indtast ny alder: ");
                medlem.setAlder(input.nextLine());
                break;
            case "6":
                System.out.println("Indtast ny svømmedisciplin: ");
                medlem.setSvømmeDiscipliner(SvømmeDiscipliner.valueOf(input.nextLine().toUpperCase()));
                break;
            case "7":
                System.out.println("Indtast ny kontingenttype: ");
                medlem.setKontingentType(KontingentType.valueOf(input.nextLine().toUpperCase()));
                break;
            default:
                break;

        }
        System.out.println("Informationen er ændret\n");
    }

    public void sletMedlem(){
        Medlem medlem = findMedlem();
        System.out.println("Er du sikker på at du vil slette medlemen: "+ medlem.getNavn() + " ? J/N");
        String choice = input.nextLine();

        if(choice.equalsIgnoreCase("J")) //Denne har vi fundet på oracle (equalsIgnoreCase). Link: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
        {
            medlemsListe.remove(medlem);
            System.out.println("medlem slettet");
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
