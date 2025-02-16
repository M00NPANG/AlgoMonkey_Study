package 프로그래머스탐욕법.구명보트;

import java.util.Collections;
import java.util.PriorityQueue;

// 이거도 효율성 테스트 실패.. 우선순위 큐의 remove 메서드가 시간복잡도 O(N)를 가져서
// 최종적으로 이 코드의 시간복잡도가 O(N^2) 이 나와서 그런 것 같다..

class Solution2 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        // 우선순위 큐
        PriorityQueue<Integer> minPq = new PriorityQueue<>(); // 가장 가벼운 순
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder()); // 가장 무거운 순

        // 우선순위 큐에 값 채워넣기
        for (int weight : people) {
            minPq.offer(weight);
            maxPq.offer(weight);
        }

        // "무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어짐" 이라는 조건 때문에
        // 무조건 몸무게가 큰 순 부터 제거해서 그 수 만큼 answer++ 한다.
        while (!maxPq.isEmpty()) {
            int max = maxPq.poll(); // 최댓값 max 제거
            minPq.remove(max); // minPq 에서 최댓값 max 이 포함되어있으므로 제거
            answer++;

            if (!minPq.isEmpty() && max + minPq.peek() <= limit) {
                int min = minPq.poll(); // 최솟값 min 제거
                maxPq.remove(min); // maxPq 에서 최솟값 min 이 포함되어있으므로 제거
            }
        }
        return answer;
    }
}