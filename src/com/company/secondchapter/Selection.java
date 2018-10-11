package com.company.secondchapter;

import static com.company.secondchapter.Base.*;

/**
 * Created by zzy on 18-9-18.
 */
public class Selection {

    public static void sort(Comparable[] a) {

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
}
