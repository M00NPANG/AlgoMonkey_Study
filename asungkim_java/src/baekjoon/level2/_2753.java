package baekjoon.level2;

import java.util.Scanner;

public class _2753 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int year=sc.nextInt();

        // 4의배수 && (100의배수x || 400의배수)

        if ((year%4==0&&year%100!=0)||year%400==0) {
            System.out.println(1);
        }
        else System.out.println(0);

    }
}
