package baekjoon.level5;

import java.util.Scanner;

public class _2675 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        for (int i = 0; i < t; i++) {
            int r=sc.nextInt();
            String s=sc.next().trim();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                String tmp=String.valueOf(c);
                System.out.print(tmp.repeat(r));
            }
            System.out.println();
        }
    }
}
