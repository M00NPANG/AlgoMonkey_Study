// Question1 같은 숫자는 싫어

package Week3;

import java.util.Stack;

public class PG_12906 {

    public int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<arr.length;i++)
        {
            if(stack.isEmpty() || stack.peek() != arr[i])
                stack.add(arr[i]);
        }
        int[] result = new int[stack.size()];

        for(int i=0;i<stack.size();i++)
        {
            result[i] = stack.get(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1,1,3,3,0,1,1};

        PG_12906 pg12906 = new PG_12906();

        int[] solution = pg12906.solution(arr);

        for (int i : solution) {
            System.out.print(i + " ");
        }

    }

}
