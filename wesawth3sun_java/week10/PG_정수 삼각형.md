```java
class Solution {
    public int solution(int[][] triangle) {
        int length = triangle.length; // 삼각형 전체 높이

        // Bottom-Up
        // 아래에서 두 번째 행부터 시작
        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                // 현재 위치 값에 아래 행의 두 대각선 값 중 큰 값을 더함
                triangle[i][j] = triangle[i][j] + Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0]; // 꼭대기의 값이 최댓값이 됨
    }
}
```