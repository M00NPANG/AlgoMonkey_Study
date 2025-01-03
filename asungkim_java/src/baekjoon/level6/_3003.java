package baekjoon.level6;

import java.util.Scanner;

public class _3003 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        String[] chess = sc.nextLine().split(" ");
        int[] cur=new int[chess.length];

        for (int i = 0; i < cur.length; i++) {
            cur[i]=Integer.parseInt(chess[i]);
        }

        int[] an=new int[]{1,1,2,2,2,8};

        for (int i = 0; i < 6; i++) {
            System.out.print(an[i]-cur[i]+" ");
        }
    }
}
