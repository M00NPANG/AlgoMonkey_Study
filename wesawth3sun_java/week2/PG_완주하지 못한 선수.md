    import java.util.HashMap;

    public class PG_완주하지못한선수 {
        public static void main(String[] args) {


        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";

        for (String string : participant) {
            map.put(string, map.getOrDefault(string, 0) + 1);
            //key가 존재하면 해당 key에 매핑되어 있는 값, 그렇지 않으면 디폴트 값을 반환
        }

        for (String string : completion) {
            map.put(string, map.getOrDefault(string, 0) - 1);
        }

        for (String string : map.keySet()) {
            if (map.get(string) == 1) {
                answer = string;
            }
        }
        System.out.println(answer);
        System.out.println(map);
    }
}