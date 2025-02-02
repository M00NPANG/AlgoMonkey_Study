package Week6;

public class PG_84512 {
    public int solution(String word) {
        int[] weights = {781, 156, 31, 6, 1}; // 각 자리의 증가량 (5^4, 5^3, 5^2, 5^1, 5^0)
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int index = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < vowels.length; j++) {
                if (c == vowels[j]) {
                    index += j * weights[i] + 1; // 해당 자리 값 계산
                    break;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        PG_84512 pg84512 = new PG_84512();
        int solution = pg84512.solution("AAAAA");
        System.out.println(solution);
    }
}
