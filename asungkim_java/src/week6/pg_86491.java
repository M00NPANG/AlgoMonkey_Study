package week6;

import java.util.ArrayList;
import java.util.List;

public class pg_86491 {
    public int solution(int[][] sizes) {
        int answer = 0;

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

        List<Integer> list=new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

    }
