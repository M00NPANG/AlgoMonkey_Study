package 프로그래머스탐욕법.섬연결하기;

// 그리디 알고리즘의 대표 문제 중 전형적인 최소 신장 트리(Minimum Spanning Tree)문제
// 프림(Prim) 알고리즘이란걸 이용해서 문제를 풀어보았습니다.
// 접해보지 못했던 문제류 여서 익히고 구현하기까지 많은 시간이 들었습니다...
// 이 외에도 크루스칼 알고리즘 방법도 있는데, 이해하기 좀 힘들어서 프림 알고리즘으로 풀어봤습니다 ㅜㅜ

// 사실 저는 평소에 알고리즘 공부할 때 프로그래머스 보다는 백준이 조금 더 익숙해서,
// https://www.acmicpc.net/problem/1197 - 1197번 최소 스패닝 트리
// 이런 류 문제들을 좀 풀어보고 나서 PG 문제를 풀어봤습니다! - 저처럼 연습이 더 필요한 팀원분들이 혹시 계시다면
// 위 문제도 한번 풀어보는 것도 좋을 것 같습니다!

import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        List<Node> list = new ArrayList<>();
        list.add(new Node(0)); // list.get(0); 의 경우 제외한다. (1-based)
        for (int i = 0; i < n; i++) {
            list.add(new Node(i + 1));
        }

        // 각 노드들 연결하기 (가중치 포함)
        for (int[] cost : costs) {
            int startNode = cost[0]; // 시작 정점
            int endNode = cost[1]; // 끝 정점
            int weight = cost[2]; // 가중치

            Node n1 = list.get(startNode);
            Node n2 = list.get(endNode);
            n1.links.add(new Edge(n2, weight));
            n2.links.add(new Edge(n1, weight));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt((edge) -> edge.weight));
        boolean[] visited = new boolean[n + 1];
        int totalWeight = 0;

        // 시작 노드 - 1 (어디든 시작해도 무방)
        visited[1] = true;
        pq.addAll(list.get(1).links); // 1번 노드에 연결된 간선 모두 추가
        int count = 1; // MST 포함된 정점 개수

        while (!pq.isEmpty()) {
            Edge edge = pq.poll(); // 가중치가 가장 작은 간선 선택
            Node targetNode = edge.target; // 다음 이어질 노드

            if (visited[targetNode.node]) continue; // 이미 방문한 노드면 다음으로 넘어감

            visited[targetNode.node] = true; // 방문 표시
            totalWeight += edge.weight;
            count++; // 정점 개수 증가

            for (Edge next : targetNode.links) {
                if (!visited[next.target.node]) {
                    pq.offer(next);
                }
            }

            // 모든 정점이 MST에 도달했다면 종료
            if (count == n) break;
        }
        return totalWeight;
    }
}


// 정점
class Node {
    int node;
    List<Edge> links = new LinkedList<>();

    public Node(int node) {
        this.node = node;
    }
}

// 간선
class Edge {
    Node target;
    int weight;

    Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}