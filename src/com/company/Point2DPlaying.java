package com.company;

import edu.princeton.cs.algs4.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Point2DPlaying {
    public static void main(String[] args) {

        int N=Integer.parseInt(args[0]);
        ArrayList<Point2D> ap=new ArrayList<Point2D>();
        Interval1D x = new Interval1D(0,1);
        Interval1D y = new Interval1D(0,1);

        Interval2D box = new Interval2D(x,y);
        StdDraw.setXscale(0,1);
        StdDraw.setYscale(0,1);
        box.draw();

        StdDraw.setPenRadius(.005);
        for (int i = 0; i < N ; i++) {
            Point2D p=new Point2D(StdRandom.uniform(0.0,1.0),StdRandom.uniform(0.0,1.0));
            ap.add(p);
            p.draw();
        }

        double min=Double.MAX_VALUE;
        int p1=0,p2=0;
        for (int i = 0; i <N ; i++) {
            for (int j = i+1; j < N; j++) {
                double dis=ap.get(i).distanceTo(ap.get(j));
                if(dis<min) {
                    min=dis;
                    StdOut.println(min);
                    p1=i;
                    p2=j;
                }

            }
        }

        StdDraw.setPenColor(Color.RED);
        ap.get(p1).drawTo(ap.get(p2));

    }
}
