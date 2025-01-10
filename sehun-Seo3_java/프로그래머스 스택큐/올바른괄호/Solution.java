package 프로그래머스스택큐.올바른괄호;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // FIFO 이용한 Deque
        Deque<Character> deque = new ArrayDeque<>();

        // toCharArray를 이용해서, String 문자열을 char형 배열로 바꿔주고, 하나씩 검사
        for(char x : s.toCharArray()){
            if(x == '('){ // ( 를 만난다면, deque에 넣기
                deque.offer(x);
            } else if(x == ')'){ // ) 를 만난다면, 두 가지 경우 뿐 -> 1. deque에 ( 이미 존재O, 2. deque에 ( 존재X
                if(!deque.isEmpty() && deque.peek()=='('){  // 1. deque에 ( 이미 존재한다면,
                    deque.poll();                           // 한 쌍을 같이 제거, ex. ())() => )()
                } else {         // 2. deque에 ( 존재X
                    return false; // ex. )()( => false.
                }
            }
        }

        if(!deque.isEmpty()){ // 1. deque에 ( 이미 존재O. 와 같이 하나씩 한 쌍을 제거 한다면 true
            return false;     // 다 제거하지 못하고 남아있다면 false. ex. ()) => )
        }

        return answer;
    }
}