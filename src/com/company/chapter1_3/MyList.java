package com.company.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

public class MyList<Item> {
    private class Node {
        Item item;
        Node next;

        public Node(Node n)
        {

            item=n.item;

            N++;
            if(n.next!=null)
                next=new Node(n.next);
        }

        public Node() {
            item=null;
            next=null;
        }
    }

    private Node first;
    private int N;

    public MyList() {
        first = null;
        N = 0;
    }

    public MyList(MyList list)
    {
        first=new Node(list.first);
    }


    public boolean isEmpty() {
        return N == 0;
    }


    public void add(Item item) {
        if (isEmpty()) {
            Node n = new Node();
            n.item = item;
            n.next = null;
            first = n;

        } else {
            Node n = new Node();
            n.item = item;
            n.next = first;
            first = n;
        }
        N++;
    }

    @Override
    public String toString() {
        String s="";

        for(Node n=first;n!=null;n=n.next)
        {
            s=s+" "+n.item.toString();
        }

        return s;
    }

    public static void main(String[] args) {
        MyList my = new MyList();
        for (int i = 0; i <10 ; i++) {
            my.add(i);

        }

        StdOut.println(my);

        MyList my2=new MyList(my);

        StdOut.println(my2);


    }
}
