package com.company.chapter1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ex_1_4_20 {
    // create a bitonic array of size N
    public static int[] bitonic(int N) {
        int mid = StdRandom.uniform(N);
        int[] a = new int[N];
        for (int i = 1; i < mid; i++) {
            a[i] = a[i-1] + 1 + StdRandom.uniform(9);
        }

        if (mid > 0) a[mid] = a[mid-1] + StdRandom.uniform(10) - 5;

        for (int i = mid + 1; i < N; i++) {
            a[i] = a[i-1] - 1 - StdRandom.uniform(9);
        }

        for (int i = 0; i < N; i++) {
            StdOut.println(a[i]);
        }
        return a;
    }

    public static boolean BitonicSearch(int[] a,int key){
        // 灵活使用二分查找的方法找到最大值
        int mid;
        int begin,end;
        int maximum=Integer.MIN_VALUE;
        //boolean isfind=false;
        begin = 0;
        end = a.length-1;

        while (begin<=end)
        {
            mid = (begin+end)/2;

            if(mid>0 && mid<a.length-1)
                //不是第一个元素，也不是最后一个元素，即元素在中间
                if(a[mid-1]<a[mid] && a[mid]>a[mid+1])
                {//找到最大值
                    maximum = mid;
                    break;
                }
                else if(a[mid-1]>a[mid])
                {//下坡
                    end=mid-1;
                }
                else {
                    //上坡
                    begin = mid+1;
                }
                else
            {
                maximum = mid;
                break;
            }
        }

        if(a[maximum]==key)
            return  true;

        //从前半部分查找
        begin=0;
        end=maximum;

        while (begin<=end)
        {
            mid = (begin+end)/2;

            if(a[mid]==key) return true;
            else if(a[mid]<key)
            {
                begin=mid + 1;
            }
            else {
                end = mid - 1;
            }


        }


        //从后半部分查找
        begin=maximum;
        end=a.length-1;

        while (begin<=end)
        {
            mid = (begin+end)/2;

            if(a[mid]==key) return true;
            else if(a[mid]<key)
            {
                end=mid - 1;
            }
            else {
                begin = mid + 1;
            }


        }

        return false;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        int [] a = bitonic(N);


        if(BitonicSearch(a,-1)) StdOut.printf("Found\n");
        else StdOut.printf("Not found");

    }
}
