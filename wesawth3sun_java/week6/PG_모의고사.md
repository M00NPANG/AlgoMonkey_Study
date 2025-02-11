말도 안 되는 노가다로 풀었는데 왜 이게 풀리지 했었다
근데 결론적으론 말도 안 되는 노가다가 맞았음 
리팩토링 오래 걸렸다 (...) 
패턴 이용 -> % 연산 기억할 것

```java
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        //패턴이 반복되는 구조
        int[] student1 = {1, 2, 3, 4, 5}; //길이: 5
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5}; //길이: 8
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //길이: 10
        //각 학생들이 몇 개나 맞췄는지 저장해 둘 int 배열
        int[] score = new int[3];
        
        //패턴 배열을 순환적으로 사용하기 (주어진 패턴보다 정답의 length가 더 길 수 있으니까)
        for (int i = 0; i < answers.length; i++) {
            //i 값이 계속 증가하더라도 pattern1 배열의 인덱스는 0에서 4 사이를 순환하게 됨
            if (answers[i] == student1[i % student1.length]) {
                score[0]++;
            }
            if (answers[i] == student2[i % student2.length]) {
                score[1]++;
            }
            if (answers[i] == student3[i % student3.length]) {
                score[2]++;
            }
        }
        
        //Math.max() 함수를 사용하여 세 수포자의 점수 중 가장 높은 점수를 찾음
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                //각 수포자의 점수를 최고 점수와 비교하여, 일치하는 경우 해당 수포자의 번호(i + 1)를 리스트에 추가
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
```