package com.company.chapter1_4;

import edu.princeton.cs.algs4.StdOut;

public class ex_1_4_12 {
    public static void printequalints(int[] a,int[] b)
    {
        int i=0;
        int j=0;
        while(i<a.length && j<b.length) {
            if(a[i]==b[j]) {
                StdOut.println(a[i]);
                i++;
                j++;
            }
            else if(a[i]<b[j]) i++;
            else j++;

        }
    }

    public static void main(String[] args) {
        int[] a = {-1,2,3,4,6,7};
        int[] b = {1,2,3,4,5,6,8};
        printequalints(a,b);

    }
}
