import java.util.Arrays;

public class MergeBU {

	public static void merge(Comparable[] a, Comparable[] aux, int lo, int hi, int mid) {

		for (int i = 0; i < a.length; i++) {
			aux[i] = a[i];
		}

		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(a[i], a[j]))
				a[k] = aux[i++];
			else
				a[k] = aux[j++];

		}

	}

	/*
	 * similar to merge sort, but: we first sort the smallest unit and merge,
	 * followed by larger units. sz is the size of the units being merged. start
	 * with 2 and then increase sz by sz
	 */
	public static void sort(Comparable[] a) {

		Comparable[] aux = new Comparable[a.length];

		int N = a.length;
		for (int sz = 2; sz < N; sz += sz) {
			for (int i = 0; i < N; i += sz) {
				int lo = i;
				int hi = i + sz - 1;
				if (hi > N - 1)
					hi = N - 1;
				int mid = lo + (hi - lo) / 2;
				merge(a, aux, lo, hi, mid);
			}
		}

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

	public static void main(String[] args) {
		String[] a = { "M", "E", "R", "G", "E", "S", "O", "R", "T" };
		MergeBU.sort(a);
		System.out.println(Arrays.toString(a));

	}

}
