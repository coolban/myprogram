package com.company;

import edu.princeton.cs.algs4.StdOut;

public class p1_1_30 {
   public static Boolean[][] createBooleanArray(int N)
    {
        Boolean[][] a = new Boolean[N][N];
        for(int i=0;i<N;i++)
            for(int j = 0;j<N;j++)
            {
                if (Euclid.Eu(i,j)==1)
                {
                    a[i][j]=true;
                }
                else{
                    a[i][j]=false;
                }
            }
        return a;
    }

    public static void main(String[] args) {
        Boolean[][] a;
        a = createBooleanArray(0);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                StdOut.printf(""+a[i][j]+" ");
            }
            StdOut.println();
        }
    }

}
