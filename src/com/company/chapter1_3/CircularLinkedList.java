package com.company.chapter1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class CircularLinkedList<Item> {
    private class Node{
        Item item;
        Node next;
    }

    private Node last;

    private int N;

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return N==0;
    }

    public CircularLinkedList(){
        last = null;
        N=0;
    }

    public void Add(Item item){
        Node n = new Node();
        n.item=item;
        if(isEmpty()) {
            n.next=n;
            last=n;

        }
        else{
            n.next=last.next;
            last.next=n;
            last=n;

        }
        N++;

    }


    public  CircularLinkedList<Item> QueueCatenate(Queue<Item> q1,Queue<Item> q2)
    {
        CircularLinkedList<Item> cl = new CircularLinkedList<Item>();

        while(!q1.isEmpty()){
            cl.Add(q1.dequeue());
        }

        while(!q2.isEmpty()){
            cl.Add(q2.dequeue());
        }

        return cl;
    }

    public CircularLinkedList<Item> StackCatenate(Stack<Item> s1, Stack<Item> s2){
        CircularLinkedList<Item> cl = new CircularLinkedList<Item>();

        while(!s1.isEmpty()){
            cl.Add(s1.pop());
        }

        while(!s2.isEmpty()){
            cl.Add(s2.pop());
        }

        return cl;
    }






    @Override
    public String toString() {
        if(isEmpty()) return "";
        Node n=last.next;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<size();i++)
        {
            sb.append(n.item.toString()+" ");
            n=n.next;
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> cl = new CircularLinkedList<Integer>();


        for (int i = 0; i <10 ; i++) {
            cl.Add(i);
        }

        StdOut.println(cl);
    }
}
