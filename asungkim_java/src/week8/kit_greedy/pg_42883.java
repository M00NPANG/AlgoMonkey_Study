package week8.kit_greedy;

import java.util.Stack;

public class pg_42883 {
    /***
     * 문제에서 중요한 부분은 스택에서 가장 깊은 부분의 값이 한정된 조건 안에서 최댓값을 가져야 한다는 부분이다.
     * -> 현재까지 선택한 숫자들이 남은 자리 수에서 최대값이 되도록 유지하는 것
     * pop하는 조건
     * 1. 비어있지 않고
     * 2. 스택 맨 윗 값이 현재 i번째 값보다 작거나
     * 3. k값이 0보다 작을 때
     */
    public String solution(String number, int k) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (true) {
                if (st.isEmpty()) break;
                if (st.peek() >= c) break;
                if (k <= 0) break;

                st.pop();
                k--;
            }
            st.push(c);
        }

        // 뒤에 남은 숫자를 제거시켜준다
        while (true) {
            if (k <= 0) break;
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }


        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
