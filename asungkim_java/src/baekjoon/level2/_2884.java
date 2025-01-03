package baekjoon.level2;

import java.util.Scanner;

public class _2884 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int h=sc.nextInt();
        int m=sc.nextInt();

        int totalMin=h*60+m;
        totalMin-=45;

        if (totalMin<0) {
            totalMin+=(24*60);
        }

        int ch=totalMin/60;
        int cm=totalMin%60;

        System.out.println(ch+" "+cm);

    }
}
