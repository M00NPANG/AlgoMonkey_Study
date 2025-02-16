package week4;

import java.util.PriorityQueue;

public class pg_42626 {
    /***
     * pq는 우선순위 큐로 오름차순 정렬이 된다
     *
     * ** while 문 작동 방식 **
     * pq.peek() 은 최소값이 대기중, 최소값이 K보다 크면 break
     * pq에 두개 이상있다면 newSco를 계산함
     * else문(두개 이상이 아닌 경우)은 pq에 하나가 남은 경우이므로 계산을 할수 없어 break
     *
     * while문을 벗어났을 때 pq에 하나 남아있는 경우는 모두 -1 리턴 (예외가 있을까봐 if문을 하나 더 썼다)
     */

    public int solution(int[] scoville, int K) {

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int sco : scoville) {
            pq.add(sco);
        }

        while (true) {
            if (pq.peek() >= K) {
                break;
            }

            if (pq.size() >= 2) {
                int first = pq.poll();
                int sec = pq.poll();
                int newSco = first + (sec * 2);
                pq.add(newSco);
                answer++;
            } else {
                break;
            }

        }

        if (pq.size() == 1) {
            if (pq.peek() < K) return -1;
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
