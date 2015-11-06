import java.util.Arrays;

public class Merge{

    /*
     * Given two sorted subarrays a[lo] to a[mid] and a[mid+1] to a[hi], replace
     * with sorted subarray a[lo] to a[hi].
     */
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int hi, int mid) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[i], aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }

    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, hi, mid);

    }
    

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
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
        
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        String b = a[1].substring(2);
        Merge.sort(a);
        System.out.println(Arrays.toString(a));

    }

}
