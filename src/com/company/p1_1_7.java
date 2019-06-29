package com.company;
import edu.princeton.cs.algs4.*;

public class p1_1_7 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i =1;i<6;i++)
            for(int j =0;j<i;j++)
                sum++;
        StdOut.println(sum);
    }
}
