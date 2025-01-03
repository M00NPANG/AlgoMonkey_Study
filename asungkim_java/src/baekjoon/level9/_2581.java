package baekjoon.level9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _2581 {
    public static void main(String[] args) {
        // m<=num<=n
        Scanner sc=new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        List<Integer> list=new ArrayList<>();
        for (int i = m; i <= n ; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }

        if (list.isEmpty()) System.out.println(-1);
        else {
            Collections.sort(list);
            int sum=list.stream().mapToInt(Integer::intValue).sum();
            int min=list.get(0);
            System.out.println(sum+"\n"+min);
        }





    }

    private static boolean isPrime(int n) {
        if (n<=1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i==0) return false;
        }

        return true;
    }
}
