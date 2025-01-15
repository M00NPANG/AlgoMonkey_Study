package baekjoon.level10;

import java.util.Scanner;

public class _5073 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 세 변 입력받기
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            // 종료 조건
            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            // 삼각형이 될 수 없는 조건 확인
            int max = Math.max(a, Math.max(b, c));
            int sum = a + b + c;

            if (max >= sum - max) {
                System.out.println("Invalid");
            } else if (a == b && b == c) {
                System.out.println("Equilateral");
            } else if (a == b || b == c || a == c) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }

        scanner.close();
    }
}
