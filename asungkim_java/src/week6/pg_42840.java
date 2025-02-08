package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pg_42840 {
    /***
     * 1. a,b,c 배열에 각각 방식을 배열에 넣는다
     * 2. answers 순회를 통해 각각의 방식의 정답 갯수를 구하여 scores 배열에 담는다
     * 3. 세개의 값중 최댓값을 max에 저장하고 이와 같은 경우 List<Integer> answer 에 저장
     * 4. 오름차순 정렬이므로 정렬하고 List를 int[]로 변환 후 리턴
     */
    public int[] solution(int[] answers) {
        int[] scores=new int[3];

        int[] a=new int[]{1,2,3,4,5};
        int[] b=new int[]{2,1,2,3,2,4,2,5};
        int[] c=new int[]{3,3,1,1,2,2,4,4,5,5};


        for (int i=0;i<answers.length;i++) {
            int an=answers[i];

            // %를 통해 인덱싱 유지
            int idxA=i%a.length;
            int idxB=i%b.length;
            int idxC=i%c.length;

            if (a[idxA]==an) {
                scores[0]++;
            }

            if (b[idxB]==an) {
                scores[1]++;
            }

            if (c[idxC]==an) {
                scores[2]++;
            }

        }

        List<Integer> answer=new ArrayList<>();

        int max=Math.max(scores[0],Math.max(scores[1],scores[2]));

        // 최댓값은 모두 answer에 넣는다.
        for (int i=0;i<3;i++) {
            if (max==scores[i]) {
                answer.add(i+1);
            }
        }


        Collections.sort(answer);
        // List<Integer> -> int[]
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }
}
