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


    public static void main(String[] args){


        Node head = new Node(1);
        head.addAtEnd(2);head.addAtEnd(2);head.addAtEnd(2);
        head.addAtEnd(3);head.addAtEnd(4);head.addAtEnd(4);head.addAtEnd(4);head.addAtEnd(4);
        head.print();
        head = RemoveDuplicates.removeDuplicates(head);
        head.print();
    }
}
