package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pg_42840 {
    public int[] solution(int[] answers) {
        int[] scores=new int[3];

        int[] a=new int[]{1,2,3,4,5};
        int[] b=new int[]{2,1,2,3,2,4,2,5};
        int[] c=new int[]{3,3,1,1,2,2,4,4,5,5};


        for (int i=0;i<answers.length;i++) {
            int an=answers[i];

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

        // 5 0 2

        List<Integer> answer=new ArrayList<>();
        int max=Math.max(scores[0],Math.max(scores[1],scores[2]));

        for (int i=0;i<3;i++) {
            System.out.println(scores[i]);
            if (max==scores[i]) {
                answer.add(i+1);
            }
        }


        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {

    }
}
