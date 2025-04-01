package 프로그래머스동적계획법.N으로표현;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1; // -> 효율성 개선코드

        // dp[i]: N을 i번 사용해서 만들 수 있는 숫자 집합
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>()); // dp[0]은 사용하지 않음

        // K를 1번부터 8번까지 사용해서 만들 수 있는 숫자 계산
        for (int i = 1; i <= 8; i++) {
            Set<Integer> currentSet = new HashSet<>();

            // N, NN, NNN, ... 반복된 수 추가 (e.g. N=5 -> 5, 55, 555, ...)
            int repeated = repeatN(N, i);
            currentSet.add(repeated);

            // 사칙연산 조합으로 숫자 만들기
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = dp.get(j); // 앞 숫자 선택
                Set<Integer> set2 = dp.get(i - j); // 뒤 숫자 선택

                for (int a : set1) {
                    for (int b : set2) {
                        currentSet.add(a + b); // 덧셈
                        currentSet.add(a - b); // 뺄셈
                        currentSet.add(a * b); // 곱셈
                        if (b != 0) currentSet.add(a / b); // 나눗셈
                    }
                }
            }

            // 원하는 숫자를 만들었는지 확인
            if (currentSet.contains(number)) {
                return i;
            }

            dp.add(currentSet);
        }

        return -1; // 8번까지 사용해도 만들 수 없는 경우
    }

    // N을 count번 이어붙인 수 생성 (예: N=5, count=3 -> 555)
    private int repeatN(int K, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) sb.append(K);

        return Integer.parseInt((sb.toString()));
    }
}

