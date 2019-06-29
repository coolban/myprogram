package com.company.chapter1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Josephus {
    public static int getPosition(int N ,int M)
    {
        int count=0;
        Queue<Integer> q = new Queue<Integer>();

        if(N<=0 || M<=0)
            return -1;

        //初始化队列
        for (int i = 0; i <N ; i++) {
            q.enqueue(i);
        }

        while(q.size()>1){
            count++;
            if(count % M==0) {

                StdOut.println(q.dequeue());
                count=0;
            }
            else
            q.enqueue(q.dequeue());
        }

        return q.dequeue();


    }

    public static void main(String[] args) {
        StdOut.println(getPosition(7,2));
    }


}
