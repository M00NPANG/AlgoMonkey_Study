```java
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        /**
         * List: N을 k번 사용했을 때의 결과 집합 저장 예. dp.get(4) → 5를 4번 사용한 모든 숫자
         * Set: 사칙 연산 값을 저장 (동일 숫자 중복 저장 방지를 위해 set 구조 사용)
         */
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        for (int k = 1; k <= 8; k++) {
            Set<Integer> current = dp.get(k);

            /**
             * k번 연속된 N을 만드는 과정 (예: 5, 55, 555 ...)
             * i = 0, 0 * 10 + 5 = 5 / i = 1, 5 * 10 + 5 = 55 / i = 2, 55 * 10 + 5 = 555 ...
             */
            int concatNum = 0;
            for (int i = 0; i < k; i++) {
                concatNum = concatNum * 10 + N;
            }
            current.add(concatNum);
            
            /**
             * k 를 i 와 k - i 로 분할해서 숫자 조합 생성
             * 예시 N: 5, number: 12
             * k = 1, (5를 1번 사용) -> 숫자가 한 개라서 연산이 불가능함
             * 결과 dp = {5}
             * 
             * k = 2, (55), 사칙 연산 조합 생성 5 + 5, 5 - 5, 5 * 5, 5 / 5 
             * 결과 dp = {0, 1, 55, 25, 10}
             * 
             * k = 3, (555), k = 2 + k = 1의 경우의 수와 k = 1 + k = 2 의 경우의 수를 조합
             * 
             * k = 4, (5555), k = 2 + k = 2 의 조합
             * (55 + 5) / 5 → 60 / 5 = 12
             */
            for (int i = 1; i < k; i++) {
                int j = k - i;
                for (int a : dp.get(i)) {
                    for (int b : dp.get(j)) {
                        current.add(a + b);
                        current.add(a * b);
                        current.add(a - b);
                        current.add(b - a);
                        if (b != 0) current.add(a / b);
                        if (a != 0) current.add(b / a);
                    }
                }
            }
            
            if (current.contains(number)) {
                return k;
            }
        }
        return -1;
    }
}
```