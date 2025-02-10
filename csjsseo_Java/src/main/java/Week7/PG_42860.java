package Week7;
import java.util.*;

public class PG_42860 {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length - 1; // 기본 이동 횟수 (오른쪽으로만 이동하는 경우)

        for (int i = 0; i < length; i++) {
            // 알파벳 변경 횟수 계산
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 커서 이동 횟수 계산
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i * 2 + (length - next)); // 오른쪽으로 이동 후 왼쪽으로 이동
            move = Math.min(move, (length - next) * 2 + i); // 왼쪽으로 이동 후 오른쪽으로 이동
        }

        answer += move;
        return answer;
    }

    public static void main(String[] args) {
        PG_42860 pg42860 = new PG_42860();

        int solution = pg42860.solution("JAZ");
        System.out.println("solution = " + solution);
    }
}