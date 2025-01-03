// Question3 올바른 괄호

import java.util.LinkedList;
import java.util.Queue;


public class PG_12909 {
    boolean solution(String s) {

        int count = 0;

        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            queue.add(c);

        }

        for (int i = 0; i < s.length(); i++) {
            Character poll = queue.poll();
            count = (poll == '(') ? (count + 1) : (count - 1);

            if (count < 0) break;
        }

        return (count == 0) ? true : false;
    }

    public static void main(String[] args) {

        PG_12909 pg12909 = new PG_12909();

        String ex1 = "()()";
        String ex2 = "(())()";
        String ex3 = ")()(";
        String ex4 = "(()(";

        boolean solution1 = pg12909.solution(ex1);
        System.out.println("solution1 = " + solution1);

        boolean solution2 = pg12909.solution(ex2);
        System.out.println("solution2 = " + solution2);

        boolean solution3 = pg12909.solution(ex3);
        System.out.println("solution3 = " + solution3);

        boolean solution4 = pg12909.solution(ex4);
        System.out.println("solution4 = " + solution4);
    }
}

