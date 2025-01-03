package baekjoon.level9;

import java.util.Scanner;

public class _1978 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int an=0;
        for (int i = 0; i < n; i++) {
            int num=sc.nextInt();
            if (isPrimeNum(num)) {
                an++;
            }
        }

        System.out.println(an);
    }

    private static boolean isPrimeNum(int n) {
        // 소수 -> 자신과 1을 제외한 약수가 없는

        if (n<=1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (n%i==0) {
                return false;
            }
        }

        return true;
    }
}
