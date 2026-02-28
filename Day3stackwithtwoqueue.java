import java.util.*;
class Stack{
    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();
    void push1(int v){
        q2.add(v);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }

    }
}
public class Day3stackwithtwoqueue {
    public static void main(String[] args) {

    }
}
