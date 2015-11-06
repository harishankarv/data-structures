import java.util.Arrays;

public class Insertion {

    /*
     * at ith iteration, look a[i] and exchange it with all the
     * numbers to the left (iteratively) which are less than it
     */
    public static void sort(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1]))
                    swap(a, j - 1, j);
                else
                    break;
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
        String[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));

    }

}
