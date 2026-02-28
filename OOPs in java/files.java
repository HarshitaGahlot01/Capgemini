import java.util.*;
import java.io.File;
public class files {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //read a directory name from user
        //list all java files only n this folder
        //sort them as per their length in descending order and display
        File file=new File("C:\\Users\\Admin\\Desktop\\Capgeminiprograms"); //about the information of file NOT DATA
        System.out.println("exists "+file.exists());
        System.out.println("is file "+file.isFile());

        System.out.println("is directory "+file.isDirectory());
        System.out.println("length "+file.length());
        System.out.println("can read "+file.canRead());
        System.out.println("can write "+file.canWrite());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParentFile());

        File dir=new File(".");
        System.out.println("exists "+dir.exists());
        System.out.println(dir.isDirectory());
        String[] list=dir.list();
        for(String name:list) {
            System.out.println(name);
        }
        //create a directory
        File newDit = new File("C:\\Users\\Admin\\Desktop\\Capgeminiprograms\\newDir");
        if(!newDit.exists())
            try {
                newDit.mkdir();
                System.out.println("Directory created");
            }
            catch(SecurityException e) {
                System.out.println("not created");
            }
        else
            System.out.println("Directory already exists");
    }

}


