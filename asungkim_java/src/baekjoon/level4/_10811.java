package baekjoon.level4;

import java.util.Scanner;

public class _10811 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr=new int[n+1]; // 0~n번 바구니
        for (int i = 1; i <= n; i++) {
            arr[i]=i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            while (a<b) {
                int tmp=arr[a];
                arr[a]=arr[b];
                arr[b]=tmp;

                a++;
                b--;
            }

            for (int j = 1; j <= n; j++) {
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i]+" ");
        }






    }


}
