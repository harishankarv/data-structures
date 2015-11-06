import java.util.Arrays;

public class Shell {

    /*
     * h-sort the array, i.e. sort sub-arrays formed by considering items
     * h-apart, using insertion sort. This yields a partially sorted array,
     * which can be more easily 1-sorted (the conventional insertion sort). use
     * h = 1, 4, 13, 40, ... (generated using h: 3*h + 1), starting from the
     * highest to the lowest h.
     */
    public static void sort(Comparable[] a) {

        int h = 1;

        while (h < a.length / 3)
            h = 3 * h + 1;

        while (h > 0) {

            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h]))
                        swap(a, j - h, j);
                    else
                        break;
                }
            }

            h /= 3;
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
        Shell.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
