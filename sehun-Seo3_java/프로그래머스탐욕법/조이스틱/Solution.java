package 프로그래머스탐욕법.조이스틱;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String name) {
        Map<Character, Integer> map = new HashMap<>();
        char[] Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (int i = 0; i < Alphabet.length; i++) {
            map.put(Alphabet[i], i);
        }
        int count = 0;
        int minLen = name.length() - 1; // 기본값 (오른쪽)

        // 알파벳 선택 횟수 구하기
        for (char Char : name.toCharArray()) {
            int index = map.get(Char); // 특정값 - index 로 빠르게 검색
            count += Math.min(index, 26 - index); // 알파벳을 오른쪽으로 돌리는 것과 왼쪽으로 돌리는 것 중 작은 값을 선택 (N(13)이 기준)
        }

        // 자리 선택 횟수 구하기
        for (int i = 0; i < name.length(); i++) {
            int nextIdx = i + 1;
            // A가 연속된 부분 찾기
            while (nextIdx < name.length() && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }

            // 1) 처음부터 i까지 갔다가 되돌아오기 + A 연속 구간 이후로 가는 경우
            int move1 = (i * 2) + (name.length() - nextIdx);
            // 2) 끝에서부터 nextIdx까지 갔다가 되돌아오기
            int move2 = (name.length() - nextIdx) * 2 + i;
            // 최솟값 갱신
            minLen = Math.min(minLen, Math.min(move1, move2));
        }

        return count + minLen;
    }
}