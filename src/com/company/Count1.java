package com.company;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class Count1 {

    public static int rank2(double key,double[] a)
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

    public static void main(String[] args) {
        int n;
        double l,r,width;
        double[] a,b;

        n=Integer.parseInt(args[0]);
        l=Double.parseDouble(args[1]);
        r = Double.parseDouble(args[2]);

        width=(r-l)/n;
        a=new double[n+1];
        b=new double[n];
        for(int i=0;i<n;i++)
        {
            b[i]=0;
        }
        a[0]=l;
        a[n]=r;
        for(int i=1;i<a.length-1;i++)
        {
            a[i]=l+width*i;
        }



        while(!StdIn.isEmpty())
        {
            double x;
            int num;
            x = StdIn.readDouble();
            num=rank2(x,a);

            if(num>0 && num<=n)
            {
                b[num-1]+=1;
            }

        }

        StdDraw.setXscale(l,r);
        StdDraw.setYscale(0,50);
        for(int i=0;i<n;i++)
        {
            StdDraw.rectangle(l+i*width+width/2,b[i]/2,width/2,b[i]/2);
        }




    }
}
