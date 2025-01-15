    import java.util.*;
    
    
    class Solution {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        //최소값에 빠르게 접근하기 위한 우선순위 큐
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        //최대값을 빠르게 접근하기 위한 우선순위 큐 (오름차순이 디폴트라서 역순 정렬)
        
        
            for (String operation : operations) {
            String[] split = operation.split(" ");
            String string = split[0];
            int value = Integer.parseInt(split[1]);
            ////명령어(string)와 값(value)으로 분리 String string = I, int value = 16 이런 식으로
                    
            if (string.equals("I")) {
                minQueue.offer(value);
                maxQueue.offer(value);
                //I면 값을 일단 양쪽 큐에 모두 삽입
            } else if (!minQueue.isEmpty()) {
                //큐가 비어있지 않은 경우에만 삭제를 수행
                if (value == 1) {
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                } else {
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                }
                 //value가 1이면 최대값 삭제, -1이면 최소값 삭제
                 //한 큐에서 값을 제거한 후, 다른 큐에서도 같은 값을 제거하여 동기화
                 //동기화되었으니 null 체크는 큐 한 쪽에서만 진행해도 됨 = 효율성 증가
            }
        }
                if (minQueue.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxQueue.peek(), minQueue.peek()};
        }
    }
}