package Week4;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PG_42627 {

    public int solution(int[][] jobs){

        Queue<int[]> queue = new PriorityQueue<>(Comparator
                .comparingInt((int[] arr) -> arr[1])
        );

        for(int i=0;i<jobs.length;i++)
        {
            queue.add(new int[]{i,jobs[i][0],jobs[i][1]});
            // 작업 번호, 요청 시간 빠른 것, 소요 시간 짧은 것
        }
        Queue<int[]> readyQueue = new PriorityQueue<>(Comparator
                .comparingInt((int[] arr) -> arr[2])
                .thenComparingInt(arr -> arr[1])
                .thenComparingInt(arr -> arr[0])
        ); // 소요시간 짧은 것, 요청 시간 빠른 것, 작업 번호 작은 순서

        boolean isWorking = false;
        int currentTime = 0;
        int endTime = 0;
        int totalTurnAroundTime = 0;

        while(!queue.isEmpty() || !readyQueue.isEmpty())
        {

            if(endTime == currentTime)
                isWorking = false;

            while(!queue.isEmpty() && queue.peek()[1] == currentTime)
                readyQueue.add(queue.poll());

            if (!readyQueue.isEmpty())
            {
                if(isWorking == false)
                {
                    isWorking = true;
                    int[] poll = readyQueue.poll();
                    endTime = currentTime + poll[2];
                    int turnAroundTime = endTime - poll[1];
                    totalTurnAroundTime += turnAroundTime;
                }
            }

            currentTime++;
        }

        return totalTurnAroundTime / jobs.length;
    }

    public static void main(String[] args) {
        PG_42627 pg42627 = new PG_42627();
        int solution = pg42627.solution(new int[][]{{0, 3}, {1, 9}, {3, 5}});
        System.out.println("solution = " + solution);
    }
}
