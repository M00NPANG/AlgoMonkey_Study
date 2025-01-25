```java

import java.util.*; 

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        // width * height = total, width >= height
        // height * height <= total
        // 즉, 높이는 전체의 제곱근을 넘을 수 없음
        for (int height = 3; height <= (int)Math.sqrt(total);
           height++) {
            // 이렇게 나누어 떨어지면 직사각형(+정사각형 포함)이 만들어짐
            if (total % height == 0) {
                int width = total / height;
                // -2 : 테두리(갈색 타일)를 제외하기 위함
                if ((width - 2) * (height - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }
        return answer;
    }
}

```