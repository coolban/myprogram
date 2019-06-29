package com.company.chapter2_1;

import com.company.SmartDate;
import com.company.Transaction;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdOut;

public class p2_1_21 {
    private class MyDate extends SmartDate implements Comparable<SmartDate>{

        public MyDate(int m,int d,int y){
            super(m,d,y);
        }

        public MyDate(String date)
        {
            super(date);
        }

        @Override
        public int compareTo(SmartDate that) {
            if(this.year()>that.year()) return +1;
            if(this.year()>that.year()) return -1;
            if(this.month()>that.month()) return +1;
            if(this.month()<that.month()) return -1;
            if(this.day()> that.day()) return +1;
            if(this.day()<that.day()) return -1;
            return 0;
        }
    }

    private static class MyTransaction extends Transaction implements Comparable<Transaction>{
        public MyTransaction(String who, SmartDate when, double amount) {
            super(who, when, amount);
        }

        public MyTransaction(String trans) {
            super(trans);
        }

        @Override
        public int compareTo(Transaction that) {
            if(this.amount()>that.amount()) return +1;
            if(this.amount()<that.amount()) return -1;
            return 0;
        }
    }

    public static MyTransaction[] readTransctions(String s)
    {
        In thefile = new In(s);
        String[] trans = thefile.readAllLines();
        MyTransaction[] myTransactions=new MyTransaction[trans.length];

        for (int i = 0; i <trans.length ; i++) {
            myTransactions[i]=new MyTransaction(trans[i]);
        }

        return myTransactions;

    }

    public static void main(String[] args) {
        MyTransaction[] myTransactions=readTransctions(args[0]);

        Shell.sort(myTransactions);

        for (int i = 0; i <myTransactions.length ; i++) {
            StdOut.println(myTransactions[i]);
        }
    }

}
