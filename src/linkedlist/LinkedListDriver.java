package linkedlist;

public class LinkedListDriver {

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
