package com.company.secondchapter;

/**
 * Created by zzy on 18-9-19.
 */
public class Applications {


    /**
     * select the k smallest elements in a[]
     * @param a
     * @param k
     * @return
     */
    public static Comparable select(Comparable[]a ,int k){

        int lo=0,hi=a.length-1;
        while(hi>lo){
            int j=partition(a,lo,hi);
            if(j==k) return a[k];
            else if(j<k) lo=j+1;
            else if(j>k) hi=j-1;
        }
        return a[k];
    }

    private static int partition(Comparable[] a,int lo,int hi){

        Comparable v=a[lo];
        int i=lo,j=hi+1;
        while(true){
            while(a[++i].compareTo(v)<0) if(i==hi)break;
            while(a[--j].compareTo(v)>0) if(j==lo) break;
            if(i>=j) break;
            exch(a,i,j);
        }

        exch(a,lo,j);
        return j;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
