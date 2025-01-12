package baekjoon.level7;

import java.util.Scanner;

public class _2566 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int max=Integer.MIN_VALUE;
        int a=0; int b=0;
        int[][] matrix=new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrix[i][j]=sc.nextInt();

                if (max<matrix[i][j]) {
                    max=matrix[i][j];
                    a=i;
                    b=j;
                }
            }
        }


        System.out.println(max+"\n"+(a+1)+" "+(b+1));


    }
}
