package baekjoon.level9;

import java.util.Scanner;

public class _5086 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (true) {
            String[] nums = sc.nextLine().split(" ");
            int a=Integer.parseInt(nums[0]);
            int b=Integer.parseInt(nums[1]);

            if (a==0&&b==0) {
                break;
            }

            // a 가 b 의 약수이면 factor, 배수라면 mulptiple 둘다 아니면 neither
            System.out.println(isWhat(a,b));
        }
    }

    private static String isWhat(int a,int b) {
        String an="";
        // a가 b의 약수
        if (b%a==0) {
            an="factor";
        }
        // a가 b의 배수
        else if (a%b==0) {
            an="multiple";
        }
        else an="neither";

        return an;
    }
}
