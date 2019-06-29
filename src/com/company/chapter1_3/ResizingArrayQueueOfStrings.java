package com.company.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings<Item> {
    private Item[] a;   //Queue entries
    private int N;      //size
    private int start;
    private int end;
    public ResizingArrayQueueOfStrings(){
        a=(Item[]) new Object[16];
        N=0;
        start=0;
        end=0;
    }

    public void enqueue(Item item) throws Exception {

        if(N==a.length)
            resize(N*2);

        if(N<a.length)
        {
            a[end]=item;
            if(end==a.length-1){

                end=0;

            }
            else{
                end++;
            }

            N++;
        }
        else
        {
            throw new Exception("Capacity exceeded.");
        }
    }

    public Item dequeue() throws Exception {
        Item ret;

        if(N<=a.length/4)
            resize(a.length/2);

        if(N==0)
        {
            throw new Exception("No elements in the queue.");
        }
        else
        {
            ret = a[start];
            if(start==a.length-1){
                start=0;
            }
            else{
                start++;
            }
        }
        N--;
        return  ret;
    }

    public boolean isEmpty()
    {
        return N==0;
    }


    public int size()
    {
        return N;
    }

    private void resize(int max)
    {
        Item[] temp = (Item[])new Object[max];
        for(int i=0;i<N;i++){
            temp[i]=a[(start+i)%a.length];

        }

        a=temp;
        start=0;
        end=N;
    }

    public static void main(String[] args) throws Exception {
        ResizingArrayQueueOfStrings<Integer> r = new ResizingArrayQueueOfStrings<Integer>();

        for (int i = 0; i < 50; i++) {
            r.enqueue(i);
        }

        for(int i=0;i<20;i++){
            StdOut.println(r.dequeue());
        }

        for(int i=50;i<100;i++){
            r.enqueue(i);
        }

        while(!r.isEmpty())
        {
            StdOut.println(r.dequeue());
        }

    }

}
