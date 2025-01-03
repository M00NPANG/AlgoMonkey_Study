package week3.kit_stackAndQueue;

import java.util.Stack;

public class pg_42584 {
    public int[] solution(int[] prices) {
        int len=prices.length;
        int[] answer = new int[len];
        Stack<Integer> st=new Stack<>();

        // 0 1 2
        //
        for (int i=0;i<len;i++) {
            int cur=prices[i];

            while (!st.isEmpty()) {
                if (prices[st.peek()]> cur) {
                    int top=st.pop();
                    answer[top]=i-top;
                }
                else break;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int top=st.pop();
            answer[top]=len-top-1;
        }


        return answer;
    }

    public static void main(String[] args) {

    }
}
