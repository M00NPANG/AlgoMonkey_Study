package baekjoon.level4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _3052 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int[] arr=new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i]=sc.nextInt();
        }

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(arr[i]%42);
        }

        System.out.println(set.size());

    }
}
