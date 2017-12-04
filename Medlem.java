public class Medlem
{
    TidsListe tidsListe;
    String navn;

    public Medlem(String navn)
    {
        this.tidsListe = new TidsListe();
        this.navn = navn;

    }

    public String getNavn() {
        return navn;
    }
}
