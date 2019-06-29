package com.company.chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Middle_order_expression {

    public static void Amend_Middle_order_expression(){
        Stack<String> ex=new Stack<String>();

        Stack<String> ex_out = new Stack<String>();

        Stack<Integer> exp=new Stack<Integer>();

        int count=0;
        // 0表示右操作数 1表示操作符 2表示左操作数 3表示一个新的表达式起点
        int flag=0;

        while (!StdIn.isEmpty())
        {
            ex.push(StdIn.readString());
        }

        while(!ex.isEmpty()){
            String s;
            s=ex.pop();
            if(s.equals(")"))
            {
                count++;
                ex_out.push(s);
                //标识表达式的起点（从右操作数开始）
                exp.push(3);
            }
            if(s.equals("+") || s.equals("-") ||s.equals("*")) {

                ex_out.push(s);
                exp.push(1);
            }
            if(s.equals("0") || s.equals("1")|| s.equals("2") || s.equals("3") ||s.equals("4") ||s.equals("5") ||s.equals("6")
                    ||s.equals("7") ||s.equals("8") ||s.equals("9"))
            {
                ex_out.push(s);
                //如果是表达式起点
                if(exp.peek()==3) { exp.push(0);}
                //如果是操作符
                while(exp.size()>0 && exp.peek()==1)
                {
                    //ex_out.push(s);

                    ex_out.push("(");
                    count--;
                    exp.pop();exp.pop();exp.pop();
                    if(count<=0) break;
                    if(exp.peek()==3) exp.push(0);
                    //if(exp.peek()==1) exp.push(2);
                }
                //while()
            }
        }

        for (String s:ex_out
             ) {
            StdOut.print(s);
        }




    }

    public static void main(String[] args) {
        Amend_Middle_order_expression();
    }

}
