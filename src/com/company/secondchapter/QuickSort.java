package com.company.secondchapter;

/**
 * Created by zzy on 18-9-14.
 */
public class QuickSort {

    private static int[] a;
    private int N;

    public QuickSort(int N) {
        this.N = N;
        a = new int[N];
    }

    private static void sort(int[] a, int low, int hi) {
        if(hi<=low) return;
        int j=partition(a,low,hi);
        sort(a,low,j-1);
        sort(a,j+1,hi);
    }

    public static void sort() {
        sort(a, 0, a.length - 1);

    }

    private static int partition(int[] a, int low, int hi) {

        int v=a[low];
        int i=low;
        int j=hi+1;

        while(true){
            while(a[++i]<v) if(i==hi) break;
            while(a[--j]>v) if(j==low) break;

            if(i>=j) break;
            exch(a,i,j);
        }
        exch(a,low,j);

        return j;
    }

    /**
     * exchange a[i] a[j]
     * @param a
     * @param i
     * @param j
     */
    private static void exch(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
