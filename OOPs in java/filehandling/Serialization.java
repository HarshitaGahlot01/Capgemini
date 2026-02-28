package filehandling;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Serialization {
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        //enter roll,enter marks
        //list all records:
        //give roll,show me marks: search
        //using inputstream and output stream
        FileOutputStream fout = new FileOutputStream("empData.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fout);

        oos.writeObject(new Employee(111, "Ayushi"));
        oos.writeObject(new Employee(222, "Pratishtha"));

        oos.close();
        fout.close();
        System.out.println("Data written");

        FileInputStream fin = new FileInputStream("empData.bin");
        ObjectInputStream ois = new ObjectInputStream(fin);
        Object ob1 = ois.readObject();
        Object ob2 = ois.readObject();
//		int x=ois.readInt();     //  control 2+L, control +space, F1
        ois.close();
        fin.close();

        System.out.println(ob1);
        System.out.println(ob2);
//		System.out.println("x=" +x);
    }


    }
