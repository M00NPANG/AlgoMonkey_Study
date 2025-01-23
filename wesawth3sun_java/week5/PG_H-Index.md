괜히 복잡하고 어렵게 생각했다 생각보다 쉬운 문젠데...!!!

```java
import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        //배열 오름차순 정렬
        Arrays.sort(citations);
        int hIndex = 0;
        
        for (int i = 0; i < citations.length; i++) {
            //현재의 논문보다 인용 횟수가 많거나 같은 논문의 수 h
            int h = citations.length - i;
            //만약 인용 횟수 >= 논문 수를 만족한다면 제일 먼저 만족하는 값을 집어넣고 루프를 빠져나옴
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }
        
        return hIndex;
    }
}

```