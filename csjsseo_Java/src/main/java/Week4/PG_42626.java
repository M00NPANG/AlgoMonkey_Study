package Week4;

import java.util.PriorityQueue;
import java.util.Queue;

public class PG_42626 {

    public int solution(int[] scoville, int K) {

        int count = 0;
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.add(i);
        }

        while (queue.peek() < K) {
            if(queue.size() == 1) return -1;

            int first = queue.poll();
            int second = queue.poll();

            if (first + second == 0) return -1;

            queue.add(first + (second * 2));
            count++;
        }

        return count;
    }

    public static void main(String[] args){

        PG_42626 pg42626 = new PG_42626();
        int solution = pg42626.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println("solution = " + solution);
    }
}
