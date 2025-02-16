package 프로그래머스탐욕법.단속카메라;

import java.util.Arrays;

// 효율성 테스트는 통과했지만, 이중 중첩문으로 되어있어 아쉬운 코드 입니다..

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        // 차량 진출 지점으로 정렬 (차량 진출 지점이 같다면 진입 지점 정렬)
        Arrays.sort(routes, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        // 차량의 대수만큼 boolean 배열 생성
        int length = routes.length;
        boolean[] visited = new boolean[length];

        // 각 배열에서 진출지점을 잡는다. -> 각 배열의 진출지점에 카메라를 설치한다고 생각.
        for (int i = 0; i < routes.length; i++) {
            int[] route1 = routes[i];
            int exit = route1[1];
            // 카메라 설치 여부를 따짐
            if (!visited[i]) {
                for (int j = 0; j < routes.length; j++) {
                    int[] route2 = routes[j];
                    // 카메라를 설치했을 때 구간에 포함되어있는 경로들을 방문처리.
                    if (route2[0] <= exit && exit <= route2[1]) {
                        visited[j] = true;
                    }
                }
                answer++; // 카메라 설치했으므로 answer++
            }
        }

        return answer;
    }
}