package 완주하지못한선수;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for(String name : participant) { // participant 배열에서 하나하나씩 검사
            map.put(name, map.getOrDefault(name, 0) + 1); // name 에 대한 value 값을 모두 : 1. (중복이 있다면 그 해당 name의 value를 2)
        }

        for(String name : completion){  // completion 배열에서 하나하나씩 검사
            map.put(name, map.get(name) - 1); //  map에서 completion name과 일치하는 key값에 대한 value를 -1 하여 재배치.
                                              //  정상적인 key에 대한 value 값은 보통 0. (+1 -1 했으므로)
                                              // 1. participant에 있지만, completion에 없는 경우, => value값 : 1 (+1 했으므로)
                                              // 2. 동일 인물 2명 중 한명은 완주하지못했을 때, => value값 : 1 (+1 +1 -1 했으므로)
        }

        for(String name : map.keySet()){
            if(map.get(name) == 1){ // 따라서 우리는 key에 대한 value값이 1인 것만 알아내면 된다.
                answer = name;
            }
        }

        return answer;
    }
}