package secondChapter;

/**
 * @Author: zzy
 * @Date: 2022-05-05
 * @Description: secondChapter
 */
public class QuickSort {
    public static void sort(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int hi){
        if(hi<=low){
            return;
        }

        int j=partition(a, low, hi);
        sort(a, low, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int low, int hi){

        Comparable v=a[low];
        int i=low;
        int j=hi+1;
        while(true){
            // scan from left to right, if the scan value less than v, then go on, u
            while(less(a[++i], v)){
                if(i==hi){
                    break;
                }
            }

            while(less(v, a[--j])){
                if(j==low){
                    break;
                }
            }

            if(i>=j)break;
            exch(a, i, j);
        }
        exch(a, low,j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
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

