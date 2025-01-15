미친 문제
고민하다가 머리털 다 뽑히는 줄 알았네요


    import java.util.*;
    
    class Solution {
    public int solution(int[][] jobs) {
    //jobs -> 요청시간, 소요시간 순서
    PriorityQueue<int[]> jobQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    //작업 요청 시간이 빠른 순서대로 정렬
    PriorityQueue<int[]> waitingQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    //작업 소요 시간이 짧은 순서대로 정렬

        int currentTime = 0; //현재 시간
        int workTime = 0;
        //대기 시간 + 실행 시간의 합계 -> 이걸 jobs.length로 나눠야 평균 반환 시간이 나옴
        int complete = 0; //실행 완료된 job의 수
        
        for (int[] job : jobs) {
            jobQueue.offer(job);
        }
        //모든 작업들을 jobQueue에 추가하기
        
        while (complete < jobs.length) {
            //jobs 의 길이만큼 돈다 = 연산이 다 끝날 때까지 돌린다
            while (!jobQueue.isEmpty() && jobQueue.peek()[0] <= currentTime) {
                //jobQueue.isEmpty()가 비어있으면 연산 할 필요가 없음 = 이미 끝난 것
                //jobQueue.peek()[0] <= currentTime 요청 시간이 현재 시간보다 작거나 같은지 확인
                //그래야지 큐 안에서 실행될 수 있음 (현재 시간이 1인데 요청 시간이 3이면 실행할 수 없으니까...)
                //이 요청을 둘 다 만족하면 해당 작업은 현재 시간에 실행 가능한 상태!
                waitingQueue.offer(jobQueue.poll());
            }
            
            if (waitingQueue.isEmpty()) {
                //현재 실행할 작업이 없으면
                currentTime = jobQueue.peek()[0];
                //실행 가능한 작업이 없다면, 다음 작업의 요청 시간으로 현재 시간을 업데이트
                //현재가 0초인데 다음 작업이 2초에 들어오면 2초는 건너뛰는 것
            } else {
                int[] job = waitingQueue.poll();
                //가장 짧은 작업 뽑아내기
                currentTime += job[1];
                //현재 시간에 작업 소요 시간을 더해 전체 시간 업데이트
                workTime = workTime + (currentTime - job[0]);
                // 전체 시간에서 작업이 들어온 시간을 빼면 반환 시간을 구할 수 있음
                complete++;
            }
          }
          return workTime / jobs.length;
       }
    }