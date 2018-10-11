package com.company.secondchapter;

/**
 * Created by zzy on 18-9-17.
 */
public class Base {
    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    public static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public static boolean isSorted(Comparable[] a){

        int N=a.length;
        for(int i=1;i<N;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }
}
