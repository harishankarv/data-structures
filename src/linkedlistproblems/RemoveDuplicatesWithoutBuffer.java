package linkedlistproblems;

/**
 * Created by Harishankar on 17-06-2015.
 */
public class RemoveDuplicatesWithoutBuffer {

    public static Node removeDuplicatesWithoutBuffer(Node head){
        Node currentPrimaryNode = head;

        while(currentPrimaryNode !=null) {
            Node currentSecondaryNode = currentPrimaryNode.next;
            Node previousSecondaryNode = currentPrimaryNode;
            while (currentSecondaryNode != null) {
                if (currentSecondaryNode.data == currentPrimaryNode.data) {
                    previousSecondaryNode.next = currentSecondaryNode.next;
                }
                previousSecondaryNode = currentSecondaryNode;
                currentSecondaryNode = currentSecondaryNode.next;
            }
            currentPrimaryNode = currentPrimaryNode.next;
        }

        return head;
    }


    public static void main(String[] args){

        Node head = new Node(1);
        head.addAtEnd(2);
        head.addAtEnd(2);
        head.addAtEnd(2);
        head.addAtEnd(3);
        head.addAtEnd(4);
        head.addAtEnd(4);
        head.addAtEnd(4);
        head.addAtEnd(4);
        head.print();

        head = removeDuplicatesWithoutBuffer(head);
        head.print();
    }

}
