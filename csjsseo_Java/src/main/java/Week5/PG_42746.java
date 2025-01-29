// 정렬 - 가장 큰 수(42746번)

package Week5;

import java.util.Arrays;

public class PG_42746 {

    public String solution(int[] numbers)
    {
        String[] numberToString = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);


        Arrays.sort(numberToString,(a,b) -> (b+a).compareTo(a+b));

        StringBuilder largestNumber = new StringBuilder();

        for (String str : numberToString) {
            largestNumber.append(str);
        }

        return largestNumber.toString();
    }

    public static void main(String[] args) {
        int[] arr = {6, 10, 2};
        PG_42746 pg42746 = new PG_42746();
        String solution = pg42746.solution(arr);
        System.out.println("solution = " + solution);
    }

}
