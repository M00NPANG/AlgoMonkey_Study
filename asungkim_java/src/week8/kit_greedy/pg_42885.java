package week8.kit_greedy;

import java.util.Arrays;

public class pg_42885 {
    /***
     * 최적의 전략은 가벼운 사람과 무거운 사람을 태우는 것이다
     * 정렬을 통해 나열하고 투 포인터를 사용하였다.
     * 위에 처럼 풀이를 어느정도 잡아두고 while문 내부의 for문의 조건이 명확하지 않아
     * 예시를 하나씩 생각해보면서 구현했다.
     */
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        // 투 포인터(idx) 생성
        int idxStart = 0;
        int idxLast = people.length - 1;

        while (true) {

            // 둘이 같아지는 경우는 하나 남는 경우이므로 answer를 1키워줌
            if (idxStart == idxLast) {
                answer++;
                break;
            }

            // start가 더 커지는 경우는 남지 않아 둘의 순서가 바뀌게 되는 경우
            if (idxStart > idxLast) {
                break;
            }

            // tmpIdx는 오른쪽부터 맨 끝값부터 시작해서 idxStart보다 클때 작동한다.
            for (int tmpIdx = idxLast; tmpIdx > idxStart; tmpIdx--) {
                // 두명 태울수 있으면 answer를 키워주고, 시작점을 한칸 밀어주고
                // 끝점을 tmp의 위치보다 한칸 왼쪽으로 밀어준다
                if (people[tmpIdx] + people[idxStart] <= limit) {
                    answer++;
                    idxStart++;
                    idxLast = tmpIdx - 1;
                    break;
                }
                // 오른쪽에 남는 끝점은 그냥 보트를 혼자 타야하므로 이렇게 처리
                else {
                    answer++;
                    idxLast--;
                }
            }


        }

        return answer;
    }

    public static void main(String[] args) {
        pg_42885 pg = new pg_42885();
        int[] people = new int[]{70, 80, 50};
        int limit = 100;
        int solution = pg.solution(people, limit);
        System.out.println(solution);
    }
}
