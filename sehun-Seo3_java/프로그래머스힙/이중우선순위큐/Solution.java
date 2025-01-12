package 프로그래머스힙.이중우선순위큐;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> pqMin = new PriorityQueue<>(); // 최솟값을 얻기위한 최소 힙
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder()); // 최댓값을 얻기위한 최대 힙
        Map<Integer, Integer> mapCount = new HashMap<>(); // 값과 해당 값의 카운트를 저장

        // 값들을 하나씩 꺼내서 operation 수행
        for(String operation : operations){
            String[] operationArr = operation.split(" ");
            String command = operationArr[0]; // I 또는 D 입력
            int num = Integer.parseInt(operationArr[1]); // 숫자 입력 받기

            // operation 수행
            switch (command) {
                case "I":
                    pqMin.offer(num);
                    pqMax.offer(num);
                    mapCount.put(num, mapCount.getOrDefault(num, 0) + 1);
                    break;
                case "D":
                    switch (num) {
                        case 1:
                            removeValid(pqMax, mapCount);
                            break;
                        case -1:
                            removeValid(pqMin, mapCount);
                            break;
                    }
                    break;
            }
        }
        if (mapCount.isEmpty()) {
            answer = new int[] {0, 0};
        } else {
            removeZeroValid(pqMax, mapCount);
            removeZeroValid(pqMin, mapCount);
            answer = new int[] {pqMax.poll(), pqMin.poll()};
        }


        return answer;
    }

    // 이미 삭제된 값 제거한다. ex. <num,0> 이면 삭제.
    // 값이 삭제되었더라도 pq 에는 여전히 남아있을 수 있기 때문 - 큐와 맵 일관성을 유지
    private void removeZeroValid(PriorityQueue<Integer> pq, Map<Integer, Integer> mapCount) {
        while (!pq.isEmpty() && mapCount.getOrDefault(pq.peek(), 0) == 0) {
            pq.poll();
        }
    }

    // 삭제를 입력받으면 mapCount 에서 값 제거하기. - 삭제 수행
    private void removeValid(PriorityQueue<Integer> pq, Map<Integer, Integer> mapCount) {
        removeZeroValid(pq, mapCount);

        if (!pq.isEmpty()) {
            int num = pq.poll(); // pq 값 제거
            if (mapCount.get(num) == 1) {
                mapCount.remove(num); // 값이 1개 남았다면 제거
            } else {
                mapCount.put(num, mapCount.get(num) - 1); // 카운트 감소
            }
        }
    }
}