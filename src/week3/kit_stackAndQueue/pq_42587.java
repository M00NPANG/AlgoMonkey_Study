package week3.kit_stackAndQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class pq_42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // location -> idx

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for (int prior : priorities) {
            pq.add(prior);
        }

        // 3 2 2 1

        while (!pq.isEmpty()) {
            for (int i=0;i<priorities.length;i++) {
                if (priorities[i]==pq.peek()) {
                    pq.poll();
                    answer++;

                    if (i==location) {
                        return answer;
                    }
                }
            }
        }




        return answer;
    }
    public static void main(String[] args) {

    }
}
