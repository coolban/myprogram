package com.company.chapter2_1;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class p2_1_11 {
    public static int sort(Comparable[] a)
    {
        int N = a.length;

        int compare_count=0; //存放累计比较次数
        int hlist[],index=0;
        hlist=new int[(int)Math.round(Math.ceil(Math.log(a.length)/Math.log(3)))+1];
        int h=1;
        hlist[0]=0;
        hlist[++index]=1;
        while (h<N/3) {
            h = 3 * h + 1;
            index++;
            hlist[index]=h;
        }

        //StdOut.println(hlist[index]);

        while (hlist[index]>=1)
        {
            for(int i = hlist[index];i<N;i++)
            {
                for(int j =i;j>=hlist[index] && ++compare_count>0 &&less(a[j],a[j-hlist[index]]);j-=hlist[index])
                    exch(a,j,j-hlist[index]);
            }

            StdOut.printf("%d  %d  %d  %f\n",hlist[index],compare_count,a.length,compare_count*1.0/a.length);
            compare_count=0;
            index--;
        }

        return compare_count;
    }

    private static boolean less(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1)<0;
    }

    private static void exch(Object[] a,int i,int j){
        Object temp = a[i];

        a[i]=a[j];
        a[j]=temp;

        return;
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        for(int i = 1;i<=7;i++){
            Double[] a = new Double[(int)Math.pow(10,i)];
            for (int j = 0; j <a.length ; j++) {
                a[j]= StdRandom.uniform();

            }

            int cnt = sort(a);

            StdOut.println("-------------------------------------------");

//            for (int j = 0; j <a.length ; j++) {
//                StdOut.printf("%f\n",a[j]);
//            }

//            if(isSorted(a)) StdOut.println("GOOD");
//            else StdOut.println("No");
//            StdOut.printf("%d %d %f\n",cnt,a.length,cnt*1.0/a.length);
        }

    }

}
