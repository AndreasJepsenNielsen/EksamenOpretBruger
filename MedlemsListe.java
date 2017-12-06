import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MedlemsListe implements Serializable{
    //Fields
    private ArrayList<Medlem> medlemsListe;
    private static Scanner input = new Scanner(System.in);

    //Constructor
    public MedlemsListe()
    {
        this.medlemsListe = new ArrayList<>();
    }

    //En metode som gør at formanden kan oprette et medlem
    public void opretMedlem() {
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
                                    indtastKontingentType(),
                                    indtastHarBetalt()
                            );
            konkurrenceSvømmer.getSvømmeDiscipliner().add(indtastSvømmeDisciplin());
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
                                    indtastKontingentType(),
                                    indtastHarBetalt()
                            );
            medlem.getSvømmeDiscipliner().add(indtastSvømmeDisciplin());

            this.medlemsListe.add(medlem);
        }

        System.out.println("Medlem oprettet!\n");
    }

    //En metode som gør at formanden kan redigere et medlem, som har en switch case og scanner input
    public void redigerMedlem(){
        Medlem medlem = findMedlem();
        System.out.println("\nHvad skal ændres?\n" +
                "1. Navn\n" +
                "2. Telefonnumer\n" +
                "3. Adresse\n" +
                "4. Email\n" +
                "5. Alder\n" +
                "6. Svømmedisciplin\n" +
                "7. Kontingenttype\n" +
                "8. Tilbage");
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
                redigerSvømmedisciplin(medlem);
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

    //En metode som sletter et medlem
    public void sletMedlem(){
        Medlem medlem = findMedlem();
        System.out.println("Er du sikker på at du vil slette medlemmet: " + medlem.getNavn() + " ? J/N");
        String choice = input.nextLine();

        if(choice.equalsIgnoreCase("J")) //Denne har vi fundet på oracle (equalsIgnoreCase). Link: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
        {
            medlemsListe.remove(medlem);
            System.out.println("Medlem slettet\n");
        }
    }

    //En metode som fortæller om et medlem er konkurrencesvømmer, som tager imod et scanner input
    private Boolean erKonkurrenceSvømmer()
    {
        System.out.println("Er det nye medlem en konkurrencesvømmer?");
        System.out.println("J/N");
        return input.nextLine().equalsIgnoreCase("J");

    }

    //En metode som giver et navn til et medlem som oprettes, som tager imod et scanner input
    private String indtastNavn() {
        System.out.println("Navn");
        return input.nextLine();
    }

    //En metode som giver et telefonnummer til et medlem som oprettes, som tager imod et scanner input
    private String indtastTelefonnummer() {
        System.out.println("Telefonnummer");
        return input.nextLine();
    }

    //En metode som giver en adresse til et medlem som oprettes, som tager imod et scanner input
    private String indtastAdresse() {
        System.out.println("Adresse");
        return input.nextLine();
    }

    //En metode som giver en email til et medlem som oprettes, som tager imod et scanner input
    private String indtastEmail() {
        System.out.println("Email");
        return input.nextLine();
    }

    //En metode som giver en alder til et medlem som oprettes, som tager imod et scanner input
    private String indtastAlder() {
        System.out.println("Alder");
        return input.nextLine();
    }

    //En metode som giver en svømmedisciplin til et medlem som oprettes, som tager imod et scanner input
    private SvømmeDiscipliner indtastSvømmeDisciplin() {
        System.out.println("Svømmedisciplin");

        return SvømmeDiscipliner.valueOf(input.nextLine().toUpperCase());
    }

    //En metode som giver en kontingenttype til et medlem som oprettes, som tager imod et scanner input
    private KontingentType indtastKontingentType() {
        System.out.println("KontingentType: ");
        return KontingentType.valueOf(input.nextLine().toUpperCase());
    }

    //En metode som som fortæller om medlemmet har betalt kontingent, som tager imod et scanner input
    private boolean indtastHarBetalt()
    {
        System.out.println("Har medlemmet betalt? J for ja, alt andet nej");
        String valg = input.nextLine().toUpperCase();

        if (valg.equals("J"))
        {
            return true;
        } else if (valg.equals("N")){
            return false;
        }
        return false;
    }

    //En metode som søger igennem medlemslisten, og tager imod et scanner input
    public Medlem findMedlem(){
        System.out.println("\nIndtast navn, adresse eller telefonnumer");
        String choice = input.nextLine();
        for(Medlem find : medlemsListe)
        {
            if(choice.equalsIgnoreCase(find.getNavn()) || choice.equalsIgnoreCase(find.getAdresse()) || choice.equalsIgnoreCase(find.getTelefonNummer())){
                return  find;
            }
        }
       return null;
    }

    //En metode som viser ranglisten med de fem bedste tider inden for en svømmedisciplin, som tager imod et scanner input
    public void visRangliste()
    {
        ArrayList<Resultat> rangListe = new ArrayList<>();
        SvømmeDiscipliner svømmeDiscipliner;

        System.out.println("Indtast disciplin");
        svømmeDiscipliner = SvømmeDiscipliner.valueOf(input.nextLine().toUpperCase());

        for (Medlem medlem : this.medlemsListe)
        {
            rangListe.add(findBedsteTid(medlem, svømmeDiscipliner));
        }

        rangListe.sort(ResultatListe::sammenlign);

        for (int i = 0; i < 5; i++)
        {
            System.out.println(rangListe.get(i));
        }
    }

    //En metode som redigere et medlems svømmedisciplin
    private void redigerSvømmedisciplin(Medlem medlem)
    {
        System.out.println("1. Tilføj\n" +
                "2. Slet\n" +
                "3. Tilbage");

        String choice = input.nextLine();

        switch (choice)
        {
            case "1":
                System.out.println("Indtast svømmedisciplin");
                medlem.tilføjSvømmeDisciplin(SvømmeDiscipliner.valueOf(input.nextLine().toUpperCase()));
                System.out.println("Svømmedisciplin tilføjet til medlem");
                break;
            case "2":
                System.out.println("Indtast svømmedisciplin");
                medlem.sletSvømmeDisciplin(SvømmeDiscipliner.valueOf(input.nextLine().toUpperCase()));
                break;
            default:
                break;
        }
    }

    //En metode som finder den bedste tid for et medlem, inden for en svømmedisciplin
    private Resultat findBedsteTid (Medlem medlem, SvømmeDiscipliner svømmeDiscipliner)
    {
        ArrayList<Resultat> resultatArrayList = new ArrayList<>();

        for (Resultat resultat : medlem.getResultatListe().resultatListe)
        {
            if (resultat.getSvømmeDiscipliner() == svømmeDiscipliner)
            {
                resultatArrayList.add(resultat);
            }
        }

        resultatArrayList.add(Collections.min(medlem.getResultatListe().resultatListe));
        resultatArrayList.sort(Resultat::compareTo); // https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html Dette har vi fundet på oracle.

        return resultatArrayList.get(0);
    }

    //En metode som sætter de medlemmer som ikke har betalt kontingent i en arraylist
    public ArrayList<Medlem> ubetaltKontigentListe()
    {
        ArrayList<Medlem> ubetaltKontingentListe = new ArrayList<>();

        for (Medlem medlem : this.medlemsListe)
        {
            if (!medlem.getHarBetalt())
            {
                ubetaltKontingentListe.add(medlem);
            }
        }
        return ubetaltKontingentListe;
    }

    //En toString metode tager medlemmerne ud af medlemslisten, og gøre at objectet medlemsliste kan printes
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.medlemsListe.size(); i++) {
            result += this.medlemsListe.get(i);
        }
        return result;
    }
}
