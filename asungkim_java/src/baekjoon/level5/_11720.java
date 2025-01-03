package baekjoon.level5;

import java.util.Scanner;

public class _11720 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();

        int total=0;
        for (int i = 0; i < s.length(); i++) {
            total+=Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        System.out.println(total);
    }
}
