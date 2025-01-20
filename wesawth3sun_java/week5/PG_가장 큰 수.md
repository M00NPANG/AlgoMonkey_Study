두 개의 숫자를 더해서 정렬해야 한다는 거? 상상치도 못함...
그리고 모든 숫자가 0이면 000이 반환될 수 있다는 거? 상상치도 못함...
피곤할 때는 문제 풀면 안 된다 ^ ^ 
엄청 까다롭거나 어려운 문제 아니었던 것 같은데 창의력 이슈 심각했음

```java

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        
        //문자 배열 만들기
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        //각 자리의 문자열 숫자를 두 개 -> 문자열 더하기 후 (10 + 1 = 101) 내림차순 정렬
        Arrays.sort(strNumbers, (o1, o2)
                -> (o2 + o1).compareTo(o1 + o2));
        
        StringBuilder sb = new StringBuilder();
        
        for (String strNumber : strNumbers) {
            sb.append(strNumber);
        }
        //맨 앞이 0인 경우를 확인 -> 정렬 후에도 맨 앞이 0이면 모든 숫자가 다 0인 것
        //이 예외를 체크하지 않으면 000, 0000과 같이 반환이 된다...
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
 ```