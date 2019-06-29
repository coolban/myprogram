package com.company;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Date;

public class Transaction {

    private final String who;
    private final SmartDate when;
    private final double amount;

    public Transaction(String who, SmartDate when,double amount)
    {
        this.who=who;
        this.when=when;
        this.amount=amount;
    }

    public Transaction(String trans)
    {
        String[] fields = trans.split("\\s+");
        who=fields[0];
        when = new SmartDate(fields[1]);
        amount = Double.parseDouble(fields[2]);
    }

    public String who() {
        return who;
    }

    public SmartDate when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    @Override
    public String toString() {
        return who()+" "+((Double)amount())+"at "+when();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null) return false;
        if(this.getClass()!=obj.getClass()) return false;
        Transaction that=(Transaction) obj;
        if(this.who!=that.who) return false;
        if(this.when!=that.when) return false;
        if(this.amount!=that.amount) return false;
        return true;
    }

    public static Transaction[] readTransaction(){
        Queue<String> q = new Queue<String>();
        while(!StdIn.isEmpty())
        {
            q.enqueue(StdIn.readLine());
        }
        Transaction[] t=new Transaction[q.size()];
        int size=q.size();
        for (int i = 0; i <size ; i++) {
            t[i]=new Transaction(q.dequeue());
        }

        return t;
    }

    public static void main(String[] args) {
        Transaction[] t= readTransaction();
        for (Transaction tt:t
             ) {
            StdOut.println(tt);
        }
    }
}
