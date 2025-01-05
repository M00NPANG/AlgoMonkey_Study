package Week2;

import java.util.HashMap;
import java.util.Map;

public class PG_1845 {

    public int solution(int[] nums){

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        if((nums.length / 2) <= map.size())
            return nums.length / 2;
        else
            return map.size();
    }


    public static void main(String[] args) {
        int[] num_1 = {3,1,2,3};
        int[] num_2 = {3,3,3,2,4,4};
        int[] num_3 = {3,3,3,2,2,2};

        PG_1845 pg1845 = new PG_1845();

        int solution = pg1845.solution(num_1);
        System.out.println("solution = " + solution);
        int solution1 = pg1845.solution(num_2);
        System.out.println("solution1 = " + solution1);
        int solution2 = pg1845.solution(num_3);
        System.out.println("solution2 = " + solution2);
    }
}
