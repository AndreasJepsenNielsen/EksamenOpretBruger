import javax.xml.transform.Result;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
                                    indtastKontingentType()
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
                                    indtastKontingentType()
                                    //erKonkurrenceSvømmer()
                            );
            medlem.getSvømmeDiscipliner().add(indtastSvømmeDisciplin());

            this.medlemsListe.add(medlem);
        }

        System.out.println("Medlem oprettet!\n");
    }

    private Boolean erKonkurrenceSvømmer()
    {
        System.out.println("Er det nye medlem en konkurrencesvømmer?");
        System.out.println("J/N");
        return input.nextLine().equalsIgnoreCase("J");

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
                "7. Kontingenttype" +
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

        rangListe.sort(ResultatListe::compare);

        for (int i = 0; i < 5; i++)
        {
            System.out.println(rangListe.get(i));
        }
    }

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
        resultatArrayList.sort(Resultat::compareTo);

        return resultatArrayList.get(0);
    }

    public ArrayList<Medlem> getMedlemsListe()
    {
        return medlemsListe;
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
