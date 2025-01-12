package 프로그래머스힙.더맵게;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 우선순위 큐 pq
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // pq 에 scoville 채워 넣기 => 자동으로 최솟값이 우선으로 나옴.
        for(int scale : scoville){
            pq.offer(scale);
        }

        // pq 안에 데이터가 2개 이상 && 최솟값이 K보다 작다면 ==> 실행
        while(pq.size() > 1 && pq.peek() < K){
            int firstScale = pq.poll(); // 가장 맵지 않은 음식의 스코빌 지수
            int secondScale = pq.poll(); // 두 번째로 맵지 않은 음식의 스코빌 지수
            pq.offer(firstScale + 2 * secondScale); // 섞는다.

            answer++; // 섞어야 하는 횟수 증가
        }

        // 만약 while 루프가 끝나도 최솟값이 K보다 작다면 answer = -1이다.
        answer = pq.peek()>=K ? answer : -1;

        return answer;
    }
}
