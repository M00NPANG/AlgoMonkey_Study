package Week7;

import java.util.Stack;

public class PG_42883 {

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

        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : stack) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        PG_42883 pg42860 = new PG_42883();
        String solution = pg42860.solution("9420", 2);
        System.out.println("solution = " + solution);
    }


}
