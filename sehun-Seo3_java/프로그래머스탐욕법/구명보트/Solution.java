package 프로그래머스탐욕법.구명보트;

import java.util.Arrays;

// 효율성 테스트 실패... 이중포문을 돌려서 푼게 문제였나봐요.. 다른 해결방법을 생각해보겠습니다...

// 처음에 무거운순으로 나열해서, 가장 알차게(?) 보트에 탑승하도록 구현을 해봤는데, (ex. 60 50 40 10 | limit:100 이라면 (60,40),(50,10) )
// 어차피 2명만 탑승하도록 하니까 상관이 없는거같더라구요..  -> ((60,10), (50,40) 어차피 상관없음.) -> 다른 문제에 적용시켜서 풀어보겠습니다.


class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        int count = 0;
        boolean[] visited = new boolean[people.length];
        Arrays.sort(people);

        // 무거운 순서부터 차례대로 보트에 탑승
        for (int i = people.length - 1; i >= 0; i--) {
            // 방문 여부를 판단해서 따짐
            if (!visited[i]) {
                int tmp = people[i];
                visited[i] = true;
                for (int j = i - 1; j >= 0; j--) {
                    if (visited[j] || tmp + people[j] > limit) continue; // 만약 이미 처리했거나, 무게 초과라면 다음으로 넘김
                    visited[j] = true;
                    break; // 최대 탑승인원이 2명이므로, 추가로 탑승할 인원을 찾았다면 break.
                }
                count++;
            }
        }
        answer = count;

        return answer;
    }
}