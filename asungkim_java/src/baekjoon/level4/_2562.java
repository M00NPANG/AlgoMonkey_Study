package baekjoon.level4;

import java.util.Scanner;

public class _2562 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int idx=-1;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
            int n=sc.nextInt();

            if (n>max) {
                max=n;
                idx=i;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}
