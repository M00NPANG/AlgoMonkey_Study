package week7.kit_greedy;

import java.util.Arrays;

public class pg_42861 {
    /***
     * 아예 어떻게 풀지 모르겠어서 관련 알고리즘에 대해서 알아보고 풀었다.
     * 최소 신장 트리(MST)를 사용하는 문제이고 그 중 크루스칼 알고리즘을 사용하였다.
     * 위에 대해서 공부하고 푸는 것을 추천!
     */

    private static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];

        // 부모노드를 자신으로 설정한다.
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 비용을 기준으로 오름차순 정렬
        Arrays.sort(costs, (s1, s2) -> s1[2] - s2[2]);


        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];

            // 두 점의 부모노드가 다르면 서로를 이어주고 answer에 cost를 더해준다.
            if (findParent(from) != findParent(to)) {
                answer += cost;
                union(from, to);
            }
        }

        return answer;
    }


    private static int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        return findParent(parent[node]);
    }

    private static void union(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }


    public static void main(String[] args) {

    }
}
