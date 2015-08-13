import java.util.NoSuchElementException;

/*
 * Heap-ordered Maximum Priority Queue using a binary heap.
 * Array is indexed starting with 1 to simplify parent and child calculations
 * insert(): O(log(N)) amortized time 
 * delMax(): O(log(N)) amortized time
 */


public class MaxPQ<Key extends Comparable<Key>> {
	
	private Key[] pq; // store items at indices 1 to N
	private int N; // number of items on priority queue.
	// (N points to LAST element in PQ, where last item was inserted)

	public MaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity];
		N = 0;
	}

	public MaxPQ() {
		this(2);
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	/*
	 * Insert element at end of array. May violate heap order (child becomes
	 * greater than parent), so call swim(). (N + 1 due to 1-based indexing)
	 */

	public void insert(Key x) {
		if (N + 1 == pq.length) {
			resize(pq.length * 2);
		}
		pq[++N] = x;
		swim(N);
	}

	public Key max() {
		return pq[1];
	}

	/*
	 * Delete maximum element and return it. Swap first (and largest) element
	 * with the last element. Remove last from the queue. May vilolate heap
	 * order (parent becomes greater than child), so call sink(). (N + 1 due to
	 * 1-based indexing)
	 */

	public Key delMax() {
		if (isEmpty())
			throw new NoSuchElementException("underflow");

		Key k = pq[1];
		swap(1, N--);
		pq[N + 1] = null;
		sink(1);
		if (N > 0 && N + 1 == pq.length / 4) {
			resize(pq.length / 2);
		}
		return k;

	}

	/*
	 * child's key becomes larger key than its parent's key. Exchange key in
	 * child with key in parent. Repeat until heap order restored.
	 */
	private void swim(int k) {

		int child = k;
		int parent = child / 2;
		while (child > 1 && less(parent, child)) {
			swap(parent, child);
			child = parent;
			if (child <= 1) {
				break;
			}
			parent = child / 2;
		}
	}

	/*
	 * parent's key becomes larger key than its parent's key. Exchange key in
	 * child with key in parent. Repeat until heap order restored.
	 * note: child < N: implies one more child exists.
	 * note: parent * 2 <= N: implies at least one child exists.
	 */
	private void sink(int k) {
		int parent = k;

		int child = 2 * parent; // choose the greater of the two children for swap.
		if (child < N && less(child, child + 1)) 
			child++;

		//continue till at least one child exists (and parent is less than child)
		while (2 * parent <= N && less(parent, child)) {
			swap(parent, child);
			parent = child;
			if (parent * 2 > N) {
				break;
			}
			child = 2 * parent; // choose the greater of the two children for swap.
			if (child < N && less(child, child + 1))
				child++;
		}
	}

	/*
	 * Helper functions for compares, resize and swap
	 */
	private void resize(int capacity) {
		Key[] temp = (Key[]) new Comparable[capacity];
		for (int i = 0; i <= N; i++)
			temp[i] = pq[i];
		pq = temp;
	}

	private boolean less(int i, int j) {
			return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void swap(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	/*
	 * Test client
	 */
	public static void main(String[] args) {
		MaxPQ<String> queue = new MaxPQ<String>();
		// P Q E X A M P L E
		queue.insert("P");
		queue.insert("Q");
		queue.insert("E");
		System.out.print(queue.delMax() + " ");
		queue.insert("X");
		queue.insert("A");
		queue.insert("M");
		System.out.print(queue.delMax() + " ");
		queue.insert("P");
		queue.insert("L");
		queue.insert("E");
		System.out.print(queue.delMax() + " ");
		System.out.println("(size: " + queue.size() + ")");
	}
}
