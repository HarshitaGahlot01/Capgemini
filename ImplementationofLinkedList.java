import java.util.*;
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public class ImplementationofLinkedList {
        Node head;
        // Insert at beginning
        void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        // Insert at end
        void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }

        // Insert at position
        void insertAtPosition(int data, int pos) {
            if (pos == 1) {
                insertAtBeginning(data);
                return;
            }
            Node temp = head;
            for (int i = 1; i < pos - 1 && temp != null; i++)
                temp = temp.next;

            if (temp == null) {
                System.out.println("Invalid Position");
                return;
            }
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }

        // Delete at beginning
        void deleteAtBeginning() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            head = head.next;
        }

        // Delete at end
        void deleteAtEnd() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (head.next == null) {
                head = null;
                return;
            }
            Node temp = head;
            while (temp.next.next != null)
                temp = temp.next;
            temp.next = null;
        }

        // Delete at position
        void deleteAtPosition(int pos) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (pos == 1) {
                deleteAtBeginning();
                return;
            }
            Node temp = head;
            for (int i = 1; i < pos - 1 && temp.next != null; i++)
                temp = temp.next;

            if (temp.next == null) {
                System.out.println("Invalid Position");
                return;
            }
            temp.next = temp.next.next;
        }

        // Display
        void display() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println("NULL");
        }
        public static void main(String[] args) {
            ImplementationofLinkedList list = new ImplementationofLinkedList();
            list.insertAtBeginning(10);
            list.insertAtEnd(20);
            list.insertAtPosition(15, 2);
            list.display();
            list.deleteAtBeginning();
            list.display();
            list.deleteAtEnd();
            list.display();
        }
    }


