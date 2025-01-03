package baekjoon.level4;

import java.util.Arrays;
import java.util.Scanner;

public class _5597 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        boolean[] list=new boolean[30];
        for (int i = 0; i < 28; i++) {
            int num=sc.nextInt();
            list[num-1]=true;
        }

        int[] an=new int[2];
        int k=0;
        for (int i = 0; i < 28; i++) {
            if (!list[i]) {
                an[k++]=i+1;
            }
        }

        Arrays.sort(an);
        for (int i = 0; i < 2; i++) {
            System.out.println(an[i]);
        }



    }
}
