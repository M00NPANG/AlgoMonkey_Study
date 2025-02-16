package 프로그래머스탐욕법.구명보트;

import java.util.Collections;
import java.util.PriorityQueue;

// 효율성 테스트 통과..
// 어찌어찌 문제를 풀긴했는데, 너무 억지로 푼 느낌이라서 애초에 방향성을 잘못잡은 듯 하다..
// 다른 팀원분들 코드를 보고 배우겠습니다 ㅜㅜ

class Solution3 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        int count = people.length;

        // 우선순위 큐
        PriorityQueue<Integer> minPq = new PriorityQueue<>(); // 가장 가벼운 순
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder()); // 가장 무거운 순

        // 우선순위 큐에 값 채워넣기
        for (int weight : people) {
            minPq.offer(weight);
            maxPq.offer(weight);
        }

        // 만약 가장 작은 무게의 2배를 하더라도 limit 보다 크다면, 애초에 짝을 지을 수 없으므로 people 개수만큼 리턴
        if (minPq.size() >= 2 && 2 * minPq.peek() > limit) return people.length; // -> 효율성 개선코드

        // "무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어짐" 이라는 조건 때문에
        // 무조건 몸무게가 큰 순 부터 제거해서 그 수 만큼 answer++ 한다.
        // count = people.length 라는걸 도입해서, 하나씩 제거할 때 마다 count 를 줄여서, minPq와 maxPq가 중복없이 제거되도록 구현
        // -> remove(Object) 를 제거해서 시간 복잡도를 낮춤
        while (!maxPq.isEmpty() && count > 0) {
            int max = maxPq.poll(); // 최댓값 max 제거
            count--;
            answer++;

            if (count == 0) break; // -> 효율성 개선코드

            if (!minPq.isEmpty() && max + minPq.peek() <= limit) {
                minPq.poll(); // 최솟값 제거
                count--;
            }
        }
        return answer;
    }
}