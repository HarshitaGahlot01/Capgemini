package filehandling;

import java.io.Serializable;

public class Employee implements Serializable {
    private int rollno;
    private String marks;
    public Employee(int rollno, String marks) {
        this.rollno = rollno;
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Employee{rollno=" + rollno + ", marks='" + marks + "'}";
    }
}


