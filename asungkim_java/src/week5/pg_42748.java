package week5;

import java.util.Arrays;

public class pg_42748 {
    /***
     * newArr를 j-i+1 의 크기로 만들고 i번째부터 j번째까지 배열에 넣는다
     * newArr를 정렬하고 k번째 값을 answer 배열에 추가
     */
    public int[] solution(int[] array, int[][] commands) {
        int len=commands.length;
        int[] answer = new int[len];

        for (int t=0;t<len;t++) {
            int[] com=commands[t];
            int i=com[0];
            int j=com[1];
            int k=com[2];

            // array i번째부터 j번째까지 자르고 정렬한 후 k번째 숫자
            // idx -> -1
            int[] newArr=new int[j-i+1];
            int startIdx=i-1;
            for (int x=0;x<newArr.length;x++,startIdx++) {
                newArr[x]=array[startIdx];
            }
            Arrays.sort(newArr);

            answer[t]=newArr[k-1];

        }

        return answer;
    }
    public static void main(String[] args) {

    }
}
