package Week2;

import java.util.HashMap;
import java.util.Map;

public class PG_42576 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name,map.getOrDefault(name,0) + 1);
        }

        for (String name : completion) {
            map.put(name,map.getOrDefault(name,0) - 1);
        }

        for (String name : map.keySet()) {
            Integer count = map.get(name);
            if(count != 0)
                answer += name;
        }
        return answer;
    }

    public static void main(String[] args) {

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        
        PG_42576 pg42576 = new PG_42576();
        String solution = pg42576.solution(participant, completion);
        System.out.println("solution = " + solution);

    }
}
