package com.company.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class MyStack<Item> {
    private Node first;
    private int N;
    private class Node
    {
        Item item;
        Node next;

        public Node(Node n)
        {
            item=n.item;
            next=n.next;
        }

        public Node()
        {
            item=null;
            next=null;
        }
    }
    public boolean isEmpty(){
        return first ==null;
    }

    public int size(){ return N;}

    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek()
    {
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }


    public MyStack(MyStack s) {
        if(s.isEmpty()) {first=null;N=0;return;}
        Node f = new Node(s.first);

        for(Node n=f;n.next!=null;n=n.next)
            n.next=new Node(n.next);

        first=f;
        N=s.size();


    }

    public MyStack() {
        first=null;
        N=0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Node n = first;n!=null;n=n.next)
        {
            s.append(n.item.toString()+" ");
        }

        return s.toString();
    }


    public static void main(String[] args) {
        MyStack<Integer> ms=new MyStack<Integer>();

        for(int i= 0;i<10;i++)
        {
            ms.push(i);
        }

        StdOut.println(ms.toString());

        MyStack<Integer> ms2=new MyStack<Integer>(ms);

        StdOut.println(ms.toString());
        StdOut.println(ms2.toString());
    }
}
