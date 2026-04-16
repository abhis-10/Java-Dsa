package linkedlist;

class Node {
    int data;
    Node next;

    Node(int data , Node next){
        this.data = data;
        this.next = next;
    }

    Node(int data){
        this.data = data;
    }
}

public class LinkedList {
    // Question--> Insert at the head of a Linked List
    public static Node insertAtHead(Node head,int newData){
        Node newNode = new Node(newData,head);
        return newNode;
    }
    // Question-->Delete Last Node of Linked List
    public static void deleteLastNode(Node head){
        while(head.next.next != null){
            head = head.next;
        }
        head.next = null;
    }
    public static void main(String[] args) {
        Node n = new Node(50);
        Node n3 = new Node(30,n);
        Node n2 = new Node(20,n3);
        Node n1 = new Node(10,n2);

        Node head = n1; // this is how we make an node a head node

        /*while(head!=null){ // loop for printing the linkedlist from head to tail. // Basic traversing
            System.out.print(head.data+" ");
            head = head.next; // this will move my head forward
        }*/

        /*Node newHeadNode = insertAtHead(n1,5);

        while (newHeadNode!=null){
            System.out.print(newHeadNode.data+" ");
            newHeadNode = newHeadNode.next;
        }*/

        System.out.println("LinkedList before deleting last node");

        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
         head = n1;
        System.out.println();

        System.out.println("LinkedList after deleting last node");
        deleteLastNode(head);

        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }

    }
}
