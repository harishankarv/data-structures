
public class LL {
	
	private Node head;
	//private int length;

	public LL()
	{
		head = null;
	}
	
	public void add(int d) 
	{
		System.out.println("in add()");
		Node temp = head;
		while(temp.next != null)
			{
				temp = temp.next;
				System.out.println("going next");
			}
		System.out.println("adding");
		Node last = new Node(d);
		temp.next = last;
	}

	public void print()
	{
		Node temp = head;
		while(temp.next != null)
			{
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
	}

	/*public void reverse()
	{

	}*/
}