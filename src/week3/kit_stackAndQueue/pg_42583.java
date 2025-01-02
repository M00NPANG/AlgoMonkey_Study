package week3.kit_stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class pg_42583 {

    /***
     * 핵심적인 접근 방법
     * 1. 순차적인 흐름에는 큐를 사용
     * 2. 큐를 대기큐, 현재 다리의 상황 큐로 나누어서 생각
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time=0;
        Queue<Integer> waitQ=new LinkedList<>();
        Queue<int[]> bridgeQ=new LinkedList<>();

        for (int w : truck_weights) {
            waitQ.offer(w);
        }

        int sum=0;
        while (true) {
            if (waitQ.isEmpty() && bridgeQ.isEmpty()) {
                break;
            }
            time++;

            if (!bridgeQ.isEmpty()&&bridgeQ.peek()[1]==time) {
                sum-=bridgeQ.poll()[0];
            }

            if (!waitQ.isEmpty() && sum+waitQ.peek()<= weight) {
                int cur=waitQ.poll();
                sum+=cur;
                bridgeQ.offer(new int[]{cur,time+bridge_length});
            }
        }

        return time;
    }

    public static void main(String[] args) {

    }
}
