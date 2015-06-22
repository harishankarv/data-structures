package linkedlistproblems;

/**
 * Created by Harishankar on 17-06-2015.
 */
public class FindKthLastNode {

    public static Node findKthLastNode(Node head, int k){

        int N = 0; //size of linked list
        Node currentNode = head;

        while(currentNode != null){
            currentNode = currentNode.next;
            N++;
        }

        Node kthLastNode = head;
        int i =0;
        while(i < N - k){
            kthLastNode = kthLastNode.next;
            i++;
        }
        return kthLastNode;
    }

    public static int findKthLastNodeRecursive(Node head, int k){

        /*
         *   when end is reached, return a counter set to 0.
         *   Each parent call adds 1 to the counter
         *   When counter == k, we have reached Kth last element.
         */

        if (head == null){
            return 0;
        }
        int i = findKthLastNodeRecursive(head.next , k) + 1;
        if ( i == k){
            System.out.println(head.data);
        }
        return i;

    }

    public static void main(String[] args){

        Node head = Node.createLinkedList();
        head.print();
        head = findKthLastNode(head, 6);
        head.print();

        head = Node.createLinkedList();
        head.print();
        System.out.println(findKthLastNodeRecursive(head, 6));
    }

}
