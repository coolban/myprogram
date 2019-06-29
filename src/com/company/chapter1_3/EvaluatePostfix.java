package com.company.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class EvaluatePostfix {
    public static void evaluatepostfix(){
        Stack<String>   ex_1=new Stack<String>();
        Stack<String>   ex = new Stack<String>();
        Stack<Integer>   ex_num=new Stack<Integer>();

        //Integer ret=null;

        while (!StdIn.isEmpty())
        {
            ex_1.push(StdIn.readString());
        }


        while(!ex_1.isEmpty())
        {
            ex.push(ex_1.pop());
        }

        while(!ex.isEmpty()){
            String s;
            s=ex.pop();
            if(s.equals("+") || s.equals("-") ||s.equals("*")) {
                Integer num1,num2;
                num2=ex_num.pop();
                num1=ex_num.pop();
                if (s.equals("+"))
                    ex_num.push(num1+num2);
                if (s.equals("-"))
                    ex_num.push(num1-num2);
                if (s.equals("*"))
                    ex_num.push(num1*num2);

            }

            if(s.equals("0") || s.equals("1")|| s.equals("2") || s.equals("3") ||s.equals("4") ||s.equals("5") ||s.equals("6")
                    ||s.equals("7") ||s.equals("8") ||s.equals("9"))
            {
                ex_num.push(Integer.parseInt(s));
            }
        }

        StdOut.println(ex_num.pop());

    }

    public static void main(String[] args) {
        evaluatepostfix();
    }
}
