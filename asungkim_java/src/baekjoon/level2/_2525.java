package baekjoon.level2;

import java.util.Scanner;

public class _2525 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int h=sc.nextInt();
        int m=sc.nextInt();

        int plus=sc.nextInt();

        int total=h*60+m+plus;


        if (total>24*60) {
            total-=(24*60);
        }

        int ch=total/60;
        int cm=total%60;

        System.out.println(ch+" "+cm);
    }
}
