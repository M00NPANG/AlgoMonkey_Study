Arrays.copyOfRange 배열이 있는지 까먹음;;;

```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            //i번째 찾기 (인덱스는 0부터 저장되니까 1을 빼 줌)
            int start = commands[i][0] - 1;
            //Arrays.copyOfRange를 할 때 마지막은 포함되지 않기 때문에 여기선 1을 빼지 않음
            int end = commands[i][1];
            //Arrays.copyOfRange(복사할 배열, 시작(포함), 끝(미포함))
            int[] copy = Arrays.copyOfRange(array, start, end);
            //배열 정렬
            Arrays.sort(copy);
            //꺼내야 할 수 구하기
            int k = commands[i][2] - 1;
            //새로운 배열에 값을 넣기
            answer[i] = copy[k];
        }
        
        return answer;
    }
}
```