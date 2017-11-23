import java.util.ArrayList;
import java.util.Scanner;

public class Medlem
{
    //Fields
    private String navn;
    private String telefonNummer;
    private String adresse;
    private String email;
    private String alder;
    //private KontingentType kontingentType;

    public Medlem() {
    }

    public Medlem(String navn, String telefonNummer, String adresse, String email, String alder) {
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.adresse = adresse;
        this.email = email;
        this.alder = alder;
        //this.kontingentType = kontingentType;
    }

    public String getNavn() {
        return navn;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getAlder() {
        return alder;
    }

   /* public KontingentType getKontingentType() {
        return kontingentType;
    }
*/
    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAlder(String alder) {
        this.alder = alder;
    }

   /* public void setKontingentType(KontingentType kontingentType) {
        this.kontingentType = kontingentType;
    }
*/
    @Override
    public String toString() {
        return "\nNavn: " + navn +
                "\nTelefonNummer: " + telefonNummer +
                "\nAdresse: " + adresse +
                "\nEmail: " + email +
                "\nAlder: " + alder +
                "\n";
                //"\nKontingenttype: " + kontingentType;
    }

}
