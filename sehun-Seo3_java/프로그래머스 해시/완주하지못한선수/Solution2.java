// 시간초과...

package 완주하지못한선수;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<Integer, String> map = new HashMap<>(); // Map<String,Integer> 로 했을 경우, 중복된 값이 삭제 될 위험이 있으므로 한번 이렇게 작성해 보았다.

        for (int i = 0; i < participant.length; i++) {
            map.put(i, participant[i]); // Hashmap에 각각 번호와 name을 매핑시켰다.
        }

        for(String name : completion){ // 도착한 선수들의 이름
            if(map.containsValue(name)){ // 전체 선수들의 이름 명단에 존재한다면, 해당 그 이름이,
                for(int key : map.keySet()){ // Hashmap의 key들 중,
                    if(map.get(key).equals(name)){ // 그 key와 도착한 선수들의 이름에 맞는 value가 서로 같다면
                        map.remove(key);     // key를 구했으므로, 그 key를 삭제시켜서 완주하지 못한 한 선수만 남게 시킨다.
                        break; // 동일인물이 있을 수 있으므로 한명 만 제거.
                    }
                }
            }
        }

        for(String value : map.values()){
            answer = value; // 다 제거되고, 한명만 남은 map 출력
        }

        return answer;
    }
}