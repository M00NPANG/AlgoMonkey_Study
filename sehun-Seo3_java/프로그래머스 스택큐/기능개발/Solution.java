package 스택큐.기능개발;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        // Deque : 양방향 (스택+큐) - LIFO(Stack) + FIFO(Queue)
        Deque<Integer> deque = new ArrayDeque<>(); // deque : 작업 완료까지 걸리는 일 수 (FIFO 이용)
        Deque<Integer> result = new ArrayDeque<>(); // result : 배포 횟수

        // deque 채우기 (작업 완료까지 걸리는 일 수)
        for (int i = 0; i < progresses.length; i++) {
            deque.offer((int) Math.ceil((double) (100 - progresses[i]) / speeds[i])); // 개발 시간 대입 ( 소수점이 있다면 올림하여, 정수로 만들기 위함이다. ex 1.1일이 걸린다. -> 2일)
        }

        while (!deque.isEmpty()) { // deque 가 빌때까지 반복!
            int current = deque.poll(); // (FIFO) 하나를 뽑았을 때,
            int count = 1; // 최소한 작업 1개는 완료.

            while (!deque.isEmpty() && current >= deque.peek()) { // deque가 비지 않고, 뽑은 current가 그 뒤에 있는 작업 일수보다 작다면
                deque.poll(); // current >= (작업일수) 인 작업일수를 다 삭제.
                count++;     // 그 만큼 작업 개수 증가.
            }
            result.offer(count); // result에 넣기.
        }

        // result -> 배열 변환
        answer = new int[result.size()]; // result 크기만큼 배열 생성
        int index = 0;
        for (int num : result) { // result 값을 순서대로 가져옴
            answer[index++] = num; // 값을 대입하고, 인덱스 증가.
        }

        return answer;
    }
}