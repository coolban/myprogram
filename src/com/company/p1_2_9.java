package com.company;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;

public class p1_2_9 {
    public static int rank(int key, int[] a, Counter counter)
    {
        //数组必须是有序的
        int lo=0;
        int hi = a.length-1;

        while(lo<=hi){
            counter.increment();
            //被查找的键要么不存在，要么必然存在于a[lo..hi]之中
            int mid=lo+(hi-lo)/2;
            if(key<a[mid]) hi = mid-1;
            else if(key>a[mid]) lo = mid+1;
            else return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        Counter counter=new Counter("mycounter");
        int [] a ={1,2,3,4,5,6,7};
        rank(1,a,counter);
        StdOut.println(counter);
    }
}
