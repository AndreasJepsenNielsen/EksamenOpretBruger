import java.util.ArrayList;
import java.util.Collections;
public class MedlemsListe
{
    ArrayList<Medlem> medlemsListe;

    public MedlemsListe()
    {
        this.medlemsListe = new ArrayList<>();
    }

    public void DisplayTider()
    {
        ArrayList<Tid> rangListe = new ArrayList<>();

        for (Medlem medlem : medlemsListe)
        {
            rangListe.add(Collections.min(medlem.tidsListe.tidsListe));

        }

        for (Tid tid : rangListe)
        {
            System.out.print(tid.getSek() + " ");
            System.out.println(tid.getNavn());
        }

        rangListe.sort(TidsListe::compare);

        System.out.println();

        for (Tid tid : rangListe)
        {
            System.out.print(tid.getSek() + " ");
            System.out.println(tid.getNavn());
        }
    }
}
