package 프로그래머스동적계획법.정수삼각형;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        // triangle 배열 복사한 dp 배열
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle[i].clone(); // clone() 이란걸 이용해 복사.
        }

        // 삼각형 모양의 수 거꾸로 채워나가기.
        for (int i = n - 1; i >= 0; i--) { // 행
            for (int j = 0; j < i; j++) { // 열
                dp[i - 1][j] += Math.max(dp[i][j], dp[i][j + 1]); // 역순으로 채워나가서, 결국 꼭대기에 있는 것이 최댓값
            }
        }

        // 최종적으로 꼭대기에는 최대 합이 저장됨
        return dp[0][0];
    }
}