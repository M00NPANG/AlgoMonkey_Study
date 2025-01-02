package 전화번호목록;// HashMap을 잘 활용하지 못한거같은데..

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();
        for (String number : phone_book) { // 각 key-value 를 number-1 로 지정해둔다. (같은 전화번호가 중복해서 들어있지 않습니다.)
            map.put(number, 1);
        }

        for (String number : map.keySet()) { // 각 phone_book에 있는 number에서
            for (int i = 1; i < number.length(); i++) { // 각각 substring(0,i)를 만든다
                String prefix = number.substring(0, i);  // ex) 119 -> 1, 11, 119
                if (map.containsKey(prefix)) {  // 만약 substring에 맞는 number가 있다면 -> false
                    return false;               // ex) 1, 11, 119 -> 1195524421 => false
                }
            }
        }
        return answer;
    }
}