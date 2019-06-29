package com.company.chapter1_4;

import edu.princeton.cs.algs4.StdOut;

public class ex_1_4_22 {
    public static boolean FibonacciSequenceFind(int[] a, int key){
        int fk=1,fkminusone=0;

        int i=0;

        while (fk<a.length){
            int tmp=0;
            tmp=fk+fkminusone;
            fkminusone=fk;
            fk=tmp;

        }

        while (fk>1)
        {

           if(a[i+fk-fkminusone-1]==key) return true;
            else if(a[i+fk-fkminusone-1]<key) {
                i=i+fk-fkminusone;
                int tmp;
                tmp = fk-fkminusone;
                fk=fkminusone;
                fkminusone=tmp;
            }
            else {
                int tmp;
                tmp = fk-fkminusone;
                fk = tmp;
                fkminusone = fkminusone-fk;
           }
        }

        return false;
    }

    public static void main(String[] args) {
        int [] a=new int[20];
        for (int i = 0; i < a.length; i++) {
            a[i]=i;
        }

        if(FibonacciSequenceFind(a,0)) StdOut.printf("Found!");
        else StdOut.printf("Not found!");
    }
}
