package week6;

import java.util.ArrayList;
import java.util.List;

public class pg_86971 {
    /***
     * 1. 첫번째 예시에서 예를 들면 [1,3] 를 끊으면 1번과 3번을 기준으로 두개의 네트워크로 나뉜다.
     * 2. 이를 통해 1에서 시작하는 깊이와 3에서 시작하는 깊이의 차를 구하고 이를 Math.min 을 통해 갱신하면 된다는 접근이다.
     * 3. 따라서 wires를 순회하면서 하나씩 끊어보고 각 깊이에 대한 계산이 필요하다
     * 4. 각 점에 대한 연결점을 쉽게 확인하기 위해 List<Integer>[] graph를 넣고, 방문처리를 위한 visited를 선언한다
     * 5. 깊이 계산을 위해 dfs 함수는 start 점을 기준으로 깊이를 탐색하여 리턴
     */

    private static List<Integer>[] graph;
    private static int min=Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        graph=new ArrayList[n+1];

        // graph 초기화
        for (int i=1;i<=n;i++) {
            graph[i]=new ArrayList<>();
        }

        // graph 선 연결해주기
        for (int i=0;i<wires.length;i++) {
            int v1=wires[i][0];
            int v2=wires[i][1];

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 하나씩 끊어보면서 탐색해보기
        for (int i=0;i<wires.length;i++) {
            int v1=wires[i][0];
            int v2=wires[i][1];

            // 현재의 v1,v2를 끊는다. 주의할 점은 List<Integer> 이므로 Integer.valueOf()를 사용해야함
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            boolean[] visited=new boolean[n+1];
            int cnt=dfs(graph,visited,v1); // dfs를 통해 v1을 시작으로 하는 노드의 길이를 구한다.

            int diff=Math.abs(cnt-(n-cnt)); // 한쪽의 길이는 cnt , 한쪽의 길이는 총 길이에서 cnt를 뺀 n-cnt 임
            min=Math.min(min,diff);

            // 다음 사용을 위해 복구
            graph[v1].add(v2);
            graph[v2].add(v1);
        }


        return min;
    }

    private static int dfs(List<Integer>[] graph,boolean[] visited,int start) {
        visited[start]=true; // 방문 처리
        int num=1; // 첫번째는 방문했으므로 1로 시작

        for (int next : graph[start]) {
            if (!visited[next]) {
                num+=dfs(graph,visited,next);
            }
        }

        return num;
    }

    public static void main(String[] args) {

    }
}
