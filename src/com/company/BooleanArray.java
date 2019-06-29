package com.company;

import edu.princeton.cs.algs4.StdOut;

public class BooleanArray {
    public static void main(String[] args) {
        Boolean[][] a;
        a=new Boolean[2][3];
        a[0][0]=true;
        a[0][1]=false;
        a[0][2]=true;
        a[1][0]=false;
        a[1][1]=true;
        a[1][2]=false;
        for(int i =0;i<a.length;i++)
        {
            if(i==0) {
                for(int h=0;h<a[0].length;h++)
                {   if(h==0) {
                        StdOut.printf("%5s", "");
                    }
                    StdOut.printf("%5s",h);
                    StdOut.print("\t");
                }
                StdOut.print("\n");
            }
            for(int j=0;j<a[0].length;j++) {
                if(j==0) {
                    StdOut.printf("%-5s", i);
                }
                StdOut.printf("%5s",a[i][j]?"*":" ");
                StdOut.print("\t");
            }
            StdOut.print("\n");

        }
    }
}
