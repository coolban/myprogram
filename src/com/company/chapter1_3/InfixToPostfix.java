package com.company.chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix {
    public static void InfixToPrefix()
    {
        Stack<String> ex=new Stack<String>();

        Stack<String> op = new Stack<String>();

        Stack<String> ex_out=new Stack<String>();

        while (!StdIn.isEmpty())
        {
            ex.push(StdIn.readString());
        }

        while(!ex.isEmpty()){
            String s;
            s=ex.pop();

            if(s.equals(")"))
            {
                //ex_out.push(s);
            }

            if(s.equals("+") || s.equals("-") ||s.equals("*")) {
                op.push(s);
            }

            if(s.equals("0") || s.equals("1")|| s.equals("2") || s.equals("3") ||s.equals("4") ||s.equals("5") ||s.equals("6")
                    ||s.equals("7") ||s.equals("8") ||s.equals("9"))
            {
                ex_out.push(s);
            }
            if(s.equals("("))
            {
                ex_out.push(op.pop());
            }


        }

        for (String s:ex_out
        ) {
            StdOut.print(s);
        }

    }

    public static void InfixToPostfix()
    {
        Stack<String> ex=new Stack<String>();

        Stack<String> op = new Stack<String>();

        Stack<String> ex_out=new Stack<String>();

        while (!StdIn.isEmpty())
        {
            ex_out.push(StdIn.readString());
        }

        while(!ex_out.isEmpty()){
            ex.push(ex_out.pop());
        }

        while (!ex.isEmpty()){
            String s;
            s=ex.pop();

            if(s.equals("("))
            {
                //ex_out.push(s);
            }

            if(s.equals("+") || s.equals("-") ||s.equals("*")) {
                op.push(s);
            }

            if(s.equals("0") || s.equals("1")|| s.equals("2") || s.equals("3") ||s.equals("4") ||s.equals("5") ||s.equals("6")
                    ||s.equals("7") ||s.equals("8") ||s.equals("9"))
            {
                ex_out.push(s);
            }

            if(s.equals(")"))
            {
                ex_out.push(op.pop());
            }
        }

        while(!ex_out.isEmpty())
        {
            ex.push(ex_out.pop());
        }

        for (String s:ex
        ) {
            StdOut.print(s);
            StdOut.print(" ");

        }

    }

    public static void main(String[] args) {
        //InfixToPrefix();
        InfixToPostfix();
    }
}
