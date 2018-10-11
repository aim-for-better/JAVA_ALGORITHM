package com.company.secondchapter;

/**
 * Created by zzy on 18-9-17.
 */
public class SelectionSort {

    public static void main(String[] args){


    }
    public static void sort(Comparable[] a){
        int N=a.length;
        for(int i=0;i<N;i++){
            int min=i;
            for(int j=i+1;j<N;j++){
               if(less(a[j],a[min])){
                   min=j;
               }
            }

            exch(a,i,min);
        }
    }

    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    public static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
