import java.util.Arrays;

public class Selection {

    /*
     * at ith iteration, find the minimum to the right of a[i]
     * and exchange it with a[i]
     */
    public static void sort(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if (less(a[j], a[min])) 
                    min = j;
            }
            swap(a, i, min);
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
        String[] a = { "9", "8", "7", "6"};
        Selection.sort(a);
        System.out.println(Arrays.toString(a));

    }

}
