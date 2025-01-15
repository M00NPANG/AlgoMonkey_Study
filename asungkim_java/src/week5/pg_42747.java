package week5;

import java.util.Arrays;

public class pg_42747 {
    /***
     * h의 예상값은 0부터 citations의 최댓값까지이다
     * 이 범위안에서 h번 이상 인용된 논문을 up에 저장하고 down은 나머지 논문에 대한 정보이다
     * up이 h 이상이고 down이 h이하일때의 값을 업데이트 계속해주면 answer에는 최대값이 들어간다
     * 만족하지 못하는 숫자가 나오는 경우 break한다
     */
    public int solution(int[] citations) {
        int answer = 0;
        int len=citations.length;
        Arrays.sort(citations);
        // 0 1 3 5 6

        int max=citations[len-1];
        for (int h=0;h<=max;h++) {
            int up=0;
            for (int i=0;i<len;i++) {
                if (citations[i]>=h) {
                    up++;
                }
            }

            int down=len-up;
            if (up>=h && down<=h) {
                answer=h;
            }
            else break;

        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
