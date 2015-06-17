package linkedlist;

/**
 * Created by Harishankar on 16-06-2015.
 */

public class LinkedList<Item> {

    private int N;            //size of LinkedList
    public Node<Item> head;  //head of LinkedList

    //helper class
    private static class Node<Item>{
        Item data;
        Node<Item> next;
    }

    public LinkedList(){
        head = null;
        N =0;
    }

    //Initialize empty LinkedList
    public boolean isEmpty() {
        return (head == null);
    }

    public int size(){
        return N;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Node<Item> temp = head; temp != null; temp = temp.next){
            stringBuilder.append(temp.data + "->");
        }
        stringBuilder.append("/");
        return stringBuilder.toString();
    }

    /*
     *Add
     */

    public void addAtBeginning(Item data) {
        Node<Item> newHead = new Node<Item>();
        newHead.data = data;
        newHead.next = head;
        head = newHead;
        N++;
    }

    public void addAtEnd(Item data) {

        Node<Item> newLast = new Node<Item>();
        newLast.data = data;
        newLast.next = null;
        N++;

        if (isEmpty()) {
            head = newLast;
            return;
        }

        Node<Item> temp = head;
        while(temp.next != null)	{
            temp = temp.next;
        }
        temp.next = newLast;
    }

    public void addAtIndex(int index, Item data){

        if (index > N || index <= 0){
            return; //TODO exception
            //if index = N+1, call addAtEnd
            //if index = 1, call addAtBeginning
        }

        if (index == 1){
            addAtBeginning(data);
            return;
        }

        Node<Item> newNode = new Node<Item>();
        newNode.data = data;
        newNode.next = null;
        N++;

        if(isEmpty()){
            head = newNode;
            return;
        }

        //use for loop when indexing is needed, i.e. atIndex, while loop otherwise
        Node<Item> currentNode = head;
        for(int i=1; i<index-1; i++){
            currentNode = currentNode.next;
        }
        Node<Item> nextNode = currentNode.next;
        newNode.next = nextNode;
        currentNode.next = newNode;
    }

    public void add(Item data){
        addAtEnd(data);
    }

    /*
     *Delete
     */
    public void deleteAtBeginning(){
        if (isEmpty()){
            return;
        }
        head = head.next;
        N--;
    }

    public void deleteAtEnd()	{
        if (isEmpty()){
            return;
        }

        Node<Item> currentNode = head;
        Node<Item> previousNode = currentNode;
        while(currentNode.next != null){
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        previousNode.next = null;
        N--;
    }

    public void deleteAtIndex(int index){
        if (index >N || index <=0){
            return;
        }

        if (index == 1){
            deleteAtBeginning();
            return;
        }

        Node<Item> currentNode = head;
        Node<Item> previousNode = head;
        Node<Item> nextNode = head.next;

        for(int i = 1; i<index ; i++){
            previousNode = currentNode;
            currentNode = currentNode.next;
            nextNode = currentNode.next;
        }
        previousNode.next = nextNode;
        N--;
    }

    //deletes the first occurence of data
    public void delete(Item data){
        if (isEmpty()){
            return;
        }
        if(head.data == data){
            head = head.next;
            N--;
            return;
        }

        Node<Item> currentNode = head;
        Node<Item> previousNode = head;
        Node<Item> nextNode = head.next;

        while(currentNode.next != null) {
            if(currentNode.data == data){
                previousNode.next = nextNode;
                N--;
                break;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
            nextNode = currentNode.next;
        }
    }

    public static void main(String[] args)	{

        LinkedList<Integer> myLL = new LinkedList<>();

        //---------basic tests---------
        myLL.addAtBeginning(1);
        myLL.addAtBeginning(2);
        myLL.addAtBeginning(3);
        myLL.addAtBeginning(4);
        myLL.addAtBeginning(5);
        myLL.addAtBeginning(1);
        myLL.addAtBeginning(2);
        myLL.addAtBeginning(3);
        myLL.addAtBeginning(4);
        myLL.addAtBeginning(5);
        myLL.addAtEnd(6);
        myLL.addAtEnd(7);
        myLL.addAtEnd(8);
        myLL.addAtEnd(9);
        myLL.addAtEnd(10);
        System.out.println(myLL.toString());

        myLL.deleteAtBeginning();
        myLL.deleteAtBeginning();
        myLL.deleteAtEnd();
        myLL.deleteAtEnd();
        System.out.println(myLL.toString());

        myLL.addAtIndex(1, 11);
        myLL.addAtIndex(1, 12);
        System.out.println(myLL.toString());

        myLL.deleteAtIndex(2);
        System.out.println(myLL.toString());

        myLL.delete(3);
        System.out.println(myLL.toString());

    }
}