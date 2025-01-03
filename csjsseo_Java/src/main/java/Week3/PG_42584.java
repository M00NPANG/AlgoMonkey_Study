package Week3;
import java.util.LinkedList;
import java.util.Queue;

public class PG_42584 {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        Queue<Integer> priceQueue = new LinkedList<>();

        for (int price : prices) {
            priceQueue.add(price);
        }

        int index = 0;

        while (!priceQueue.isEmpty()) {
            Integer poll = priceQueue.poll();

            int count = 0;

            for (int i = index + 1; i < prices.length; i++) {
                count++;

                if (poll > prices[i])
                    break;
            }

            answer[index++] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        PG_42584 pg42584 = new PG_42584();
        int[] solution = pg42584.solution(new int[]{1, 2, 3, 2, 3});
        for (int num : solution) {
            System.out.print(num + " ");
        }
    }
}