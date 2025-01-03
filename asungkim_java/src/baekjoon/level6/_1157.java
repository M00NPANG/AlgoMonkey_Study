package baekjoon.level6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _1157 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int max=-1;
        char answer='?';
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            int cnt=entry.getValue();
            char alp= entry.getKey();

            if (cnt>max) {
                max=cnt;
                answer= alp;
            }
            else if (cnt==max) {
                answer='?';
            }
        }

        System.out.println(answer);

    }
}