package week7.kit_greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class pg_42861 {
    /***
     * 아예 어떻게 풀지 모르겠어서 관련 알고리즘에 대해서 알아보고 풀었다.
     * 최소 신장 트리(MST)를 사용하는 문제이고 그 중 크루스칼 알고리즘을 사용하였다.
     * 위에 대해서 공부하고 푸는 것을 추천!
     */

//    private static int[] parent;
//
//    public int solution1(int n, int[][] costs) {
//        int answer = 0;
//        parent = new int[n];
//
//        // 부모노드를 자신으로 설정한다.
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
//
//        // 비용을 기준으로 오름차순 정렬
//        Arrays.sort(costs, (s1, s2) -> s1[2] - s2[2]);
//
//
//        for (int i = 0; i < costs.length; i++) {
//            int from = costs[i][0];
//            int to = costs[i][1];
//            int cost = costs[i][2];
//
//            // 두 점의 부모노드가 다르면 서로를 이어주고 answer에 cost를 더해준다.
//            if (findParent(from) != findParent(to)) {
//                answer += cost;
//                union(from, to);
//            }
//        }
//
//        return answer;
//    }
//
//
//    private static int findParent(int node) {
//        if (parent[node] == node) {
//            return node;
//        }
//
//        return findParent(parent[node]);
//    }
//
//    private static void union(int a, int b) {
//        int rootA = findParent(a);
//        int rootB = findParent(b);
//
//        if (rootA != rootB) {
//            parent[rootB] = rootA;
//        }
//    }

    static boolean[] visited;
    public int solution(int n, int[][] costs) {
        // n이 100이하이므로 2차원 배열 사용
        int[][] graph = new int[n][n];

        visited=new boolean[n];

        // 그래프 초기화 (-1은 연결되지 않은 상태)
        // 빈 값을 체크하기위해
        for (int[] g : graph) {
            Arrays.fill(g, -1);
        }

        for (int[] c : costs) {
            int from = c[0];
            int to = c[1];
            int cost = c[2];
            graph[from][to] = cost;
            graph[to][from] = cost;
        }

        return prim(n,graph);


    }

    // bfs와 유사 bfs는 너비 탐색을 통해 최단거리를 탐색하지만
    // 프림은 우선순위큐를 활용해서 최소 간선 비용을 구한다
    private int prim(int n,int[][] graph) {

        // 우선순위큐에 들어가는 int[] 배열은 {목적지,비용} 순으로 배열이 들어간다
        PriorityQueue<int[]> pq=
                new PriorityQueue<>((a,b)->a[1]-b[1]);

        // 초기값 설정 (0번 점,비용 0)
        pq.add(new int[]{0,0});

        // 리턴할 최소 간선 비용
        int minCost=0;

        // bfs 와 유사한 구조
        while (!pq.isEmpty()) {
            int[] cur=pq.poll();
            int curTo=cur[0];
            int curCost=cur[1];

            // 가려는 곳이 방문했으면 패스
            if (visited[curTo]) continue;
            visited[curTo]=true;
            minCost+=curCost;

            for (int next=0;next<n;next++) {
                // 방문하지 않았고, 빈 배열이 아니라면(-1이면 빈 값이다)
                if (!visited[next] && graph[curTo][next]!=-1) {
                    pq.offer(new int[]{next,graph[curTo][next]});
                }
            }
        }

        return minCost;

    }


    public static void main(String[] args) {

    }
}
