//import java.util.*;
//class Node{
//    Node next;
//    int val;
//    Node(int val){
//        this.next=null;
//        this.val=val;
//    }
//}
//public class ImplementStackUsingLinkedList {
//    Node head= null;                             // head is top
//    void push(int val){
//        Node newN=new Node(val);
//        newN.next=head;
//        head=newN;
//        System.out.println("Element push in the stack"+val);
//    }
//    void pop(){
//        if(head==null){
//            System.out.println("Empty one");
//            return ;
//        }else{
//            System.out.println("pop");
//            head=head.next;
//        }
//    }
//    void display(){
//        if(head==null){
//            System.out.println("empty");
//            return ;
//        }
//        System.out.print("Stack elements: ");
//        Node temp = head;
//        while (temp != null) {
//            System.out.print(temp.val + " ");
//            temp = temp.next;
//        }
//        System.out.println();
//    }
//    public static void main(String[] args) {
//        ImplementStackUsingLinkedList s = new ImplementStackUsingLinkedList();
//        s.push(10);
//        s.push(20);
//        s.push(30);
//        s.display();
//        s.pop();
//        s.display();
//    }
//}
//
