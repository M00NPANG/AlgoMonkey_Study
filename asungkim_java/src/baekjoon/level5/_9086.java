package baekjoon.level5;

import java.util.Scanner;

public class _9086 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s=sc.next();
            System.out.println(s.substring(0,1)+s.substring(s.length()-1));
        }
    }
}
