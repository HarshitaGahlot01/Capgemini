import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Filedirectoryread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter folder:");
        String folder = sc.nextLine();
        File dir = new File(folder);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Cannot proceed with this directory");
            return;
        }
        File[] listFiles = dir.listFiles();
        List<File> files = new ArrayList<>();
        for (File f : listFiles) {
            if (f.isFile() && f.getName().endsWith(".java")) {
                files.add(f);
            }
        }
        Collections.sort(files,
                (a, b) -> Long.compare(b.length(), a.length()));
        System.out.println("\nJava files sorted by size:");
        for (File f : files) {
            System.out.println(f.length() + "\t" + f.getName());
        }
        sc.close();
    }
}