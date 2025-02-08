```java
import java.util.*;
import java.util.stream.Collectors;

class Solution {
public int solution(int n, int[] lost, int[] reserve) {
// 전체를 다 입을 수 있다고 가정하고 시작 -> 소거법으로 간다
int answer = n;

        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        for (int num : lost) lostSet.add(num);
        for (int num : reserve) reserveSet.add(num);

        // 1. 여벌 가진 도난 학생 처리 (자기 체육복 사용)
        Set<Integer> duplicates = new HashSet<>(lostSet);
        duplicates.retainAll(reserveSet); // 교집합 찾기
        lostSet.removeAll(duplicates);
        reserveSet.removeAll(duplicates);

        // 정렬된 리스트로 변환
        List<Integer> lostList = new ArrayList<>(lostSet);
        List<Integer> reserveList = new ArrayList<>(reserveSet);
        Collections.sort(lostList);
        Collections.sort(reserveList);

        // 2. 이제 전체에서 옷 도둑맞은 애들은 제거 -> 빌려줄 때까지 기다려
        answer -= lostSet.size();
        
        for (int i = reserveList.size() - 1 ; i >= 0; i--) {
            for (int j = lostList.size() - 1; j >= 0; j--) {
                if (lostList.get(j) == (reserveList.get(i) - 1) || lostList.get(j) == (reserveList.get(i) + 1)) {
                    answer++;
                    // 한 번 빌려 줬으면 또 빌려 줄 수 없다 -> 내가 입어야 함
                    // 한 번 받았으면 또 받을 필요가 없다 -> 두 개 있어서 뭐 해
                    lostList.remove(j);
                    break;
                }
            }
        }
        return answer;
    }
}
```