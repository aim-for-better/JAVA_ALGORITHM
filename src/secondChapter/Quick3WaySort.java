package secondChapter;

/**
 * @Author: zzy
 * @Date: 2022-05-05
 * @Description: secondChapter
 */
public class Quick3WaySort {

    public static void sort(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int hi) {
        if (hi <= low) return;

        int lt = low;
        int gt = hi;
        int i = low + 1;
        Comparable v = a[low];
        while (i <= gt) {  // here i needs to be equals gt because, we need to handle the gt index at firstly
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, low, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
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
