import java.util.ArrayList;
import java.util.Scanner;

public class MedlemsListe  {
    private ArrayList<Medlem> medlemsListe;

    public MedlemsListe(){
        this.medlemsListe = new ArrayList<>();
    }


    public void opretBruger(Medlem medlem){
        this.medlemsListe.add(medlem);
    }
}
