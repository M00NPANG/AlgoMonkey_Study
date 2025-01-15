// 정렬 - K번째 수(42748번)

package Week5;

import java.util.*;

public class PG_42748 {
    public int[] solution(int[] array, int[][] commands) {

        int[] result = new int[commands.length];

        int index = 0;

        for (int[] command : commands) {

            int start = command[0];
            int end = command[1];
            int k = command[2];

            ArrayList<Integer> subList = new ArrayList<>();

            for(int i = start-1; i < end; i++) {
                subList.add(array[i]);
            }

            int[] sortedSubArray = subList.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            Arrays.sort(sortedSubArray);

            result[index++] = sortedSubArray[k-1];
        }

        return result;

    }
    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        
        PG_42748 pg42748 = new PG_42748();
        int[] solution = pg42748.solution(arr, commands);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
