
    import java.util.*;
    
    class Solution {
    public int solution(int[] scoville, int K) {
    //작은 것부터 정렬되어야 하니까 sort 하는 것보다 우선순위 큐 쓰는 게 효율이 더 나을 것 같았다
    PriorityQueue<Integer> queue = new PriorityQueue<>();

        //큐 안에 스코빌 값 넣어 주기
        for (int s : scoville) {
            queue.offer(s);
        }
        
        //몇 번의 계산이 있었는지 체크할 용도
        int count = 0;
        
        //큐는 두 개를 꺼내서 덧셈을 해야 하니까 size가 1보다는 커야 한다
        //큐에서 꺼낼 값이 7보다 작아야 한다
        while (queue.size() > 1 && queue.peek() < K) {
            int first = queue.poll();
            int second = queue.poll();
            //큐에서 값 두 개 꺼내서 새로운 스코빌 지수 만들어 준 후 큐에 다시 넣기
            //우선순위 큐라서 자동 정렬됨
            int newScoville = first + (second * 2);
            queue.offer(newScoville);
            count++;
        }
        //다음에 꺼낼 값이 K보다 크면 count, K보다 작으면 -1
        return queue.peek() >= K ? count : -1;
    }
}