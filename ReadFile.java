import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile
{
    private Scanner x;

    public void openFile()
    {
        try{
            x = new Scanner(new File("chinese.txt"));
        }
        catch (Exception eFNFE)
        {
            System.out.println("Error");
        }
    }

    public ArrayList<Medlem> readFile()
    {
        ArrayList<Medlem> medlemmer = new ArrayList<>();

        while (x.hasNext())
        {
            Medlem medlem = new Medlem();

            x.next();
            medlem.setNavn(x.next());
            x.next();
            medlem.setTelefonNummer(x.next());
            x.next();
            medlem.setAdresse(x.next());
            x.next();
            medlem.setEmail(x.next());
            x.next();
            medlem.setAlder(x.next());
            x.next();
            medlem.setSvømmeDiscipliner(SvømmeDiscipliner.valueOf(x.next().toUpperCase()));
            x.next();
            medlem.setKontingentType(KontingentType.valueOf(x.next().toUpperCase()));
            x.next();
            medlem.setErKonkurrenceSvømmer(x.next().equals("true"));

            medlemmer.add(medlem);


        }
        return medlemmer;
    }

    public void closeFile()
    {
        x.close();
    }
}
