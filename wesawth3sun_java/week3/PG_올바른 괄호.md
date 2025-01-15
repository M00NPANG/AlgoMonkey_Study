상세 설명:
https://velog.io/@suunn001/%EC%98%AC%EB%B0%94%EB%A5%B8-%EA%B4%84%ED%98%B8java


    import java.util.*;

    class Solution {
    boolean solution(String s) {
    boolean answer = true;
    Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}