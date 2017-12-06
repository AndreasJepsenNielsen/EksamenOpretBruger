public class StævneResultat extends Resultat
{
    //Fields
    String stævneNavn;
    String placering;

    //Constructor
    public StævneResultat(int sek, String navn, String dato, SvømmeDiscipliner svømmeDiscipliner, String placering, String stævne)
    {
        super(sek, navn, dato, svømmeDiscipliner);
    }

    //Bliver ikke brugt
    public void setStævne(String stævne)
    {
        this.stævneNavn = stævne;
    }

    //Bliver ikke brugt
    public void setPlacering(String placering)
    {
        this.placering = placering;
    }
}

