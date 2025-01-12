package baekjoon.level5;

import java.util.Arrays;
import java.util.Scanner;

public class _10809 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int[] check=new int['z'-'a'+1];
        Arrays.fill(check,-1);

        for (int i = 0; i < s.length(); i++) {
            int idx=s.charAt(i)-'a';
            if (check[idx]==-1) {
                check[idx]=i;
            }
        }

        for (int i = 0; i < check.length; i++) {
            System.out.print(check[i]+" ");
        }


    }
}
