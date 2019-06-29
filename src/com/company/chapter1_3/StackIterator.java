package com.company.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Stack;

public class StackIterator<Item> implements Iterable<Item> {

    private Stack<Item> s;
    private Stack<Item> s1;
    private Iterator<Item> i;

    public StackIterator(Stack<Item> s){
        this.s=s;
        i=this.copy();
    }

    public Stack<Item> getS() {
        return s;
    }

    @Override
    public Iterator<Item> iterator() {
        return i;
    }

    public Iterator<Item> copy()
    {
        s1=(Stack<Item>) s.clone();
        return new mystack<Item>();
    }

    private class mystack<Item> implements Iterator<Item>{
        @Override
        public boolean hasNext() {
            return !s1.isEmpty();
        }

        @Override
        public Item next() {
            return (Item)s1.pop();
        }
    }

    public static void main(String[] args) {
        Stack<String> s=new Stack<String>();
        s.push("1");
        s.push("2");
        s.push("3");
        StackIterator<String> ss = new StackIterator<String>(s);

        s.pop();
        for(String x:ss)
            StdOut.println(x);

        StdOut.println("The origin source:");

        for(String x:s)
            StdOut.println(x);


    }
}
