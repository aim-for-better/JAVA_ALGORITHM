package secondChapter;

/**
 * @Author: zzy
 * @Date: 2022-05-04
 * @Description: secondChapter
 */
public class MergeSort {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {

        if (a == null || a.length == 0) {
            return;
        }
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int hi) {
        if (hi <= low) {
            return;
        }

        int mid = low + (hi - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, hi);
        merge(a, low, mid, hi);
    }

    private static void merge(Comparable[] a, int low, int mid, int hi) {
        if(hi<=low) return;

        // copy the a to aux
        for (int k = low; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static String printArray(Comparable[] a) {
        if (a == null || a.length == 0) return "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i != a.length - 1) {
                sb.append(',');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 4, 2, 1, 5};
        System.out.println("Before sorting: " + printArray(a));
        sort(a);
        System.out.println("After sortedy: " + printArray(a));
    }
}
