package linkedlistproblems;

/**
 * Created by Harishankar on 22-06-2015.
 */
public class DeleteNode {

    public static void deleteNode(Node someNode){

        Node currentNode = someNode;
        while( (currentNode.next.next) != null){
            Node nextNode = currentNode.next;
            currentNode.data = nextNode.data;
            currentNode = nextNode;
        }
         currentNode.next = null;
    }

    public static void deleteNode_2(Node someNode){

        Node nextNode = someNode;
        nextNode.data = nextNode.next.data;
        nextNode.next = nextNode.next.next;

    }

    public static void main(String[] args){
        Node head = Node.createLinkedList();
        head.print();
        deleteNode(head.next.next.next);
        head.print();

        head = Node.createLinkedList();
        head.print();
        deleteNode_2(head.next.next.next);
        head.print();
    }
}
