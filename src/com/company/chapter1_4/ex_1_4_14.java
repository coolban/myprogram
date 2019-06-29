package com.company.chapter1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ex_1_4_14 {
    public static int FourSum(int[] a)
    {
        int count=0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = i+1; j <a.length ; j++) {
                for (int k = j+1; k < a.length; k++) {
                    for (int l = k+1; l < a.length; l++) {
                        if(Math.addExact(Math.addExact(Math.addExact(a[i],a[j]),a[k]),a[l])==0)
                        {
                            count++;
                            StdOut.printf("%d %d %d %d \n",a[i],a[j],a[k],a[l]);
                        }

                    }

                }

            }

        }

        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);

        int [] a=in.readAllInts();

        StdOut.println(FourSum(a));
    }
}
