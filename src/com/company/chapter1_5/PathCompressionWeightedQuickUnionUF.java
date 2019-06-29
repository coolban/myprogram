package com.company.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PathCompressionWeightedQuickUnionUF {

    private int [] id;
    private int count;
    private int [] sz;

    public PathCompressionWeightedQuickUnionUF(int N){
        count=N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
            sz[i]=1;
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

    public void union(int p,int q){
        int pID=find(p);
        int qID=find(q);

        if(pID==qID) return;

        /*int biggerID;
        int smallerID;*/
        if(sz[pID]>sz[qID]) {
            id[pID]=id[qID];
            sz[qID]+=sz[pID];
        }
        else {
            id[qID]=id[pID];
            sz[pID]+=sz[qID];
        }


       /* for (int i = 0; i <id.length ; i++) {
            if(id[i]==smallerID) {id[i]=biggerID;sz[biggerID]+=1;}
        }*/
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        PathCompressionWeightedQuickUnionUF uf = new PathCompressionWeightedQuickUnionUF(N);
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
