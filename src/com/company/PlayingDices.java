package com.company;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class PlayingDices {
    public static void main(String[] args) {
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <=SIDES ; j++) {
                dist[i+j]+=1.0;
            }
        }

        for(int k=2;k<=2*SIDES;k++)
            dist[k]/=36.0;


        int count =0;
        double[] disttest=new double[2*SIDES+1];

        do{

            disttest[StdRandom.uniform(1,7)+StdRandom.uniform(1,7)]+=1.0;

            count++;

        }while(!check(dist,disttest,count));

        StdOut.println(count);

    }

    private static boolean check(double[] dist, double[] disttest,int count) {
        boolean ret;
        ret=true;
        for (int k=2;k<=2*6;k++) {
            StdOut.printf("%5f  %5f %5f\n",disttest[k]/count,dist[k],Math.abs(dist[k]-disttest[k]/count));
            ret = ret && Math.abs(dist[k]-disttest[k]/count)<0.0001;
            if (!ret) return ret;
        }

        return ret;
    }
}
