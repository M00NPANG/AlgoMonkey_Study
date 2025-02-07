package Week6;

public class PG_87946 {

    public int solution(int k, int[][] dungeons){
        int answer = -1;

        boolean[] visited = new boolean[dungeons.length];

        answer = dfs(k,dungeons,visited,0);
        return answer;
    }


    private int dfs(int fatigue, int[][] dungeons, boolean[] visited, int count) {
        int maxCount = count; // 현재 탐험 개수 저장

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) { // 방문 X & 최소 피로도 충족
                visited[i] = true; // 방문 처리
                int value = dfs(fatigue - dungeons[i][1], dungeons, visited, count + 1);
                maxCount = Math.max(maxCount, value);
                visited[i] = false; // 백트래킹 (원상 복구)
            }
        }
        return maxCount;
    }
}