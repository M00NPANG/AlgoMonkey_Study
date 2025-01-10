package 프로그래머스스택큐.다리를지나는트럭;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        // 다리를 건너는 트럭 관리 deque
        Deque<Integer> deque = new ArrayDeque<>();

        int time = 0; // 시간
        int currentWeight = 0; // 다리 위 무게

        // deque 채우기 (무게 0으로 일단 다 채우기)
        for (int i = 0; i < bridge_length; i++) { // 다리에는 트럭이 최대 bridge_length 대 올라갈 수 있다.
            deque.offer(0);
        }

        // 일단 truck_weights에 있는 트럭 하나씩 다리를 건넘 - 0으로 다 채워져 있는 deque 여서, 턴 개념으로 생각하면 쉽다.
        for (int truck : truck_weights) {
            while(!deque.isEmpty()) { // 사실 deque는 항상 값이 존재하므로 (적어도, 0으로 존재) 항상 true이다.
                time++; // 1턴 지날때 마다 time++
                currentWeight -= deque.poll();  // 1턴 지날때 마다 맨 앞에 있는 트럭이 빠짐
                if (currentWeight + truck <= weight) { // 현재 다리 위 무게와 트럭의 무게 합이 weight 보다 작다면 실행
                    deque.offer(truck); // 트럭을 다리 위에 넣어 둠
                    currentWeight += truck;
                    break; // 트럭 하나를 보냈으므로 break
                } else {
                    deque.offer(0); // 기준에 충족하지 못했다면 0을 보내서, 한턴을 쉬게 된다.
                }
            }
        }

        answer = time + bridge_length; // 마지막 트럭이 출발했다면, bridge_length만큼 시간을 소비한다.

        return answer;
    }
}