package Week6;

public class PG_42842 {

    public int[] solution(int brown, int yellow) {

        int total = brown + yellow;

        for (int height = 3; height <= total / height; height++) {
            if (total % height == 0) {
                int width = total / height;
                if ((width - 2) * (height - 2) == yellow)
                    return new int[]{width, height};
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {

        PG_42842 pg42842 = new PG_42842();
        int[] solution = pg42842.solution(10, 2);
        for (int num : solution) {
            System.out.print(num + " ");
        }
    }
}
