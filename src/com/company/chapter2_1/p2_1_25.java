package com.company.chapter2_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class p2_1_25 {
    public static void sort(Comparable[] a) {
        int n = a.length;
        setmin(a);
        for (int i = 1; i < n; i++) {
            Comparable temp=a[i];
            int j=i;
            for (; less(temp, a[j-1]); j--) {
                a[j]=a[j-1];
            }
            a[j]=temp;
            //assert isSorted(a, 0, i);
        }
        //assert isSorted(a);
    }

    private static void setmin(Comparable[] a) {
        if(a.length==0) return;
        int min=0;

        for (int i = 1; i < a.length ; i++) {
            if(less(a[i],a[min])) min=i;
        }
        exch(a,min,0);

    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }

    // is the array a[lo..hi) sorted
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i < hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        Integer[] a={2,3,1,5,5,2,5,7,8,0};

        Double [] d=new Double[10000];

        for (int i = 0; i < d.length; i++) {
            d[i]= StdRandom.uniform();
        }


        sort(d);

        if(isSorted(d)) StdOut.println("GOOD");
        else  StdOut.println("NO");


    }
}
