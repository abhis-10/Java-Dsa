package linkedlist;

import java.util.ArrayList;
import java.util.List;

class DoublyNode{
    int data;
    DoublyNode next;
    DoublyNode prev;

    DoublyNode(int data){
        this.data = data;
    }
    DoublyNode(int data, DoublyNode next, DoublyNode prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class DoublyLinkedList {
    //Question --> Delete the head node of a doubly linked list.
    public static DoublyNode deleteHeadNode(DoublyNode head){
        if(head.next == null || head == null){
            return null;
        }

        head = head.next;
        head.prev = null;
        return head;
    }
    public static DoublyNode reverseDoublyLinkedList(DoublyNode head){
        DoublyNode curr = head;
        DoublyNode temp = null;
        while(curr != null){
            temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;

            // move to next node (which is prev now)
            curr = curr.prev;
        }
        if (temp != null) { // update head
            head = temp.prev;
        }
        return head;
    }
    // Question --> Delete all the occurences of a key in a DLL
    public static DoublyNode deleteKeyOccurences(DoublyNode head, int key){
        DoublyNode ptr = head;

        while(ptr!=null){
            DoublyNode nextNode = ptr.next;

            if(ptr.data == key){

                if(ptr.prev == null){ // case 1 for head being in first node
                    head = ptr.next;

                    if(head!=null){ // case 2 for head being not in first node
                        head.prev = null;
                    }
                }else{
                    ptr.prev.next = ptr.next;

                    if(ptr.next!=null){
                        ptr.next.prev = ptr.prev;
                    }
                }
            }
            ptr = nextNode;
        }
        return head;
    }

    //Question --> Find Pairs with the given sum in DLL with brute force
    public static List<List<Integer>> findPairs(DoublyNode head,int target){

         DoublyNode slow = head;

        List<List<Integer>> pairs = new ArrayList<>();

         while(slow!=null){
             DoublyNode fast = slow.next;

             while(fast!=null){

             int num1 = slow.data;
             int num2 = fast.data;

                 if((num1+num2)==target){
                     List<Integer> arr = new ArrayList<>();
                     arr.add(num1);
                     arr.add(num2);
                     pairs.add(arr);
                 }
                 fast = fast.next;
             }

            slow = slow.next;
         }
         return  pairs;
    }
    //Question --> Find Pairs with the given sum in DLL with optimal soln
    public static List<List<Integer>> findPair(DoublyNode head, int target){
        DoublyNode left = head;
        DoublyNode temp = head;
        List<List<Integer>> allArray = new ArrayList<>();
        if(head == null) return allArray;

        while(temp.next!=null){
            temp = temp.next;
        }
        DoublyNode right = temp;

        while(left != null && right != null && left != right && right.next != left){
            int num1 = left.data;
            int num2 = right.data;

            if((num1+num2)==target){
               List<Integer> arr = new ArrayList<>();
               arr.add(num1);
               arr.add(num2);
               allArray.add(arr);

               left = left.next;
               right = right.prev;
            }
            else if((num1+num2) > target){
                right = right.prev;
            }else{
                left = left.next;
            }
        }
        return  allArray;
    }
    public static void main(String[] args) {
        DoublyNode db4 = new DoublyNode(5,null,null);
        DoublyNode db3 = new DoublyNode(4,db4,null);
        DoublyNode db2 = new DoublyNode(3,db3,null);
        DoublyNode db1 = new DoublyNode(2,db2,null);
        DoublyNode db = new DoublyNode(1,db1,null);

        db1.prev = db;
        db2.prev = db1;
        db3.prev = db2;
        db4.prev = db3;
        DoublyNode head = db;

//        DoublyNode ans = deleteHeadNode(head);
//        DoublyNode ans = reverseDoublyLinkedList(head);
//        while(ans != null){
//            System.out.print(ans.data+" ");
//            ans=ans.next;
//        }

//        DoublyNode ans = deleteKeyOccurences(head,3);
//        while(ans!=null){
//            System.out.print(ans.data+" ");
//            ans = ans.next;
//        }



        List<List<Integer>> finalArr = findPair(head,7);

        for (List<Integer> x: finalArr){
            System.out.print(x+" ");
        }
    }
}
