package week10;

/**
 * Week 10. 동적 계획법 - 등굣길 문제 풀이
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1]; // 격자의 크기 (n행 x m열)

        // 물에 잠긴 지역 표시 (기본값을 -1 로 설정)
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        // DP 시작점
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0; // 물에 잠긴 지역은 경로를 계산하지 않음
                    continue;
                }

                if (i > 1) {
                    dp[i][j] += dp[i - 1][j]; // 위쪽 칸에서 오는 경로
                }

                if (j > 1) {
                    dp[i][j] += dp[i][j - 1]; // 왼쪽 칸에서 오는 경로
                }

                // 모듈러 연산 적용
                dp[i][j] %= 1_000_000_007;
            }
        }
        return dp[n][m]; // 학교 위치의 최단 경로 개수 반환
    }
}
