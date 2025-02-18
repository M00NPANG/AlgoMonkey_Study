package Week8;

import java.util.Stack;

public class PG_42883 {

    public String solution(String number,int k){

        Stack<Character> stack = new Stack<>();
        int removeCount = 0;

        for(Character digit : number.toCharArray()) {
            while(!stack.isEmpty() && removeCount < k && stack.peek() < digit) {
                stack.pop();
                removeCount++;
            }
            stack.push(digit);
        }

        while(removeCount < k) {
            stack.pop();
            removeCount++;
        }
        StringBuilder sb = new StringBuilder();

        for(Character digit : stack) sb.append(digit);


        return sb.toString();
    }

    public static void main(String[] args) {
        PG_42883 pg42883 = new PG_42883();
        String solution = pg42883.solution("1993", 2);
        System.out.println("solution = " + solution);
    }
}
