//class Node{
//        int val;
//        Node next;
//        Node(int val){
//            this.val=val;
//            this.next=null;
//    }
//}
//public class Day3ReverseLinkedList {
//    static Node head =null;
//    static void add(int val){
//        Node newN=new Node(val);
//        if (head == null) {
//            head = newN;
//            return;
//        }
//        Node temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = newN;
//    }
//    static void reverse() {
//        Node prev = null;
//        Node curr = head;
//        Node next = null;
//        while (curr != null) {
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        head = prev;
//    }
//    static void display() {
//        Node temp = head;
//        while (temp != null) {
//            System.out.print(temp.val +" ");
//            temp = temp.next;
//        }
//    }
//    public static void main(String[] args) {
//        add(10);
//        add(20);
//        add(30);
//        add(40);
//        System.out.println("original one:");
//        display();
//        reverse();
//        System.out.println();
//        System.out.println("reversed one:");
//        display();
//    }
//}
//
