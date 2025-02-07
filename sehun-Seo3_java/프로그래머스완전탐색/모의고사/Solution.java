package 프로그래머스완전탐색.모의고사;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};

        // A : 1번 수포자가 찍는 방식, B : 2번 수포자가 찍는 방식, C : 3번 수포자가 찍는 방식
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 각 A, B, C 수포자가 얻은 점수
        int scoreA = 0;
        int scoreB = 0;
        int scoreC = 0;

        // 각 정답을 비교하면서 일치하면 점수 획득.
        // 여기서 포인트는 % length 를 이용하여, 각 배열의 범위를 벗어나서 접근하지 않고, 무한으로 돌게 설정.
        // ex. A[5 % A.length] = A[0], B[10 % B.length] = B[2]
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == A[i % A.length]) scoreA++;
            if (answers[i] == B[i % B.length]) scoreB++;
            if (answers[i] == C[i % C.length]) scoreC++;
        }

        // 각 점수들 중 가장 큰 값을 maxScore 에 저장
        int maxScore = Math.max(scoreA, Math.max(scoreB, scoreC));

        // 가장 높은 점수를 받은 사람이 여럿일 경우를 생각해서, List 로 대입해준다. (동적 배열)
        List<Integer> list = new ArrayList<>();
        if(scoreA == maxScore) list.add(1);
        if(scoreB == maxScore) list.add(2);
        if(scoreC == maxScore) list.add(3);
        // 이렇게 구현한다면 return 하는 값을 오름차순으로 정렬하지 않아도 된다.

        // list -> Array 변환 stream 사용
        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}