package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Matrix {
    /*
     *
     *计算向量点乘
     *
     */
    public static double dot(double[] x,double[] y)
    {

        if(x.length != y.length)
        {
            throw new IllegalArgumentException("向量纬度不同");
        }

        double ret;
        ret = 0.0;
        for(int i=0;i<x.length;i++)
        {
            ret+=x[i]*y[i];
        }

        return ret;
    }

    /*
    *矩阵和矩阵的乘积
    *
     */
    public static double[][] mult(double[][] a,double[][] b)
    {
        if(a[0].length!=b.length)
        {
            throw new IllegalArgumentException("a的行数与b的列数不同，不能相乘");
        }

        double[][] ret =new double[a.length][b[0].length];

        for (int i = 0; i <ret.length ; i++) {
            for (int j = 0; j <ret[0].length ; j++) {
                ret[i][j]=0.0;
            }
        }

        for (int i = 0; i <ret.length ; i++) {
            for (int j = 0; j <ret[0].length ; j++) {
                for (int k = 0; k <b.length ; k++) {
                    ret[i][j]+=a[i][k]*b[k][j];
                }

            }
        }
        return ret;
    }

    /*
    *转置矩阵
    *
    *
     */
    public static double[][] transpose(double[][] a)
    {
        double[][] ret = new double[a[0].length][a.length];

        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[0].length ; j++) {
                ret[j][i]=a[i][j];
            }

        }
        return ret;

    }

    /*
    *矩阵和向量的乘积
    *
     */

    public static double[] mult(double[][] a,double[] x)
    {
        if(a[0].length!=x.length)
        {
            throw new IllegalArgumentException("a的行数与b的列数不同，不能相乘");
        }

        double[] ret =new double[a.length];

        for (int i = 0; i <ret.length ; i++) {
                ret[i]=0.0;
        }

        for (int i = 0; i <a.length ; i++) {

            for (int j = 0; j <x.length ; j++) {
                    ret[i]+=a[i][j]*x[j];
            }
        }
        return ret;
    }

    public static double[] mult(double[] y,double[][] a)
    {
        if(a.length!=y.length)
        {
            throw new IllegalArgumentException("a的行数与b的列数不同，不能相乘");
        }

        double[] ret =new double[a[0].length];

        for (int i = 0; i <ret.length ; i++) {
            ret[i]=0.0;
        }

        for (int i = 0; i <ret.length ; i++) {

            for (int j = 0; j <y.length ; j++) {
                ret[i]+=a[j][i]*y[j];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        /*double[] a,b;
        double ans;
        a = new double[5];
        b = new double[5];

        for (int i = 0; i <a.length ; i++) {
            a[i]=StdIn.readDouble();
        }

        for (int i = 0; i <b.length ; i++) {
            b[i]=StdIn.readDouble();
        }

        ans=dot(a,b);

        StdOut.println(ans);*/

/*        double[][] a1,b1;
        double[][] c1;
        a1 = new double[2][2];
        b1 = new double[2][2];

        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[0].length; j++) {
                a1[i][j]=StdIn.readDouble();

            }

        }

        for (int i = 0; i < b1.length; i++) {
            for (int j = 0; j < b1[0].length; j++) {
                b1[i][j]=StdIn.readDouble();

            }

        }

        c1=mult(a1,b1);

        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1[0].length; j++) {
                StdOut.printf("%5f  ",c1[i][j]);

            }
            StdOut.println();

        }*/

        /*double[][] a = new double[2][4];
        double[][] b;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j]=StdIn.readDouble();

            }

        }
        b=transpose(a);



        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                StdOut.printf("%5f  ",b[i][j]);

            }
            StdOut.println();

        }*/

/*        double[] a,c;
        double[][] b;

        b=new double[2][3];
        a=new double[3];

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j]=StdIn.readDouble();

            }

        }

        for (int i = 0; i <a.length ; i++) {
            a[i]=StdIn.readDouble();
        }

        c=mult(b,a);

        for (int i = 0; i <c.length ; i++) {
            StdOut.printf("%5f ",c[i]);
        }*/
        double[] a,c;
        double[][] b;

        b=new double[2][3];
        a=new double[2];

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j]=StdIn.readDouble();

            }

        }

        for (int i = 0; i <a.length ; i++) {
            a[i]=StdIn.readDouble();
        }

        c=mult(a,b);

        for (int i = 0; i <c.length ; i++) {
            StdOut.printf("%5f ", c[i]);
        }

    }

}
