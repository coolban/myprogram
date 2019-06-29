package com.company;

import edu.princeton.cs.algs4.StdOut;

public class p1_1_15 {
    public static int[] histogram(int[] a,int m)
    {
        int[] b = new int[m];
        for(int i = 0;i<a.length;i++)
        {
            if(a[i]<m && a[i]>=0)
                b[a[i]]+=1;
        }

        return b;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,1,2};
        int[] b = histogram(a,4);

        for (int i = 0; i <b.length ; i++) {
            StdOut.printf("%d\n",b[i]);
        }
    }
}
