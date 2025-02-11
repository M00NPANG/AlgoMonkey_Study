package week6;

import java.util.ArrayList;
import java.util.List;

public class pg_42842 {
    /***
     * 1. 예시를 통해 그림을 그려보고 규칙성을 찾는다
     * 2. yellow의 약수를 통해 만들어질 수 있는 모양을 찾는다 -> findWant
     * 3. tmpBrown은 for문에서 구한 x,y를 통해 예상되는 brown이다
     * 4. 예상 brown 과 실제 brown 이 같은 경우는 하나이고 이때의 x,y값의 +2가 전체의 가로,세로 크기이다.
     */
    private static List<Integer> list;
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        list=new ArrayList<>();
        findWant(yellow);

        for (int x : list) {
            int y=yellow/x;

            // x,y 가 yellow 값의 소인수분해
            int tmpBrown=(2*(x+y))+4;

            if (tmpBrown==brown) {
                answer[0]=y+2;
                answer[1]=x+2;
            }
        }
        return answer;
    }

    private static void findWant(int y) {
        for (int i=1;i<=Math.sqrt(y);i++) {
            if (y%i==0) {
                list.add(i);
            }
        }
    }

    public static void main(String[] args) {

    }
}
