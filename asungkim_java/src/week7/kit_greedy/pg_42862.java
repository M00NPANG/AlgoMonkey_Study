package week7.kit_greedy;

import java.util.Arrays;

public class pg_42862 {
    /***
     * cnt 배열의 길이가 n+1인 이유는 인덱싱을 편하게 사용하기 위해서 (학생 번호를 그대로 사용하기 위해서)
     * if문의 순서가 왼쪽에서 오른쪽인 이유 : for문의 순서상 맞다
     */
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] cnt = new int[n + 1]; // 각 학생번호가 가진 체육복 개수
        Arrays.fill(cnt, 1);

        // 여벌이 있는 애들은 하나씩 추가
        for (int r : reserve) {
            cnt[r]++;
        }

        // 잃어버린 애들은 하나씩 삭제
        for (int l : lost) {
            cnt[l]--;
        }

        for (int i = 1; i <= n; i++) {
            // 옷이 없는 사람인 경우
            if (cnt[i] == 0) {
                // 인덱싱이 범위가 맞고 이전 사람이 두개 있다면
                if (i - 1 >= 1 && cnt[i - 1] == 2) {
                    cnt[i]++;
                    cnt[i - 1]--;
                }
                // 앞사람에게 두개가 있다면
                else if (i + 1 <= n && cnt[i + 1] == 2) {
                    cnt[i]++;
                    cnt[i + 1]--;
                }

            }
        }

        // 체육복이 있는 사람
        for (int i = 1; i <= n; i++) {
            if (cnt[i] >= 1) {
                answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {

    }
}
