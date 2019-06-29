package com.company.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {

    private int [] id;
    private int count;

    public QuickUnionUF(int N) {
        count=N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q)
    {
        return find(p)==find(q);
    }

    public int find(int q) {

        while (id[q]!=q) q=id[q];
        return q;
    }

    public void union(int p,int q)
    {
        int pID=find(p);
        int qID=find(q);

        if(pID==qID) return;

        id[qID]=pID;
        count--;

    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q))
                continue;
            uf.union(p,q);
            StdOut.println(p+" "+q);
        }

        StdOut.println(uf.count()+"components");
    }
}
