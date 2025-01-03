package baekjoon.level8;

import java.util.Scanner;

public class _2903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 9 -> 25 -> 81
        // 3^2 5^2 9^2 17^2
        int n=sc.nextInt();


        System.out.println(answer(n));
    }

    private static int answer(int n) {
         int bn=(int) Math.pow(2,n);
         int an=(int) Math.pow(1+bn,2);

         return an;
    }
}
