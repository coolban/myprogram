package com.company;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomMatch {

    public static int[] getRandomArray(int N)
    {
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i]= StdRandom.uniform(100000,1000000);
        }

        return a;
    }

    public static void test(int t)
    {
        for (int i = 1000; i <=1000000 ; i=i*10) {
            int matchtimes=0;
            for (int j = 0; j <t ; j++) {
                int [] a=getRandomArray(i);
                int [] b=getRandomArray(i);


                matchtimes+=matches(a,b);

            }

            StdOut.println(matchtimes/t);
        }
    }

    private static int matches(int[] a, int[] b) {
        int sum=0;
        for (int i = 0; i <a.length ; i++) {
            sum+=BinarySearch2.rank(a[i],b)>=0?1:0;
        }
        return sum;
    }

    public static void main(String[] args) {
        int t= Integer.parseInt(args[0]);
        test(t);
    }

}
