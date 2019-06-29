package com.company;

import edu.princeton.cs.algs4.StdOut;

public class MyLog {
    public static int lg(int n){
        int a=-1;
        while(n>0)
        {
            n=n>>>1;
            a++;
        }
        return a;
    }

    public static void main(String[] args) {
        StdOut.printf("%d\n",lg(2));
        StdOut.printf("%d\n",lg(3));
        StdOut.printf("%d\n",lg(4));
        StdOut.printf("%d\n",lg(5));
        StdOut.printf("%d\n",lg(6));
        StdOut.printf("%d\n",lg(7));
        StdOut.printf("%d\n",lg(8));
    }
}
