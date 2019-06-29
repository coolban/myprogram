package com.company;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

public class BruteForceSearch {
    public static int rank(int key,int [] a){
        for(int i = 0;i<a.length;i++)
            if(a[i]==key) return i;
            return -1;
    }

    public static void main(String[] args) {
        int [] whitelist= In.readInts(args[0]);
        Arrays.sort(whitelist);
        LocalTime t1= LocalTime.now();
        while(!StdIn.isEmpty()){
            int key=StdIn.readInt();
            if(rank(key,whitelist)<0)
                StdOut.println(key);
        }
        LocalTime t2= LocalTime.now();
        Duration du = Duration.between(t1,t2);
        System.out.println(du.getSeconds());
    }
}
