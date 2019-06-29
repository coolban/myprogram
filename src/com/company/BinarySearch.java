package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
    public static int rank(int key,int[] a)
    {
        return rank(key,a,0,a.length-1,0);
    }

    public static int rank(int key,int[] a,int lo,int hi,int depth)
    {
        for(int i =0;i<depth;i++)
        {
            StdOut.printf(" ");
        }
        StdOut.printf("%5d%5d\n",lo,hi);
        if(lo>hi) return -1;
        int mid = lo +(hi-lo)/2;
        if(key<a[mid]) return rank(key,a,lo,mid-1,depth+1);
        else if (key>a[mid]) return rank(key,a,mid+1,hi,depth+1);
        else return mid;
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6,7,8,9,12,13,24,45};
        int index,f;
        char p;
        p = StdIn.readChar();
        f=3;

        index = rank(f,a);

        if(p=='+')
        {
            if(index<0) StdOut.print(f);
            StdOut.println();
        }
        if(p=='-')
        {
            if(index>=0) StdOut.print(f);
            StdOut.println();
        }



        StdOut.print(rank(3,a));

    }
}
