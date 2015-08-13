import java.util.NoSuchElementException;

/*
 * Unordered Maximum Priority Queue.
 * Maintains a resizable array of elements
 * insert(): O(1) time 
 * delMax(): O(N) time
 */
public class UnorderedMaxPQ<Key extends Comparable<Key>> {

	private Key[] pq; // pq[i] = ith element on pq
	private int N; // number of items on priority queue.
	// (N points to LAST + 1 element in PQ, where next item is to be inserted)

	public UnorderedMaxPQ() {
		pq = (Key[]) new Comparable[2];
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void insert(Key x) {
		if (N == pq.length) {
			resize(2 * pq.length);
		}
		pq[N++] = x;
	}

	/*
	 * iterate through the array to get the maximum, swap with the last element,
	 * and delete the last element.
	 */
	public Key delMax() {
		if (isEmpty())
			throw new NoSuchElementException("underflow");

		int max = 0;
		for (int i = 1; i < N; i++) {
			if (less(max, i)) {
				max = i;
			}
		}

		swap(max, N - 1);
		Key k = pq[N - 1];
		pq[N - 1] = null;
		N--;

		if (N > 0 && N == pq.length / 4) {
			resize(pq.length / 2);
		}
		return k;
	}

	// is A strictly less than B
	private boolean less(int a, int b) {
		return (pq[a].compareTo(pq[b]) < 0);
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
		UnorderedMaxPQ<String> queue = new UnorderedMaxPQ<String>();
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