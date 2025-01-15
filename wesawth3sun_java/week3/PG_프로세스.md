상세 풀이: 
https://velog.io/@suunn001/%ED%94%84%EB%A1%9C%EC%84%B8%EC%8A%A4-java


    import java.util.*;

    class Solution {
    public int solution(int[] priorities, int location) {
    Queue<Integer> queue = new ArrayDeque<>();
    //문서의 초기 순서를 유지하는 큐
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    //중요도 순으로 정렬된 우선순위 큐 (내림차순)
    int count = 0;
    //location과 비교하기 위한 변수, 현재까지 인쇄된 문서의 수

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
            pq.offer(priorities[i]);
        }
        
        
        while (!pq.isEmpty()) {
            Integer current = queue.poll();
            //현재 검사 중인 문서의 인덱스
            if (pq.peek() == priorities[current]) {
                pq.poll();
                count++; 
                if (location == current) {
                    return count;
                }
            } else {
                queue.offer(current);
            }
        }
        return count;
    }
}