package com.company.chapter1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ex_1_4_19 {
        public static int LocalMinimumInMatrix(int [][] a)
        {
            int rows=a.length;
            int columns=a[0].length;
            int rowofstart=0;
            int rowofend=rows-1;
            int columnofstart=0;
            int columnofend=columns-1;

            do {
                //one circle
                int rowindex = (rowofstart + rowofend) / 2;

                int min = Integer.MAX_VALUE;

                int maxcolumnindex = -1;

                //查找最小值及最小值对应的列索引
                for (int i = columnofstart; i <= columnofend; i++) {
                    if (a[rowindex][i] <= min) {
                        min = a[rowindex][i];
                        maxcolumnindex = i;
                    }
                }
                //范围内只有一行
                if (rowindex - 1 < rowofstart && rowindex + 1 > rowofend) return min;
                //有一边（上边）超范围
                if (rowindex - 1 < rowofstart && rowindex + 1 <= rowofend && a[rowindex][maxcolumnindex] < a[rowindex + 1][maxcolumnindex])
                    return min;
                //有一边（下边）超范围
                if (rowindex - 1 >= rowofstart && rowindex + 1 > rowofend && a[rowindex][maxcolumnindex] < a[rowindex - 1][maxcolumnindex])
                    return min;
                //都在范围内
                if (rowindex - 1 >= rowofstart && rowindex + 1 <= rowofend && a[rowindex][maxcolumnindex] < a[rowindex + 1][maxcolumnindex] && a[rowindex][maxcolumnindex] < a[rowindex - 1][maxcolumnindex])
                    return min;

                if (rowindex + 1 >= rowofend || a[rowindex - 1][maxcolumnindex] < a[rowindex + 1][maxcolumnindex])
                    //临近的上面小于下面
                    rowofend = rowindex - 1;
                else rowofstart = rowindex + 1;

                //取列的中间索引
                int columnindex = (columnofstart + columnofend) / 2;

                int maxrowindex = -1;

                min = Integer.MAX_VALUE;

                for (int i = rowofstart; i <= rowofend; i++) {
                    if (a[i][columnindex] <= min) {
                        min = a[i][columnindex];
                        maxrowindex = i;
                    }
                }

                if (columnindex - 1 < columnofstart && columnindex + 1 > columnofend) return min;

                if (columnindex - 1 < columnofstart && columnindex + 1 <= columnofend && a[maxrowindex][columnindex] < a[maxrowindex][columnindex + 1])
                    return min;

                if (columnindex - 1 >= columnofstart && columnindex + 1 > columnofend && a[maxrowindex][columnindex] < a[maxrowindex][columnindex - 1])
                    return min;

                if (columnindex - 1 >= columnofstart && columnindex + 1 <= columnofend && a[maxrowindex][columnindex] < a[maxrowindex][columnindex + 1] && a[maxrowindex][columnindex] < a[maxrowindex][columnindex - 1])
                    return min;

                if (columnindex + 1 >= columnofend || a[maxrowindex][columnindex - 1] < a[maxrowindex][columnindex + 1])
                    columnofend = columnindex - 1;
                else columnofstart = columnindex + 1;
            }while (true);





        }

    public static void main(String[] args) {
            int[] a=new int[81];
        for (int i = 0; i <a.length ; i++) {
            a[i]=i;
        }

        StdRandom.shuffle(a);

        int [][] b =new int[9][9];

        int count=0;

        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                b[i][j]=a[count++];
                if(count==81) break;
            }

            if(count==25) break;
        }

        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j < 9 ; j++) {

                StdOut.printf("%3d ",b[i][j]);

            }
            StdOut.println();
        }

        StdOut.printf("The number is %d",LocalMinimumInMatrix(b));





    }

}
