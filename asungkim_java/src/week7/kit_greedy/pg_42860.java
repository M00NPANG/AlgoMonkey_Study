package week7.kit_greedy;

import java.util.Arrays;

public class pg_42860 {
    /***
     * 최소 이동거리 경우의 수
     * 1. 오른쪽에 A가 없이 쭉 오른쪽으로 이동
     * 2. 왼쪽으로 갔다가 다시 되돌아 오는 경우
     * 3. 오른쪽으로 갔다가 왼쪽으로 돌아오는 경우
     *
     * Math.min(i,len-aCnt) -> 왼쪽으로 돌아가는 것과 오른쪽으로 돌아가는 것중 작은 값
     *
     */
    public int solution(String name) {
        int answer = 0;
        int aCnt = 0;
        int len = name.length();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            // 위아래 조이스틱
            answer += Math.min(c - 'A', 'Z' - c + 1);

            aCnt = i + 1; // A를 찾기위해 초기화


            // 오른쪽의 A의 개수를 구하는 과정
            while (aCnt < len && name.charAt(aCnt) == 'A') aCnt++;

            // 옆으로 움직이는 최적화 알고리즘
            min = Math.min(min, i + len - aCnt + Math.min(i, len - aCnt));

        }

        return answer + min;
    }

    public static void main(String[] args) {

    }
}
