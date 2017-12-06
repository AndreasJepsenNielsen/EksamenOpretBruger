import java.io.Serializable;
import java.util.ArrayList;

public class Medlem implements Serializable
{
    //Fields
    private String navn;
    private String telefonNummer;
    private String adresse;
    private String email;
    private String alder;
    private boolean harBetalt;
    private ArrayList<SvømmeDiscipliner> svømmeDiscipliner;
    private KontingentType kontingentType;
    private ResultatListe resultatListe;

    //Constructor
    public Medlem(String navn, String telefonNummer, String adresse, String email, String alder, KontingentType kontingentType, boolean harBetalt /*, Boolean isKonkurrenceSvømmer*/) {
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.adresse = adresse;
        this.email = email;
        this.alder = alder;
        this.svømmeDiscipliner = new ArrayList<>();
        this.kontingentType = kontingentType;
        this.resultatListe = new ResultatListe();
        this.harBetalt = harBetalt;
        //this.erKonkurrenceSvømmer = isKonkurrenceSvømmer;
    }

    //Getter af arraylisten som indeholder svømmediscipliner
    public ArrayList<SvømmeDiscipliner> getSvømmeDiscipliner() {
        return svømmeDiscipliner;
    }

    //Getter til navnet på medlemmet
    public String getNavn() {
        return navn;
    }

    //Getter til telefonnummeret på medlemmet
    public String getTelefonNummer() {
        return telefonNummer;
    }

    //Getter til adressen på medlemmet
    public String getAdresse() {
        return adresse;
    }

    //Getter til arraylisten resultatliste
    public ResultatListe getResultatListe() {
        return resultatListe;
    }

    //Getter til booleanen som fortæller om medlemmet har betalt kontingent
    public boolean getHarBetalt()
    {
        return harBetalt;
    }

    //Setter til navnet på medlemmet
    public void setNavn(String navn) {
        this.navn = navn;
    }

    //Setter til telefonnummeret på medlemmet
    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    //Setter til adressen på medlemmet
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    //Setter til emailen på medlemmet
    public void setEmail(String email) {
        this.email = email;
    }

    //Setter til alderen på medlemmet
    public void setAlder(String alder) {
        this.alder = alder;
    }

    //Setter til kontingentypen som medlemmet har
    public void setKontingentType(KontingentType kontingentType) {
        this.kontingentType = kontingentType;
    }

    //En metode som tilføjer en svømmedisciplin til et medlem
    public void tilføjSvømmeDisciplin(SvømmeDiscipliner svømmeDiscipliner)
    {
        this.svømmeDiscipliner.add(svømmeDiscipliner);
    }

    //En metode som sletter en svømmedisciplin til et medlem
    public void sletSvømmeDisciplin (SvømmeDiscipliner svømmeDiscipliner)
    {
        int index = 0;

        for (SvømmeDiscipliner svømmeDiscipliner1 : this.svømmeDiscipliner)
        {
            if (svømmeDiscipliner == svømmeDiscipliner1)
            {
                break;
            }
            index++;
        }
        this.svømmeDiscipliner.remove(index);
    }

    //toString metode som gør at objectet medlem kan printes
    @Override
    public String toString() {
        return "\nNavn: " + navn + " " +
                "\nTelefonNummer: " + telefonNummer + " " +
                "\nAdresse: " + adresse + " " +
                "\nEmail: " + email + " " +
                "\nAlder: " + alder + " " +
                "\nSvømmedisciplin: " + svømmeDiscipliner + " " +
                "\nKontingenttype: " + kontingentType + " " +
                //"\nKonkurrencesvømmer: " + erKonkurrenceSvømmer + " " +
                "\n";

    }
}
