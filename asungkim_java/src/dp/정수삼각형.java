package dp;

public class 정수삼각형 {

    /***
     * 특정 dp[i][j]의 값은 바로 위에 값 dp[i-1][j-1] 과 dp[i-1[j] 의 영향을 받는다는 아이디어
     * 처음과 끝부분은 이어지게끔 갱신이 되므로 따로 해줌
     * 사이의 값들은 예시로 해본 결과 dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]; 와 같은 규칙이 나옴
     * 맨 아랫 값중에 최대값을 찾아 반환
     */
    class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            int n = triangle.length;

            int[][] dp = new int[n][n];
            dp[0][0] = triangle[0][0];

            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i - 1][0] + triangle[i][0];
                dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
            }

            for (int i = 2; i < n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                answer = Math.max(answer, dp[n - 1][i]);
            }


            return answer;
        }
    }
}
