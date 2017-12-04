import java.util.ArrayList;

public class TidsListe
{
    ArrayList<Tid> tidsListe;

    public TidsListe() {
        this.tidsListe = new ArrayList<>();
    }

    public void TilføjTid(int tid, String navn) {
        Tid tid2 = new Tid(tid, navn);

        tidsListe.add(tid2);
    }

    public static int compare(Object o1, Object o2) {
        Integer i1 = ((Tid) o1).getSek();
        Integer i2 = ((Tid) o2).getSek();

        int sComp = i1.compareTo(i2);

        if (sComp != 0) {
            return sComp;
        } else {
            String s1 = ((Tid) o1).getNavn();
            String s2 = ((Tid) o2).getNavn();
            return s1.compareTo(s2);
        }

    }
}

