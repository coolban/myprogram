package com.company.chapter1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class FindTheSameOne {
    public static int count(int[] a){
        int sum=0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = i+1; j <a.length ; j++) {
                if(a[i]==a[j])
                  sum++;
            }

        }

        return sum;
    }

    public static int countfast(int[] a)
    {
        Arrays.sort(a);

        int first = a[0];
        int sum=0;
        int n = 1;

        for (int i = 1; i <a.length ; i++) {


            if(a[i]==first){
                n++;
            }
            else{
                if(n>1) {sum+=numn(n);}
                first=a[i];
                n=1;
            }


        }
        return sum;
    }

    private static int numn(int n)
    {
        return n*(n-1)/2;
    }

    public static void main(String[] args) {
        In thefile = new In(args[0]);

        int[] theints = thefile.readAllInts();

        for (int i = 0; i <theints.length ; i++) {
            theints[i]=Math.abs(theints[i]);
        }

        StdOut.println(countfast(theints));

    }

}
