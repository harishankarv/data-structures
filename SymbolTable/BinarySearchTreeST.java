import java.util.ArrayList;

public class BinarySearchTreeST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {

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

	// hibbard deletion
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
		if (key.compareTo(x.key) == 0)
			return x;
		else if (key.compareTo(x.key) < 0)
			return floor(x.left, key);
		else {
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
		if (key.compareTo(x.key) == 0)
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

	private void inorder(ArrayList<Key> a, Node x) {
		if (x.left != null)
			inorder(a, x.left);
		a.add(x.key);
		if (x.right != null)
			inorder(a, x.right);
	}

	public static void main(String[] args) {
		BinarySearchTreeST<String, Integer> bst = new BinarySearchTreeST<>();
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			bst.put(key, i);
		}

		// print keys
		for (String s : bst.keys())
			StdOut.println(s + " " + bst.get(s));
	}
}
