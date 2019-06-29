package com.company;
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
public class BinarySearch2 {
    public static int rank(int key,int[] a)
    {
        //数组必须是有序的
        int lo=0;
        int hi = a.length-1;

        while(lo<=hi){
            //被查找的键要么不存在，要么必然存在于a[lo..hi]之中
            int mid=lo+(hi-lo)/2;
            if(key<a[mid]) hi = mid-1;
            else if(key>a[mid]) lo = mid+1;
            else return mid;
        }

        return -1;
    }

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

    /****************************
     * 返回数组a中小于key的元素的数量
     * @param key
     * @param a 排好序的数组（由小到大）
     * @return 数组a中小于key的元素的数量
     */
    public static int rank2(int key,int[] a)
    {
        //数组必须是有序的
        int lo=0;
        int direction=-1;
        int hi = a.length-1;

        while(lo<=hi){
            //被查找的键要么不存在，要么必然存在于a[lo..hi]之中
            int mid=lo+(hi-lo)/2;
            if(key<a[mid]) {hi = mid-1;direction=1;}
            else if(key>a[mid]) {lo = mid+1;direction=2;}
            else return mid;
        }

        if(direction==1)    return lo;
        if(direction==2)    return hi+1;
        return -1;
    }


    public static int count(int key,int[] a)
    {
        //数组必须是有序的
        int lo=0;
        int hi = a.length-1;

        while(lo<=hi){
            //被查找的键要么不存在，要么必然存在于a[lo..hi]之中
            int mid=lo+(hi-lo)/2;
            if(key<a[mid]) hi = mid-1;
            else if(key>a[mid]) lo = mid+1;
            else {
                int findmid = mid;
                int lowdirection = 0;
                int hidirection =0;
                for(int i = mid;i<=a.length-1 && i>=0;i--)
                {
                    if(a[i]==key) lowdirection++;
                    else break;
                }

                for(int i = mid+1;i<=a.length-1 && i>=0;i++)
                {
                    if(a[i]==key) hidirection++;
                    else break;
                }

                return lowdirection+hidirection;


            }
        }

        return 0;
    }

    public static void main(String[] args)
    {
        int [] whitelist= In.readInts(args[0]);
        Arrays.sort(whitelist);
        LocalTime t1= LocalTime.now();
        while(!StdIn.isEmpty()){
            int key=StdIn.readInt();
            if(rank(key,whitelist)<0)
                StdOut.println(key);
        }
        LocalTime t2= LocalTime.now();
        Duration du = Duration.between(t1,t2);
        System.out.println(du.getSeconds());
        //int[] whitelist = In.readInts(args[0]);
        /*int[] whitelist = {2,2,4,5,6,4,4,8,3,1,1,7,1,9};
        Arrays.sort(whitelist);

        int[] whitelist2=new int[whitelist.length];
        int indexofwl2 =0;

        if(whitelist.length>0)
            whitelist2[0]=whitelist[0];


        for(int i=1;i<whitelist.length;i++)
        {
            if(whitelist[i]==whitelist2[indexofwl2])
            {
                continue;
            }
            else{
                indexofwl2++;
                whitelist2[indexofwl2]=whitelist[i];
            }
        }

        int[] whitelist3=new int[indexofwl2+1];

        for(int i=0;i<whitelist3.length;i++)
        {
            whitelist3[i]=whitelist2[i];
            StdOut.println(whitelist2[i]);
        }

        whitelist=whitelist3;

        while(!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if(rank(key,whitelist)<0)
                StdOut.println(key);
        }*/

    }
}
