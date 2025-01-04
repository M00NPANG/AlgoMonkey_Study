### 프로그래머스_Hash_폰켓몬

#### 결론 : 어렵게 생각하면 어렵구 쉽게 생각하면 쉬움

1. 최대값 구하기 : 배열 길이 / 2
2. HashSet 사용해서 배열에 중복 제거
3. HashSet 크기와 max 값 비교
   1. HashSet의 크기가 max보다 크면 max값
   2. HashSet의 크기가 max보다 작으면 HashSet의 크기

``` java
java.util.HashSet;

class Solution {
public int solution(int[] nums) {
int result = 0;
int max = nums.length / 2;

        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);

            if (max >= set.size()) {
                result = set.size();
            } else {
                result = max;
            }
        }
        return result;
    }
}
```