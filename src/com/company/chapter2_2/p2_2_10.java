package com.company.chapter2_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class p2_2_10 {
    private static Comparable[] aux;
    //private static int count;

    public static void sort(Comparable[] a)
    {
        Comparable [] aux;
        aux=new Comparable[a.length];
        //count=0;
        sort(a,0,a.length-1,aux);
    }

    private static void sort(Comparable[] a,int lo,int hi,Comparable[] aux)
    {
        if(hi<=lo) return;
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid,aux);
        sort(a,mid+1,hi,aux);
        merge(a,lo,mid,hi,aux);

    }
    private static void merge(Comparable[] a,int lo,int mid,int hi,Comparable[] aux)
    {
        for (int i = lo; i <=mid ; i++) {
            aux[i]=a[i];
        }

        int index=mid+1;
        for (int i = hi; i > mid ; i--) {
            aux[index++]=a[i];

        }

        int i1=lo;
        int j1=hi;

        for (int i = lo; i <=hi ; i++) {
            //if(i1>=j1) return;
            if(less(aux[i1],aux[j1])) a[i]=aux[i1++];
            else a[i]=aux[j1--];
        }

    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static boolean less(Comparable aux, Comparable aux1) {
        return aux.compareTo(aux1)<0;
    }

    public static void main(String[] args) {
        int trial=100;
        Double [] a= new Double[10];
        for (int i = 0; i <trial ; i++) {
            for (int j = 0; j <a.length ; j++) {
                a[j]= StdRandom.uniform();
            }
            sort(a);
            if(isSorted(a)) StdOut.println("GOOD.");
            else StdOut.println("No Good.");

        }

    }
}
