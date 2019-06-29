package com.company.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {

    static private char[] left={'(','[','{'};
    static private char[] right={')',']','}'};

    public static boolean isMatch()
    {
        Stack<Character> lefts=new Stack<Character>();
        String characters_to_check="";
        while(!StdIn.isEmpty())
        {
            characters_to_check+=StdIn.readString();
        }

        char[] c=characters_to_check.toCharArray();

        for (int i = 0; i < c.length; i++) {
            int index = findIndex(left,c[i]);
            if(index>=0) {lefts.push(c[i]);continue;}
            index= findIndex(right,c[i]);
            if(index>=0)
            {
                if(!lefts.isEmpty() && lefts.pop()==left[index])
                    continue;
                else return false;
            }
        }
        if(lefts.isEmpty()) return true;
        return false;
    }

    private static int findIndex(char [] a,char c)
    {
        for (int i = 0; i < a.length; i++) {
            if(c==a[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        if(isMatch()) StdOut.println("OK");
        else StdOut.println("Not OK");
    }


}
