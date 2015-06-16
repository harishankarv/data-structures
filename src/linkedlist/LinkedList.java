package linkedlist;

/**
 * Created by Harishankar on 16-06-2015.
 */

public class LinkedList<Item> {
    private int N;            //size of LinkedList
    private Node<Item> head;  //head of LinkedList

    //helper class
    private static class Node<Item>{
        Item data;
        Node<Item> next;
    }

    public LinkedList() 	{
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

    public void print(){
        for(Node<Item> temp = head; temp != null; temp = temp.next){
            System.out.print(temp.data + "->");
        }
        System.out.println("/");
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
        Node<Item> nextNode = head;
        for(int i = 1; i<index ; i++){
            previousNode = currentNode;
            currentNode = currentNode.next;
            nextNode = currentNode.next;
        }
        previousNode.next = nextNode;
    }
}