package com.company;

import edu.princeton.cs.algs4.*;

import java.util.ArrayList;

public class p1_2_3 {

    public static void main(String[] args) {
        int N=Integer.parseInt(args[0]);
        ArrayList<Interval2D> ai=new ArrayList<Interval2D>();
        double min,max;

        min = Double.parseDouble(args[1]);
        max = Double.parseDouble(args[2]);

        for (int i = 0; i < N; i++) {
            double i1,i2,i3,i4;
            i1=StdRandom.uniform(min,max);
            i2=StdRandom.uniform(min,max);
            i3=StdRandom.uniform(min,max);
            i4=StdRandom.uniform(min,max);
            StdOut.printf("%f  %f  %f  %f\n",i1,i2,i3,i4);
            ai.add(new Interval2D(new Interval1D(i1<=i2?i1:i2,i1>i2?i1:i2),new Interval1D(i3<=i4?i3:i4,i3>i4?i3:i4)));
            //ai.get(i).draw();
        }
        StdDraw.setXscale(0,max);
        StdDraw.setYscale(0,max);
        for (int i = 0; i < N; i++) {
            ai.get(i).draw();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(ai.get(i).intersects(ai.get(j)))
                {
                    StdOut.println(""+ai.get(i)+" "+ai.get(j));
                }

            }
        }




    }

}
