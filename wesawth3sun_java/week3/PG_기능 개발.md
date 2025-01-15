문제 상세 해설 :
https://velog.io/@suunn001/%EA%B8%B0%EB%8A%A5-%EA%B0%9C%EB%B0%9C-java

    import java.util.*;

    class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
    

        List<Integer> list = new ArrayList<>();     
        //각 배포마다 배포되는 기능의 수를 저장할 리스트
    
        Queue<Integer> queue = new LinkedList<>();
        //각 작업이 완료되는 데 필요한 일수를 저장할 큐

            for (int i = 0; i < progresses.length; i++) {
                int days = (int) Math.ceil((100 - progresses[i]) / speeds[i]);
                 //기능을 업데이트하는 데에 걸리는 날짜 수
                    queue.offer(days);
            }
        
            while (!queue.isEmpty()) {
                //큐가 빌 때까지 반복
                int day = queue.poll();
                int count = 1;
            
                while (!queue.isEmpty() && queue.peek() <= day) {
                    queue.poll();
                    count++;
            }
                list.add(count);
            }
            int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
            return answer;
        }
    }