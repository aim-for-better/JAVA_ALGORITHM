package secondChapter;

/**
 * @Author: zzy
 * @Date: 2022-05-04
 * @Description: secondChapter
 */
public class SelectionSort {

    public static void sort(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static String printArray(Comparable[] a){
        if(a==null || a.length==0) return "";
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<a.length;i++){
            sb.append(a[i]);
            if(i!=a.length-1){
                sb.append(',');
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Integer [] a= new Integer[] {3, 4, 2, 1 ,5};
        System.out.println("Before sorting: "+ printArray(a));
        sort(a);
        System.out.println("After sortedy: "+ printArray(a));
    }
}
