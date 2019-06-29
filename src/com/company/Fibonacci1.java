package com.company;

import edu.princeton.cs.algs4.StdOut;

public class Fibonacci1 {
    public static long F(int N)
    {
        if(N==0) return 0;
        if(N==1) return 1;
        return F(N-1)+F(N-2);
    }

    public static long F1(int N)
    {
        long n1,n2,count,fib;
        if(N==0) return 0;
        if(N==1) return 1;
        n1=0;n2=1;
        count=N;
        fib=0;
        while(count>1){
            fib=n1+n2;
            n1=n2;
            n2=fib;
            count--;
        }

        return fib;


    }

    public static void main(String[] args) {
        for(int N=0;N<100;N++)
            StdOut.println(N+" "+F1(N));
    }
}
