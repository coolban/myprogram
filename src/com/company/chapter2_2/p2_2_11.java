package com.company.chapter2_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class p2_2_11 {

    private static int height;
    private static int flag;
    //private static int count;

    public static void merge(double[] a,double[] aux,int lo,int mid,int hi)
    {
        //将a[lo..mid]和a[mid+1..hi]归并
        int i=lo,j=mid+1;


        //将a[lo..hi]复制到aux[lo..hi]
//        for(int k=lo;k<=hi;k++) {
//            aux[k] = a[k];
//            //count+=2;
//        }

        for(int k=lo;k<=hi;k++)     //归并回到a[lo..hi]
            if(i>mid)   a[k]=aux[j++];
            else if(j>hi)   a[k]=aux[i++];
            else if(less(aux[j],aux[i])) {a[k]=aux[j++];/*count+=2;*/}
            else a[k]=aux[i++];

//        count+=2;

    }

    private static boolean less(double aux, double aux1) {
        if(aux<aux1) return true;
        return false;
    }


    public static void sort(double[] a)
    {
        double[] aux;
        aux=new double[a.length];
        for (int i = 0; i <a.length ; i++) {
            aux[i]=a[i];
        }
        //第一次merge的层
        height = (int)Math.ceil(Math.log(a.length)/Math.log(2))-5;
        //flag = height%2;
//        count=0;
        int level=0;
        sort(a,aux,0,a.length-1,level);
    }

    private static void sort(double[] a,double[] aux,int lo,int hi,int level)
    {
        //if(hi<=lo) return;
        level++;
        if(level>=height-4) {
            InsertSort(a,lo,hi);
            return;
        }
        int mid=lo+(hi-lo)/2;

            sort(aux,a, lo, mid,level);
            sort(aux,a, mid + 1, hi,level);
            merge(a,aux,lo, mid, hi);



    }

    private static void InsertSort(double[] a,int lo,int hi)
    {
        for (int i = lo+1; i <=hi ; i++) {
            for (int j = i; j >lo && less(a[j],a[j-1]) ; j--) {
                exch(a,j,j-1);
            }
        }
    }

    private static void exch(double[] a, int i, int j) {
        double temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private static boolean isSorted(double[] a) {
        for (int i = 1; i < a.length; i++) {
            if(less(a[i],a[i-1])) return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        int length=1345;
        double [] a = new double[length];
        for (int i = 0; i <a.length ; i++) {
              a[i]= StdRandom.uniform();
        }

        sort(a);

        if(isSorted(a)) StdOut.println("Good.");
        else StdOut.println("No Good.");
        //if(isSorted(aux)) StdOut.println("Good.");
        //else StdOut.println("No Good.");

//        for (int i = 0; i < a.length; i++) {
//            StdOut.println(a[i]);
//        }
    }


}
