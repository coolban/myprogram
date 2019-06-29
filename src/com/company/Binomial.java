package com.company;

import edu.princeton.cs.algs4.StdOut;

public class Binomial {

    static int count = 0;
    static int count1=0;
    public static double binomial(int N,int k,double p,double [][] a)
    {
        count1++;

        StdOut.println(count1);
        if(N == 0 && k == 0) return 1.0;
        if(N < 0 || k < 0) return 0.0;

        if(N-1 >=0 && k-1 >=0 && a[N-1][k]>=0 && a[N-1][k-1]>=0)
        {
            a[N][k]=(1.0-p)*a[N-1][k]+p*a[N-1][k-1];
            return a[N][k];
        }
        else if(N-1 >=0 && k-1 >=0  && a[N-1][k]>=0)
        {
            a[N][k]=(1.0-p)*a[N-1][k]+p*binomial(N-1,k-1,p,a);
            return a[N][k];
        }else if(N-1 >=0 && k-1 >=0 && a[N-1][k-1]>=0)
        {
            a[N][k]=(1.0-p)*binomial(N-1,k,p,a)+p*a[N-1][k-1];
            return a[N][k];
        }
        else
        {
            a[N][k]=(1.0-p)*binomial(N-1,k,p,a)+p*binomial(N-1,k-1,p,a);;
            return a[N][k];
        }


    }


    public static void binomial2Start(int N, int k, double p) {

        double[][] arr = new double[N + 1][k + 1];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = -1;
            }
        }

        StdOut.print(binomial2(arr, N, k, p));
    }

    public static double binomial2(double[][] arr, int N, int k, double p) {

        count++;

        StdOut.println(count);

        if ((N == 0) && (k == 0)) return 1.0;
        if ((N < 0) || (k < 0)) return 0.0;

        if (arr[N][k] == -1) {
            arr[N][k] = (1 - p) * binomial2(arr, N - 1, k, p) + p * binomial2(arr, N - 1, k - 1, p);
        }

        return arr[N][k];
    }

    public static void main(String[] args) {
        int n,k;
        double p;
        n=100;
        k=50;
        p=0.25;
        double[][] a =new double[100+1][50+1];
        for(int i =0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                a[i][j]=-1.0;
        StdOut.print(binomial(n,k,p,a));

        binomial2Start(100, 50, 0.25);


    }
}
