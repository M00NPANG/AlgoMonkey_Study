```java

/**
 * int[] route = [진입 지점, 탈출 지점]
 */

class Solution {
    public int solution(int[][] routes) {
        // 차량 경로를 나가는 지점 기준으로 정렬
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        
        int camera = 0; // 설치된 카메라 개수
        int lastCameraPosition = 30000; // 마지막 카메라 위치 (제한 지점으로 초기화)

        for (int[] route : routes) {
            // 현재 차량이 마지막 카메라 위치에서 감시되지 않는 경우
            if (lastCameraPosition < route[0]) {
                lastCameraPosition = route[1]; // 현재 차량의 나가는 지점에
                camera++; // 새로운 카메라 설치
            }
        }

        return camera;
    }
}

```