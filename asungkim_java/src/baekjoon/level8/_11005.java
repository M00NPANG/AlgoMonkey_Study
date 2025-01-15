package baekjoon.level8;

import java.util.HashMap;
import java.util.Scanner;

public class _11005 {
    private static HashMap<Integer,Character> map;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        map=new HashMap<>();
        char c='A';
        for (int i = 10; i <= 35 ; i++,c++) {
            map.put(i,c);
        }

        String[] split = sc.nextLine().split(" ");
        long n = Long.parseLong(split[0]);
        int b = Integer.parseInt(split[1]);

        System.out.println(convertToB(n,b));
    }

    private static String convertToB(long n,int b) {
        StringBuilder sb=new StringBuilder();

        while (n>0) {
            long re=n%b;
            if (re>=0&&re<=9) {
                sb.insert(0,re);
            }
            else {
                sb.insert(0,map.get((int)re));
            }

            n/=b;
        }

        return sb.toString();

    }


}
