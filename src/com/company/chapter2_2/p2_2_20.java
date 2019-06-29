package com.company.chapter2_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class p2_2_20 {
    private static int[] aux;
    private static int count;

    public static int[] merge(Comparable[] a,int[] perm,int lo,int mid,int hi)
    {
        //将a[lo..mid]和a[mid+1..hi]归并
        int i=lo,j=mid+1;


        //将a[lo..hi]复制到aux[lo..hi]
        for(int k=lo;k<=hi;k++) {
            aux[k] = perm[k];
        }

        for(int k=lo;k<=hi;k++)     //归并回到a[lo..hi]
            if(i>mid)   perm[k]=aux[j++];
            else if(j>hi)   perm[k]=aux[i++];
            else if(less(a[aux[j]],a[aux[i]])) {perm[k]=aux[j++];}
            else perm[k]=aux[i++];

            return perm;

    }

    private static boolean less(Comparable aux, Comparable aux1) {
        if(aux.compareTo(aux1)<0) return true;
        return false;
    }


    public static int[] sort(Comparable[] a)
    {
        int [] perm=new int[a.length];
        for (int i = 0; i <perm.length ; i++) {
            perm[i]=i;
        }
        aux=new int[a.length];

       return sort(a,perm,0,a.length-1);
    }

    private static int[] sort(Comparable[] a,int[] perm,int lo,int hi)
    {
        if(hi<=lo) return perm;
        int mid=lo+(hi-lo)/2;
        sort(a,perm,lo,mid);
        sort(a,perm,mid+1,hi);
        return merge(a,perm,lo,mid,hi);
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
    public static void main(String[] args) {
        Double[] d = new Double[1000000];
        for (int i = 0; i < d.length; i++) {
            d[i]= StdRandom.uniform();
//            StdOut.println(d[i]);

        }


        StdOut.println();
        StdOut.println();
        int [] p = sort(d);

        for (int i = 1; i < p.length; i++) {
            if(d[p[i-1]]>d[p[i]]) StdOut.println("Wrong!");
        }
    }
}
