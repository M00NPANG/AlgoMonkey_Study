package baekjoon.level5;

import java.util.Scanner;

public class _1152 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine().trim();
        if (s.length()==0) System.out.println(0);
        else {
            String[] split = s.split(" ");
            System.out.println(split.length);
        }


    }
}
