package linkedlistproblems;

/**
 * Created by Harishankar on 17-06-2015.
 */

  public class Node {
      public int data;
      public Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public void addAtEnd(int data) {

        Node newLast = new Node(data);
        Node currentNode = this;

        while(currentNode.next != null)	{
            currentNode = currentNode.next;
        }
        currentNode.next = newLast;
    }

    public void print(){
        Node currentNode = this;
        while(currentNode!= null){
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println("//");
    }

  }
