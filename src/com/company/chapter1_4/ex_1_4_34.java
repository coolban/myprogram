package com.company.chapter1_4;

import edu.princeton.cs.algs4.StdOut;

public class ex_1_4_34 {

    /*表示猜测结果
        值   意义
        -1   初始值，表示还未猜测
        0    相等
        1    冷
        2    热
        4    无变化
    */
    int horc=-1;

    int lastDistance=-1;

    int end;

    int secretnum;

    public int getCount() {
        return count;
    }

    int count=0;

    public ex_1_4_34(int end, int secretnum) {
        this.end = end;
        this.secretnum = secretnum;
    }

    /*
        本函数对数组（1、2 、...、N的有序数组）中的一个秘密数字进行猜测，每一次猜测会根据用户的反馈是比前一次冷（远离秘密数字）
        还是热（靠近秘密数字）来进行下一次猜测。程序的复杂度能够达到1lg N。
        为了能够达到要求的复杂度，要求程序每次的猜测能够淘汰查询范围中一半的数组元素。如果将猜测范围限定在查询范围内，
        则需要两次猜测才能将查询范围缩小到原来的一半。例如，假定某次猜测淘汰了一半的元素，那么下次猜测一定反馈热，但是不能判断秘密数字
        在查询范围的哪边，因此并不能淘汰查询范围内的一半元素。

        如果将查询范围扩大到-N~~2N,那么，可以保证每次猜测淘汰一半的元素。原理如下，假定[a,b]是当前的查询范围，
        c是上次查询的元素，则下次猜测为d，其中d需要满足（c+d）/2=(a+b)/2=m。即c到a、b中点的距离与d到a、b中点的距离相同。
        这就重新构造了一个查询范围，这个新的查询范围与原查询范围的关系的包含关系并且关于相同的中点对称。根据d点冷暖情况，
        可知秘密数是靠近c点还是d点，即知是靠近a点还是b点（或者b点还是a点，与c、d点的位置有关）。


        这是空间换时间的一种方式。效率提高的原因在于在猜测的同时构造了一个与原来查询范围等价的范围，但是利用了额外的空间。

         */
    public int HotOrColdGuess(){

        int start = 1,end = this.end;
        int c;
        int d;

        c=-end;

        //使用-N 进行第一次猜测，为后续猜测设定参照
        guess(c);

        while (end-start>1) {
            d = start + end - c;
            int gg = guess(d);
            if (gg == 4) return (c+d)/2;
            else if (gg == 1) {//在c这边
                if (c < d) {
                    end = (start + end) / 2;

                } else {
                    start = (start + end) / 2;
                }


            } else {
                //在d这边
                if (c < d) {
                    start = (start + end) / 2;

                } else {
                    end = (start + end) / 2;
                }
            }

            c = d;
        }

        if(guess(start)==0) return start;
        if(guess(end)==0) return end;

        return -1;

    }

    private int guess(int g) {

        count++;
        if(g==secretnum) {
            horc=0;
            return 0;
        }

        if(lastDistance==-1) {
            lastDistance=Math.abs(secretnum-g);
        }
        else {
            if(Math.abs(secretnum-g)==lastDistance) horc=4;
            else if(Math.abs(secretnum-g)>lastDistance) horc=1;
            else horc=2;
        }

        lastDistance=Math.abs(secretnum-g);
        return horc;

    }


    public static void main(String[] args) {
        int x=1000000;
        ex_1_4_34 e = new ex_1_4_34(x,1);

        StdOut.printf("%d\nguess number %d\n",e.HotOrColdGuess(),e.getCount());
        StdOut.print(Math.log(x)/Math.log(2));
    }

}
