package Week6;

import java.util.ArrayList;

public class PG_42840 {

    public int[] Solution(int[] answers)
    {
        int[] first = new int[]{1,2,3,4,5};
        int[] second = new int[]{2,1,2,3,2,4,2,5};
        int[] third = new int[]{3,3,1,1,2,2,4,4,5,5};

        int[] scores = new int[3];

        for(int i = 0; i < answers.length; i++)
        {
            int K = answers[i];

            if(K == first[i % first.length]) scores[0]++;
            if(K == second[i % second.length]) scores[1]++;
            if(K == third[i % third.length]) scores[2]++;
        }

        int maxScores = Math.max(scores[0], Math.max(scores[1],scores[2]));

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < scores.length; i++) {
            if(maxScores == scores[i])
                arrayList.add(i+1);
        }

        return arrayList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        PG_42840 pg42840 = new PG_42840();
        int[] solution = pg42840.Solution(new int[]{1, 2, 3, 4, 5});

        for (int num : solution) {
            System.out.print(num + " ");
        }
    }
}
