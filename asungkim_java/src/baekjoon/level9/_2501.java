package baekjoon.level9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _2501 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // p%q==0 -> q는 p의 약수

        String[] split = sc.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        // n의 약수들 중 k번째로 작은 수 출력

        List<Integer> list=new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            if (n%i==0) {
                list.add(i);
            }
        }

        // size=k , ok | size=k-1 , no
        if (list.size()<k) System.out.println(0);
        else System.out.println(list.get(k-1));
    }
}
