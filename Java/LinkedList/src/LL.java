

public class LL {
	
	private Node head;
	//private int length;

	public LL() 	{
		head = null;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public void print(){
		Node temp = head;
		while(temp.next != null){
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println(temp.data + "->" + "|");
	}

	
	//----------------------------------------------------------------------------------------------------
	
	public void addAtBeginning(int d) {
		Node newHead = new Node();
		newHead.data = d;
		newHead.next = head;
		
		head = newHead;
	}

	public void addAtEnd(int d) {
		
		Node newLast = new Node();
		newLast.data = d;
		newLast.next = null;
		
		if (isEmpty()) {
			head = newLast; 
			return;
		}
	
		Node temp = head;
		while(temp.next != null)	{	
			temp = temp.next;	
		}	
		temp.next = newLast;
	}

	//****//
	public void deleteAtEnd()	{
		Node temp = head;
		Node prev = temp;
		while(temp.next!=null){
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
		
	}	
	
	public void deleteAtBeginning(){
		Node newHead = head.next;
		head = newHead;
	}

	//----------------------------------------------------------------------------------------------------

	public void reverse()	{
		if (head.next == null){	
			return;	
		}
		
		Node before = head;
		Node current = head.next;
		Node after = head.next.next;
		
		while(current != null) {
			after = current.next;
			current.next = before;
			before = current;
			current = after;
		}
		
		head.next = null;
		System.out.println();
		head = before;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	public void reverseRecursive() {
		
	}
	
}