package 프로그래머스완전탐색.최소직사각형;

import java.util.Arrays;

class Solution2 {
    public int solution(int[][] sizes) {
        int answer = 0;

        int w = 0; // 명함의 가로 길이 w
        int h = 0; // 명함의 세로 길이 h

        // 모든 명함들을 하나씩 조사
        for(int[] size : sizes) {
            Arrays.sort(size); // sort 하면 [작은값, 큰값] 으로 정렬되므로 지갑에 넣을 명함들을 수납하기 용이하다.

            // 명함의 가로 길이 w 의 최댓값 구하기.
            if(size[0]>w){
                w = size[0];
            }
            // 명함의 세로 길이 h 의 최댓값 구하기.
            if(size[1]>h){
                h = size[1];
            }
        }
        // 지갑의 크기 = (가로) x (세로)
        answer = w*h;

        return answer;
    }
}