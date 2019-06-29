package com.company;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ShuffleTest2 {
    public static void shuffle(double[] a)
    {
        int N=a.length;
        for(int i = 0;i<N;i++)
        {
            int r = StdRandom.uniform(N);
            double temp = a[i];
            a[i]=a[r];
            a[r]=temp;
        }
    }

    private  static void reset(double[] a)
    {
        for (int i = 0; i <a.length ; i++) {
            a[i]=i;
        }
    }

    public static void shuffletest(double[] a,double[][] test)
    {
        reset(a);
        shuffle(a);
        for (int i = 0; i <a.length ; i++) {
            test[(int)a[i]][i]+=1;
        }

    }

    public static void main(String[] args) {
        int len = Integer.parseInt(args[0]);
        int times = Integer.parseInt(args[1]);

        double[][] test=new double[len][len];
        double[] a = new double[len];
        for (int i = 0; i < times; i++) {
            shuffletest(a,test);
        }

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                StdOut.printf("%5f  ",test[i][j]);
            }
            StdOut.println();
        }

    }
}
