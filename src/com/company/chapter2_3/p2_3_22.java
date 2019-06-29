package com.company.chapter2_3;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class p2_3_22 {

    private static void QuickSort(Comparable[] a,int lo,int hi)
    {
        //排序结束
        if(hi<=lo) return;
        int p,q,i,j;

        int tempi;
        int tempj;
        //初始化p、q、i、j
        //以满足a[lo..p-1]=v
        //a[p..i-1]<v
        //a[i..j]待定
        //a[j+1..q]>v
        //a[q+1..hi]=v
        p=lo+1;
        i=lo+1;
        j=hi;
        q=hi;

        Comparable v=a[lo];

        while(true)
        {


            while(a[i].compareTo(v)<=0)
            {
                if(a[i].compareTo(v)==0)
                    exch(a,i++,p++);
                else i++;

                if(i>q) break;

            }

            while (a[j].compareTo(v)>=0)
            {
                if(a[j].compareTo(v)==0)
                    exch(a,j--,q--);
                else j--;

                if(j<p) break;

            }

            if(i>j) break;

            exch(a,i,j);
        }

        int middleleft;
        int middleright;

        middleleft=j;
        middleright=j+1;

        if(q<lo) q=lo;
        if(p>hi) p=hi;

        for (int k = q+1; k <=hi ; k++) {
            exch(a,middleright++,k);
        }

        for (int k = p-1; k >=lo ; k--) {
            exch(a,middleleft--,k);
        }

        QuickSort(a,lo,middleleft);
        QuickSort(a,middleright,hi);

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

        for (int k = 1; k <10000000 ; k=k*2) {


            int num = k;

            Integer[] a = new Integer[num];

            for (int i = 0; i < a.length; i++) {
                a[i] = StdRandom.uniform(1000);
            }


            QuickSort(a, 0, a.length - 1);


//        for (int i = 0; i < a.length; i++) {
//            StdOut.println(a[i]);
//        }

            if(!isSorted(a)) {StdOut.println("No Good"); break;}
        }

        StdOut.println("Good");

    }

}
