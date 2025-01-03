package baekjoon.level8;

import java.util.Scanner;

public class _2720 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int change = sc.nextInt();
            int[] arr = makeArray(change);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }
    }

    private static int[] makeArray(int change) {
        int q=change/25;
        change%=25;
        int d=change/10;
        change%=10;
        int n=change/5;
        change%=5;
        int p=change;

        return new int[]{q,d,n,p};

    }
}
