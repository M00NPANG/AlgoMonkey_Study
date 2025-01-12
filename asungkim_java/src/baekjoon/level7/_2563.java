package baekjoon.level7;

import java.util.Scanner;

public class _2563 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        boolean[][] visited=new boolean[101][101];
        for (int i = 0; i < n; i++) {
            int x=sc.nextInt();
            int y=sc.nextInt();

            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10 ; k++) {
                    visited[j][k]=true;
                }
            }
        }

        int an=0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (visited[i][j]) {
                    an++;
                }
            }
        }


        System.out.println(an);
    }
}
