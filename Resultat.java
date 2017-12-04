import java.io.Serializable;

public class Resultat implements Comparable<Resultat>, Serializable {
    private int sek;
    private String navn;
    private String dato;
    private SvømmeDiscipliner svømmeDiscipliner;

    public Resultat(int sek, String navn, String dato, SvømmeDiscipliner svømmeDiscipliner) {
        this.sek = sek;
        this.navn = navn;
        this.dato = dato;
        this.svømmeDiscipliner = svømmeDiscipliner;
    }


    @Override
    public int compareTo(Resultat o) {
        if (this.sek < o.sek) {
            return -1;
        } else if (this.sek == o.sek) {
            return 0;
        } else {
            return 1;
        }
    }

    public int getSek() {
        return sek;
    }

    public String getNavn() {
        return navn;
    }

    public String getDato() {
        return dato;
    }

    public String visTid()
    {
        String tid;

        tid = "" + this.sek / 60000 + " min, " + this.sek % 60000 / 1000 + " sek, " + this.sek % 1000 + " ms.";

        return tid;
    }

    public SvømmeDiscipliner getSvømmeDiscipliner() {
        return svømmeDiscipliner;
    }

    @Override
    public String toString() {
        return (this.visTid() + " " + this.getNavn() + " " + this.getDato() + " " + this.getSvømmeDiscipliner() + "\n");
    }
}