import java.io.Serializable;

public class Resultat implements Comparable<Resultat>, Serializable {
   //Fields
   private int sek;
   private String navn;
   private String dato;
   private SvømmeDiscipliner svømmeDiscipliner;

   //Constructor
   public Resultat(int sek, String navn, String dato, SvømmeDiscipliner svømmeDiscipliner) {
        this.sek = sek;
        this.navn = navn;
        this.dato = dato;
        this.svømmeDiscipliner = svømmeDiscipliner;
    }

    //En metode som sammenligner om der er to tider som har den samme værdi.
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

    //Getter til et resultats tid
    public int getSek() {
        return sek;
    }

    //Getter til navnet på det medlem som har lavet et resultat
    public String getNavn() {
        return navn;
    }

    //Getter til datoen på det resultat medlemmet har lavet
    public String getDato() {
        return dato;
    }

    //Getter til medlemmets svømmediscipliner
    public SvømmeDiscipliner getSvømmeDiscipliner() {
        return svømmeDiscipliner;
    }

    //En metode som viser medlemmets resultat i minutter, sekunder og millisekunder
    public String visTid()
    {
        String tid;

        tid = "" + this.sek / 60000 + " min, " + this.sek % 60000 / 1000 + " sek, " + this.sek % 1000 + " ms.";

        return tid;
    }

    //En toString metode som gør at objectet resultat kan printes og der vises tiden, navnet på medlemmet, datoen og svømmedisciplinen
    @Override
    public String toString() {
        return (this.visTid() + " " + this.getNavn() + " " + this.getDato() + " " + this.getSvømmeDiscipliner() + "\n");
    }
}