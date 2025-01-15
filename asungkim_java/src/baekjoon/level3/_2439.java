package baekjoon.level3;

import java.util.Scanner;

public class _2439 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <=n ; i++) {
            System.out.print(" ".repeat(n-i));
            System.out.println("*".repeat(i));
        }
    }
}
