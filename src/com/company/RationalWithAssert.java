package com.company;

import edu.princeton.cs.algs4.StdOut;

import java.math.BigInteger;

public class RationalWithAssert {

    private BigInteger numerator;
    private BigInteger denominator;
    private final BigInteger max = BigInteger.valueOf(Long.MAX_VALUE);
    private final BigInteger min = BigInteger.valueOf(Long.MIN_VALUE);


    public RationalWithAssert(long numerator,long denominator)
    {
        //if (denominator != 0) throw new AssertionError("分母不能为零");
        assert denominator != 0:"分母不能为零";

        this.numerator = BigInteger.valueOf(numerator);

        this.denominator = BigInteger.valueOf(denominator);

        BigInteger g = this.numerator.gcd(this.denominator);

        this.numerator = this.numerator.divide(g);
        this.denominator = this.denominator.divide(g);

        this.numerator = this.denominator.compareTo(BigInteger.valueOf(0))<0?this.numerator.multiply(BigInteger.valueOf(-1)):this.numerator;
        this.denominator = this.denominator.compareTo(BigInteger.valueOf(0))<0?this.denominator.multiply(BigInteger.valueOf(-1)):this.denominator;

    }

    public RationalWithAssert plus(RationalWithAssert b){
        assert this.numerator.add(this.denominator).compareTo(max)<=0 && this.numerator.add(this.denominator).compareTo(min)>=0:"溢出";
        if(this.denominator==b.denominator) return new RationalWithAssert(this.numerator.add(this.denominator).longValue(),this.denominator.longValue());

        assert this.numerator.multiply(b.denominator).add(b.numerator.multiply(this.denominator)).compareTo(max)<=0 &&this.numerator.multiply(b.denominator).add(b.numerator.multiply(this.denominator)).compareTo(min)>=0:"溢出";
        assert this.denominator.multiply(b.denominator).compareTo(max)<=0 && this.denominator.multiply(b.denominator).compareTo(min)>=0:"溢出";
        return new RationalWithAssert(this.numerator.multiply(b.denominator).add(b.numerator.multiply(this.denominator)).longValue(),this.denominator.multiply(b.denominator).longValue());

    }

    public RationalWithAssert minus(RationalWithAssert b)
    {
        RationalWithAssert b1 = new RationalWithAssert(b.numerator.multiply(BigInteger.valueOf(-1)).longValue(),b.denominator.longValue());
        return plus(b1);
    }

    public RationalWithAssert times(RationalWithAssert b)
    {
        assert this.numerator.multiply(b.numerator).compareTo(max)<=0 && this.numerator.multiply(b.numerator).compareTo(min)>=0:"溢出";
        assert this.denominator.multiply(b.denominator).compareTo(max)<=0 && this.denominator.multiply(b.denominator).compareTo(min)>=0:"溢出";
        return new RationalWithAssert(this.numerator.multiply(b.numerator).longValue(),this.denominator.multiply(b.denominator).longValue());
    }

    public RationalWithAssert divides(RationalWithAssert b)
    {
        assert b.numerator.compareTo(BigInteger.valueOf(0))!=0:"不能除零";
        assert this.numerator.multiply(b.denominator).compareTo(max)<=0 && this.numerator.multiply(b.denominator).compareTo(min)>=0:"溢出";
        assert this.denominator.multiply(b.numerator).compareTo(max)<=0 && this.denominator.multiply(b.numerator).compareTo(min)>=0:"溢出";
        return new RationalWithAssert(this.numerator.multiply(b.denominator).longValue(),this.denominator.multiply(b.numerator).longValue());

    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null) return false;
        if(this.getClass()!=obj.getClass()) return false;
        RationalWithAssert that=(RationalWithAssert)obj;

        if(this.numerator.compareTo(that.numerator)!=0) return false;
        if(this.denominator.compareTo(that.denominator)!=0) return false;

        return true;
    }

    @Override
    public String toString() {
        return numerator+"/"+denominator;
    }

    public static void main(String[] args) {
        RationalWithAssert r1 = new RationalWithAssert(new Long(100),new Long(-20));
        RationalWithAssert r2 = new RationalWithAssert(new Long(-20),new Long(100));

        StdOut.println(r1.times(r2));
        try {
            StdOut.println(r1.divides(r2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        StdOut.println(r1.plus(r2));
        StdOut.println(r1.minus(r2));
    }

}
