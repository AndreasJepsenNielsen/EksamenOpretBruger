import java.util.Formatter;

public class CreateFile {
    private Formatter x;

    public void openFile() {
        try {
            x = new Formatter("chinese.txt");
        }
        catch (Exception eFNFE){
            System.out.println("Error");
        }
    }



    public void addPerson(String medlem)
    {
        x.format("%s%n", medlem);
    }

    public void closeFile()
    {
        x.close();
    }
}