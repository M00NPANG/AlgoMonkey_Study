package Week7;

import java.util.Arrays;

public class PG_42885 {

    public int solution(int[] people, int limit) {

        Arrays.sort(people);

        int result = 0;
        int left = 0, right = people.length - 1;

        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;
            result++;
        }

        return result;
    }

    public static void main(String[] args) {

        PG_42885 pg42885 = new PG_42885();
        int solution = pg42885.solution(new int[]{30, 50, 50, 70, 100}, 100);
        System.out.println(solution);
    }
}
