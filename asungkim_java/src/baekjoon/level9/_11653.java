package baekjoon.level9;

import java.util.Scanner;

public class _11653 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            while (true) {
                if (n%i!=0) {
                    break;
                }
                System.out.println(i);
                n/=i;
            }
        }

        if (n>1) System.out.println(n);
    }

}
