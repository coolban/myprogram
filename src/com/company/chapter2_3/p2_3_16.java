package com.company.chapter2_3;

import edu.princeton.cs.algs4.StdOut;

public class p2_3_16 {
    public static void bestSortCase(Comparable[] a,int lo,int hi){
        if(lo>=hi)
            return;
        int mid = (lo+hi)/2;
//        moveexch(a,lo,mid);
        bestSortCase(a,lo,mid-1);
        bestSortCase(a,mid+1,hi);
        exch(a,lo,mid);

    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    private static void moveexch(Comparable[] a, int i, int j) {
        Comparable temp=a[j];
//        a[i]=a[j];
//        a[j]=temp;
        for (int k = j-1; k >=i ; k--) {
            a[k+1]=a[k];
        }
        a[i]=temp;
    }
    public static void main(String[] args) {
        String[] a = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
//        for (int i = 0; i < a.length; i++) {
//            a[i]=i;
//
//        }

        bestSortCase(a,0,a.length-1);

        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }

    }


}
