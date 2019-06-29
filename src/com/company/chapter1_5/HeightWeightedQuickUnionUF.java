package com.company.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class HeightWeightedQuickUnionUF {

    private int [] id;
    private int count;
    private int [] sz;

    public HeightWeightedQuickUnionUF(int N){
        count=N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
            sz[i]=0;
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
        while(id[q]!=q) q=id[q];

        return q;
    }

    public void union(int p,int q){
        int pID=find(p);
        int qID=find(q);



        if(pID==qID) return;

        if(sz[pID]<sz[qID]) {
            id[pID]=qID;
        }
        else if(sz[pID]>sz[qID]){
            id[qID]=pID;
        }
        else
        {
            id[qID]=pID;
            sz[pID]+=1;
        }

        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        HeightWeightedQuickUnionUF uf = new HeightWeightedQuickUnionUF(N);
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
/*

证明如下命题：
用此算法产生的N个触点的树的高度一定不超过lgN。
可以证明这样一个等价的命题：高度为h的树的触点数量至少为2^h，即N>=2^h。
当N=1时，高度为0，命题成立。
假设i、j<N时,命题成立，及i>=2^h(i),j>=2^h(j)
显然，当h(i)不等于h(j)时，合并两颗树后命题显然成立。
当h(i)=h(j)时，不妨设大小为j的树合并到大小为i的树上，
合并后的树的高度为h(i)+1，i+j>=2^h(i)+2^h(j)=2^(h(i)+1),显然命题成立。
综上所述，命题成立。
*/