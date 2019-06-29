package com.company.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

public class DoublyLinkedList<Item> {
    private  class DoubleNode{
        Item item;
        DoubleNode pre;
        DoubleNode next;
    }

    private DoubleNode first;
    private DoubleNode last;
    private int N;

    public DoublyLinkedList(){
        first=null;
        last=null;
        N=0;
    }

    public void insertHead(Item item)
    {
        DoubleNode node = new DoubleNode();
        node.item=item;
        node.pre=null;
        node.next=null;
        if(first==null)
        {
            first=node;
            last=node;
        }
        else{

            node.next=first;
            first.pre=node;
            first=node;
        }
        N++;

    }

    public void insertTail(Item item)
    {
        DoubleNode node = new DoubleNode();
        node.item=item;
        node.pre=null;
        node.next=null;

        if(last==null)
        {
            first=node;
            last=node;
        }
        else{

            node.pre =last;
            last.next=node;
            last=node;
        }
        N++;

    }

    public void deleteHead()
    {
        if(N==0) return;
        if(N==1) {first=null;last=null;N--;return;};
        first=first.next;
        first.pre=null;
        N--;

    }

    public void deleteTail()
    {
        if(N==0) return;
        if(N==1) {first=null;last=null;N--;return;};
        last=last.pre;
        last.next=null;
        N--;
    }

    public void insertBefore(DoubleNode node,Item item)
    {
        if(node==null) return;
        if(node==first) insertHead(item);
        else {
            DoubleNode  n = new DoubleNode();
            n.item=item;
            node.pre.next=n;
            n.pre=node.pre;
            n.next=node;
            node.pre=n;
            N++;
        }
    }

    public void insertAfter(DoubleNode node,Item item)
    {
        if(node==null) return;
        if(node==last) insertTail(item);
        else {
            DoubleNode  n = new DoubleNode();
            n.item=item;
            node.next.pre=n;
            n.next=node.next;
            n.pre=node;
            node.next=n;
            N++;
        }
    }

    public void delete(DoubleNode node)
    {
        if(node==null) return;
        if(node==first) {deleteHead();return;}
        if(node==last) {deleteTail();return;}

        node.pre.next=node.next;
        node.next.pre=node.pre;
        node.pre=null;
        node.next=null;
        N--;

    }

    public DoubleNode find(Item item){
        for(DoubleNode n=first;n!=null;n=n.next)
        {
            if(item.equals(n.item))
                return n;
        }
        return null;
    }


    @Override
    public String toString() {
        DoubleNode n;
        String s="";
        if(isEmpty()) return s;
        n=first;
        for(int i=0;i<size();i++)
        {
            s=s+" "+n.item.toString();
            n=n.next;
        }

        return s;
    }

    private boolean isEmpty() {
        return N==0;
    }

    public int size(){
        return N;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList=new DoublyLinkedList<Integer>();

        for(int i=0;i<5;i++)
        {
            doublyLinkedList.insertHead(i);
        }

        StdOut.println(doublyLinkedList);

        for (int i = 0; i <5 ; i++) {
            doublyLinkedList.insertTail(i);
        }

        StdOut.println(doublyLinkedList);


        doublyLinkedList.insertAfter(doublyLinkedList.find(1),6);

        StdOut.println(doublyLinkedList);

        doublyLinkedList.insertBefore(doublyLinkedList.find(1),6);

        StdOut.println(doublyLinkedList);

        doublyLinkedList.insertBefore(doublyLinkedList.find(4),10);

        StdOut.println(doublyLinkedList);

        doublyLinkedList.insertTail(20);

        doublyLinkedList.insertAfter(doublyLinkedList.find(20),21);

        StdOut.println(doublyLinkedList);

        doublyLinkedList.delete(doublyLinkedList.find(21));

        StdOut.println(doublyLinkedList);

        doublyLinkedList.delete(doublyLinkedList.find(20));

        StdOut.println(doublyLinkedList);

        doublyLinkedList.delete(doublyLinkedList.find(10));

        StdOut.println(doublyLinkedList);




//        for (int i = 0; i <11 ; i++) {
//            doublyLinkedList.deleteHead();
//
//            StdOut.println(doublyLinkedList);
//        }



//        doublyLinkedList.deleteTail();
//
//        StdOut.println(doublyLinkedList);
//
//        doublyLinkedList.deleteTail();
//
//        StdOut.println(doublyLinkedList);
//
//        doublyLinkedList.deleteTail();
//
//        StdOut.println(doublyLinkedList);
//
//        doublyLinkedList.deleteTail();
//
//        StdOut.println(doublyLinkedList);
//
//        doublyLinkedList.deleteTail();
//
//        StdOut.println(doublyLinkedList);




    }


}
