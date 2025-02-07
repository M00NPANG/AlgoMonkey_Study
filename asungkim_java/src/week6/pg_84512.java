package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pg_84512 {
    /***
     * 1. word의 길이가 최대 5이므로 모든 경우의수는 5의 5승이다. 따라서 모두 탐색하기로 결정
     * 2. dfs 함수는 빈 문자열이 depth 길이가 되면 list에 담는다.
     * 3. 그리고 alp에 있는 경우를 for문을 통해 tmp문자열에 추가해줌
     * 4. list를 순회하여 word 문자열인 경우의 idx값에 1을 더하여 answerd에 담아주고 리턴
     */

    private static List<String> list;
    private static String[] alp = {"A", "E", "I", "O", "U"};
    private static boolean[] visited;

    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        visited = new boolean[5];

        for (int i = 1; i <= 5; i++) {
            dfs(i, "");
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }


        return answer;
    }

    private static void dfs(int depth, String tmp) {
        if (depth == tmp.length()) {
            list.add(tmp);
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(depth, tmp + alp[i]);
        }
    }

    public static void main(String[] args) {

    }
}
