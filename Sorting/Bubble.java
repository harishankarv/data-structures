import java.util.Arrays;

public class Bubble {

    public static void sort(Comparable[] a) {
	for (int i = 0; i < a.length; i++) {
	    int exchanges = 0;
	    for (int j = a.length - 1; j > i; j--) {
		if (less(a[j], a[j - 1])) {
		    swap(a, j, j - 1);
		    exchanges++;
		}
	    }
	    if (exchanges == 0)
		break;
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
	String[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
	Bubble.sort(a);
	System.out.println(Arrays.toString(a));

    }

}
