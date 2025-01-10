package 프로그래머스스택큐.프로세스;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // FIFO 이용한 Deque
        Deque<int[]> deque = new ArrayDeque<>();

        // 프로세스 실행 순서대로 들어가게 되는 list
        List<int[]> list = new ArrayList<>();

        // 실행 대기 deque
        for (int i = 0; i < priorities.length; i++) {
            deque.offer(new int[]{priorities[i], i}); // 짝 지어줌 { (우선순위) , (위치 인덱스) }
        }

        // deque 에 실행 대기중인 프로세스가 다 종료할 때 까지 반복
        while (!deque.isEmpty()) {
            int[] process = deque.poll();
            boolean isMax = true; // true 라면 꺼낸값 중 가장 큰 값 | false 라면 가장 큰 값은 아님.

            for (int[] waiting : deque) {
                if (process[0] < waiting[0]) { // [0] ==> 즉 우선순위를 비교해봄
                    isMax = false;
                    deque.offer(process); // 다시 deque 에 넣기
                    break;
                }
            }
            if(isMax){
                list.add(process); // 최댓값이라면, list에 최대값 순으로 순서대로 들어감.
            }
        }

        for (int[] process : list) {
            if (process[1] == location) { // 그 중 [1] ==> 즉 위치 인덱스가 location과 같다면
                answer = list.indexOf(process) + 1;  // indexOf를 이용해서 해당 인덱스 위치를 얻음, +1 하는 이유는 0번째 인덱스가 1번째로 실행되기 때문.
            }
        }

        return answer;
    }
}