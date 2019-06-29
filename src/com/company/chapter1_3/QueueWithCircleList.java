package com.company.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

public class QueueWithCircleList<Item> {
    private class Node{
        Item item;
        Node next;
    }

    private Node last;
    private int N;

    public QueueWithCircleList(){
        last=null;
        N=0;
    }

    public void enqueue(Item item){
        Node nd = new Node();
        nd.item=item;
        if(N==0)
        {
            last=nd;
            last.next=last;
        }
        else{
            nd.next=last.next;
            last.next=nd;
            last=nd;
        }

        N++;

    }

    public Item dequeue(){
        if(N==0)
            return null;
        Item item = last.next.item;
        if(N==1)
            last=null;
        else
        {
            last.next=last.next.next;
        }
        N--;
        return item;
    }

    public boolean isEmpty()
    {
        return N==0;
    }

    public int size(){
        return N;
    }

    @Override
    public String toString() {
        Node n;
        String s="";
        if(isEmpty()) return s;
        n=last.next;
        for(int i=0;i<size();i++)
        {
            s=s+" "+n.item.toString();
            n=n.next;
        }

        return s;
    }

    public static void main(String[] args) {
        QueueWithCircleList<Integer> q =new QueueWithCircleList<>();
        for(int i = 0;i<100;i++)
        {
            q.enqueue(i);
        }

        StdOut.println(q);

        StdOut.println(q.dequeue());

        StdOut.println(q);

        StdOut.println(q.dequeue());

        StdOut.println(q);

    }
}
