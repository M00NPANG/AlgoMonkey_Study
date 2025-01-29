package weekendstudy.first;

import java.io.*;
import java.util.Stack;

public class BJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int firstCnt=1;
        int secondCnt=0;

        String s =  br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
                firstCnt *= 2;

            } else if (c == '[') {
                stack.push(c);
                firstCnt *= 3;

            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    secondCnt = 0;
                    break;
                }

                if (s.charAt(i - 1) == '(') {
                    secondCnt += firstCnt;
                }
                stack.pop();
                firstCnt /= 2;

            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    secondCnt = 0;
                    break;
                }

                if (s.charAt(i - 1) == '[') {
                    secondCnt += firstCnt;
                }
                stack.pop();
                firstCnt /= 3;

            }
        }
        if (!stack.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(secondCnt);
        }
    }
}
