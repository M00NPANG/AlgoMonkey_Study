package Week2;

import java.util.*;

public class PG_42579 {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genrePlayCount = new HashMap<>();

        for(int i=0;i<genres.length;i++)
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i],0) + plays[i]);


        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a,b) ->  genrePlayCount.get(b) - genrePlayCount.get(a));

        Map<String, PriorityQueue<int[]>> genreToSongs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreToSongs.putIfAbsent(genres[i], new PriorityQueue<>((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1]; // 재생 횟수 내림차순
                return a[0] - b[0]; // 고유 번호 오름차순
            }));
            genreToSongs.get(genres[i]).offer(new int[]{i, plays[i]});
        }

        List<Integer> bestAlbum = new ArrayList<>();

        for (String genre : sortedGenres) {
            PriorityQueue<int[]> songs = genreToSongs.get(genre);
            int count = 0;
            while (!songs.isEmpty() && count < 2) {
                bestAlbum.add(songs.poll()[0]);
                count++;
            }
        }

        int[] answer = new int[bestAlbum.size()];

        for(int i=0;i<answer.length;i++){
            answer[i] = bestAlbum.get(i);
        }

        return answer;
    }


    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays =   {500, 600, 150, 800, 2500};
        
        PG_42579 pg42579 = new PG_42579();
        int[] solution = pg42579.solution(genres, plays);

        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
