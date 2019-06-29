package com.company.chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackTools {
    public static boolean checkOverFlow(){

        String s;
        int N=0;
        while(!StdIn.isEmpty())
        {
            s=StdIn.readString();
            if(s.equals("-")) {
                if (--N < 0) return false;
            }else N++;
        }

        return true;

    }

    public static boolean canGenerate(){

        Stack<Integer> s=new Stack<Integer>();

        int x;

        int N=0;

        while(!StdIn.isEmpty())
        {

            x=Integer.parseInt(StdIn.readString());
            if(s.size()==0) s.push(N++);
            int t=s.pop();
            if(t==x) continue;
            else if(t>x) return false;
            else {
                for (int i = t; i < x; i++) {
                    s.push(i);
                }

                N=x+1;
            }

         }

         return true;

    }


    public static void main(String[] args) {
        //StdOut.println(checkOverFlow());
        StdOut.println(canGenerate());
    }
}
