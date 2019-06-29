package com.company;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class VisualCounter {

    private int N;
    private int max;
    private int counter=0;
    private int c;

    public VisualCounter(int N,int max){
        this.N=N;
        this.max=max;
        StdDraw.setXscale(0,this.N);
        StdDraw.setYscale(-this.max,this.max);
        StdDraw.setPenRadius(.01);
        StdDraw.setPenColor(Color.RED);
    }

    public void increment() throws Exception {
        if(++counter>N) throw new Exception("超过操作次数");
        if(Math.abs(++c)>max) throw new Exception("超过最大计数值");
        StdDraw.point(counter,c);
    }

    public void decrement() throws Exception{
        if(++counter>N) throw new Exception("超过操作次数");
        if(Math.abs(--c)>max) throw new Exception("超过最大计数值");
        StdDraw.point(counter,c);
    }

    public static void main(String[] args) {
        VisualCounter v = new VisualCounter(100,150);
        for (int i = 0; i < 100; i++) {
            try {
                if(StdRandom.bernoulli(.6)) v.increment();
                else v.decrement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
