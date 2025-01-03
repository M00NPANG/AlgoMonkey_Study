package baekjoon.level4;

import java.util.Scanner;

public class _1546 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // 점수/MAX * 100
        int n=sc.nextInt();
        int[] scores=new int[n];
        int max=Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            scores[i]=sc.nextInt();
            max=Math.max(max,scores[i]);
        }

        double[] newScores=new double[n];
        double total=0;
        for (int i = 0; i < n; i++) {
            newScores[i]=(double)scores[i]/max*100;
            total+=newScores[i];
        }

        System.out.println(total/n);

    }
}
