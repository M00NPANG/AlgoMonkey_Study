package baekjoon.level5;

import java.util.Scanner;

public class _5622 {
    public static void main(String[] args) {

        // num 1 2 ... 9  0
        // sec 2 3 ... 10 11
        String[] all={"ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};

        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine().trim();


        int total=0;
        for (int i = 0; i < s.length(); i++) {
            char alp = s.charAt(i);

            for (int j = 0; j < all.length; j++) {
                if (all[j].indexOf(alp)!=-1) {
                    total+=(j+3);
                    break;
                }
            }
        }

        System.out.println(total);
    }
}
