package com.company;

import edu.princeton.cs.algs4.StdOut;

public class Pivot {
    public static int[][] piv(int[][] a)
    {
        int[][] b = new int[a[0].length][a.length];
        for(int i = 0;i<b.length;i++)
            for(int j = 0;j<b[0].length;j++)
                b[i][j]=a[j][i];
            return  b;
    }

    public static void main(String[] args) {
        int[][] a=new int[2][3];

        a[0][0]=1;
        a[0][1]=2;
        a[0][2]=3;
        a[1][0]=4;
        a[1][1]=5;
        a[1][2]=6;

        int[][] b =piv(a);

        for(int i=0;i<b.length;i++) {
            for (int j = 0; j < b[0].length; j++)
                StdOut.printf("%4d",b[i][j]);
            StdOut.printf("\n");
        }


    }
}
