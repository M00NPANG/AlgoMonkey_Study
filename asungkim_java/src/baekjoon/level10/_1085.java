package baekjoon.level10;

import java.util.Scanner;

public class _1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 0,0 w,h w,0 0,h
        int x=sc.nextInt();
        int y=sc.nextInt();
        int w=sc.nextInt();
        int h=sc.nextInt();

        int min = Math.min(Math.min(Math.abs(h - y), Math.abs(y)), Math.min(Math.abs(w - x), Math.abs(x)));

        System.out.println(min);
    }
}
