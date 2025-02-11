package Week7;

import java.util.*;

public class PG_42861 {
    // Union-Find 자료구조를 위한 부모 배열
    private int[] parent;

    public int solution(int n, int[][] costs) {
        // 간선을 비용 기준으로 오름차순 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        // 부모 배열 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgeCount = 0;

        // 크루스칼 알고리즘 수행
        for (int[] edge : costs) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            // 두 노드의 루트를 찾아 사이클이 형성되지 않으면 간선 선택
            if (find(u) != find(v)) {
                union(u, v);
                totalCost += cost;
                edgeCount++;
            }

            // 모든 섬이 연결되면 종료
            if (edgeCount == n - 1) {
                break;
            }
        }

        return totalCost;
    }

    // Find 연산: 노드의 루트를 찾음
    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // 경로 압축
    }

    // Union 연산: 두 노드의 루트를 합침
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}