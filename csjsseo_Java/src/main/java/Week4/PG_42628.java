package Week4;

import java.util.*;

public class PG_42628 {

    public int[] solution(String[] operations) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (String operation : operations) {

            String[] split = operation.split(" ");
            String command = split[0];
            int value = Integer.parseInt(split[1]);

            if (command.equals("I")) {
                maxHeap.add(value);
                minHeap.add(value);
            } else if (command.equals("D"))
            {
                if (value == 1 && !maxHeap.isEmpty() && !minHeap.isEmpty())
                {
                    Integer poll = maxHeap.poll();
                    minHeap.remove(poll);
                }
                if (value == -1 && !minHeap.isEmpty() && !maxHeap.isEmpty())
                {
                    Integer poll = minHeap.poll();
                    maxHeap.remove(poll);
                }
            }
        }
        if (!maxHeap.isEmpty() && !minHeap.isEmpty())
            return new int[]{maxHeap.poll(),minHeap.poll()};
        else
            return new int[]{0,0};

    }

    public static void main(String[] args) {
        PG_42628 pg42628 = new PG_42628();
        int[] solution = pg42628.solution(new String[]
                {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});

        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
