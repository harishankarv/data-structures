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

    public static void main(String[] args){


        Node head = new Node(1);
        head.addAtEnd(2);head.addAtEnd(2);head.addAtEnd(2);
        head.addAtEnd(3);head.addAtEnd(4);head.addAtEnd(4);head.addAtEnd(4);head.addAtEnd(4);
        head.print();
        head = findKthLastNode(head, 6);
        head.print();
    }
}
