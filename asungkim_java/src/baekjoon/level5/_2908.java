package baekjoon.level5;

import java.util.Scanner;

public class _2908 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] split = sc.nextLine().trim().split(" ");

        String a = new StringBuilder(split[0]).reverse().toString();
        String b = new StringBuilder(split[1]).reverse().toString();

        int reva=Integer.parseInt(a);
        int revb=Integer.parseInt(b);

        System.out.println(Math.max(reva,revb));
    }
}
