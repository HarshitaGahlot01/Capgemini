import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("data.txt");
        FileOutputStream fout = new FileOutputStream("dataCopy.txt");
        int ch;
        int index = 1;
        while ((ch = fin.read()) != -1) {
            if(ch!=' '){
            if (index % 2 != 0) {   // odd index
                fout.write(ch);
            }

            index++;
        }
}
        fin.close();
        fout.close();

        System.out.println("Odd indexed characters copied successfully!");
    }}