package Week3;

import java.util.LinkedList;
import java.util.Queue;

public class PG_42583 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;

        Queue<Integer> waitingQueue = new LinkedList<>();
        Queue<Integer> inQueue = new LinkedList<>();

        for (int truckWeight : truck_weights) {
            waitingQueue.add(truckWeight);
        }

        while (!waitingQueue.isEmpty() || !inQueue.isEmpty()) {
            answer++;

            // 다리의 길이와 동일한 큐의 크기일 때 가장 앞의 트럭을 제거
            if (inQueue.size() == bridge_length) {
                totalWeight -= inQueue.poll();
            }

            if (!waitingQueue.isEmpty()) {
                int nextTruck = waitingQueue.peek();
                // 다음 트럭이 다리에 올라갈 수 있는지 확인
                if (totalWeight + nextTruck <= weight) {
                    inQueue.add(waitingQueue.poll());
                    totalWeight += nextTruck;
                } else {
                    inQueue.add(0); // 다리의 길이를 유지하기 위해 0 추가
                }
            } else {
                if (totalWeight == 0) break; // 모든 트럭이 다리를 통과했는지 확인
                inQueue.add(0); // 다리의 길이를 유지하기 위해 0 추가
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        
        PG_42583 pg42583 = new PG_42583();
        int solution = pg42583.solution(100, 100, new int[]{10});
        System.out.println("solution = " + solution);

    }
}
