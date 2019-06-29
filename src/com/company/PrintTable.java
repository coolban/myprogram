package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PrintTable {
    public static void main(String[] args) {
        String[] name=new String[100];
        int[] n1 = new int[100];
        int[] n2 = new int[100];
        int count=0;
        while(!StdIn.isEmpty())
        {
            name[count]=StdIn.readString();
            n1[count]=StdIn.readInt();
            n2[count]=StdIn.readInt();
            count++;
        }

        for(int i = 0;i<count;i++)
        {
            StdOut.printf("%10s\t%3d\t%3d\t%5.3f\n",name[i],n1[i],n2[i],n1[i]*1.0/n2[i]);
        }
    }
}
