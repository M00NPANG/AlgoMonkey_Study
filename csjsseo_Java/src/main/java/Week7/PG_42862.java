package Week7;
import java.util.*;

public class PG_42862 {

    public int solution(int n, int[] lost, int[] reserve) {

        int result = 0;

        int[] students = new int[n + 1];

        Arrays.fill(students, 1);       // 모든 학생이 체육복을 가지고 있다고 가정(value = 1)

        for (int num : lost) students[num]--;       // 체육복을 잃어버린 학생은 value -= 1
        for (int num : reserve) students[num]++;    // 체육복 여분을 챙겨온 학생은 value += 1

        for (int i = 1; i < students.length; i++) {
            if (students[i] == 0) {     // 체육복을 잃어버린 경우 조건
                if (i > 0 && students[i - 1] >= 2) {    // 앞에 학생이 여분이 있는지 체크
                    students[i]++;
                    students[i - 1]--;
                } else if (i < n && students[i + 1] >= 2) {     // 뒤에 학생이 여분이 있는지 체크
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }

        for (int i = 1; i <= n; i++) result = (students[i] >= 1) ? result + 1 : result;
        // 전체 반복을 통해 여분이 있는 경우 체크

        return result;
    }


    public static void main(String[] args) {
        PG_42862 pg42862 = new PG_42862();
        int solution = pg42862.solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
        System.out.println("solution = " + solution);
    }
}