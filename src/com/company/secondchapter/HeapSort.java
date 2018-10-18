package com.company.secondchapter;

/**
 * Created by zzy on 18-9-19.
 */
public class HeapSort {

    /**
     * a from index 0,but heap sort need index from 1,so index 0 is useless
     *
     *
     * max Heap  sort asc
     * @param a
     */
    public static void sort(Comparable[] a){
        int N=a.length-1;

        //build heap
        for(int k=N/2;k>=1;k--){
            sink(a,k,N);
        }

        while(N>1){

            exch(a,1,N--);
            sink(a,1,N);
        }


    }
    private static void sink(Comparable[] a,int k,int N){
        while(2*k<=N){

            int j=2*k;
            if(j<N&&less(a[j],a[j+1])) j++;
            if(!less(k,j)) break;
            exch(a,k,j);
            k=j;
        }
    }

    private static boolean less(Comparable v ,Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
