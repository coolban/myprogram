package com.company;

import edu.princeton.cs.algs4.StdOut;

public class Ln {
    public static double Ln(int N)
    {
        if(N==1) return 0;
        return Math.log(N)+Ln(N-1);
    }

    public static void main(String[] args) {
        StdOut.print(Ln(10));
    }

}
