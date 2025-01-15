상세 설명:
https://velog.io/@suunn001/%EB%8B%A4%EB%A6%AC%EB%A5%BC-%EC%A7%80%EB%82%98%EB%8A%94-%ED%8A%B8%EB%9F%AD-java

    import java.util.*;
    
    class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int time = 0;
        //경과 시간
        int currentWeight = 0;
        //현재 다리 위에 있는 트럭의 무게
        //새 트럭이 다리에 올라갈 수 있는지 판단하는 데 사용
        int truckIndex = 0;
        //현재 처리 중인 트럭의 인덱스
        //truck_weights 배열에서 어떤 트럭을 다음에 처리할지 결정
        
        Queue<Integer> bridge = new ArrayDeque<>();
        
        for (int i = 0; i <bridge_length; i++) {
            bridge.offer(0);
        }
        
        while (truckIndex < truck_weights.length) {
            time++;
            currentWeight = currentWeight - bridge.poll();
            if (currentWeight + truck_weights[truckIndex] <= weight) {
                bridge.offer(truck_weights[truckIndex]);
                currentWeight = currentWeight + truck_weights[truckIndex];
                truckIndex++;
            } else {
                bridge.offer(0);
            }
        }
        return time + bridge_length;
    }
}