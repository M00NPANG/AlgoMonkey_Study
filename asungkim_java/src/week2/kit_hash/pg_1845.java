package week2.kit_hash;

import java.util.*;
class pg_1845 {
    public int solution(int[] nums) {
        int answer = 0;

        Map<Integer,Integer> map=new HashMap<>(); // 번호 - 개수
        for (int i=0;i<nums.length;i++) {
            int num=nums[i];
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int need=nums.length / 2;

        if (map.size()>need) {
            return need;
        }

        return map.size();
    }

    public static void main(String[] args) {
        pg_1845 p=new pg_1845();
    }
}
