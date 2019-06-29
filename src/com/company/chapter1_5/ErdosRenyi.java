package com.company.chapter1_5;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyi {

    /**********************************
     *参数N为触点个数
     * 返回值表示触点连接总数
     *********************************/
    public static int count(int N){
        int c=0;

        HeightWeightedQuickUnionUF uf = new HeightWeightedQuickUnionUF(N);



        while(uf.count()>1)
        {
            Pair p = generatePair(N);

                uf.union(p.a,p.b);
                StdOut.printf("%d %d\n",p.a,p.b);
                c++;


        }


        return c;

    }

    private static class Pair{
        int a;
        int b;
    }

    private static Pair generatePair(int N)
    {
        Pair p = new Pair();

        p.a= StdRandom.uniform(N);

        int tmp = StdRandom.uniform(N);

        while(p.a==tmp)
        {
            tmp = StdRandom.uniform(N);
        }
        p.b=tmp;

        return p;

    }


    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        int c=0;

        if(N>0)
            c=count(N);

        StdOut.println(c);

    }

}
