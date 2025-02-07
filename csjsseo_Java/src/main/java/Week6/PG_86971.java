package Week6;
import java.util.*;

public class PG_86971 {
    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            // i번째 전선을 제외한 그래프 구성
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) graph.add(new ArrayList<>()); // 1-based index

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; // i번째 전선 제거
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }

            // BFS 탐색으로 한쪽 네트워크의 송전탑 개수 구하기
            boolean[] visited = new boolean[n + 1];
            int groupSize = bfs(1, graph, visited); // 1번 노드에서 탐색 시작

            // 두 그룹의 크기 차이 계산
            int diff = Math.abs((n - groupSize) - groupSize);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }

    private int bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PG_86971 pg86971 = new PG_86971();
        int[][] wires1 = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int solution = pg86971.solution(9, wires1);
        System.out.println(solution);
    }
}