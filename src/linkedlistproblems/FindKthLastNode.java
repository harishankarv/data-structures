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

    //------------------------------------------------------------------------------------------------------------------


    /*
    //just print the Node, do not return it.
    public static int findKthLastNodeRecursive_T(Node head, int k) {

        if (head == null){
            return 0;
        }
        int value = findKthLastNodeRecursive_T(head.next , k) + 1;
        if ( value == k){
            System.out.println(head.data);
        }
        return value;

    }

    */

    //based on the above.
    static class IntegerWrapper{
        int value;

        IntegerWrapper(int value){
            this.value = value;
        }
    }

    public static Node findKthLastNodeRecursive(Node head, int k){
        return findKthLastNodeRecursiveHelper(head,k, new IntegerWrapper(0));
    }


    /*
     *  when end is reached, return a counter set to 0.
     *  Each parent call adds 1 to the counter
     *  When counter == k, we have reached Kth last element.
     */

    private static Node findKthLastNodeRecursiveHelper(Node head, int k, IntegerWrapper i){

        if (head == null){
            return null;
        }

        Node currentNode = findKthLastNodeRecursiveHelper(head.next , k, i);
        i.value += 1;
        if ( i.value == k){
            return head;
        }
        return currentNode;

    }

    //------------------------------------------------------------------------------------------------------------------

    //alternate solution
    /*
    static class NodeWrapper{
        Node node;
        int indexFromEnd; //indexFromEnd in linked list from the end

        NodeWrapper(Node node, int index){
            this.node = node;
            this.indexFromEnd = index;
        }
    }

    public static Node findKthLastNodeRecursive_2(Node head, int k){
        //need to pass return a Node and a counter
        NodeWrapper kthLastNode = findKthLastNodeRecursiveHelper(new NodeWrapper(head, -1), k);
        return kthLastNode.node;

    }

    public static NodeWrapper findKthLastNodeRecursiveHelper(NodeWrapper headNodeWrapper, int k){

        if(headNodeWrapper.node == null){
            return new NodeWrapper(null, 0);
        }

        NodeWrapper currentNodeWrapper =  findKthLastNodeRecursiveHelper(new NodeWrapper(headNodeWrapper.node.next, -1), k);
        headNodeWrapper.indexFromEnd = currentNodeWrapper.indexFromEnd + 1;
        if( currentNodeWrapper.indexFromEnd  == k){
            return currentNodeWrapper;
        }else{
            return headNodeWrapper;
        }
    }
    */

    public static void main(String[] args){

        Node head = Node.createLinkedList();
        head.print();
        head = findKthLastNode(head, 6);
        head.print();

        head = Node.createLinkedList();
        head.print();
        head = findKthLastNodeRecursive(head, 6);
        head.print();

    }

}



