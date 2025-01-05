package Week2;

import java.util.HashMap;
import java.util.Map;

public class PG_42578 {
        public int solution(String[][] clothes) {

            int answer = 1;

            Map<String, Integer> map = new HashMap<>();

            for (String[] clothe : clothes) {
                map.put(clothe[1],map.getOrDefault(clothe[1],0) + 1);
            }

            for (Integer value : map.values()) {
                answer *= (value + 1);
            }

            return answer-1;
        }

    public static void main(String[] args) {
        PG_42578 pg42578 = new PG_42578();

        String[][] data_1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] data_2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        int solution_1 = pg42578.solution(data_1);
        System.out.println("solution = " + solution_1);

        int solution_2 = pg42578.solution(data_2);
        System.out.println("solution = " + solution_2);
    }
    }
