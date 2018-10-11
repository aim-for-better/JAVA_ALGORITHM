package com.company.secondchapter;

import static com.company.secondchapter.Base.*;

/**
 * Created by zzy on 18-9-17.
 */
public class InsertionSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        //什么是插入排序, 就是处理第i个元素时, 在前ｉ-1个中选择位置
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }

        /*
        for(int i=1;i<N;i++){
            // 从i往前查找碰见比前面的小, 就交换位置, 直到找到一个合适的位置，前面没有更小的数了
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
        */
    }

}
