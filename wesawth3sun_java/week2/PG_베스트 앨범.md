    import java.util.*;

    class Solution {
        public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> playCount = new HashMap<>();

        Map<String, HashMap<Integer, Integer>> musicNum = new HashMap<>();

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            playCount.put(genres[i], playCount.getOrDefault(genres[i], 0) + plays[i]);
            if (!musicNum.containsKey(genres[i])) {
                // 처음 등록하는 경우
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                // 장르별로 고유 번호와 플레이 횟수를 저장
                musicNum.put(genres[i], map);
            } else {
                musicNum.get(genres[i]).put(i, plays[i]);
                // 나눠서 등록하지 않으면 key 값인 장르명이 겹쳐서 덧씌워진다 주의!!!
            }
        }
        
        List<String> list = new ArrayList<>(playCount.keySet());
        Collections.sort(list, (s1, s2) -> playCount.get(s2) - playCount.get(s1));

        for (String str : list) {
            HashMap<Integer, Integer> map = musicNum.get(str);
            List<Integer> genre = new ArrayList<>(map.keySet());

            Collections.sort(genre, (s1, s2) -> map.get(s2) - map.get(s1));
            answer.add(genre.get(0));
            if (genre.size() > 1) {
                answer.add(genre.get(1));
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}