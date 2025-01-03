package week3.kit_stackAndQueue;

import java.util.Stack;

public class pg_12906 {
    public int[] solution(int []arr) {

        Stack<Integer> st=new Stack<>();
        for (int num : arr) {
            if (st.isEmpty() || st.peek() !=num) {
                st.push(num);
            }
        }

        int[] answer=new int[st.size()];
        for (int i=answer.length-1; i>=0 ; i--) {
            answer[i]=st.pop();
        }



        return answer;
    }
    public static void main(String[] args) {

    }
}
