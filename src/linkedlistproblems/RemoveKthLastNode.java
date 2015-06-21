package linkedlistproblems;

/**
 * Created by Harishankar on 17-06-2015.
 */
public class RemoveKthLastNode {

    public static Node removeKthLastNode(Node head, int k){

        int N = 0; //size of linked list
        Node currentNode = head;

        while(currentNode != null){
            currentNode = currentNode.next;
            N++;
        }

        if(N==k){
            return head.next;
        }

        currentNode = head;
        Node previousNode = head;
        Node nextNode = null;
        int i =0;
        while(i < N - k){
            previousNode = currentNode;
            currentNode = currentNode.next;
            nextNode = currentNode.next;
            i++;
        }
        previousNode.next = nextNode;
        return head;
    }

    public static void main(String[] args){

        Node head = new Node(1);
        head.addAtEnd(2);head.addAtEnd(2);head.addAtEnd(2);
        head.addAtEnd(3);head.addAtEnd(4);head.addAtEnd(4);head.addAtEnd(4);head.addAtEnd(4);
        head = removeKthLastNode(head, 1);
        head.print();
    }
}
