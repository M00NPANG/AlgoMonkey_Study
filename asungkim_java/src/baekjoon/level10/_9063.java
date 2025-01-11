package baekjoon.level10;

import java.util.Scanner;

public class _9063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int minX=Integer.MAX_VALUE;
        int minY=Integer.MAX_VALUE;
        int maxX=Integer.MIN_VALUE;
        int maxY=Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int x= sc.nextInt();
            int y= sc.nextInt();

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }

        int a=Math.abs(maxX-minX);
        int b=Math.abs(maxY-minY);

        System.out.println(a*b);

    }
}
