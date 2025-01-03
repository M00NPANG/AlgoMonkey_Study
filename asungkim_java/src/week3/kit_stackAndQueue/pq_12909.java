package week3.kit_stackAndQueue;

import java.util.Stack;

public class pq_12909 {
    boolean solution(String s) {
        return isRight(s);
    }

    // (()()()
    private static boolean isRight(String s) {
        Stack<Character> st=new Stack<>();


        for (char c : s.toCharArray()) {
            if (c=='(') {
                st.push(c);
            }
            else if (c==')') {
                if (st.isEmpty()) return false;
                st.pop();
            }
        }

        return st.isEmpty();
    }
    public static void main(String[] args) {

    }
}
