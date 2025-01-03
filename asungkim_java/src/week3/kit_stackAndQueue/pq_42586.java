package week3.kit_stackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pq_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer=new ArrayList<>();
        int len=speeds.length;

        // 작업 순서 ->
        Queue<Integer> q=new LinkedList<>();

        // resDay -> 7 3 9
        // resDay -> 5 10 1 1 20 1


        int[] rest=new int[len];
        for (int i=0;i<len;i++) {
            int res=100-progresses[i];
            int resDay= res%speeds[i]==0 ? res/speeds[i] : res/speeds[i] +1;

            rest[i]=resDay;
        }

        for (int i=0;i<rest.length;i++) {
            if (!q.isEmpty() && q.peek() < rest[i]) {
                answer.add(q.size());
                q.clear();
            }

            q.offer(rest[i]);
        }

        answer.add(q.size());

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {

    }
}
