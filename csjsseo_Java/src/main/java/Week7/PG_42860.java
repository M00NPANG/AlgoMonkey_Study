package Week7;

import java.util.Stack;

public class PG_42860 {

    public String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();
        int popCount = 0;

        for (char data : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < data && popCount < k){
                stack.pop();
                popCount++;
            }
            stack.add(data);
        }

        while(popCount < k){
            stack.pop();
            popCount++;
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PG_42860 pg42860 = new PG_42860();
        String solution = pg42860.solution("9420", 2);
        System.out.println("solution = " + solution);
    }


}
