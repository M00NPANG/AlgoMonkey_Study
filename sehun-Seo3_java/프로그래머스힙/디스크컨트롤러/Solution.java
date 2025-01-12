package 프로그래머스힙.디스크컨트롤러;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        // 작업 요청하는 순서대로 정렬하는 큐 pqJobs. - 우선순위 큐 이용
        PriorityQueue<int[]> pqJobs = new PriorityQueue<>((o1, o2) ->  o1[0] - o2[0]);
        for (int[] job : jobs) {
            pqJobs.offer(job); // 대입한다면 poll 할 때 자동으로 작업요청 순서대로 나온다.
        }

        // 대기큐 pq - 우선순위 큐 이용, int[] = {요청시간, 소요시간}, 소요시간 순으로 정렬하되, 소요시간이 같다면 요청시간 순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int timeSum = 0; // 반환 시간들의 합
        int timeLine = 0; // 작업이 끝났을 때의 시간

        // 하드디스크 작업 시작 (pqJobs 나 pq가 다 빌때까지 반복한다.)
        while (!pqJobs.isEmpty() || !pq.isEmpty()) {
            // 이 부분이 문제의 핵심. 작업 중에 작업 요청이 들어왔을 때,
            while(!pqJobs.isEmpty() && pqJobs.peek()[0]<=timeLine){
                pq.offer(pqJobs.poll()); // 전부 pq에 넣어서 소요시간 순으로 정렬.
            }

            // 만약 pq에 값이 있다면
            if(!pq.isEmpty()){
                int[] arr = pq.poll();
                timeLine += arr[1]; // arr[1] : 소요시간
                timeSum += timeLine - arr[0]; // arr[0] : 요청시간
            } else{
                timeLine++; // pq에 값이 없다면 아직 작업요청이 안들어온것이므로, 시간을 보낸다.
            }
        }

        answer = timeSum / jobs.length;

        return answer;
    }
}