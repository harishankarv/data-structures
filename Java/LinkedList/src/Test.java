

public class Test
{
	public static void main(String[] args)
	{
		LL myLL = new LL();
		myLL.addAtBeginning(1);
		myLL.addAtBeginning(2);
		myLL.addAtBeginning(3);
		myLL.addAtBeginning(4);
		myLL.print();
		
		myLL.addAtEnd(8);
		myLL.addAtEnd(9);
		myLL.addAtEnd(10);
		myLL.addAtEnd(11);
		myLL.print();
		
		myLL.deleteAtEnd();
		myLL.deleteAtEnd();
		myLL.deleteAtEnd();
		myLL.print();
		
		myLL.deleteAtBeginning();
		myLL.deleteAtBeginning();
		myLL.deleteAtBeginning();
		myLL.print();
		
		myLL.reverse();
		myLL.print();
	}
}