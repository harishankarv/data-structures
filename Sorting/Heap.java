import java.util.Arrays;

public class Heap {

	public static void sort(Comparable[] a) {
		/*
		 * HEAP CONSTRUCTION 
		 * assume array is 1-indexed. Start max-heap ordering
		 * heaps rooted at all nodes. Bottom n/2 elements are heaps of size 1,
		 * they are in max-heap order. Call sink() on all elements starting from
		 * array[n/2], as heaps rooted at them may not be max-heap ordered.
		 */
		int N = a.length;
		for (int k = N / 2; k >= 1; k--) {
			sink(a, k, N);
		}

		/*
		 * HEAP SORTDOWN
		 * Peel off elements from the top of the heap, and exchange it with the last element of the heap.
		 * But now heap order will be violated, so call sink on the heap root.
		 * Max elements keep accumulating at the end of the array.
		 */
		while (N > 1) {
			swap(a, N--, 1);
			sink(a, 1, N);
		}

	}

	private static void sink(Comparable[] a, int k, int N) {
		int parent = k;
		int child = 2 * parent; 
		if (child < N && less(a, child, child + 1))
			child++;

		while (2 * parent <= N && less(a, parent, child)) {
			swap(a, parent, child);
			parent = child;
			if (parent * 2 > N) {
				break;
			}
			child = 2 * parent;
			if (child < N && less(a, child, child + 1))
				child++;
		}
	}

	// is A strictly less than B
	private static boolean less(Comparable[] a, int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}

	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		String[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		Heap.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
