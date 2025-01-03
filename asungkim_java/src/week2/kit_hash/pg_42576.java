package week2.kit_hash;

import java.util.HashMap;
import java.util.Map;

public class pg_42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String,Integer> p=new HashMap<>();
        for (String s : participant ) {
            p.put(s,p.getOrDefault(s,0)+1);
        }

        for (String s : completion ) {
            p.put(s,p.get(s)-1);
        }

        for (String key : p.keySet()) {
            if (p.get(key)!=0) {
                answer=key;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        pg_42576 p=new pg_42576();
    }
}
