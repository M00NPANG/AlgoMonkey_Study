package week6;

public class pg_86491 {
    /***
     * 가로 세로는 중요하지 않고 max 와 min 으로 나눈 후, 이를 max업데이트를 각각해주면 된다.
     * 직관적인 문제라고 생각됨
     */
    public int solution(int[][] sizes) {
        int maxW=0;
        int maxH=0;

        for (int i=0;i<sizes.length;i++) {
            int max=Math.max(sizes[i][0],sizes[i][1]);
            int min=Math.min(sizes[i][0],sizes[i][1]);

            maxW=Math.max(maxW,max);
            maxH=Math.max(maxH,min);
        }

        return maxW*maxH;
    }

    public static void main(String[] args) {

    }
}
