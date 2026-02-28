import java.util.*;
class Student1{
    String name;
    int marks;
    Student1(String name,int marks){
        this.name=name;
        this.marks=marks;
    }

public String toString() {
    return name + " " + marks;
}}
public class Tasks {
    public static void main(String[] args) {
        List<Student1> l=new ArrayList<>();
        l.add(new Student1("Ravi",60));
        l.add(new Student1("Shyam",61));
        l.add(new Student1("ram",61));
        l.add(new Student1("riya",62));
        Collections.sort(l,(a,b)->{
            if(a.marks!=b.marks){
                return a.marks-b.marks;

            }
            return a.name.compareTo(b.name);
        });
        System.out.println(l);

    }
}
