나는 아직도 재귀함수가 어렵다... 백트래킹...

```java

import java.util.*;

public class Solution {
    public int solution(String numbers) {
        //중복 제거 용도
        Set<Integer> primes = new HashSet<>();
        
        // 모든 가능한 숫자 조합 생성
        for (int i = 0; i < numbers.length(); i++) {
            makeAllNumbers("", numbers, i + 1, primes);
        }
        
        // 소수 개수 세기
        int count = 0;
        for (int num : primes) {
            if (isPrime(num)) {
                count++;
            }
        }
        
        return count;
    }
    
    // 순열 생성 (재귀 방법 이용)
    private void makeAllNumbers(String fix, String yet, int n, Set<Integer> set) {
        if (fix.length() == n) {
            set.add(Integer.parseInt(fix));
            return;
        }
        
        for (int i = 0; i < yet.length(); i++) {
            makeAllNumbers(fix + yet.charAt(i), yet.substring(0, i) + yet.substring(i + 1), n, set);
        }
    }
    
    // 소수 판별
    // Math.sqrt(n) = 제곱근을 구해 주는 함수 (효율성 높일 수 있다)
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
```