package 프로그래머스동적계획법.등굣길;

public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // n : 행, m : 열

        // [행][열]로 구성 (1-based index)
        int[][] dp = new int[n + 1][m + 1];

        // 물에 잠긴 곳 체크
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            isPuddle[y][x] = true; // 물에 잠긴 곳은 true
        }

        // 시작 위치 초기화
        dp[1][1] = 1;

        // DP 테이블 채우기
        for (int y = 1; y <= n; y++) { // 행
            for (int x = 1; x <= m; x++) { // 열
                if (isPuddle[y][x]) {
                    dp[y][x] = 0; // 웅덩이 위치는 0
                } else {
                    if (y > 1) dp[y][x] = (dp[y][x] + dp[y - 1][x]) % 1000000007; // 위쪽에서 오는 경우
                    if (x > 1) dp[y][x] = (dp[y][x] + dp[y][x - 1]) % 1000000007; // 왼쪽에서 오는 경우
                }
            }
        }

        // 최종 도착지의 경우의 수
        return dp[n][m];
    }
}