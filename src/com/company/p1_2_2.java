package com.company;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class p1_2_2 {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);

        ArrayList<Interval1D> ai=new ArrayList<Interval1D>();

        for (int i = 0; i < N; i++) {
            ai.add(new Interval1D(StdIn.readDouble(),StdIn.readDouble()));
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(ai.get(i).intersects(ai.get(j))) {
                    StdOut.print(ai.get(i));
                    StdOut.print("  ");
                    StdOut.println(ai.get(j));
                }

            }
        }


    }
}
