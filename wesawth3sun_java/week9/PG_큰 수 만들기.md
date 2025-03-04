```java
/**
 * 그리디 알고리즘을 풀어내는 방식(보통 for문을 자주 사용하니까)으로만 생각하고 풀었는데
 * 다 풀고 나서 보니까 test 10번에서 생각보다 오래 걸리길래... 
 * 다른 방법 없나 -> 스택으로도 풀 수 있을 것 같은데? 
 * 
 * 그래서 두 번째는 스택으로 풀어본 방식인데, 이게 시간 복잡도 효율도 좋고 생각보다 직관적이라서 괜찮았다!
 */
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int size = number.length() - k; // 최종 숫자 길이
        int start = 0;

        // 완성할 숫자 길이만큼만 반복
        for (int i = 0; i < size; i++) {
            // 현재의 최곳값
            char max = '0';
            // 현재 위치에서 선택 가능한 범위 내에서 최대값 탐색
             // j <= k + i(length)-> k에서 i를 더하면 초기의 원래 숫자 길이가 최대가 됨 (끝까지 돌 수 있다)
            for (int j = start; j <= k + i; j++) {
                if (number.charAt(j) > max) {
                    max = number.charAt(j);
                    start = j + 1; // 다음 탐색 시작 위치 갱신, start는 이전에 선택된 숫자의 다음 인덱스부터 시작 (이미 들어간 값은 다시 들어갈 수 없게 하기 위해서)
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int remove = k;

        // 스택에 저장한 후, 이전에 선택된 숫자보다 큰 숫자가 등장하면 제거
        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < c && remove > 0) {
                stack.pop();
                remove--;
            }
            stack.push(c);
        }
        /**
         * 모든 숫자가 내림차순으로 이미 정렬된 형태의 숫자(예: "7654321")처럼, 스택에서 숫자를 제거할 조건이 충족되지 않는 경우에 발생
         * 만약 반복문이 끝난 후에도 remove > 0이라면, 아직 제거해야 할 숫자가 남아 있다는 뜻
         * 스택의 마지막(가장 작은 값)부터 남은 횟수만큼 제거해야 최종적으로 가장 큰 수를 만들 수 있음
         * while (remove-- > 0) 루프를 통해 스택의 마지막 요소를 계속 pop()하여 남은 제거 횟수를 소진
         * (사실 이런 경우가 테스트 케이스에 있나 싶긴 하지만... 그리디니까... 추가된 안전장치)
         */
        while (remove-- > 0) {
            stack.pop();
        }
        // 결과 생성
        StringBuilder answer = new StringBuilder();
        for (char c : stack) {
            answer.append(c);
        }
        return answer.toString();
    }
}
```