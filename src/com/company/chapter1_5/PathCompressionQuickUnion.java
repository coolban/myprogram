package com.company.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PathCompressionQuickUnion {

    private int [] id;
    private int count;

    public PathCompressionQuickUnion(int N) {
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

        int tmp = q;

        while (id[q]!=q) q=id[q];

        //将参数q到根节点路径上的所有触点连接到根节点
        while (id[tmp]!=q)
        {
            int node=id[tmp];
            id[tmp]=q;
            tmp=node;
        }

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
        PathCompressionQuickUnion uf = new PathCompressionQuickUnion(N);
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
