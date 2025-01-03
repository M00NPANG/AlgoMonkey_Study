package baekjoon.level8;

import java.util.Scanner;

public class _1193 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // 1 ...
        // 00 | 01 10 | 20 11 02 | 03 12 21 30 | ...


        int x=sc.nextInt();

        // 14 -> 14 - 1 - 2 - 3 - 4 -5
        //

        int cycle=1;
        while (true) {
            if (x<=cycle) break;
            x-=(cycle);
            cycle++;
        }
        // cycle=5 x=4
        // sum=cycle+1

        if (cycle%2==0) {
            int a=x;
            int b=cycle-x+1;
            System.out.println(a+"/"+b);
        }
        else {
            int a=cycle-x+1;
            int b=x;
            System.out.println(a+"/"+b);
        }

    }
}
