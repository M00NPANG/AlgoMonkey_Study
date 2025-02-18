```java
/**
 * 1. 건설 비용의 순서대로 오름차순 정렬하기 -> 가격이 적을수록 좋다
 * 2. 섬이 서로 연결되었는지 확인 + 연결 안 됐으면 연결하기
 * 3. 연결됐으면 하나로 합쳐 주기 -> 한 팀이라고 생각하기, 연결 = 팀에 가입한다
 *
 * 단계별 진행 예시 (n=4, costs=[[0,1,1],[1,2,2],[2,3,1],[0,3,3]])
 */

class Solution {

    int[] team; // 각 섬의 소속 그룹 저장용

    public int solution(int n, int[][] costs) {
        int answer = 0;

        // 건설 비용 순서대로 오름차순 정렬
        // 예: 정렬 후 [0-1(1), 2-3(1), 1-2(2), 0-3(3)]
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        team = new int[n];
        // 각자 1인 팀 구축 -> 춘추전국시대라고 생각하면 됨... (모든 노드가 분리된 상태에서 시작)
        // 예: 0, 1, 2, 3 한 개씩 각자 개별 팀으로 설정
        for (int i = 0; i < n; i++) {
            team[i] = i;
        }

        for (int[] island : costs) {
            // 연결할 섬, 비용 하나씩 차례대로 꺼내기
            int x = island[0];
            int y = island[1];
            int cost = island[2];

            // 2. 서로 다른 팀에 속한 경우에만 연결하기 -> 섬이 연결되지 않았다
            // 예: 첫 번째 경우 [0-1] 0 != 1 은 다른 팀이니까 연결시켜 준다 (단순히 숫자로 판단)
            if (find(x) != find(y)) {
                answer = answer + cost;
                // 3. 같은 팀에 가입시켜 주기 -> 섬 연결 -> 섬 번호를 같은 번호로 바꿔 준다 (1 -> 0)
                join(x, y);
            }
        }
        return answer;
    }

    int find(int island) {
        if (team[island] == island) {
            return island;
        }
        return team[island] = find(team[island]);
    }

    void join(int x, int y) {
        x = find(x);
        y = find(y);
        // 작은 수의 팀으로 합쳐 주기 -> 최종적으로는 0 팀으로 전부 합쳐질 수 있도록
        // 예: 1 -> 0 남은 팀: [0, 0, 2, 3] 팀
        if (x < y) {
            team[y] = x;
        } else {
            team[x] = y;
        }
    }
}
```