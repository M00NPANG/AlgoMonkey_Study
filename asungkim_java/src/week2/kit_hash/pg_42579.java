package week2.kit_hash;

import java.util.*;

public class pg_42579 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer=new ArrayList<>();

        // 고유번호 = 인덱스
        Map<String,Integer> total=new HashMap<>(); // 장르 - 총재생횟수
        Map<String,List<Integer>> list=new HashMap<>(); // 장르 - 고유번호배열
        for (int i=0;i<genres.length;i++) {
            String genre=genres[i];
            int playTime=plays[i];

            total.put(genre,total.getOrDefault(genre,0)+playTime);

            list.putIfAbsent(genre,new ArrayList<>());
            list.get(genre).add(i);
        }

        // 총 재생횟수 기준으로 정렬해준 배열이 sorted
        List<Map.Entry<String,Integer>> sorted=new ArrayList<>(total.entrySet());
        sorted.sort((a,b)->b.getValue()-a.getValue());

        for (Map.Entry<String,Integer> entry : sorted) {
            String genre=entry.getKey();
            List<Integer> tmp=list.get(genre);

            Collections.sort(tmp,(a, b)->plays[b]-plays[a]);

            for (int i=0;i<Math.min(2,tmp.size());i++) {
                answer.add(tmp.get(i));
            }
        }


        int[] an=new int[answer.size()];
        for (int i=0;i<an.length;i++) {
            an[i]=answer.get(i);
        }

        return an;
    }

    public static void main(String[] args) {
        pg_42579 p=new pg_42579();
    }
}
