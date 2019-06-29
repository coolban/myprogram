package com.company.chapter1_4;

import com.company.ShuffleTest;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ex_1_4_18 {

    public static void shuffle(int[] a)
    {
        int N=a.length;
        for(int i = 0;i<N;i++)
        {
            int r = i + StdRandom.uniform(N-i);
            int temp = a[i];
            a[i]=a[r];
            a[r]=temp;
        }
    }

    public static int LocalMinimum(int[] a)
    {
        int begin=0;
        int end=a.length-1;

        int mid = 0;

        do {
            mid = (begin+end)/2;
            if (mid == 0 || mid == a.length-1) return a[mid];
            if (a[mid]<a[mid+1] && a[mid]<a[mid-1]) return a[mid];
            else if(a[mid+1]>a[mid-1]) {end=mid-1;continue;}
            else {begin=mid+1;continue;}
        } while(true);




    }

    public static void main(String[] args) {
        int[] a=new int[20];

        for (int i = 0; i <a.length ; i++) {
            a[i]=i;

        }


        shuffle(a);

        for (int x:a
             ) {
            StdOut.printf("%d ",x);
        }
        StdOut.println();

        StdOut.println(LocalMinimum(a));




    }
}
