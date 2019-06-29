package com.company.chapter2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class p2_1_18 {
    public static void selectSort(Comparable[] a)
    {
        for (int i = 0; i < a.length-1 ; i++) {
            int[] exchange=new int[a.length];
            exchange[i]=1;
            Comparable min = a[i];
            int index = i;
            for (int j = i+1; j < a.length; j++) {
                if(less(a[j],min)) {
                    min = a[j];
                    index = j;
                    exchange[j]=1;
                }
            }
            show(a,exchange,a.length,i);
            exch(a,i,index);
//            show(a,exchange,a.length,i);
        }
    }

    public static void insertionSort(Comparable[] a)
    {
        for (int i = 0; i <a.length-1 ; i++) {
            int[] exchange=new int[a.length];
            for (int j = i+1; j >0 && less(a[j],a[j-1]) ; j--) {
                exch(a,j,j-1);
                exchange[j-1]=1;
                exchange[j]=1;
                //show(a);
            }
            show(a,exchange,a.length,i);
        }
    }

    private static void show(Comparable[] a,int[] exchage,int total,int index) {
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //StdDraw.clear();
        StdDraw.setXscale(0,100);
        StdDraw.setYscale(0,100);
        double width=100.0/a.length;
        double height=100.0/a.length;

        double x=-width/2;
        double y=height*index;

        StdDraw.show();
        for (int i = 0; i <a.length ; i++) {
            x+=width;
            //y+=height;
            StdDraw.rectangle(x,(double)a[i]*100/2/total+y,width/2,(double)a[i]*100/total/2);
            if(exchage[i]==1) StdDraw.filledRectangle(x,(double)a[i]*100/2/total+y,width/2,(double)a[i]*100/total/2);

        }



    }

    private static boolean less(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1)<0;
    }

    private static void exch(Object[] a,int i,int j){
        Object temp = a[i];

        a[i]=a[j];
        a[j]=temp;

        return;
    }


    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    public static void main(String[] args)
    {

        for(int i = 1;i<=1;i++) {
            Double[] a = new Double[(int) Math.pow(10, i)];
            for (int j = 0; j < a.length; j++) {
                a[j] = StdRandom.uniform();

            }
//            selectSort(a);
            insertionSort(a);
            if(isSorted(a)) StdOut.println("GOOD");

        }


    }
}
