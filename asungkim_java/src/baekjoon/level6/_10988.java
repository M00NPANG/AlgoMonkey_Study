package baekjoon.level6;

import java.util.Scanner;

public class _10988 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();

        String reverse = new StringBuilder(s).reverse().toString();

        if (s.equals(reverse)) {
            System.out.println(1);
        }
        else System.out.println(0);
    }
}
