package filehandling;

import java.io.File;
import java.io.IOException;
public class demo {
    public static void main(String[] args) throws IOException {
        File f = new File("abc.txt");
        f.createNewFile();
    }
}

