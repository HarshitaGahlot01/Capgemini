package filehandling;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class Twobytesprint {
    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");
        FileInputStream fis = new FileInputStream(file);
        long length = file.length();   // Get actual file size
        if (length < 2) {
            System.out.println("File has less than 2 bytes");
            fis.close();
            return;
        }
        fis.skip(length - 2);
        int b1 = fis.read();
        int b2 = fis.read();
        System.out.println("Last two bytes:");
        System.out.println((char) b1);
        System.out.println((char) b2);
        fis.close();
    }
}