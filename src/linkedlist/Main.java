package linkedlist;

public class Main {

    public static void main(String[] args)	{

        LinkedList<Integer> myLL = new LinkedList<>();
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

        myLL.print();

        myLL.deleteAtBeginning();
        myLL.deleteAtBeginning();
        myLL.deleteAtEnd();
        myLL.deleteAtEnd();

        myLL.print();

        myLL.addAtIndex(1, 11);
        myLL.addAtIndex(1, 12);
        myLL.print();
        myLL.deleteAtIndex(2);
        myLL.print();
    }
}
