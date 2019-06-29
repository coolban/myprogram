package com.company.chapter1_4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {

    private static final int MAXIMUM_INTEGER = 1000000;

    //private static StdDraw d;

    // This class should not be instantiated.
    private DoublingTest() { }

    /**
     * Returns the amount of time to call {@code ThreeSum.count()} with <em>n</em>
     * random 6-digit integers.
     * @param n the number of integers
     * @return amount of time (in seconds) to call {@code ThreeSum.count()}
     *   with <em>n</em> random 6-digit integers
     */
    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }



    /**
     * Prints table of running times to call {@code ThreeSum.count()}
     * for arrays of size 250, 500, 1000, 2000, and so forth.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        StdDraw.setPenRadius(0.001);
        StdDraw.setXscale(0,12);
        StdDraw.setYscale(-5,5);
        StdDraw.show();
        double x0=0;
        double y0=0;
        double x1=0;
        double y1=0;

        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            x1=Math.log(n);
            y1=Math.log(time);
            if(n==250) {
                x0 = x1;
                y0 = y1;
            }
                        StdDraw.point(Math.log(n),Math.log(time));
                        StdDraw.line(x0,y0,x1,y1);

            x0=x1;
            y0=y1;
            StdOut.printf("%7d %7.1f\n", n, time);
        }
    }

}
