package Week6;

public class PG_86491 {
    public int solution(int[][] sizes) {

        int[] result = new int[sizes.length];

        int maxWidth = 0;
        int minHeight = 0;

        for (int[] size : sizes) {

            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);

            maxWidth = Math.max(maxWidth, width);
            minHeight = Math.max(minHeight, height);
        }

        return maxWidth * minHeight;
    }

    public static void main(String[] args) {
        PG_86491 pg86491 = new PG_86491();
        int solution = pg86491.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
        System.out.println("solution = " + solution);
    }
}
