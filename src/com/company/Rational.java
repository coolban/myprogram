package com.company;

import edu.princeton.cs.algs4.StdOut;

public class Rational {
    private Long numerator;
    private Long denominator;

    public Rational(Long numerator,Long denominator)
    {
        Long g=gcd(numerator,denominator);
        this.numerator = numerator/g;
        this.denominator = denominator/g;
    }

    public Rational plus(Rational b){
        if(this.denominator==b.denominator) return new Rational(this.numerator+b.numerator,this.denominator);

        return new Rational(this.numerator*b.denominator+b.numerator*this.denominator,this.denominator*b.denominator);

    }

    public Rational minus(Rational b){
        Rational b1 = new Rational(-b.numerator,b.denominator);
        return plus(b1);
    }

    public Rational times(Rational b){

        return new Rational(this.numerator*b.numerator,this.denominator*b.denominator);
    }

    public Rational divides(Rational b) throws Exception{
        //if(b.numerator==0) throw new Exception("不能除零");
        assert b.numerator!=0:"不能除零";
        return new Rational(this.numerator*b.denominator,this.denominator*b.numerator);

    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null) return false;
        if(this.getClass()!=obj.getClass()) return false;
        Rational that=(Rational)obj;

        if(this.numerator!=that.numerator) return false;
        if(this.denominator!=that.denominator) return false;

        return true;
    }

    @Override
    public String toString() {
        return numerator.toString()+"/"+denominator.toString();
    }

    private  Long gcd(Long a, Long b)
    {
        if(a % b ==0) return b;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        Rational r1 = new Rational(new Long(100),new Long(20));
        Rational r2 = new Rational(new Long(20),new Long(100));
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
