package week6;

public class pg_87946 {
    /***
     * dfs 에서는 던전을 순회하여 최소 피로도보다 현재 k가 더 크고 방문하지 않은 곳이면 백트레킹을 통해 깊이 탐색을 한다.
     * 이를 통해 max값을 갱신하여 최대 깊이를 찾는다.
     */
    private static boolean[] visited;
    private static int max=-1;
    public int solution(int k, int[][] dungeons) {
        int n=dungeons.length;
        visited=new boolean[n];

        dfs(k,dungeons,0);
        return max;
    }

    private static void dfs(int k, int[][] dungeons,int depth) {
        max=Math.max(max,depth); // 최대 던전 수 갱신

        for (int i=0;i<dungeons.length;i++) {
            int minK=dungeons[i][0];
            int useK=dungeons[i][1];

            // 방문하지않은 곳이고 현재 k가 최소 피로도보다 크면 탐색
            if (!visited[i]&&k>=minK) {
                visited[i]=true;
                dfs(k-useK,dungeons,depth+1);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) {

    }
}
