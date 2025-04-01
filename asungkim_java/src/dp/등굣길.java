package dp;

public class 등굣길 {
    /***
     * 웅덩이를 어떻게 처리할 지 예제를 통해서 고민
     * 옛날 수학 문제처럼 dp를 통해 누적
     * (x,y) 부분의 값은 왼쪽까지의 최대합(x-1,y)과 위쪽까지의 최대합(x,y-1) 을 더한 값이다.
     */
    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[n + 1][m + 1];
            dp[1][1] = 1;

            for (int i = 0; i < puddles.length; i++) {
                int x = puddles[i][1];
                int y = puddles[i][0];
                dp[x][y] = -1;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    // 시작값은 패스
                    if (i == 1 && j == 1) {
                        continue;
                    }

                    // 웅덩이는 0으로 처리 -> 그래야 원하는 누적값이 됨
                    if (dp[i][j] == -1) {
                        dp[i][j] = 0;
                        continue;
                    }

                    // 공식 사용
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                }
            }


            return dp[n][m] % 1000000007;
        }
    }
}
