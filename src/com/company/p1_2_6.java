package com.company;

import edu.princeton.cs.algs4.StdOut;

public class p1_2_6 {
    public static void main(String[] args) {
        String s1="ACTGACG";
        String s2="TGACGAC";

        StdOut.println(s1.substring(0,1));

        StdOut.print(s1.indexOf(s2));

        for (int i = 1; i < s1.length(); i++) {
            StdOut.println(s1.substring(i)+""+s1.substring(0,i));
            if(s2.equals(s1.substring(i)+s1.substring(0,i)))
            {
                StdOut.println("yes");
                break;
            }
        }

        StdOut.println(isCircularRoation(s1,s2));

        StdOut.println("no");

    }

    public static boolean isCircularRoation(String s,String t)
    {
        return s.length()==t.length() && (s+s).indexOf(t)>0;
    }
}
