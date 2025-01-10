package week4;

import java.util.Collections;
import java.util.PriorityQueue;

public class pg_42628 {
    /***
     * 최소힙과 최대힙을 만들고
     * D 1 일때는 최대힙의 값을 poll하고 최소힙도 동기화
     * D -1 일때는 최소힙의 값을 poll 하고 최대힙도 동기화
     * 삽입하는 경우에는 둘다 넣어줌
     */
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> minQ=new PriorityQueue<>(); // 최소 - 최대
        PriorityQueue<Integer> maxQ=new PriorityQueue<>(Collections.reverseOrder());

        for (String cmd : operations) {
            String[] cmdBits=cmd.split(" ");
            int num=Integer.parseInt(cmdBits[1]);
            if (cmdBits[0].equals("D")) {

                if (num==1 &&!maxQ.isEmpty()) {
                    // 최댓값 삭제
                    minQ.remove(maxQ.poll());
                }
                else if(num==-1&&!minQ.isEmpty()) {
                    // 최솟값 삭제
                    maxQ.remove(minQ.poll());
                }
            }
            else {
                minQ.add(num);
                maxQ.add(num);
            }
        }


        if (minQ.isEmpty() && maxQ.isEmpty()) {
            return new int[]{0,0};
        }


        answer=new int[]{maxQ.poll(),minQ.poll()};
        return answer;
    }

    public static void main(String[] args) {

    }
}
