package 프로그래머스탐욕법.체육복;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 처음 배열 값들을 1로 다 초기화(체육복이 1벌 있다) 해서 구현하려 했는데, 0으로 해도 상관없기에 그렇게 구현해봤습니다. (따로 초기화도 안해도 되기도 해서)
        // 그런데 0으로 초기화 하면 동료 개발자가 봤을 때 이해하기 어려울 수 있겠다 라는 생각도 했습니다. (체육복이 -1개 있다라고 생각할 수 있기에)
        // 사소한 내용이지만, 이런 부분이 저에게 조금 고민이 되었습니다...
        int[] students = new int[n+1]; // 학생들의 체육복 개수 (1-based index) 초기값 : 0


        students[0] = -1;

        // 잃어버린 학생들은 -1
        for (int lostNum : lost) {
            students[lostNum]--;
        }

        // 여벌 체육복이 있는 학생들은 +1
        for (int reserveNum : reserve) {
            students[reserveNum]++;
        }

        // 체육복 빌려주기
        for (int i = 1; i <= n; i++) {
            // 체육복이 없는 학생
            if (students[i] == -1) {
                // 앞번호 학생이 여벌 체육복이 있는 경우
                if (students[i - 1] == 1) {
                    students[i]++;
                    students[i - 1]--;
                }
                // 뒷번호 학생이 여벌 체육복이 있는 경우
                else if ((i + 1)< (n + 1) && students[i + 1] == 1) {
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }

        // 체육복이 있는 학생 수 계산
        for (int i = 1; i < students.length; i++) { // (0번 제외) 1부터 시작
            if (students[i] >= 0) {
                answer++;
            }
        }

        return answer;
    }
}