package baekjoon.random_algo;

import java.util.*;

public class _1655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());


        // 2개째까지는 minQ.poll

        // minQ 1 5
        // maxQ 5 1


        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            //
        }
    }
}