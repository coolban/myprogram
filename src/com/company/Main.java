package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
//        long u;
//        Random r =new Random();
//        long u1 = r.nextLong();
//
//        while(u1>0)
//        {
//            u1 = r.nextLong();
//        }
//
//        System.out.println(u1);
//        System.out.println(u1>>>1);
//        System.out.println((u1>>>1)%10);
//
//        System.out.println(4%5);
//
//        u=100;
//        System.out.println(100>>>1);

        Random random;
        int n = 100000;
        random = new Random();
        if (n <= 0L) throw new IllegalArgumentException("argument must be positive: " + n);

        // https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#longs-long-long-long-
        long r = random.nextLong();
        long m = n - 1;

        // power of two
        if ((n & m) == 0L) {
            return ;//r & m;
        }

        // reject over-represented candidates
        long u = r >>> 1;
        while (true) {
            if(u + m - (r = u % n) < 0L) {
                System.out.println(r);
                return;
            }
            u = random.nextLong() >>> 1;
        }
        //return ;//r;
    }
}
