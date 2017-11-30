import java.io.Serializable;

public class Medlem implements Serializable
{
    //Fields
    private String navn;
    private String telefonNummer;
    private String adresse;
    private String email;
    private String alder;
    private SvømmeDiscipliner svømmeDiscipliner;
    private KontingentType kontingentType;
    private boolean erKonkurrenceSvømmer;

    public Medlem() {
    }

    public Medlem(String navn, String telefonNummer, String adresse, String email, String alder,SvømmeDiscipliner svømmeDiscipliner,KontingentType kontingentType, Boolean isKonkurrenceSvømmer) {
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.adresse = adresse;
        this.email = email;
        this.alder = alder;
        this.svømmeDiscipliner = svømmeDiscipliner;
        this.kontingentType = kontingentType;
        this.erKonkurrenceSvømmer = isKonkurrenceSvømmer;
    }

    public SvømmeDiscipliner getSvømmeDiscipliner() {
        return svømmeDiscipliner;
    }

    public KontingentType getKontingentType() {
        return kontingentType;
    }

    public boolean isErKonkurrenceSvømmer() {
        return erKonkurrenceSvømmer;
    }

    public void setErKonkurrenceSvømmer(boolean erKonkurrenceSvømmer) {
        this.erKonkurrenceSvømmer = erKonkurrenceSvømmer;
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

    public void setKontingentType(KontingentType kontingentType) {
        this.kontingentType = kontingentType;
    }

    public void setSvømmeDiscipliner(SvømmeDiscipliner svømmeDiscipliner) {
        this.svømmeDiscipliner = svømmeDiscipliner;
    }

    @Override
    public String toString() {
        return "\nNavn: " + navn + " " +
                "\nTelefonNummer: " + telefonNummer + " " +
                "\nAdresse: " + adresse + " " +
                "\nEmail: " + email + " " +
                "\nAlder: " + alder + " " +
                "\nSvømmedisciplin: " + svømmeDiscipliner + " " +
                "\nKontingenttype: " + kontingentType + " " +
                "\nKonkurrencesvømmer: " + erKonkurrenceSvømmer + " " +
                "\n";

    }

}
