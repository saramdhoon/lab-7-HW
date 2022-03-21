import javax.xml.soap.Node;

/**
 * Created by user on 09/03/2022.
 */

// JAVA PROGRAM TO DELET A NODE FROM DOUBLY LINKED LIST
public class Linkedlist {
    static Node head,head1,head2;
    static class Node{
        int data;
        Node next,prev;
        Node(int d){
            data=d;
            next=prev=null;
        }
    }

    /* Function to split a list (starting with head) into two lists.
     head1_ref and head2_ref are references to head nodes of
     the two resultant linked lists */
   void splitList(){
       Node Slow_ptr=head;
       Node fast_ptr=head;
       if (head==null){
           return;
       }
        /* If there are odd nodes in the circular list then
         fast_ptr->next becomes head and for even nodes
         fast_ptr->next->next becomes head */
       while (fast_ptr.next != head)
       while (fast_ptr.next!=head&& fast_ptr.next.next!=head){
           fast_ptr=fast_ptr.next.next;
           Slow_ptr=Slow_ptr.next;
       }
       /* If there are even elements in list then move fast_ptr */
       if (fast_ptr.next.next==head){
           fast_ptr=fast_ptr.next;
           /* Set the head pointer of first half */
           head1=head;
       }
       if (head.next!=head){
           head2=Slow_ptr.next;
       }
        /* Make second half circular */
       fast_ptr.next=Slow_ptr.next;
           /* Make first half circular */
       Slow_ptr.next=head;

   }

    /* Function to print nodes in a given singly linked list */
     void printList(Node node){
      Node temp=node;
         if (node!=null){
             do {
                 System.out.println(temp.data+"");
                 temp=temp.next;
             }while (temp!=node);
         }
     }

    public static void main(String[] args) {
        Linkedlist LIST=new Linkedlist();
        //Created linked list will be 12->56->2->11
        LIST.head=new Node(12);
        LIST.head.next=new Node(56);
        LIST.head.next.next=new Node(2);
        LIST.head.next.next.next=new Node(11);
        LIST.head.next.next.next.next=LIST.head;
        System.out.println("original circular linked list");
        LIST.printList(head);
        // Split the list
        LIST.splitList();
        System.out.println("");
        System.out.println("first circular list");
        LIST.printList(head1);
        System.out.println("");
        System.out.println("second circular list");
        LIST.printList(head2);
    }}