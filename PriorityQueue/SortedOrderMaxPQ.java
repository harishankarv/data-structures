import java.util.NoSuchElementException;

/*
 * Ordered Maximum Priority Queue.
 * Maintains a resizable array of elements
 * insert(): O(N) worst case time. 
 * delMax(): return the last item of array. O(1) time.
 */
public class SortedOrderMaxPQ<Key extends Comparable<Key>> {

	private Key[] pq; // pq[i] = ith element on pq
	private int N; // number of items on priority queue.
	// (N points to LAST + 1 element in PQ, whe re next item is to be inserted)

	public SortedOrderMaxPQ() {
		pq = (Key[]) new Comparable[2];
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	/*
	 * shift all items greater than key to be inserted to the right.
	 * break out of loop and insert key.
	 */
	public void insert(Key x) {
		if (N == pq.length) {
			resize(2 * pq.length);
		}
		int i = N - 1;
		while (i >= 0 && less(x, pq[i])) {
			pq[i + 1] = pq[i];
			i--;
		}
		pq[i + 1] = x;
		N++;
	}

	/*
	 * remove the last element and resize if necessary
	 */
	public Key delMax() {
		if (isEmpty())
			throw new NoSuchElementException("underflow");

		Key k = pq[N - 1];
		pq[N - 1] = null;
		N--;

		if (N > 0 && N == pq.length / 4) {
			resize(pq.length / 2);
		}
		return k;
	}

	// is A strictly less than B
	private boolean less(Key a, Key b) {
		return a.compareTo(b) < 0;
	}

	private void swap(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	private void resize(int capacity) {
		Key[] copy = (Key[]) new Comparable[capacity];
		for (int i = 0; i < N; i++)
			copy[i] = pq[i];
		pq = copy;
	}

	public static void main(String[] args) {
		SortedOrderMaxPQ<String> queue = new SortedOrderMaxPQ<String>();
		queue.insert("P");
		queue.insert("R");
		queue.insert("I");
		queue.insert("O");
		queue.insert("R");
		queue.insert("I");
		queue.insert("T");
		queue.insert("Y");
		queue.insert("Q");
		queue.insert("U");
		queue.insert("E");
		queue.insert("U");
		queue.insert("E");

		while (!queue.isEmpty()) {
			System.out.printf("%s ", queue.delMax());
		}
	}

}