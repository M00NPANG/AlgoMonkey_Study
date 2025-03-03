package Week8;

import java.util.Arrays;
import java.util.Stack;

public class PG_42884 {

    public int solution(int[][] routes){

        int count = 0;
        Arrays.sort(routes,(a,b)->a[1] - b[1]);

        int camera = -30000;

        for(int [] route : routes){
            if(camera < route[0]){
                camera = route[1];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        PG_42884 pg42884 = new PG_42884();
        int[][] data = new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int solution = pg42884.solution(data);
        System.out.println("solution = " + solution);
    }
}
