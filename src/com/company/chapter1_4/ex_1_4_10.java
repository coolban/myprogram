package com.company.chapter1_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ex_1_4_10 {
    private int[] a;
    public ex_1_4_10(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i <keys.length ; i++) {
            a[i]=keys[i];
        }
        Arrays.sort(a);
    }

    public boolean contains(int key)
    {
        return rank(key)!=-1;
    }

    private int rank(int key) {
        int lo = 0;
        int hi = a.length-1;
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
            if(key<a[mid]) lo = mid-1;
            else if(key>a[mid]) hi=mid+1;
            else return mid;
        }
        return -1;
    }

    private int rank_smallest_index(int key){
        int lo = 0;
        int hi = a.length-1;
        int index = -1;
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
            if(key<a[mid]) hi = mid-1;
            else if(key>a[mid]) lo=mid+1;
            else {
                index=mid;
                hi=mid-1;
            }
        }
        return index;
    }

    private int howMany(int key)
    {
        int lo = 0;
        int hi = a.length-1;
        int indexsmallest = -1;
        int indexbiggest=-1;
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
            if(key<a[mid]) hi = mid-1;
            else if(key>a[mid]) lo=mid+1;
            else {
                indexsmallest=mid;
                hi=mid-1;
            }
        }

        if(indexsmallest==-1) return 0;

        lo = 0;
        hi = a.length-1;
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
            if(key<a[mid]) hi = mid-1;
            else if(key>a[mid]) lo=mid+1;
            else {
                indexbiggest=mid;
                lo=mid+1;
            }
        }

        return indexbiggest-indexsmallest+1;

    }

    public static void main(String[] args) {
        int [] a={0,3,4,4,4,5,6,7,8};
        ex_1_4_10 e =new ex_1_4_10(a);
        StdOut.println(e.rank_smallest_index(4));

        StdOut.println(e.howMany(8));
    }
}
