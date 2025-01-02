// Question2 기능 개발

package Week3;

import java.util.*;

public class PG_42586 {

    public int[] solution(int[] progresses, int[] speeds){

        Queue<Integer> dayQue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<progresses.length;i++)
        {
            double data = (100 - progresses[i]) / (double) speeds[i];
            int remain = (int) Math.ceil(data);
            dayQue.add(remain);
        }

        while (!dayQue.isEmpty())
        {
            Integer poll = dayQue.poll();
            int count = 1;

            while(!dayQue.isEmpty() && dayQue.peek() <= poll) {
                dayQue.poll();
                count++;

            }
            result.add(count);
        }

        int[] resultArr = new int[result.size()];

        for(int i=0;i<result.size();i++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }

    public static void main(String[] args) {

        PG_42586 pg42586 = new PG_42586();
        int[] pro = {93,30,55};
        int[] speed = {1,30,5};
        int[] solution = pg42586.solution(pro, speed);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
