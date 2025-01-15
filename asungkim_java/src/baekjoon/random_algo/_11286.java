package baekjoon.random_algo;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 절댓값 힙

        // 절댓값 같으면 원래순서대로 정렬, 아닐때는 절댓값 기준으로 정렬
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            int absA=Math.abs(a);
            int absB=Math.abs(b);

            if (absA==absB) {
                return a-b;
            }
            return absA-absB;
        });

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if (x==0) {
                // 배열에서 절댓값 가장 작은 값 출력하고 그 값 배열에서 제거
                if (pq.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(pq.poll());
            }
            else {
                // 배열에 x값 추가
                pq.add(x);
            }
        }
    }

}
