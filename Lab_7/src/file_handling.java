import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class file_handling {
    public static void main(String[] args) throws IOException {

        File myFile = new File("abc.txt");

        FileWriter  f = new FileWriter("abc.txt");
        f.write("Hello! Fizza.");
        f.close();

//        myFile.delete();
    }
}

