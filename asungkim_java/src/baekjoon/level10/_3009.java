package baekjoon.level10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer,Integer> xMap=new HashMap<>();
        Map<Integer,Integer> yMap=new HashMap<>();

        for (int i = 0; i < 3; i++) {
            int x= sc.nextInt();
            xMap.put(x,xMap.getOrDefault(x,0)+1);
            int y= sc.nextInt();
            yMap.put(y,yMap.getOrDefault(y,0)+1);
        }

        for (int key : xMap.keySet()) {
            if (xMap.get(key)==1) {
                System.out.print(key);
            }
        }
        System.out.print(" ");
        for (int key : yMap.keySet()) {
            if (yMap.get(key)==1) {
                System.out.print(key);
            }
        }

    }
}
