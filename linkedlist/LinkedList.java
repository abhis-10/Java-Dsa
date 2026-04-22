package linkedlist;

import java.util.HashMap;
import java.util.HashSet;

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
    // Question--> Given the head of a linked list, print the length of the linked list.
    public static int lengthOfList(Node head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
    // Question -->Search an element in a Linked List
    public static boolean searchInLinkedList(Node head,int val){
        while(head!=null){
            if(head.data == val){
                return true;
            }
            head = head.next;
        }
        return false;
    }
    //Question --> Reverse a linked list
    public static Node reverseLinkedList(Node head){
        Node curr = head;
        Node prev = null;

        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;// this will connect current node with prev linked list that is getting generated.
            prev = curr;
            curr = next; // this will move my curr forward normally.
        }
        return  prev;
    }

    //Qustion--> Find middle of linked list
    public static Node middleOfLinkedList(Node head){
       Node i = head;
       Node j = head;

       while(j != null && j.next != null){
           i = i.next;
           j = j.next.next;
       }
       return i;

    }
    //Question --> Reverse a singly linked list using recursion
    public static Node reverseLinkedListRecursively(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node newNode = reverseLinkedListRecursively(head.next);

        head.next.next = head;
        head.next = null;

        return newNode;
    }
    //Question --> Detect a cycle in a linked list
    public static boolean detectCycle(Node head){
        HashSet<Node> set = new HashSet<>();

        while(head!=null){
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
    // //Question --> Detect a cycle in a linked list optimal approach
    public static boolean detectCycle2(Node head){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    // Question --> Length of loop in linked List
    public static int lengthOfLoop(Node head){
        int len = 1;
        HashSet<Node> set = new HashSet<>();

        while(head!=null){
            if(set.contains(head)){
                Node slow = head;
                Node fast = head.next;

                while(fast!=slow){
                    len++;
                    fast = fast.next;
                }
                return len;
            }
            set.add(head);
            head = head.next;
        }
        return 0;
    }

    //Question --> Length of loop in linked list optimal soln
    public static int lengthOfLoops(Node head){
        Node slow = head;
        Node fast = head;
        int len = 1;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
            Node temp = slow.next;

            while(temp!= slow){
                len++;
                temp=temp.next;
            }
                return len;
            }

        }
            return 0;
    }

    //Question --> Sort the LinkedList using an optimal approach
    public static Node sortLL(Node head){
        if(head==null || head.next==null) return head;

        Node slow = head;
        Node fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node rightHead = slow.next;
        slow.next = null;

        Node left = sortLL(head);
        Node right = sortLL(rightHead);

        return merge(left,right);
    }
    public static Node merge(Node left , Node right){
        Node dummy = new Node(-1);
        Node tail = dummy;

        while(left!=null && right!=null){
            if(left.data <= right.data){
                tail.next = left;
                left = left.next;
            }else{
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if(left!=null) tail.next = left;
        if(right!=null) tail.next = right;

        return dummy.next;
    }
    public static void main(String[] args) {
        Node n = new Node(1);
        Node n3 = new Node(7,n);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(9,n2);

        Node head = n1; // this is how we make a node a head node

        /*while(head!=null){ // loop for printing the linkedlist from head to tail. // Basic traversing
            System.out.print(head.data+" ");
            head = head.next; // this will move my head forward
        }*/

        /*Node newHeadNode = insertAtHead(n1,5);

        while (newHeadNode!=null){
            System.out.print(newHeadNode.data+" ");
            newHeadNode = newHeadNode.next;
        }*/

        /*System.out.println("LinkedList before deleting last node");

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
        }*/

//        int ans = lengthOfList(head);
//        System.out.println("length of the linked list is :" + ans);

//        System.out.println(searchInLinkedList(n1,51));

//        Node prev = reverseLinkedList(n1);
//          Node mid = middleOfLinkedList(n1);
//        System.out.println(mid.data);
//        while(prev!=null){
//            System.out.print(prev.data+" ");
//            prev=prev.next;
//        }

//        deleteLastNode(head);
//        while(head!=null){
//            System.out.print(head.data+" ");
//            head = head.next;
//        }

//        Node lastNode = reverseLinkedListRecursively(head);
//
//        while(lastNode!=null){
//            System.out.print(lastNode.data+" ");
//            lastNode = lastNode.next;
//        }

        Node ans = sortLL(head);

        while(ans!=null){
            System.out.print(ans.data+" ");
            ans=ans.next;
        }
    }
}
