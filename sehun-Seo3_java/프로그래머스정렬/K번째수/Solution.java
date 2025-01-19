package 프로그래머스정렬.K번째수;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        // 배열 크기 초기화
        answer = new int[commands.length];
        int idx = 0; // answer 인덱스

        for (int[] command : commands){ // command == [i, j, k]
            int i = command[0]; // i번째 숫자부터
            int j = command[1]; // j번째 숫자까지 자르고
            int k = command[2]; // k번째 있는 수를 구하기

            // Arrays.copyofRange를 이용해서 배열 복사 및 자르기
            int[] arr = Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(arr); // 배열 오름차순 정렬

            answer[idx] = arr[k-1]; // k번째 수 (index : k-1) 대입
            idx++;
        }

        return answer;
    }
}