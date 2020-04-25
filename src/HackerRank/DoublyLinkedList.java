package HackerRank;

public class DoublyLinkedList {
    static Node head;

    static class Node {

        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    Node insertNode(){
        int data = 6;
        Node current = head;
        Node newNode = new Node(data);
        // insert at front
        if(data < head.data){
            head.prev = newNode;
            newNode.prev = null;
            newNode.next = head;
            head = newNode;
            return head;
        }

        while(current!= null){
            if(current.next == null && data > current.data){
                current.next = newNode;
                newNode.prev = current;
                newNode.next = null;
                break;
            }else if(data < current.next.data) {
                newNode.next = current.next;
                newNode.prev = current;
                current.next.prev = newNode;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
        return head;
    }

    /* Function to reverse a Doubly Linked List */
    void reverse() {
        Node temp = null;
        Node current = head;
        while(current!=null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    /* UTILITY FUNCTIONS */
    /* Function to insert a node at the beginning of the Doubly Linked List */
    void push(int new_data) {
        /* allocate node */
        Node new_node = new Node(new_data);

        /* since we are adding at the beginning,
         prev is always NULL */
        new_node.prev = null;

        /* link the old list off the new node */
        new_node.next = head;

        /* change prev of head node to new node */
        if (head != null) {
            head.prev = new_node;
        }

        /* move the head to point to the new node */
        head = new_node;
    }

    /* Function to print nodes in a given doubly linked list
     This function is same as printList() of singly linked list */
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        /* Let us create a sorted linked list to test the functions
         Created linked list will be 10->8->4->2 */
        list.push(1);
        list.push(4);
        list.push(5);
        list.push(7);

        System.out.println("Original linked list ");
        list.printList(head);

        list.reverse();
        System.out.println("The reversed Linked List is ");
        list.printList(head);
        list.insertNode();
        System.out.println("");
        System.out.println("The reversed Linked List is ");
        list.printList(head);
    }
}
