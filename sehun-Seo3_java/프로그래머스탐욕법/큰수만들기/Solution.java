package 프로그래머스탐욕법.큰수만들기;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        int removeCount = 0; // 제거한 숫자의 개수

        Deque<Character> stack = new ArrayDeque<>(); // stack 을 이용한 방법

        for (char num : number.toCharArray()) {
            // 현재 스택의 마지막 숫자가 현재 숫자보다 작다면 제거. (앞의 작은 숫자들을 while 문을 이용해 최대한 제거한다.)
            while (!stack.isEmpty() && stack.peekLast() < num && removeCount != k) {
                stack.removeLast();
                removeCount++;
            }
            stack.offer(num); // 현재 숫자를 추가
        }

        // 54321 과 같은 예외 발생. 자릿수 맞춰야하므로 현재 스택의 수가 맞도록 제거
        while(stack.size()>(number.length()-k)){
            stack.removeLast();
        }

        // stream 을 이용한 출력
        answer = stack.stream()
                .map(String::valueOf) // Character -> String 변환
                .collect(Collectors.joining()); // 문자열 합치기

        return answer;
    }
}