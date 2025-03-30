package Week8;

import java.util.Arrays;

public class PG_42885 {

    public int solution(int[] people, int limit) {

        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int boatCount = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boatCount++;
        }
        return boatCount;
    }

    public static void main(String[] args) {
        PG_42885 pg42885 = new PG_42885();
        int solution = pg42885.solution(new int[]{70, 50, 80, 50}, 100);
        System.out.println("solution = " + solution);
    }
}
