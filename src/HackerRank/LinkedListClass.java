package HackerRank;

public class LinkedListClass {

    Node head,head1;  // head of list

    /* Node Class */
    static class Node
    {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int d) {data = d; next = null; }
    }


    private void insertionAtfront(int data){

        LinkedListClass.Node nodeclass = new Node(data);
        nodeclass.next = head;
        head = nodeclass;

    }
    private void insertAfterNode(Node prev_node,int data){

        LinkedListClass.Node newNode = new Node(data);
        newNode.next = null;
        newNode.next = prev_node.next;
        prev_node.next = newNode;
    }
    private void printLinkedListValues(Node start){

        LinkedListClass.Node temp = start;
        while (temp != null){
            System.out.println("Values are"+temp.data);
            temp = temp.next;
        }
    }

    private void DeleteNodeWithKey(int key){
        LinkedListClass.Node temp = head;
        LinkedListClass.Node prev_node = null;
        while(temp != null){
            if (temp.data == key){
                prev_node.next = temp.next;
                break;
            }
            prev_node = temp;
            temp = temp.next;
        }
    }
    private int ListCount(Node val){
        LinkedListClass.Node temp = val;
        int count =0;
        while (temp!= null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void nthNodeFromEnd(int nth){
        int len =0;

        LinkedListClass.Node temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        temp = head;
        int nthFromEnd = len-nth+1;
        int count =1;
        while (nthFromEnd>0){
            if(nthFromEnd == count){
                System.out.println("nth form end"+temp.data);
                break;
            }
            count++;
            temp = temp.next;
        }

    }

    public void middleElement(){

        LinkedListClass.Node slow_ptr = head;
        LinkedListClass.Node fast_ptr = head;
        while (fast_ptr != null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        System.out.println("middle element is "+slow_ptr.data);
    }
    public Node LoopCheck(){

        LinkedListClass.Node slow_ptr = head;
        LinkedListClass.Node fast_ptr = head.next;
        LinkedListClass.Node foundNode = null;
        while (fast_ptr != null && fast_ptr.next!= null){
            if (fast_ptr.data == slow_ptr.data){
                foundNode = fast_ptr;
                System.out.println("loop found");
                break;
            }
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        return foundNode;
    }

    public Node MergeCheck(Node headOne,Node headTwo){

        int countone = this.ListCount(headOne);
        int counttwo = this.ListCount(headTwo);
        int diffVal = Math.abs(countone-counttwo);
        int trans =0;
        Node temp1 = headOne;
        Node temp2 = headTwo;
        if(countone>counttwo){
            while (temp1!=null){
                if(trans==diffVal){
                    break;
                }
                temp1 = temp1.next;
                trans++;
            }
        }else {
            while (temp2!=null){
                if(trans==diffVal){
                    break;
                }
                temp2 = temp2.next;
                trans++;
            }
        }
        while (temp1!=null && temp2!=null){
            if(temp1.data==temp2.data){
                System.out.println("found");
                break;
            }
            temp1 = temp1.next;
            temp2 =temp2.next;
        }
        return temp1;
    }


    public void foundNode(Node foundNode){
        LinkedListClass.Node temp = foundNode;
        int res = 1;
        temp = temp.next;
        while (temp == foundNode){
            res++;
        }
        System.out.println("total is-----"+res);
    }

    public static void main(String[] args) {

        LinkedListClass list = new LinkedListClass();

        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);

        // creating second linked list
        list.head = new Node(10);
        list.head.next = new Node(15);
        list.head.next.next = new Node(30);
        list.MergeCheck(list.head1,list.head);
        /*LinkedListClass ll = new LinkedListClass();
        ll .head = new Node(2);
        LinkedListClass.Node second = new Node(3);
        ll.head.next = second;
        LinkedListClass.Node third = new Node(6);
        second.next = third;

        LinkedListClass.Node fouth = new Node(67);*/


        //third.next = fouth;
        //fouth.next = second;
        //ll.printLinkedListValues(ll.head);
        //ll.insertionAtfront(8);
        //ll.foundNode(ll.LoopCheck());
        // ll.printLinkedListValues(ll.head);
        // ll.insertAfterNode(ll.head.next,9);
        //ll.printLinkedListValues(ll.head);
        //ll.DeleteNodeWithKey(3);
        //System.out.println("After delete");
        //ll.printLinkedListValues(ll.head);
        // System.out.println("List count is "+ll.ListCount());
        // System.out.println("value from nth from end ");
        // ll.nthNodeFromEnd(2);
        // ll.middleElement();
    }

}
