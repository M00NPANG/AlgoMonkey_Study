1. 큐 도입 풀이 (큐 문제라서 일단 큐를 써 보긴 함...)


    import java.util.ArrayDeque;
    import java.util.Queue;
    
      class Solution {
      public int[] solution(int[] prices) {
           int n = prices.length;
           int[] answer = new int[n];
           Queue<Integer> queue = new ArrayDeque<>();

           for (int price : prices) {
               queue.offer(price);
           }

           int index = 0;
           while (!queue.isEmpty()) {
           //queue가 비어있지 않은 동안 계속 실행,
           //주식 가격을 순차적으로 처리하기 위한 구조
           int current = queue.poll();
           //큐에서 현재 처리할 주식 가격을 꺼내 `current` 변수에 저장
           int time = 0;
           //주식 가격이 떨어지지 않고 유지되는 시간을 저장할 변수

               for (int i = index + 1; i < n; i++) {
               //현재 가격(current) 이후의 가격들을 순회
                   time++;
                   //매 반복마다 시간을 1씩 증가
                   if (prices[i] < current) {
                       break;
                   }
                   //현재 가격보다 낮은 가격을 만나면 루프를 종료
               }

               answer[index] = time;
               index++;
               //다음 주식 가격을 처리하기 위해 인덱스를 증가
           }

           return answer;
           }
       }

2. 이중 루프 풀이 (그치만 이게 더 효율적인 것 같긴 하다...)


    import java.util.*;
    
    class Solution {
    public int[] solution(int[] prices) {
    int n = prices.length;
    int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                answer[i]++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
        }
        
        return answer;
    }