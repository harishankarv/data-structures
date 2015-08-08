/**
 * Created by Harishankar on 27-06-2015.
 */

/*
 * a FIFO Queue which internally uses a linked list.
 */

public class Queue<Item> {

    private int N;
    private Node<Item> head;
    private Node<Item> tail;


    private static class Node<Item>{
        Item data;
        Node<Item> next;
    }

    public Queue() {
        head = null;
        tail = null;
        N =0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() { return N; }

    /*
     * enqueue at tail
     * dequeue from head
     */

    public void enQueue(Item data){

        Node<Item> oldTail = tail;
        tail = new Node<Item>();
        tail.data = data;
        tail.next = null;

        if(isEmpty()){
            head = tail;
        } else {
            oldTail.next = tail;
        }

        N++;
    }

    public Item deQueue(){

        if(isEmpty()){
            return null;
            //TODO exception
        }

        Item data = head.data;
        head = head.next;
        N--;

        if(isEmpty()){
            tail = null;
        }
        return data;
    }

    public static void main(String[] args){

        Queue<Integer> queue = new Queue<Integer>();
        queue.enQueue(1); queue.enQueue(2); queue.enQueue(3); queue.enQueue(4); queue.enQueue(5);
        queue.enQueue(6); queue.enQueue(7); queue.enQueue(8);

        System.out.println(queue.deQueue()); System.out.println(queue.deQueue()); System.out.println(queue.deQueue());
        System.out.println(queue.deQueue()); System.out.println(queue.deQueue()); System.out.println(queue.deQueue());
        System.out.println(queue.deQueue()); System.out.println(queue.deQueue());
    }

}
