package baekjoon.level9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _9506 {
    public static void main(String[] args) {
        // n을 제외한 n의 약수들의 합 = n  -> 완전수

        Scanner sc=new Scanner(System.in);
        while (true) {
            int n=sc.nextInt();
            if (n==-1) {
                break;
            }

            int[] list=makeList(n);
            if (isCompleteNum(list,n)) {
                printCompleteNum(list,n);
            }
            else System.out.println(n+" is NOT perfect.");
        }
    }

    private static void printCompleteNum(int[] list,int n) {
        StringBuilder sb=new StringBuilder();
        sb.append(n);
        sb.append(" = ");

        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);
            if (i!= list.length-1) {
                sb.append(" + ");
            }
        }

        System.out.println(sb.toString());

    }

    private static boolean isCompleteNum(int[] list,int n) {
        int an=0;
        for (int i = 0; i < list.length; i++) {
            an+=list[i];
        }

        return n==an;
    }

    private static int[] makeList(int n) {
        List<Integer> list=new ArrayList<>();

        for (int i = 1; i < Math.sqrt(n) ; i++) {
            if (n%i==0) list.add(i);
        }

        list.sort(Integer::compare);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
