import java.util.Arrays;

public class Quick {

	public static void sort(Comparable[] a) {
		shuffle(a); // for performance guarantees
		System.out.println(Arrays.toString(a));
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;

		int j = partition(a, lo, hi);
		sort(a, lo, j - 1); // sort the left part
		sort(a, j + 1, hi); // sort the right part
	}

	/*
	 * a[lo] is the pivot. After this method returns, the pivot is in its final
	 * location. All elements to the left are smaller (or equal), all elements
	 * the right are larger (or equal). alt: while (i < j) and swap if (i < j)
	 */
	private static int partition(Comparable[] a, int lo, int hi) {

		int i = lo;
		int j = hi + 1;
		while (true) {

			// find an item on left greater than or equal to pivot
			while (less(a[++i], a[lo])) {
				if (i == hi)
					break;
			}

			// find an item on left lesser than or equal to pivot
			while (less(a[lo], a[--j])) {
				if (j == lo)
					break;
			}

			// check if pointers have crossed
			if (i >= j)
				break;
			swap(a, i, j);
		}

		swap(a, lo, j);
		return j;

	}

	// is A strictly less than B
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// Knuth shuffle: Rearranges an array of objects in uniformly random order
	private static void shuffle(Object[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			// choose index uniformly in [i, N-1]
			int r = i + (int) (Math.random() * (N - i));
			Object swap = a[r];
			a[r] = a[i];
			a[i] = swap;
		}
	}

	public static void main(String[] args) {

		System.out.println("A".compareTo("A"));
		String[] a = { "A", "B", "A", "A", "A", "B", "A", "A", "A", "A", "B", "B" };
		// String[] a = { "Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X",
		// "A", "M", "P", "L", "E" };
		Quick.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
