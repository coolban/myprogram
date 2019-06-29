package com.company.chapter2_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class p2_2_6 {

    private static Comparable[] aux;
    private static int count;

    public static void merge(Comparable[] a,int lo,int mid,int hi)
    {
        //将a[lo..mid]和a[mid+1..hi]归并
        int i=lo,j=mid+1;


        //将a[lo..hi]复制到aux[lo..hi]
        for(int k=lo;k<=hi;k++) {
            aux[k] = a[k];
            count+=2;
        }

        for(int k=lo;k<=hi;k++)     //归并回到a[lo..hi]
            if(i>mid)   a[k]=aux[j++];
            else if(j>hi)   a[k]=aux[i++];
            else if(less(aux[j],aux[i])) {a[k]=aux[j++];count+=2;}
            else a[k]=aux[i++];

            count+=2;

    }

    private static boolean less(Comparable aux, Comparable aux1) {
        if(aux.compareTo(aux1)<0) return true;
        return false;
    }


    public static void sort(Comparable[] a)
    {
        aux=new Comparable[a.length];
        count=0;
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

    public static void sortBU(Comparable[] a)
    {
        int N=a.length;
        aux = new Comparable[N];

        count=0;

        for(int sz=1;sz<N;sz=sz+sz)
            for(int lo=0;lo<N-sz;lo+=sz+sz)
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
    }

    public static void main(String[] args) {
        //存放每次实验的次数及结果
        int[][] trial=new int[150][2];

        //初始化每次执行排序的数组元素的数量
        for (int i = 0; i <150 ; i++) {
            trial[i][0]=i+1;
        }

        for (int i = 0; i <150 ; i++) {
            //初始化要排序的数组
            Double[] a = new Double[trial[i][0]];
            for (int j = 0; j < a.length; j++) {
                a[j]= StdRandom.uniform();
            }

            //进行排序
//            sort(a);

            sortBU(a);

            //存放结果
            trial[i][1]=count;


        }

        StdDraw.setXscale(0,150);
        StdDraw.setYscale(0,3800);
        for (int i = 0; i <trial.length ; i++) {

                StdOut.printf("%d,%d,%f\n",trial[i][0],trial[i][1],6*trial[i][0]*Math.log(trial[i][0])/Math.log(2));



            }

        StdDraw.setXscale(0,150);
        StdDraw.setYscale(0,trial[149][1]+50);
        for (int i = 0; i <trial.length ; i++) {

            StdDraw.point(trial[i][0],trial[i][1]);

        }

        StdDraw.show();


        }

    }




