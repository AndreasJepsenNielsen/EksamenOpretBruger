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
    private ArrayList<SvømmeDiscipliner> svømmeDiscipliner;
    private KontingentType kontingentType;
    private ResultatListe resultatListe;
    //private boolean erKonkurrenceSvømmer;

    public Medlem()
    {

    }

    public Medlem(String navn, String telefonNummer, String adresse, String email, String alder,KontingentType kontingentType /*, Boolean isKonkurrenceSvømmer*/) {
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.adresse = adresse;
        this.email = email;
        this.alder = alder;
        this.svømmeDiscipliner = new ArrayList<>();
        this.kontingentType = kontingentType;
        this.resultatListe = new ResultatListe();
        //this.erKonkurrenceSvømmer = isKonkurrenceSvømmer;
    }

    public ArrayList<SvømmeDiscipliner> getSvømmeDiscipliner() {
        return svømmeDiscipliner;
    }

    public KontingentType getKontingentType() {
        return kontingentType;
    }

    /*public boolean isErKonkurrenceSvømmer() {
        return erKonkurrenceSvømmer;
    }

    //public void setErKonkurrenceSvømmer(boolean erKonkurrenceSvømmer) {
        this.erKonkurrenceSvømmer = erKonkurrenceSvømmer;
    }
    */

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

    public void setSvømmeDiscipliner(ArrayList svømmeDiscipliner) {
        this.svømmeDiscipliner = svømmeDiscipliner;
    }

    public ResultatListe getResultatListe() {
        return resultatListe;
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
                //"\nKonkurrencesvømmer: " + erKonkurrenceSvømmer + " " +
                "\n";

    }

    public void tilføjSvømmeDisciplin(SvømmeDiscipliner svømmeDiscipliner)
    {
        this.svømmeDiscipliner.add(svømmeDiscipliner);
    }

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
}
