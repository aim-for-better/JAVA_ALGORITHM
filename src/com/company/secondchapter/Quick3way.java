package com.company.secondchapter;

import static com.company.secondchapter.Base.*;

/**
 * Created by zzy on 18-9-19.
 */
public class Quick3way {


    public static void sort(Comparable[] a, int lo, int hi) {

        if (hi <= lo) return;
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {

            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, i++, lt++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
