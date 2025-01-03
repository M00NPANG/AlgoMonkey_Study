// Question4 프로세스

package Week3;

import java.util.LinkedList;
import java.util.Queue;

public class PG_42587 {

    public int solution(int[] priorities, int location) {

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        int executionOrder = 0;

        while (!queue.isEmpty())
        {
            int[] poll = queue.poll();

            boolean isHigherPriority = false;

            for (int[] arr : queue) {
                if(arr[1] > poll[1])
                {
                    isHigherPriority = true;
                    break;
                }
            }

            if(isHigherPriority){
                queue.add(poll);
            }
            else {
                executionOrder++;
                if(location == poll[0])
                    return executionOrder;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        PG_42587 pg42587 = new PG_42587();

        int[] proprities = {2,1,3,2};
        int location = 2;
        int solution = pg42587.solution(proprities, location);
        System.out.println("solution = " + solution);

        int[] proprities2 = {1,1,9,1,1,1};
        int location2 = 0;
        int solution2 = pg42587.solution(proprities2, location2);
        System.out.println("solution = " + solution2);

    }
}
