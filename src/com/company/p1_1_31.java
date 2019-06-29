package com.company;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;


public class p1_1_31 {
    public static void main(String[] args) {
        int n;
        double p ;
        if(args.length<2)
        {
            StdOut.println("You should provide two parameters,the useage bellow:\n java classname 5 0.2");
            return;
        }
        n = Integer.parseInt(args[0]);
        p =Double.parseDouble(args[1]);
        double[][] points = new double[2][n];
        StdDraw.setXscale(-1,1);
        StdDraw.setYscale(-1,1);
        StdDraw.circle(0,0,1);
        StdDraw.setPenRadius(0.05);
        for(int i =0;i<n;i++)
        {
            points[0][i]=Math.cos(2*Math.PI/n*i);
            points[1][i]=Math.sin(2*Math.PI/n*i);
            StdDraw.point(points[0][i],points[1][i]);

        }

        for(int i =0;i<n;i++)
            for(int j=i+1;j<n;j++)
            {
                if(StdRandom.bernoulli(p)) {
                    StdDraw.line(points[0][i], points[1][i], points[0][j], points[1][j]);
                }
            }

    }
}
