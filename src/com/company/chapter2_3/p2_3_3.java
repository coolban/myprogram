package com.company.chapter2_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;



public class p2_3_3 {

    static int count=0;

    private static void sort(Comparable[] a,int lo,int hi)
    {
        if(hi<=lo) return;
        int lt=lo,i=lo+1,gt=hi;
        Comparable v = a[lo];
        while(i<=gt)
        {
            int cmp=a[i].compareTo(v);
            if(cmp<0) {exch(a,lt++,i++);count++;}
            else if(cmp>0) {exch(a,i,gt--);count++;}
            else i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    public static void main(String[] args) {
        Integer[] a=new Integer[100000];

        for (int i = 0; i <a.length ; i++) {

            a[i]= StdRandom.uniform(2);

        }

        sort(a,0,a.length-1);

        if(isSorted(a))
        {
            StdOut.println("OK");
            StdOut.println(count);
        }
        else StdOut.println("Not Ok");



    }
}
