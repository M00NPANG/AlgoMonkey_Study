package baekjoon.level7;

import java.util.Scanner;

public class _2738 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][][] matrix=new int[n][m][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    matrix[j][k][i]=sc.nextInt();
                }
            }
        }

        int[][] an=new int[n][m];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                an[j][k]=matrix[j][k][0]+matrix[j][k][1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(an[i][j]+" ");
            }
            System.out.println();
        }


    }
}
