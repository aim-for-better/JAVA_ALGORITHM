package secondChapter;

/**
 * @Author: zzy
 * @Date: 2022-05-04
 * @Description: secondChapter
 */
public class ShellSort {

    public static void sort(Comparable[] a){
        if(a==null ||a.length==0){
            return;
        }
        int h=1;
        int N=a.length;
        while(h<N/3){
            h=3*h+1;
        }

        while(h>=1){
            for(int i=h; i<N;i++){
                for(int j=i; j>=h&&less(a[j], a[j-h]); j-=h){
                    exch(a, j, j-h);
                }
            }
            h=h/3;
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
