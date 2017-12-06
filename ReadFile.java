/*

import com.sun.rmi.rmid.ExecPermission;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile
{
    public MedlemsListe readFile()
    {
        MedlemsListe medlemsListe = new MedlemsListe();
        try {


            File file = new File("medlemmer.txt");

            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            medlemsListe = (MedlemsListe) ois.readObject();

            ois.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return medlemsListe;
    }
}
*/