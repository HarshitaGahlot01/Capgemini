import java.util.ArrayList;

class Student{
private String rollNo;
private String name;
Student(String name, String rollNo){
    this.name=name;
    this.rollNo=rollNo;
}
public String getName(){
    return name;
}
public String getRollNo(){
    return rollNo;
}
}

class Teacher{
    private String teacherId;
    private String name;
    private ArrayList<Student> students;
    Teacher(String teacherId, String name){
        this.teacherId=teacherId;
        this.name=name;
        students=new ArrayList<>();
    }
    public void addStudent(Student s){
        students.add(s);
    }
    public ArrayList<Student> getStudents(){
        return students;
    }




        }
public class OnetoManyTeachertoStudentRelationship {
    public static void main(String[] args) {
  Teacher t=new Teacher("101","ridhima");
  Student s1=new Student("Riya","123");
  Student s2=new Student("krishna","456");
  t.addStudent(s1);
  t.addStudent(s2);
        for (Student s : t.getStudents()) {
            System.out.println(s.getName());
            System.out.println(s.getRollNo());

        }


    }
}
