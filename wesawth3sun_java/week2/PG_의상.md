import java.util.HashMap;
import java.util.Map;


class Solution { 
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;
        
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for (Integer value : map.values()){
            answer *= value + 1;
        // map에 종류, 개수로 저장해 뒀는데, 
        // 결국 모든 value 값을 곱해야 하는 것이다
        // 종류의 개수 (value) + 안 입는 경우 (1가지)
        }
        return answer - 1;
        // -1 은 아무것도 안 입은 경우를 제외하기 위함
    }
}