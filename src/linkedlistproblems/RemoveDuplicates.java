package linkedlistproblems;

import java.util.HashSet;

/**
 * Created by Harishankar on 17-06-2015.
 */
public class RemoveDuplicates {

    //remove duplicates and return head
    public static Node removeDuplicates(Node head) {

        HashSet<Integer> set = new HashSet<>();
        Node currentNode = head;
        Node previousNode = null;

        while(currentNode!= null){
          if(set.contains(currentNode.data)){
              previousNode.next = currentNode.next;
          }else {
              set.add(currentNode.data);
              previousNode = currentNode;
          }
            currentNode = currentNode.next;
        }
      return head;
    }

    //remove duplicates and return head without using a temporary buffer
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


    public static void main(String[] args) {

        Node head = Node.createLinkedList();
        head.print();
        head = removeDuplicates(head);
        head.print();

        head = Node.createLinkedList();
        head.print();
        head = removeDuplicatesWithoutBuffer(head);
        head.print();
    }
}
