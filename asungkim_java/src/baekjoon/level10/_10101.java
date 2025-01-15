package baekjoon.level10;

import java.util.Scanner;

public class _10101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a==60&&b==60&&c==60) {
            System.out.println("Equilateral");
        }

        if (a+b+c==180) {
            if ((a==b&&b!=c)||(a==c&&b!=a)||(b==c&&a!=c)) {
                System.out.println("Isosceles");
            }
        }

        if (a+b+c==180) {
            if (a!=b&&b!=c&&c!=a) {
                System.out.println("Scalene");
            }
        }

        if (a+b+c!=180) {
            System.out.println("Error");
        }
    }
}
