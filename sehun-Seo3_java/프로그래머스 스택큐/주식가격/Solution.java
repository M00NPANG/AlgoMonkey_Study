package 프로그래머스스택큐.주식가격;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};

        // FIFO 이용한 Deque
        Deque<Integer> deque = new ArrayDeque<>();

        // answer 에 저장할 result Deque
        Deque<Integer> result = new ArrayDeque<>();

        // deque 에 prices 채우기
        for (int cost : prices) {
            deque.offer(cost);
        }

        // deque 이 다 빌때까지 반복
        while (!deque.isEmpty()) {
            int p = deque.poll(); // 첫번째 걸 기준으로, 오른쪽 비교 시작
            int second = 0;  // 시간

            for (int cost : deque) { // deque에 있는 가격 비교
                second++;            // 일단 떨어지던, 말던 무조건 시간은 지나감.
                if (p > cost) {      // 주식이 떨어졌다면 그만. || 아니라면 deque 다 돌때까지 진행
                    break;
                }
            }
            result.offer(second);    // 시간을 result에 저장.
        }

        // result Deque -> answer 배열
        answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            if (!result.isEmpty()) {
                answer[i] = result.poll();
            }
        }

        return answer;
    }
}