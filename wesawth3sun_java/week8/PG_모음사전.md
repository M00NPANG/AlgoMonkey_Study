핵심은 각 자리에서 선택한 글자보다 앞선 글자로 시작하는 모든 단어의 수를 누적하는 것
모든 A(1) ... AUUUU(781) 까지 다 끝나고 난 후에야 5의 4제곱 = 781, E (782번째)가 시작한다

```java
class Solution {
    public int solution(String word) {
        // 가중치 구하기 (핵심 포인트)
        int[] weight = {781, 156, 31, 6, 1};
        char[] chars = {'A', 'E', 'I', 'O', 'U'};
        int answer = word.length();
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = 0;
            for (int j = 0; j < 5; j++) {
                if (chars[j] == c) {
                    index = j;
                    break;
                }
            }
            answer += weight[i] * index;
        }
        return answer;
    }
}
```