package com.company.chapter1_4;

import edu.princeton.cs.algs4.StdOut;

public class ex_1_4_23 {
/***************************************
使用二分查找法在数组a中查找key。其中，数组a中允许含有重复的整数值。
 此函数返回具有key值的最小的索引
 **************************************/
    public static int BinarySearchWithDuplicatesSmallestIndex(int[] a,int key)
    {
        int begin,end,mid;

        begin = 0;
        end = a.length-1;

        while(begin<=end){
            mid = begin+(end-begin)/2;
            if(a[mid]==key) {
                while (mid-1>=0){
                    if(a[mid-1]==key) {mid--;}
                    else return mid;
                }
                return mid;
            }
            else if(a[mid]>key){
                end=mid-1;
            }
            else {
                begin = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int [] a ={1,2,3,3,4,4,4,5,6,7,9,9,9,10};

        StdOut.printf("%d\n",BinarySearchWithDuplicatesSmallestIndex(a,1));
        StdOut.printf("%d\n",BinarySearchWithDuplicatesSmallestIndex(a,2));
        StdOut.printf("%d\n",BinarySearchWithDuplicatesSmallestIndex(a,3));
        StdOut.printf("%d\n",BinarySearchWithDuplicatesSmallestIndex(a,4));
        StdOut.printf("%d\n",BinarySearchWithDuplicatesSmallestIndex(a,9));
        StdOut.printf("%d\n",BinarySearchWithDuplicatesSmallestIndex(a,6));
        StdOut.printf("%d\n",BinarySearchWithDuplicatesSmallestIndex(a,11));
    }

}
