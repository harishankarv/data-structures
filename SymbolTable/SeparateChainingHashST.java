/*
 * A symbol table of generic Key-Value pairs
 * Internally maintains a constant sized array (a prime like 97) of Nodes
 * Requires that Key overrides the equals() and hashCode() methods.
 * Uses hashCode to find index into the array. If two Keys hash to the same index, 
 * another Node is appended to the existing node. 
 */
public class SeparateChainingHashST<Key, Value> implements SymbolTable<Key, Value> {

	private int M = 97;
	private int N;
	private Node[] st = new Node[M];

	public static class Node {
		Object key;
		Object val;
		Node next;

		public Node(Object key, Object val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}

		public String toString() {
			return "<" + key.toString() + "," + val.toString() + ">";
		}

	}

	/* possible 1-in-a-billion bug */
	private int hash(Key key) {
		return Math.abs(key.hashCode() % M);
	}

	// node is inserted to the start everytime
	@Override
	public void put(Key key, Value val) {
		if (val == null) {
			delete(key);
			return;
		}
		int i = hash(key);
		Node x = st[i];
		while (x != null) {
			if (x.key.equals(key)) {
				x.val = (Value) val;
				return;
			}
			x = x.next;
		}
		st[i] = new Node((Key) key, (Value) val, st[i]);
		N++;
	}

	@Override
	public Value get(Key key) {
		int i = hash(key);
		Node x = st[i];
		while (x != null) {
			if (x.key.equals(key))
				return (Value) x.val;
			x = x.next;
		}
		return null;
	}

	@Override
	public void delete(Key key) {
		// TODO Auto-generated method stub
		int i = hash(key);
		Node x = st[i];
		if (x == null)
			return;
		while (x != null) {
			if (x.key.equals(key)) {
				x = delete(x);
				break;
			}
			x = x.next;
		}

	}

	private Node delete(Node x) {
		N--;
		if (x.next == null)
			return null;
		x.key = x.next.key;
		x.val = x.next.val;
		x.next = x.next.next;
		return x;
	}

	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Key> keys() {
		Queue<Key> q = new Queue<>();
		for (Node x : st)
			add(q, x);
		return q;
	}

	private void add(Queue<Key> q, Node x) {
		if (x == null)
			return;
		while (x != null) {
			q.enqueue((Key) x.key);
			x = x.next;
		}
	}

	public static void main(String[] args) {

		String filename = args[0];
		In in = new In(filename);

		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
		for (int i = 0; !in.isEmpty(); i++) {
			String key = in.readString();
			st.put(key, i);
		}

		st.delete("H");

		// print keys
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}

}