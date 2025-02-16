package week5;

import java.util.Arrays;

public class pg_42746 {
    /***
     * return String 을 위하여 StringBuilder 사용
     * 예외) 앞자리가 0이면 0 출력
     */
    public String solution(int[] numbers) {
        StringBuilder sb=new StringBuilder();

        // 3 30 34 5 9
        // 9 5 34 30 3

        String[] numStr=new String[numbers.length];
        for (int i=0;i<numStr.length;i++) {
            numStr[i]=String.valueOf(numbers[i]);
        }

        Arrays.sort(numStr,(a, b)->{
            int x1=Integer.parseInt(a+b);
            int x2=Integer.parseInt(b+a);

            return x2-x1;
        });

        for (String s : numStr) {
            sb.append(s);
        }

        String answer=sb.toString();

        if (answer.startsWith("0")) {
            return "0";
        }


        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
