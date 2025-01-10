package 스택큐.같은숫자는싫어;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        // Deque : 양방향 (스택+큐) - LIFO(Stack) + FIFO(Queue)
        Deque<Integer> deque = new ArrayDeque<>();

        // deque 에 arr 값 채우기.
        for (int num : arr) {
            if(deque.isEmpty() || deque.peekLast() != num) { // deque 값이 비어있거나 전에 값이랑 중복되지 않는다면,
                deque.offer(num); // [deque] <- num (offer : 오른쪽에서 값 넣기)
            }
        }

        // deque -> 배열 변환
        answer = new int[deque.size()]; // deque 크기만큼 배열 생성
        int index = 0;
        for (int num : deque) { // deque 값을 순서대로 가져옴
            answer[index++] = num; // 값을 대입하고, 인덱스 증가.
        }


        // Stream 을 이용한 deque -> 배열 변환
//        answer = deque.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}