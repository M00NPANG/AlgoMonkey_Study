package 의상;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>(); // 우리가 필요한 건 의상의 이름이 아닌, 개수이다.

        // 의상 종류 별 개수 카운트
        for (String[] cloth : clothes) {                 // 즉, 의상의 이름이 들어있는 첫번째 배열은 필요가 없다. => 두 번째 배열만 사용
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1); // 의상의 종류를 key로, 그에 따른 개수를 value로 했다.
        }

        int totalCases = 1;
        for (int count : map.values()) { // 의상 개수를 가져와서,
            totalCases *= count + 1;            // 각각 +1 씩 더한 다음 (한 종류당 입지 않은 경우까지 생각), totalCases 에 곱한다.(곱의 법칙에 의해서)
        }
        answer = totalCases - 1;            // 마지막으로, -1을 한다. (모든 종류의 옷을 입지 않았을 경우를 빼준다.)

        return answer;
    }
}