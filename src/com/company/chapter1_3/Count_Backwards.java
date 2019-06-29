package com.company.chapter1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Count_Backwards {

    public static void GetCountBackwars(int k){
        Queue<Character> q=new Queue<Character>();
        while(!StdIn.isEmpty())
        {
            q.enqueue(StdIn.readChar());
        }

        int i=0;
        int size=q.size();
        while(i<size-k)
        {
            q.dequeue();
            i++;
        }
        StdOut.println(q.dequeue());
    }

    public static void main(String[] args) {
        StdOut.println(args[0]);
        GetCountBackwars(Integer.parseInt(args[0]));
    }

}
