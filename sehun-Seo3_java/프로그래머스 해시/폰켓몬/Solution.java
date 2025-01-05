package 폰켓몬;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        // HashMap의 특징 중 하나는 중복 된 key 값을 허용하지 않는다는 것이다. (중복 시 덮어씀.)
        Map<Integer, Integer> map = new HashMap<>();

        int N = nums.length;   // nums 배열의 길이 N (1 이상 10,000 이하의 자연수이며, 항상 짝수)
        int selectNum = N / 2; // 선택할 폰켓몬의 개수 selectNum

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i); // 각 배열에 value값인 i를 대응시켰을 때, HashMap의 특징으로 인해
            // 중복된 key 발생 시 덮어 씌워진다.
        }

        if(selectNum <= map.size()){ // 만약 중복 제거된 배열의 개수가 더 많다면 무조건 selectNum 수 만큼은 뽑아야 한다.
            answer = selectNum;
        } else{     // 중복 제거된 배열의 개수가 더 적다면, 폰켓몬 종류의 개수가 많아야 하므로 답은 map.size()가 된다.
            answer = map.size();
        }
        return answer;

        // 위 6줄을 return selectNum <= map.size() ? selectNum : map.size(); 이렇게 삼항연산자로도 활용할 수 있겠다.
    }
}