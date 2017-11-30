/*
import java.io.*;


public class CreateFile {

    public void createStream(MedlemsListe medlemmer)
    {
        try
        {
            File file = new File("medlemmer.txt");

            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream thwwizardofuss = new ObjectOutputStream(bos);

            thwwizardofuss.writeObject(medlemmer);

            thwwizardofuss.close();
        }
        catch(FileNotFoundException eFNFE)
        {

            System.out.println("Error eFNFE");
            eFNFE.printStackTrace();
        }
        catch (IOException eIOE)
        {
            System.out.println("Error eIOE");
            eIOE.printStackTrace();
        }
    }
}
*/