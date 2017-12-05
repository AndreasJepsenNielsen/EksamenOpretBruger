public class StævneResultat extends Resultat
{
    String stævneNavn;
    String placering;


    public StævneResultat(int sek, String navn, String dato, SvømmeDiscipliner svømmeDiscipliner, String placering, String stævne)
    {
        super(sek, navn, dato, svømmeDiscipliner);
    }

    public void setStævne(String stævne)
    {
        this.stævneNavn = stævne;
    }

    public void setPlacering(String placering)
    {
        this.placering = placering;
    }
}

