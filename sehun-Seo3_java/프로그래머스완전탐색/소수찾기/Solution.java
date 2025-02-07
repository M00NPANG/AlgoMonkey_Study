package 프로그래머스완전탐색.소수찾기;
// 너무 시간복잡도를 고려하지 않고 풀어서 효율성이 떨어지는 문제이기도 하고..
// 제 기준으로는 조금.. 아니 많이 어렵더라구요..ㅜ
// 문자열에서 각 문자 별로 모든 경우의 수를 구하는 순열(permutation) 재귀함수는
// 인터넷 개발 블로거분들 + 그저 신..gpt 에서 일부 참고해서 구현해봤습니다!
// 다른 분들은 어떻게 푸셨는지 궁금했던 문제입니다!

import java.util.HashSet;

class Solution {

    // 중복을 제거하고 숫자를 저장하기 위한 HashSet. 전역변수로 설정.
    public HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        // 주어진 문자열로 만들 수 있는 모든 숫자 조합 생성
        permutation("", numbers);

        // HashSet 저장된 각 숫자에 대해 소수 판별
        for (Integer num : set) {
            boolean isPrime = true; // 초기 소수 판별은 true

            if (num == 0 || num == 1) continue; // 만약, num이 0 또는 1이라면 소수가 아니므로 패쓰.

            // 2부터 루트(num) 까지 나누었을때 나누어떨어지는지 검사 (소수 판별)
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) { // 나누어 떨어진다면 소수가 아님.
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) { // 소수라면 answer++
                answer++;
            }
        }

        return answer;
    }

    // 문자열로 만들 수 있는 모든 경우을 생성하는 재귀 함수
    public void permutation(String prefix, String s) {
        int n = s.length();

        // prefix 존재한다면 숫자로 변환해 Hashset 에 추가.
        if (!prefix.isEmpty()) {
            set.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < n; i++) {
            // 현재 선택한 문자(prefix+s.charAt(i)) 와 나머지 문자 (s.substring(0, i) + s.substring(i + 1))로 재귀 호출
            permutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
        }
    }
}