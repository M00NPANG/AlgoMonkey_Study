package 베스트앨범;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        // HashMap 선언 및 초기화
        Map<String, Integer> genreToPlayCount = new HashMap<>(); // 장르 - 총 재생 횟수
        Map<Integer, Integer> iToPlays = new HashMap<>(); // 고유번호 - 재생 횟수
        Map<Integer, String> iToGenre = new HashMap<>(); // 고유번호 - 장르

        for(int i=0; i<genres.length; i++){ // genres.length == plays.length
            // value가 등록되지 않았다면 초기값을 0으로 두고, play[i]를 더하는 식으로 해서 총 재생 횟수를 구함
            genreToPlayCount.put(genres[i], genreToPlayCount.getOrDefault(genres[i],0) + plays[i]);

            // 고유번호 - 재생 횟수
            iToPlays.put(i,plays[i]);

            // 고유번호 - 장르
            iToGenre.put(i,genres[i]);
        }

        // 장르별 정렬 (genreToPlayCount)
        List<String> sortedGenres = new ArrayList<>(genreToPlayCount.keySet()); // genreToPlayCount에서 key(Genres)를 기준으로 List 생성

        sortedGenres.sort(new Comparator<String>() { // List 정렬하기
            @Override
            public int compare(String o1, String o2) {
                return genreToPlayCount.get(o2).compareTo(genreToPlayCount.get(o1)); // get을 이용하여, 총 재생횟수를 기준으로 내림차순으로 구현
            }
        });


        // 곡 정렬 및 결과
        List<Integer> result = new ArrayList<>(); // answer에 저장할 List 생성
        for(String genre : sortedGenres){ // sortedGenres 에서 genre 추출

            List<Integer> idByGenre = new ArrayList<>();
            for(int id : iToGenre.keySet()){ // 고유번호 - 장르에서, 고유번호를 뽑아서,
                if(iToGenre.get(id).equals(genre)){ // 그거의 get값인 genre와 sortedGenres 에서 추출된 genre와 서로 같다면,
                    idByGenre.add(id); // 고유번호를 idByGenre에 저장
                }
            }

            idByGenre.sort(new Comparator<Integer>() { // 이제 idByGenre에는 특정 장르에만 있는 고유번호가 있다
                @Override
                public int compare(Integer o1, Integer o2) {
                    // plays 수가 같다 -> 고유번호 오름차순,  plays 수가 다르다 -> plays 내림차순
                    return iToPlays.get(o1).equals(iToPlays.get(o2)) ?  o1 - o2 : iToPlays.get(o2) - iToPlays.get(o1);
                }
            });

            for(int i=0; i<Math.min(2, idByGenre.size()); i++){ // result에 저장되는건 상위 2개 idByGenre 이다. - Math.min을 이용해서 최대 2개
                result.add(idByGenre.get(i));
            }
        }

        // 리스트 -> 배열(answer) 변환
        int resultSize = result.size();
        answer = new int[resultSize]; // result 크기와 같은 배열 생성
        for (int i = 0; i < result.size(); i++) {  // 각각 집어넣기
            answer[i] = result.get(i);
        }

        return answer;
    }

}