package baekjoon.random_algo;

import java.util.Scanner;
import java.util.Stack;

public class _2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();
        // () = 2 | [] = 3 |
        // ()[] = 5
        // (()[[]])([])
        // 2*(2+3*3)+2*3
        int answer = 0;
        int result = 1;

        // ([]())
        // 2(3+2)

        //
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
                result *= 2;
            } else if (c == '[') {
                st.push(c);
                result *= 3;
            } else if (c == ')') {
                // 스택이 비었거나 잘못된 괄호일 때
                if (st.isEmpty() || st.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                // () 형태 일떄는 더해줌
                if (s.charAt(i - 1) == '(') {
                    answer += result;
                }

                st.pop();
                result /= 2;


            } else if (c == ']') {
                if (st.isEmpty() || st.peek() != '[') {
                    System.out.println(0);
                    return;
                }

                if (s.charAt(i - 1) == '[') {
                    answer += result;
                }
                st.pop();
                result /= 3;
            }
        }


        if (st.isEmpty()) {
            System.out.println(0);
        }
        else System.out.println(answer);
    }
}
