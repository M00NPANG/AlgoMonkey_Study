package baekjoon.level8;

import java.util.Scanner;

public class _2745 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String[] nb = sc.nextLine().split(" ");

        String n=nb[0];
        int b=Integer.parseInt(nb[1]);
        System.out.println(convertToTen(n,b));

    }

    /***
     * b 진법으로 표현된 s를 받아서 10진법으로 변환한다
     * 일의자리부터 for문을 돌리고 0~9일때와 알파벳일때를 나누어 계산한다
     */
    private static long convertToTen(String s,int b) {
        long an=0;
        int num=1;
        for (int i = s.length()-1; i >= 0; i--, num*=b) {
            char data=s.charAt(i);
            int value;
            if (data>='0'&&data<='9') {
                value=data-'0';
            }
            else value=data-'A'+10;

            an+=(long) value * num;

        }

        return an;
    }
}
