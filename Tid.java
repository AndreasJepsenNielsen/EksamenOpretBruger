public class Tid implements Comparable<Tid>
{
    int sek;
    String navn;

    public Tid(int sek, String navn)
    {
        this.sek = sek;
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn)
    {
        this.navn = navn;
    }

    public int getSek()
    {
        return sek;
    }





    @Override
    public int compareTo(Tid o)
    {
        if (this.sek < o.sek)
        {
            return -1;
        } else if (this.sek == o.sek) {

            return 0;
        } else {
            return 1;
        }
    }
}
