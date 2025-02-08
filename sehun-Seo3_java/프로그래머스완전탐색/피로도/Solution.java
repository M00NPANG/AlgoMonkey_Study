package 프로그래머스완전탐색.피로도;

import java.util.ArrayDeque;
import java.util.Deque;

// stack 에 {현재 피로도, 현재 탐험한 던전 수} 를 채워 넣어서 구현해보려고 했는데
// visited. 즉 방문여부를 따져서 구현하는게 힘들더라구요,,
// 그래서 비트마스크라는걸 알게 되어서 그걸 이용해서 구현해보았습니다.
//
// 지금 생각해보면 객체 class 를 만들어서 구현하는게 좀 더 자바스럽지 않을까 해서
// 개인적으로는 조금 아쉬운 풀이 같습니다.. 다른 분들은 어떻게 구현하셨는지도 궁금합니다!

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;

        // Stack 으로 구현 {남은 피로도, 탐험한 던전 수, 방문 상태 - 비트 마스크라는걸 이용}
        Deque<int[]> stack = new ArrayDeque<>();
        stack.addFirst(new int[]{k, 0, 0}); // 초기값은 {k,0,0}

        // 완전탐색으로, 다 돌고나서 그때의 최댓값인 count 가 answer 이 된다.
        while (!stack.isEmpty()) {
            int[] tiredCount = stack.poll();
            int tired = tiredCount[0]; // 현재 피로도
            int count = tiredCount[1]; // 현재 탐험한 던전 수
            int visited = tiredCount[2]; // 지금까지 방문한 상태 - 비트마스크 이용

            // 만약 던전을 모두 다 돌 수 있다면 그때의 탐험한 던전 수 리턴.
            if(count == dungeons.length) return count;

            // 현재까지 나온 최대 탐험한 던전 수 갱신
            answer = Math.max(answer, count);

            // 모든 던전에 대해 탐색
            for (int i = 0; i < dungeons.length; i++) {
                // 피로도가 "최소 필요 피로도" 이상이고, 던전을 탐험하지 않았다면, 실행
                if (tired >= dungeons[i][0] && (visited & (1 << i)) == 0) {
                    stack.addFirst(new int[]{tired - dungeons[i][1], count + 1, visited | (1 << i)}); // *
                }
            }
        }
        return answer;
    }
}

// * - visited 따지는 방법 - 비트마스크 설명
// 초기값 visited : 0 (이진수의 비트를 활용함 -> ex. 00000000) (0001 << 2 -> 0100)
//
// 1. (visited & (1 << i)) == 0
// -> 던전 방문 여부 확인.
// ex. 0001 & 0100 == 0 이므로 방문 X
//     0010 & 0110 != 0 이므로 방문 O
//
// 2. visited | (1 << i)
// -> 던전 방문 후 방문 여부 갱신
// ex. 0001 | 1000 -> 1001 로 현재 방문 여부 갱신함.