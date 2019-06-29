package com.company.chapter2_2;

import edu.princeton.cs.algs4.StdOut;

public class p2_2_19 {
    private static Comparable[] aux;
    private static int count;
    private static int inversecounter;

    public static void merge(Comparable[] a,int lo,int mid,int hi)
    {
        //将a[lo..mid]和a[mid+1..hi]归并
        int i=lo,j=mid+1;


        //将a[lo..hi]复制到aux[lo..hi]
        for(int k=lo;k<=hi;k++) {
            aux[k] = a[k];

        }

        for(int k=lo;k<=hi;k++)     //归并回到a[lo..hi]
            if(i>mid)   a[k]=aux[j++];
            else if(j>hi)   a[k]=aux[i++];
            else if(less(aux[j],aux[i])) {a[k]=aux[j++];inversecounter += mid-i+1;}
            else a[k]=aux[i++];



    }

    private static boolean less(Comparable aux, Comparable aux1) {
        if(aux.compareTo(aux1)<0) return true;
        return false;
    }


    public static void sort(Comparable[] a)
    {
        aux=new Comparable[a.length];

        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi)
    {
        if(hi<=lo) return;
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

//    public static void sortBU(Comparable[] a)
//    {
//        int N=a.length;
//        aux = new Comparable[N];
//
//        count=0;
//
//        for(int sz=1;sz<N;sz=sz+sz)
//            for(int lo=0;lo<N-sz;lo+=sz+sz)
//                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
//    }

    public static void main(String[] args)
    {
        //Integer[] a = {1,2,3,4,5,6,7};
        Integer[] a = {5,3,4,2,1};
        inversecounter=0;
        sort(a);
        StdOut.println(inversecounter);
    }


}
