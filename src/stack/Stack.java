package stack;

/**
 * Created by Harishankar on 27-06-2015.
 */

/*
 * a LIFO Stack which internally uses a linked list.
 */

public class Stack<Item> {

    private int N;
    private Node<Item> head;

    private static class Node<Item>{
        Item data;
        Node<Item> next;
    }

    public Stack(){
        head = null;
        N =0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return N;
    }

    public void push(Item data) {

        Node oldHead = head;
        head = new Node<Item>();
        head.data = data;
        head.next = oldHead;

        N++;
    }


    public Item pop() {

        if (isEmpty()) {
            return null;
            //TODO exception
        }

        Node<Item> oldHead = head;
        head = head.next;
        N--;
        return oldHead.data;
    }

    public static void main(String[] args){

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(8);stack.push(7);stack.push(6);stack.push(5);
        stack.push(4);stack.push(3);stack.push(2);stack.push(1);
        System.out.println(stack.pop());System.out.println(stack.pop());System.out.println(stack.pop());
        System.out.println(stack.pop());System.out.println(stack.pop());System.out.println(stack.pop());
        System.out.println(stack.pop());System.out.println(stack.pop());

    }


}
