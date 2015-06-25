package linkedlistproblems;

/**
 * Created by Harishankar on 22-06-2015.
 */
public class PartitionLinkedList {

     /*
      * create two new linked lists,
      * one for every node who's value is less than given Node
      * other for every node who's value is greater that given Node
      * join the two lists together
      */

    public static Node partitionLinkedList_1(Node head, int partitionValue){

        Node smallerHead = null;
        Node largerHead = null;

        Node currentNode = head;
        while(currentNode.next !=null){
            if(currentNode.data < partitionValue){
                if(smallerHead == null){
                    smallerHead = new Node(currentNode.data);
                }else{
                    smallerHead.addAtEnd(currentNode.data);
                }
            }else{
                if(largerHead == null){
                    largerHead = new Node(currentNode.data);
                }else{
                    largerHead.addAtEnd(currentNode.data);
                }
            }
            currentNode = currentNode.next;
        }

        /*
         * now join the two lists together
         */
        currentNode = smallerHead;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = largerHead;

        return smallerHead;
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Node partitionLinkedList_2(Node head, int partitionValue){



        Node smallerHead = null;
        Node smallerTail = null;
        Node largerHead = null;
        Node largerTail = null;

        Node currentNode = head;
        while(currentNode.next !=null){

            if(currentNode.data < partitionValue){
                if(smallerHead == null){
                    smallerHead = new Node(currentNode.data);
                }else{
                    smallerTail = new Node(currentNode.data);
                    Node currentSmallerNode = smallerHead;
                    while(currentSmallerNode.next != null){
                        currentSmallerNode = currentSmallerNode.next;
                    }
                    currentSmallerNode.next = smallerTail;
                }
            }else{
                if(largerHead == null){
                    largerHead = new Node(currentNode.data);
                }else{
                    largerTail = new Node(currentNode.data);
                    Node currentLargerNode = largerHead;
                    while(currentLargerNode.next!= null){
                        currentLargerNode = currentLargerNode.next;
                    }
                    currentLargerNode.next = largerTail;
                }
            }
            currentNode = currentNode.next;
        }

        /*
         * now join the two lists together
         */
        if(largerHead == null){
            return smallerHead;
        }else{
            smallerTail.next = largerHead;
            return smallerHead;
        }


    }

    //------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args){

        Node head = Node.createLinkedList();
        head.print();
        head = partitionLinkedList_1(head, 3);
        head.print();

        head = Node.createLinkedList();
        head.print();
        head = partitionLinkedList_2(head, 3);
        head.print();

    }
}
