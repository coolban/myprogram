package com.company;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SmartDate {
    private final int month;
    private final int day;
    private final int year;
    private int[] days={31,0,31,30,31,30,31,31,30,31,30,31};

    public SmartDate(int m,int d,int y)
    {
        month=m;
        day=d;
        year=y;
    }

    public SmartDate(String date)
    {
        String[] fields = date.split("/");
        month = Integer.parseInt(fields[0]);
        day = Integer.parseInt(fields[1]);
        year = Integer.parseInt(fields[2]);
    }

    public boolean isValid()
    {
        if((month==1 ||month==3 ||month==5 ||month==7 ||month==8 ||month==10 ||month==12) && day>=1 && day<=31) return true;
        if((month==4 ||month==6 ||month==9 ||month==11 ) && day>=1 &&day<=30) return true;
        if(((year % 4==0 && year %100>0) || (year % 400==0)) && month==2 && day==29) return true;
        return false;

/*        if(month<1 && month>12) return false;
        if((year % 4==0 && year %100>0) || (year % 400==0))
        {
            //闰年
            if((month==1 ||month==3 ||month==5 ||month==7 ||month==8 ||month==10 ||month==12) && day>=1 && day<=31) return true;
            if((month==4 ||month==6 ||month==9 ||month==11 ) && day>=1 &&day<=30) return true;
            if(month==2 && day>=1 && day<=29) return true;
            return false;

        }else {
            if((month==1 ||month==3 ||month==5 ||month==7 ||month==8 ||month==10 ||month==12) && day>=1 && day<=31) return true;
            if((month==4 ||month==6 ||month==9 ||month==11 ) && day>=1 &&day<=30) return true;
            if(month==2 && day>=1 && day<=28) return true;
            return false;
        }*/
    }

    private boolean isLeapYear(int year){
        if((year % 4==0 && year %100>0) || (year % 400==0)) return true;
        return false;
    }

    public String dayOfTheWeek()
    {
        //假定是21世纪
        int daysince2000_01_01=0;
        for (int i = 2000; i < year(); i++) {
           if (isLeapYear(i)) daysince2000_01_01+=366;
           else daysince2000_01_01+=365;
        }

        for (int i = 0; i <month()-1 ; i++) {
            daysince2000_01_01+=days[i];
        }

        if(month()>2)
            if(isLeapYear(year())) daysince2000_01_01+=29;
            else daysince2000_01_01+=28;

            daysince2000_01_01+=day();

        switch (daysince2000_01_01 % 7) {
            case 1:
                return "Saturday";
            case 2:
                return "Sunday";

            case 3:
                return "Monday";

            case 4:
                return "Tuesday";

            case 5:return "Wednesday";

            case 6:return "Thursday";

            case 0:return "Friday";

            default: return "";
        }


    }
    public int month(){
        return month;
    }

    public int day(){
        return day;
    }

    public int year()
    {
        return year;
    }

    public String toString()
    {
        return month()+"/"+day()+"/"+year();
    }

    public static SmartDate[] readDates(){

        Queue<String> q=new Queue<String>();

        while(!StdIn.isEmpty())
        {
            q.enqueue(StdIn.readString());
        }

        SmartDate[] a = new SmartDate[q.size()];
        for (int i = 0; i <a.length ; i++) {
            a[i]=new SmartDate(q.dequeue());
        }

        return a;


    }

    public static void main(String[] args) {
        SmartDate sd;
        sd = new SmartDate(3,2,2029);
        StdOut.println(sd.dayOfTheWeek());
        SmartDate[] s;
        s=readDates();

        for (SmartDate d:
             s) {
            StdOut.println(d);
        }

    }
}
