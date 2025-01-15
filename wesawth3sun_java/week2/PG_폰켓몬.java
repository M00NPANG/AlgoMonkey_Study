package week2;

import java.util.HashSet;

public class PG_폰켓몬 {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};
        HashSet<Integer> poketmons = new HashSet<>();
        for (int num : nums) {
            poketmons.add(num);
        }

        if (poketmons.size() < nums.length / 2) {
            System.out.println(poketmons.size());
        } else {
            System.out.println(nums.length / 2);
        }
    }
}

