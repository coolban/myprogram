package com.company.chapter1_4;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class ex_1_4_15 {
    public static int TwoSumFaster(int [] a){
        int i=0;
        int j=0;
        int mid=-1;
        int count=0;
        int isame=0;
        int jsame=0;

        for (int k = 0; k <a.length ; k++) {
            if(a[k]>=0) {mid=k;break;}
        }

        if(mid==-1) return 0;

        j=a.length-1;

        StdOut.println(j);

        while(i<mid && j>=mid)
        {
            if(a[i]+a[j]==0)
            {
                isame=0;
                jsame=0;
                for (int k = i; k <mid ; k++) {
                    if(a[i]==a[k]) isame++;
                    else break;
                }
                for (int k = j; k >= mid ; k--) {
                    if(a[j]==a[k]) jsame++;
                    else break;
                }
                count+=isame*jsame;

                i+=isame;
                j-=jsame;




            }
            else if(a[i]+a[j]<0) i++;
            else j--;
        }
        return count;

    }

    public static int ThreeSumFast(int[] a)
    {
        Arrays.sort(a);
        int count=0;
        for (int i = 0; i <a.length ; i++) {

            int n = a.length-1;

            for (int j = i+1; j < a.length ; j++) {
                while(n>j)
                {
                    int x=a[i]+a[j]+a[n];
                    if(x==0) {count++;n--;continue;}
                    if(x<0) break;
                    if(x>0) n--;

                }
            }

        }

        return count;
    }

    public static int count(int[] a)
    { // Count pairs that sum to 0.
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            if (BinarySearch.rank(-a[i], a) > i) {
                cnt++;
                //StdOut.println(a[i]);
            }
        return cnt;
    }

    public static void main(String[] args) {
        In in =new In(args[0]);

        int[] a=in.readAllInts();

        Arrays.sort(a);

        /*
        for (int i:a
             ) {
            StdOut.println(i);
        }
        */

        //StdOut.println(count(a));
        //StdOut.println(TwoSumFaster(a));
//        Stopwatch timer1=new Stopwatch();
//
//        StdOut.println(ThreeSumFast.count(a));
//
//        StdOut.println(timer1.elapsedTime());

        Stopwatch timer2=new Stopwatch();

        StdOut.println(ThreeSumFast(a));

        StdOut.println(timer2.elapsedTime());
    }

}
