package week8.kit_greedy;

import java.util.Arrays;

public class pg_42884 {
    /***
     * 1.진입 시점으로 정렬해준다.
     * 2. 첫 차량에 카메라를 설치하고 진출 지점에 카메라를 배치한다
     * 3. 다음 차량부터 순회하면서 범위를 벗어나면 카메라를 추가하고, 진출 지점을 업데이트 해준다
     * 4. 범위 안에 있으면 늦게 빠져나가는 차량의 위치로 업데이트한다.
     */
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);

        int answer = 1;
        int startX = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            // 시작점이 범위를 벗어나면
            if (routes[i][0] > startX) {
                answer++;
                startX = routes[i][1];
            }
            // 범위 안이면
            else {
                startX = Math.min(startX, routes[i][1]);
            }
        }


        return answer;
    }

    public static void main(String[] args) {

    }
}
