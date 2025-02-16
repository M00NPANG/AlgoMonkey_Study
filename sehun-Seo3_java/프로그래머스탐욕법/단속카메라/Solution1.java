package 프로그래머스탐욕법.단속카메라;

import java.util.Arrays;

// 백준문제에 제가 풀었던 회의실 배정(1931번)과 유사해보여서 한번 가져와서 적용시켜봤는데
// 확실히 코드량이 줄고 가독성 있게 제 나름대로 최적화를 해 보았습니다..!

class Solution1 {
    public int solution(int[][] routes) {
        int answer = 0;

        // 차량 진출 지점으로 정렬 (차량 진출 지점이 같다면 진입 지점 정렬)
        Arrays.sort(routes, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        // camera 위치를 초기화
        int camera = Integer.MIN_VALUE; // 문제의 조건에 의해서, -30001 이라고 둬도 상관없다.

        // 각 차량의 경로마다
        for (int[] route : routes) {
            // 카메라가 벗어나있다면 -> 진출지점에 카메라 생성
            if(camera < route[0]){
                camera = route[1]; // 진출지점에 카메라 생성
                answer++; // 카메라 수 증가
            }
        }

        return answer;
    }
}