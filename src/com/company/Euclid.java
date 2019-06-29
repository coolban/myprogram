package com.company;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Euclid {
    public static int Eu(int a,int b){
        StdOut.printf("%6d %6d\n",a,b);
        if(b==0) return a;

        return Eu(b,a%b);
    }

    public static void main(String[] args) {
        int a;
        int b;
        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);
        StdOut.print(Eu(a,b));
    }
}
