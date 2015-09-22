import java.util.ArrayList;

public class BinarySearchTreeST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {

	enum traversal {
		IN, PRE, POST, LEVEL;
	}

	private Node root;

	private class Node {
		Key key;
		Value val;
		Node left, right;

		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
	}

	public BinarySearchTreeST() {

	}

	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	// x is the root of a subtree, which is a tree in itself
	private Node put(Node x, Key key, Value val) {
		if (x == null)
			return new Node(key, val);

		if (key.compareTo(x.key) < 0)
			x.left = put(x.left, key, val);
		else if (key.compareTo(x.key) > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		return x;
	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null)
			return null;
		if (key.compareTo(x.key) < 0)
			return get(x.left, key);
		else if (key.compareTo(x.key) > 0)
			return get(x.right, key);
		else
			return x.val;
	}

	public void delete(Key key) {
		delete(root, key);
	}

	/*
	 * hibbard deletion: For the node to delete (x), If both children are null,
	 * return null to parent. If one child is null, return the other child to
	 * parent. If both children are not null: 1. Find minimum in right subtree
	 * 2. Change the <k, v> of x to the <k, v> of the min. 3. delete the minimum
	 * in the right subtree. return the node with changed <k,v> to parent.
	 */
	private Node delete(Node x, Key key) {
		if (x == null)
			return null;

		if (key.compareTo(x.key) < 0)
			x.left = delete(x.left, key);
		else if (key.compareTo(x.key) > 0)
			x.right = delete(x.right, key);
		else {
			// now x points to the Node to delete.
			if (x.right == null && x.left == null)
				return null;
			if (x.right == null && x.left != null)
				return x.left;
			if (x.right != null && x.left == null)
				return x.right;

			Node y = min(x.right);
			x.key = y.key;
			x.val = y.val;
			x.right = deleteMin(x.right);
		}
		return x;
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		return x;
	}

	public Node min() {
		return min(root);
	}

	private Node min(Node x) {
		if (x.left == null)
			return x;
		return min(x.left);
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	// largest element greater than key
	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null)
			return null;
		return x.key;
	}

	private Node floor(Node x, Key key) {
		if(x == null)
			return null;
		else if (key.compareTo(x.key) == 0)
			return x;
		else if (key.compareTo(x.key) < 0)
			return floor(x.left, key);
		else{

			Node y = floor(x.right, key);
			if (y == null)
				return x;
			else
				return y;
		}
	}

	public Key ceil(Key key) {
		Node x = ceil(root, key);
		if (x == null)
			return null;
		return x.key;
	}

	private Node ceil(Node x, Key key) {
		if(key == null)
			return null;
		else if (key.compareTo(x.key) == 0)
			return x;
		else if (key.compareTo(x.key) > 0)
			return ceil(x.right, key);
		else {
			Node y = ceil(x.left, key);
			if (y == null)
				return x;
			else
				return y;
		}
	}

	public Iterable<Key> keys() {
		ArrayList<Key> a = new ArrayList<>();
		inorder(a, root);
		return a;
	}

	public Iterable<Key> keys(traversal tr) {
		ArrayList<Key> a = new ArrayList<>();
		switch (tr) {
		case IN:
			inorder(a, root);
			break;
		case PRE:
			preorder(a, root);
			break;
		case POST:
			postorder(a, root);
			break;
		case LEVEL:
			levelorder(a);
			break;
		default:
			inorder(a, root);
		}
		return a;
	}

	private void inorder(ArrayList<Key> a, Node x) {
		if (x == null)
			return;
		inorder(a, x.left);
		a.add(x.key);
		inorder(a, x.right);
	}

	private void preorder(ArrayList<Key> a, Node x) {
		if (x == null)
			return;
		a.add(x.key);
		preorder(a, x.left);
		preorder(a, x.right);
	}

	private void postorder(ArrayList<Key> a, Node x) {
		if (x == null)
			return;
		postorder(a, x.left);
		postorder(a, x.right);
		a.add(x.key);
	}

	private void levelorder(ArrayList<Key> a) {
		Queue<Node> q = new Queue<>();
		q.enqueue(root);
		while (!q.isEmpty()) {
			Node x = q.dequeue();
			a.add(x.key);
			if (x.left != null)
				q.enqueue(x.left);
			if (x.right != null)
				q.enqueue(x.right);
		}
	}
	
	public static void main(String[] args) {

		String test = "S E A R C H E X A M P L E";
		String[] keys = test.split(" ");
		int N = keys.length;
		BinarySearchTreeST<String, Integer> bst = new BinarySearchTreeST<>();
		for (int i = 0; i < N; i++)
			bst.put(keys[i], i);

		// print keys
		for (String s : bst.keys(traversal.IN))
			StdOut.println(s + " " + bst.get(s));
		StdOut.println();
		for (String s : bst.keys(traversal.PRE))
			StdOut.println(s + " " + bst.get(s));
		StdOut.println();
		for (String s : bst.keys(traversal.POST))
			StdOut.println(s + " " + bst.get(s));
		StdOut.println();
		for (String s : bst.keys(traversal.LEVEL))
			StdOut.println(s + " " + bst.get(s));
	}
}
