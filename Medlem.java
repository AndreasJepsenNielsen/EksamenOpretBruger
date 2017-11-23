import java.util.InputMismatchException;
import java.util.Scanner;

public class Medlem
{
    //Fields
    private String navn;
    private int telefonNummer;
    private String adresse;
    private String email;
    private int alder;
    private KontingentType kontingentType;

    //Constructor
    public Medlem() {
        Scanner input = new Scanner(System.in);

        String tempNavn = null;
        int tempTelefonNummer = 0;
        String tempAdresse = null;
        String tempEmail = null;
        int tempAlder = 0;
        KontingentType tempKontingentType = null;


        while (true) {
            //Fjern continue, Tjek try catch muligvis incapsulate i en try catch?? flyt alt koden i Medlemsliste constructor er for stor.
            //Husk kommentarer til alt, ingen temp variabler vi skal kunne gøre det uden, find en måde.
            if (this.getNavn() == null)
            {
                System.out.println("Navn");
                tempNavn = input.nextLine();
                // Use of regex found it here: ,
                if (tempNavn.matches(".*\\d+.*")) {
                    System.out.println("Navn kan ikke indeholde tal");
                    tempNavn = null;
                    continue;
                }
                this.navn = tempNavn;

            }

            if (this.getTelefonNummer() == 0) {
                System.out.println("Telefonnummer");
                try
                {
                    tempTelefonNummer = input.nextInt();
                    input.nextLine();

                    if (Integer.toString(tempTelefonNummer).length() == 8)
                    {
                        this.telefonNummer = tempTelefonNummer;
                    } else {
                        System.out.println("Ugyldigt nummer");
                        tempTelefonNummer = 0;
                        continue;
                    }
                }
                catch (InputMismatchException eIME)
                {
                    System.out.println("Ugyldigt nummer");
                    input.nextLine();
                    tempTelefonNummer = 0;
                    continue;
                }
                this.telefonNummer = tempTelefonNummer;
            }

            //Spørg troels om den er fin sådan her

            if (this.getAdresse() == null)
            {
                System.out.println("Adresse");
                this.adresse = input.nextLine();
            }

            //Spørg troels hvordan man laver denne.

            if (this.getEmail() == null)
            {
                System.out.println("Email");
                this.email = input.nextLine();
            }

            if (tempAlder == 0)
            {
                System.out.println("Alder");

                try
                {
                    tempAlder = input.nextInt();
                    input.nextLine(); // End the nextInt with nextLine

                    if (tempAlder >= 0)
                    {
                        this.alder = tempAlder;
                    } else {
                        System.out.println("Ugyldig alder");
                        tempAlder = 0;
                        continue;
                    }
                }
                catch (InputMismatchException eIME)
                {
                    System.out.println("Ugyldig alder");
                    input.nextLine();
                    tempAlder = 0;
                    continue;
                }
                this.alder = tempAlder;
            }


            System.out.println("Aktiv eller passiv");
            String choice = input.nextLine().toUpperCase();

            switch (choice)
            {
                case "AKTIV":
                    if (this.alder < 18)
                    {
                        this.kontingentType = KontingentType.JUNIOR;
                    } else if (this.alder < 60 && this.alder > 18){
                        this.kontingentType = KontingentType.SENIOR;
                    } else if (this.alder >= 60){
                        this.kontingentType = KontingentType.VETERAN;
                    }
                    break;
                case "PASSIV":
                    this.kontingentType = KontingentType.PASSIV;
                    break;
                default:
                    break;
            }
            if (this.kontingentType == null)
            {
                continue;
            }
            break;
        }
    }


    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(int telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public KontingentType getKontingentType() {
        return kontingentType;
    }

    public void setKontingentType(KontingentType kontingentType) {
        this.kontingentType = kontingentType;
    }
}

