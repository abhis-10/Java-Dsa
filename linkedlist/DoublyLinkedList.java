package linkedlist;
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
    public static void main(String[] args) {
        DoublyNode db2 = new DoublyNode(3,null,null);
        DoublyNode db1 = new DoublyNode(2,db2,null);
        DoublyNode db = new DoublyNode(1,db1,null);

        db1.prev = db;
        db2.prev = db1;
        DoublyNode head = db;

//        DoublyNode ans = deleteHeadNode(head);
        DoublyNode ans = reverseDoublyLinkedList(head);
        while(ans != null){
            System.out.print(ans.data+" ");
            ans=ans.next;
        }
    }
}
