package Week9;

import java.util.*;

public class PG_43105 {

    public int solution(int[][] triangle) {

        int size = triangle.length - 2;

        for(int i = size; i >= 0; i--)
        {
            for(int j = 0; j < triangle[i].length; j++)
            {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }

        return triangle[0][0];

    }
}
