package week2.kit_hash;

import java.util.HashMap;
import java.util.Map;

public class pg_42577 {
    public int solution(String[][] clothes) {
        int answer = 1;

        // head - 2 , eye - 1
        // 3*2-1

        Map<String,Integer> map=new HashMap<>(); // 타입 - 개수
        for (String[] set : clothes) {
            String name=set[0];
            String type=set[1];

            map.put(type,map.getOrDefault(type,0)+1);
        }

        for (String key : map.keySet()) {
            answer*=(map.get(key)+1);
        }

        return answer-1;
    }

    public static void main(String[] args) {
        pg_42577 p=new pg_42577();
    }
}
