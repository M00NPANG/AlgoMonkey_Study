package week4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class pg_42627 {
    /***
     * 문제 정리
     * waitQueue -> num, reqTime, needTime
     * 하드 작업 x && 대기큐 비어있지 x -> 우선순위 높은 작업 대기큐에서 꺼내 작업 시킴
     * 우선순위 높은 순서 : needTime low, reqTime fast, num low
     * 마칠때까지 작업 수행
     * 겹치면 대기큐에 저장 -> 우선순위 높은 작업 꺼내서 작업
     * turnTime 요청~~종료
     */

    /***
     * 알고리즘
     * 번호, 요청시각, 소요 시간을 가지는 Disk라는 객체를 만든다
     * 우선순위큐를 needTime 오름차순 구현
     * 주어진 jobs에서 reqTime 기준으로 오름차순
     */

    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Disk> waitQ=
                new PriorityQueue<>(Comparator.comparingInt(d->d.needTime));
        int curTime=0;
        int turnTime=0;
        int n=jobs.length;

        Arrays.sort(jobs,(s1, s2)->s1[0]-s2[0]);
        int cnt=0;
        int idx=0;

        // n개의 작업이 끝나야 종료
        while (cnt<n) {

            // 대기큐에 추가하는 상황
            while (true) {
                if (idx>=n||jobs[idx][0]>curTime) {
                    break;
                }
                waitQ.add(new Disk(jobs[idx][0],jobs[idx][1]));
                idx++;
            }


            // 비어있지 않으면 작업 시작
            if (!waitQ.isEmpty()) {
                Disk task=waitQ.poll();
                curTime+=task.needTime;
                turnTime+=(curTime-task.reqTime);
                cnt++;
            }
            // 현재까지 소요된 시간을 다음 reqTime으로 갱신
            else {
                curTime=jobs[idx][0];
            }
        }

        answer= turnTime/n;
        return answer;
    }

    class Disk {
        private int id;
        private int reqTime;
        private int needTime;


        public Disk(int reqTime,int needTime) {
            this.reqTime=reqTime;
            this.needTime=needTime;
        }
    }

    public static void main(String[] args) {

    }
}
