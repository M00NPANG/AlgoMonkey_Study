package 프로그래머스완전탐색.전력망을둘로나누기;

class Solution {
    static boolean[] visited;
    static int[][] graph;

    public int solution(int n, int[][] wires) {
        int answer = -1;

        // 송전탑 개수의 차이를 계산할 때 최솟값 갱신해야 하므로 MAX_VALUE 로 초기화
        int minDiff = Integer.MAX_VALUE;

        // 제외할 i번째 배열 선택해서 여러 경우를 다 계산해봄. -> wires 배열 하나 누락시킴.
        for (int i = 0; i < wires.length; i++) {
            visited = new boolean[n + 1]; // 방문 여부
            graph = new int[n + 1][n + 1]; // 그래프 graph[1][2] = 1 의 뜻은 1->2에 연결이 되어있다는 뜻

            // 그래프 연결
            for (int j = 0; j < wires.length; j++) {
                if (i != j) { // i번째 배열을 제외하고 계산.
                    int v1 = wires[j][0];
                    int v2 = wires[j][1];

                    // 양방향 연결 되어있으므로
                    graph[v1][v2] = 1;
                    graph[v2][v1] = 1;
                }
            }

            // 송전탑의 개수 계산
            int network1 = DFS(1);

            // 어차피 두 전력망으로 나누기 때문에 n-network1 => network2
            int network2 = n - network1;

            // 두 전력망 네트워크 차이 계산
            int diff = Math.abs(network1 - network2);
            minDiff = Math.min(minDiff, diff); // 최솟값 갱신
        }
        answer = minDiff;

        return answer;
    }

    // DFS 방식으로, 각 노드(송전탑)들을 돌아다녀 방문 여부 체크 + 연결된 노드 개수 카운팅 
    public int DFS(int V) {
        visited[V] = true;
        int count = 1;

        for (int i = 0; i < graph.length; i++) {
            if(graph[V][i] == 1 && !visited[i]) {
                count+= DFS(i); // 재귀 호출로 개수 세기
            }
        }
        return count;
    }
}