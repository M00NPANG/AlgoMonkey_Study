package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현 {

    /***
     * dfs를 활용한 풀이
     * n이 작은 수인 것을 보고 dfs로 풀기로 생각
     */
    class Solution1 {
        static int answer = Integer.MAX_VALUE;

        public int solution(int N, int number) {

            dfs(N, number, 0, 0);

            if (answer > 8) return -1;

            return answer;
        }

        public void dfs(int N, int number, int start, int cnt) {
            // 8번보다 크면 패스
            if (cnt > 8) {
                return;
            }

            // 숫자가 같아지면 최솟값인지 체크
            if (start == number) {
                answer = Math.min(answer, cnt);
                return;
            }

            int tmp = 0;
            for (int i = 1; i <= 8; i++) {
                tmp = tmp * 10 + N;
                dfs(N, number, start + tmp, cnt + i);
                dfs(N, number, start - tmp, cnt + i);
                dfs(N, number, start * tmp, cnt + i);
                dfs(N, number, start / tmp, cnt + i);
            }
        }
    }

    /***
     * dp를 활용한 풀이
     * 1. N으로 만들수 있는 숫자를 다 만들어두고 dp에 보관한다.
     * 2. 숫자를 둘로 찢어 a,b로 만들고 그걸로 만들 수 있는 수를 dp에 추가로 저장
     */
    class Solution2 {
        public int solution(int N, int number) {
            List<Set<Integer>> dp = new ArrayList<>();
            for (int i = 0; i <= 8; i++) {
                dp.add(new HashSet<>());
            }

            for (int i = 1; i <= 8; i++) {
                int num = Integer.parseInt(String.valueOf(N).repeat(i));
                dp.get(i).add(num);

                for (int j = 1; j < i; j++) {
                    // N=5 , i=5 => 55555 -> (5,5555) , (55,555) ...
                    for (int a : dp.get(j)) {
                        for (int b : dp.get(i - j)) {
                            dp.get(i).add(a + b);
                            dp.get(i).add(a - b);
                            dp.get(i).add(a * b);
                            if (b != 0) dp.get(i).add(a / b);
                        }
                    }
                }

                if (dp.get(i).contains(number)) return i;
            }

            return -1;
        }
    }
}